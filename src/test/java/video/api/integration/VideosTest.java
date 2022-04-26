package video.api.integration;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import video.api.client.api.ApiException;
import video.api.client.api.clients.VideosApi;
import video.api.client.api.models.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Integration tests of api.videos() methods")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIfEnvironmentVariable(named = "INTEGRATION_TESTS_API_KEY", matches = ".+")
public class VideosTest extends AbstractTest {
    @Nested
    @DisplayName("upload by chunk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class UploadByChunk {
        private Video testVideo;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.testVideo = apiClient.videos()
                    .create(new VideoCreationPayload().title("[Java-SDK-tests] upload with chunk")._public(false));
        }

        @Test
        public void uploadVideo() throws ApiException {
            File mp4File = new File(this.getClass().getResource("/assets/10m.mp4").getFile());

            long fileSize = mp4File.length();
            int chunkSize = 1024 * 1024 * 5;

            apiClient.getHttpClient().setUploadChunkSize(chunkSize);

            AtomicLong totalUploadedAtomic = new AtomicLong(0);
            AtomicLong totalBytesAtomic = new AtomicLong(0);
            AtomicLong chunkCountAtomic = new AtomicLong(0);
            HashSet<Integer> seenChunkNums = new HashSet<>();

            apiClient.videos().upload(testVideo.getVideoId(), mp4File,
                    (bytesWritten, totalBytes, chunkCount, chunkNum) -> {
                        totalUploadedAtomic.set(bytesWritten);
                        totalBytesAtomic.set(totalBytes);
                        chunkCountAtomic.set(chunkCount);
                        seenChunkNums.add(chunkNum);
                    });

            assertThat(totalBytesAtomic.get()).isEqualTo(fileSize);
            assertThat(totalUploadedAtomic.get()).isEqualTo(fileSize);
            assertThat(chunkCountAtomic.get())
                    .isEqualTo(new Double(Math.ceil((float) fileSize / chunkSize)).longValue());
            assertThat(seenChunkNums).containsExactly(1, 2, 3);

            System.out.println(testVideo);
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(testVideo.getVideoId());
        }
    }

    @Nested
    @DisplayName("progressive upload")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ProgressiveUpload {
        private Video testVideo;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.testVideo = apiClient.videos()
                    .create(new VideoCreationPayload().title("[Java-SDK-tests] progressive upload")._public(false));
        }

        @Test
        @Order(1)
        public void uploadVideo() throws ApiException {
            File part1 = new File(this.getClass().getResource("/assets/10m.mp4.part.a").getFile());
            File part2 = new File(this.getClass().getResource("/assets/10m.mp4.part.b").getFile());
            File part3 = new File(this.getClass().getResource("/assets/10m.mp4.part.c").getFile());

            VideosApi.UploadProgressiveSession uploadProgressiveSession = apiClient.videos()
                    .createUploadProgressiveSession(this.testVideo.getVideoId());

            uploadProgressiveSession.uploadPart(part1);
            uploadProgressiveSession.uploadPart(part2);
            uploadProgressiveSession.uploadLastPart(part3);
        }

        @Test
        @Order(2)
        public void getStatus() throws ApiException {
            VideoStatus status = apiClient.videos().getStatus(testVideo.getVideoId());

            assertThat(status.getIngest().getReceivedParts().getTotal()).isEqualTo(3);
            assertThat(status.getIngest().getReceivedParts().getParts()).containsExactly(1, 2, 3);
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(testVideo.getVideoId());
        }
    }

    @Nested
    @DisplayName("progressive upload with upload token")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ProgressiveUploadWithUploadToken {
        private UploadToken uploadToken;
        private Video result;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.uploadToken = apiClient.uploadTokens().createToken(new TokenCreationPayload());
        }

        @Test
        public void uploadVideo() throws ApiException {
            File part1 = new File(this.getClass().getResource("/assets/10m.mp4.part.a").getFile());
            File part2 = new File(this.getClass().getResource("/assets/10m.mp4.part.b").getFile());
            File part3 = new File(this.getClass().getResource("/assets/10m.mp4.part.c").getFile());

            VideosApi.UploadWithUploadTokenProgressiveSession uploadProgressiveSession = apiClient.videos()
                    .createUploadWithUploadTokenProgressiveSession(this.uploadToken.getToken());

            uploadProgressiveSession.uploadPart(part1);
            uploadProgressiveSession.uploadPart(part2);
            this.result = uploadProgressiveSession.uploadLastPart(part3);
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(result.getVideoId());
        }
    }

    @Nested
    @DisplayName("upload without chunk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Upload {
        private Video testVideo;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.testVideo = apiClient.videos()
                    .create(new VideoCreationPayload().title("[Java-SDK-tests] upload without chunk"));
        }

        @Test
        public void uploadVideo() throws ApiException {
            File mp4File = new File(this.getClass().getResource("/assets/558k.mp4").getFile());

            long fileSize = mp4File.length();
            long chunkSize = apiClient.getHttpClient().getUploadChunkSize();

            AtomicLong totalUploadedAtomic = new AtomicLong(0);
            AtomicLong totalBytesAtomic = new AtomicLong(0);
            AtomicLong chunkCountAtomic = new AtomicLong(0);
            HashSet<Integer> seenChunkNums = new HashSet<>();

            apiClient.videos().upload(testVideo.getVideoId(), mp4File,
                    (bytesWritten, totalBytes, chunkCount, chunkNum) -> {
                        totalUploadedAtomic.set(bytesWritten);
                        totalBytesAtomic.set(totalBytes);
                        chunkCountAtomic.set(chunkCount);
                        seenChunkNums.add(chunkNum);
                    });

            assertThat(totalBytesAtomic.get()).isEqualTo(fileSize);
            assertThat(totalUploadedAtomic.get()).isEqualTo(fileSize);
            assertThat(chunkCountAtomic.get()).isEqualTo(1);
            assertThat(seenChunkNums).containsExactly(1);
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(testVideo.getVideoId());
        }
    }

    @Nested
    @DisplayName("upload without chunk with upload token")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class UploadWithUploadToken {
        private Video testVideo;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.testVideo = apiClient.videos().create(
                    new VideoCreationPayload().title("[Java-SDK-tests] upload without chunk with upload token"));
        }

        @Test
        public void uploadVideo() throws ApiException {
            File mp4File = new File(this.getClass().getResource("/assets/558k.mp4").getFile());

            long fileSize = mp4File.length();
            long chunkSize = apiClient.getHttpClient().getUploadChunkSize();

            AtomicLong totalUploadedAtomic = new AtomicLong(0);
            AtomicLong totalBytesAtomic = new AtomicLong(0);
            AtomicLong chunkCountAtomic = new AtomicLong(0);
            HashSet<Integer> seenChunkNums = new HashSet<>();

            apiClient.videos().uploadWithUploadToken(testVideo.getVideoId(), mp4File,
                    (bytesWritten, totalBytes, chunkCount, chunkNum) -> {
                        totalUploadedAtomic.set(bytesWritten);
                        totalBytesAtomic.set(totalBytes);
                        chunkCountAtomic.set(chunkCount);
                        seenChunkNums.add(chunkNum);
                    });

            assertThat(totalBytesAtomic.get()).isEqualTo(fileSize);
            assertThat(totalUploadedAtomic.get()).isEqualTo(fileSize);
            assertThat(chunkCountAtomic.get()).isEqualTo(1);
            assertThat(seenChunkNums).containsExactly(1);
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(testVideo.getVideoId());
        }
    }

    @Nested
    @DisplayName("update")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Update {
        private Video testVideo;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.testVideo = apiClient.videos()
                    .create(new VideoCreationPayload().title("[Java-SDK-tests] video updates"));
        }

        @Test
        public void addMetadata() throws ApiException {

            Video updated = apiClient.videos().update(testVideo.getVideoId(),
                    new VideoUpdatePayload().addMetadataItem(new Metadata("firstKey", "firstValue"))
                            .addMetadataItem(new Metadata("secondKey", "secondValue")));

            assertThat(updated.getMetadata()).containsExactlyInAnyOrder(new Metadata("firstKey", "firstValue"),
                    new Metadata("secondKey", "secondValue"));

            Video updated2 = apiClient.videos().update(testVideo.getVideoId(), new VideoUpdatePayload()
                    .metadata(updated.addMetadataItem(new Metadata("thirdKey", "thirdValue")).getMetadata()));

            assertThat(updated2.getMetadata()).containsExactlyInAnyOrder(new Metadata("firstKey", "firstValue"),
                    new Metadata("secondKey", "secondValue"), new Metadata("thirdKey", "thirdValue"));

            Video updated3 = apiClient.videos().update(testVideo.getVideoId(),
                    new VideoUpdatePayload().metadata(Collections.emptyList()));

            assertThat(updated3.getMetadata()).isEmpty();
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(testVideo.getVideoId());
        }
    }

    @Nested
    @DisplayName("get")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Get {
        private Video testVideo;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.testVideo = apiClient.videos().create(new VideoCreationPayload().title("[Java-SDK-tests] get"));
        }

        @Test
        public void get() throws ApiException {
            Video video = apiClient.videos().get(testVideo.getVideoId());

            assertThat(video.getVideoId()).isEqualTo(testVideo.getVideoId());
            assertThat(video.getTitle()).isEqualTo(testVideo.getTitle());
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(testVideo.getVideoId());
        }
    }

    @Nested
    @DisplayName("list with metadata")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ListWithMetadata {
        private Video testVideo;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.testVideo = apiClient.videos()
                    .create(new VideoCreationPayload()
                            .metadata(Collections.singletonList(new Metadata("key1", "value1")))
                            .title("[Java-SDK-tests] list metadatas"));
        }

        @Test
        public void listMetadataNotFound() throws ApiException {
            Map<String, String> metadata = new HashMap<>();
            metadata.put("key1", "valueNotFound");
            Page<Video> page = apiClient.videos().list().metadata(metadata).execute();

            assertThat(page.getItemsTotal()).isEqualTo(0);
        }

        @Test
        public void listMetadataFound() throws ApiException {
            Map<String, String> metadata = new HashMap<>();
            metadata.put("key1", "value1");
            Page<Video> page = apiClient.videos().list().metadata(metadata).execute();

            assertThat(page.getItemsTotal()).isGreaterThan(0);
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(testVideo.getVideoId());
        }
    }

    @Nested
    @DisplayName("list with tags")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ListWithTags {
        private Video testVideo;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.testVideo = apiClient.videos().create(
                    new VideoCreationPayload().tags(Arrays.asList("tag1", "tag2")).title("[Java-SDK-tests] list tags"));
        }

        @Test
        public void listTagNotFound() throws ApiException {
            Page<Video> page = apiClient.videos().list().tags(Collections.singletonList("valueNotFound")).execute();

            assertThat(page.getItemsTotal()).isEqualTo(0);
        }

        @Test
        public void listTagFound() throws ApiException {
            Page<Video> page = apiClient.videos().list().tags(Arrays.asList("tag1", "tag2")).execute();

            assertThat(page.getItemsTotal()).isGreaterThan(0);
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(testVideo.getVideoId());
        }
    }

    @Nested
    @DisplayName("thumbnail")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Thumbnail {
        private Video testVideo;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.testVideo = apiClient.videos().create(new VideoCreationPayload().title("[Java-SDK-tests] thumbnail"));
        }

        @Test
        public void uploadThumbnail() throws ApiException {
            File jpgFile = new File(this.getClass().getResource("/assets/cat.jpg").getFile());

            Video video = apiClient.videos().uploadThumbnail(testVideo.getVideoId(), jpgFile);

            assertThat(video.getAssets()).isNotNull();
            assertThat(video.getAssets().getThumbnail()).isNotNull();
        }

        @Test
        public void pickThumbnail() throws ApiException {
            Video video = apiClient.videos().pickThumbnail(testVideo.getVideoId(),
                    new VideoThumbnailPickPayload().timecode("00:00:02"));

            assertThat(video.getAssets()).isNotNull();
            assertThat(video.getAssets().getThumbnail()).isNotNull();
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(testVideo.getVideoId());
        }
    }

    @Nested
    @DisplayName("video status")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class VideoStatusTest {
        private Video testVideo;

        @BeforeAll
        public void createVideo() throws ApiException {
            this.testVideo = apiClient.videos()
                    .create(new VideoCreationPayload().title("[Java-SDK-tests] videoStatus"));
        }

        @Test
        public void getVideoStatus() throws ApiException {
            VideoStatus videoStatus = apiClient.videos().getStatus(testVideo.getVideoId());

            assertThat(videoStatus.getIngest()).isNull();
            assertThat(videoStatus.getEncoding()).isNotNull();
            assertThat(videoStatus.getEncoding().getPlayable()).isFalse();
        }

        @AfterAll
        public void deleteVideo() throws ApiException {
            apiClient.videos().delete(testVideo.getVideoId());
        }
    }
}
