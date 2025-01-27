/*
 * api.video Java API client
 * api.video is an API that encodes on the go to facilitate immediate playback, enhancing viewer streaming experiences across multiple devices and platforms. You can stream live or on-demand online videos within minutes.
 *
 * The version of the OpenAPI document: 1
 * Contact: ecosystem@api.video
 *
 * NOTE: This class is auto generated.
 * Do not edit the class manually.
 */

package video.api.client.api.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import video.api.client.api.models.Metadata;
import video.api.client.api.models.VideoClip;
import video.api.client.api.models.VideoWatermark;
import java.io.Serializable;

/**
 * VideoCreationPayload
 */

public class VideoCreationPayload implements Serializable, DeepObject {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_TITLE = "title";
    @SerializedName(SERIALIZED_NAME_TITLE)
    private String title;

    public static final String SERIALIZED_NAME_SUBTITLE = "subtitle";
    @SerializedName(SERIALIZED_NAME_SUBTITLE)
    private String subtitle;

    public static final String SERIALIZED_NAME_DESCRIPTION = "description";
    @SerializedName(SERIALIZED_NAME_DESCRIPTION)
    private String description;

    public static final String SERIALIZED_NAME_SOURCE = "source";
    @SerializedName(SERIALIZED_NAME_SOURCE)
    private String source;

    public static final String SERIALIZED_NAME_PUBLIC = "public";
    @SerializedName(SERIALIZED_NAME_PUBLIC)
    private Boolean _public = true;

    public static final String SERIALIZED_NAME_PANORAMIC = "panoramic";
    @SerializedName(SERIALIZED_NAME_PANORAMIC)
    private Boolean panoramic = false;

    public static final String SERIALIZED_NAME_MP4_SUPPORT = "mp4Support";
    @SerializedName(SERIALIZED_NAME_MP4_SUPPORT)
    private Boolean mp4Support = true;

    public static final String SERIALIZED_NAME_PLAYER_ID = "playerId";
    @SerializedName(SERIALIZED_NAME_PLAYER_ID)
    private String playerId;

    public static final String SERIALIZED_NAME_TAGS = "tags";
    @SerializedName(SERIALIZED_NAME_TAGS)
    private List<String> tags = null;

    public static final String SERIALIZED_NAME_METADATA = "metadata";
    @SerializedName(SERIALIZED_NAME_METADATA)
    private List<Metadata> metadata = null;

    public static final String SERIALIZED_NAME_CLIP = "clip";
    @SerializedName(SERIALIZED_NAME_CLIP)
    private VideoClip clip;

    public static final String SERIALIZED_NAME_WATERMARK = "watermark";
    @SerializedName(SERIALIZED_NAME_WATERMARK)
    private VideoWatermark watermark;

    /**
     * Use this parameter to set the language of the video. When this parameter is set, the API creates a transcript of
     * the video using the language you specify. You must use the [IETF language
     * tag](https://en.wikipedia.org/wiki/IETF_language_tag) format. &#x60;language&#x60; is a permanent attribute of
     * the video. You can update it to another language using the [&#x60;PATCH
     * /videos/{videoId}&#x60;](https://docs.api.video/reference/api/Videos#update-a-video-object) operation. This
     * triggers the API to generate a new transcript using a different language.
     */
    @JsonAdapter(LanguageEnum.Adapter.class)
    public enum LanguageEnum {
        AR("ar"),

        CA("ca"),

        CS("cs"),

        DA("da"),

        DE("de"),

        EL("el"),

        EN("en"),

        ES("es"),

        FA("fa"),

        FI("fi"),

        FR("fr"),

        HE("he"),

        HI("hi"),

        HR("hr"),

        HU("hu"),

        IT("it"),

        JA("ja"),

        KO("ko"),

        ML("ml"),

        NL("nl"),

        NN("nn"),

        FALSE("false"),

        PL("pl"),

        PT("pt"),

        RU("ru"),

        SK("sk"),

        SL("sl"),

        TE("te"),

        TR("tr"),

        UK("uk"),

        UR("ur"),

        VI("vi"),

        ZH("zh");

        private String value;

        LanguageEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static LanguageEnum fromValue(String value) {
            for (LanguageEnum b : LanguageEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<LanguageEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final LanguageEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public LanguageEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return LanguageEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_LANGUAGE = "language";
    @SerializedName(SERIALIZED_NAME_LANGUAGE)
    private LanguageEnum language;

    public static final String SERIALIZED_NAME_TRANSCRIPT = "transcript";
    @SerializedName(SERIALIZED_NAME_TRANSCRIPT)
    private Boolean transcript;

    public static final String SERIALIZED_NAME_TRANSCRIPT_SUMMARY = "transcriptSummary";
    @SerializedName(SERIALIZED_NAME_TRANSCRIPT_SUMMARY)
    private Boolean transcriptSummary;

    /**
     * Gets or Sets transcriptSummaryAttributes
     */
    @JsonAdapter(TranscriptSummaryAttributesEnum.Adapter.class)
    public enum TranscriptSummaryAttributesEnum {
        ABSTRACT("abstract"),

        TAKEAWAYS("takeaways");

        private String value;

        TranscriptSummaryAttributesEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TranscriptSummaryAttributesEnum fromValue(String value) {
            for (TranscriptSummaryAttributesEnum b : TranscriptSummaryAttributesEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<TranscriptSummaryAttributesEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TranscriptSummaryAttributesEnum enumeration)
                    throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TranscriptSummaryAttributesEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TranscriptSummaryAttributesEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_TRANSCRIPT_SUMMARY_ATTRIBUTES = "transcriptSummaryAttributes";
    @SerializedName(SERIALIZED_NAME_TRANSCRIPT_SUMMARY_ATTRIBUTES)
    private List<TranscriptSummaryAttributesEnum> transcriptSummaryAttributes = null;

    public VideoCreationPayload title(String title) {
        this.title = title;
        return this;
    }

    /**
     * The title of your new video.
     * 
     * @return title
     **/
    @ApiModelProperty(example = "Maths video", required = true, value = "The title of your new video.")

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VideoCreationPayload subtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    /**
     * A subtitle for your video.
     * 
     * @return subtitle
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "A great subtitle.", value = "A subtitle for your video.")

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public VideoCreationPayload description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A brief description of your video.
     * 
     * @return description
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "A video about string theory.", value = "A brief description of your video.")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VideoCreationPayload source(String source) {
        this.source = source;
        return this;
    }

    /**
     * You can either add a video already on the web, by entering the URL of the video, or you can also enter the
     * &#x60;videoId&#x60; of one of the videos you already have on your api.video acccount, and this will generate a
     * copy of your video. Creating a copy of a video can be especially useful if you want to keep your original video
     * and trim or apply a watermark onto the copy you would create.
     * 
     * @return source
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "https://www.myvideo.url.com/video.mp4 OR vi4k0jvEUuaTdRAEjQ4JfOyl", value = "You can either add a video already on the web, by entering the URL of the video, or you can also enter the `videoId` of one of the videos you already have on your api.video acccount, and this will generate a copy of your video. Creating a copy of a video can be especially useful if you want to keep your original video and trim or apply a watermark onto the copy you would create.")

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public VideoCreationPayload _public(Boolean _public) {
        this._public = _public;
        return this;
    }

    /**
     * Default: True. If set to &#x60;false&#x60; the video will become private. More information on private videos can
     * be found [here](https://docs.api.video/delivery/video-privacy-access-management)
     * 
     * @return _public
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "true", value = "Default: True. If set to `false` the video will become private. More information on private videos can be found [here](https://docs.api.video/delivery/video-privacy-access-management)")

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    public VideoCreationPayload panoramic(Boolean panoramic) {
        this.panoramic = panoramic;
        return this;
    }

    /**
     * Indicates if your video is a 360/immersive video.
     * 
     * @return panoramic
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "false", value = "Indicates if your video is a 360/immersive video.")

    public Boolean getPanoramic() {
        return panoramic;
    }

    public void setPanoramic(Boolean panoramic) {
        this.panoramic = panoramic;
    }

    public VideoCreationPayload mp4Support(Boolean mp4Support) {
        this.mp4Support = mp4Support;
        return this;
    }

    /**
     * Enables mp4 version in addition to streamed version.
     * 
     * @return mp4Support
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "true", value = "Enables mp4 version in addition to streamed version.")

    public Boolean getMp4Support() {
        return mp4Support;
    }

    public void setMp4Support(Boolean mp4Support) {
        this.mp4Support = mp4Support;
    }

    public VideoCreationPayload playerId(String playerId) {
        this.playerId = playerId;
        return this;
    }

    /**
     * The unique identification number for your video player.
     * 
     * @return playerId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "pl45KFKdlddgk654dspkze", value = "The unique identification number for your video player.")

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public VideoCreationPayload tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public VideoCreationPayload addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * A list of tags you want to use to describe your video.
     * 
     * @return tags
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"maths\", \"string theory\", \"video\"]", value = "A list of tags you want to use to describe your video.")

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public VideoCreationPayload metadata(List<Metadata> metadata) {
        this.metadata = metadata;
        return this;
    }

    public VideoCreationPayload addMetadataItem(Metadata metadataItem) {
        if (this.metadata == null) {
            this.metadata = new ArrayList<>();
        }
        this.metadata.add(metadataItem);
        return this;
    }

    /**
     * A list of key value pairs that you use to provide metadata for your video.
     * 
     * @return metadata
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[{\"key\": \"Author\", \"value\": \"John Doe\"}]", value = "A list of key value pairs that you use to provide metadata for your video.")

    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    public VideoCreationPayload clip(VideoClip clip) {
        this.clip = clip;
        return this;
    }

    /**
     * Get clip
     * 
     * @return clip
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public VideoClip getClip() {
        return clip;
    }

    public void setClip(VideoClip clip) {
        this.clip = clip;
    }

    public VideoCreationPayload watermark(VideoWatermark watermark) {
        this.watermark = watermark;
        return this;
    }

    /**
     * Get watermark
     * 
     * @return watermark
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public VideoWatermark getWatermark() {
        return watermark;
    }

    public void setWatermark(VideoWatermark watermark) {
        this.watermark = watermark;
    }

    public VideoCreationPayload language(LanguageEnum language) {
        this.language = language;
        return this;
    }

    /**
     * Use this parameter to set the language of the video. When this parameter is set, the API creates a transcript of
     * the video using the language you specify. You must use the [IETF language
     * tag](https://en.wikipedia.org/wiki/IETF_language_tag) format. &#x60;language&#x60; is a permanent attribute of
     * the video. You can update it to another language using the [&#x60;PATCH
     * /videos/{videoId}&#x60;](https://docs.api.video/reference/api/Videos#update-a-video-object) operation. This
     * triggers the API to generate a new transcript using a different language.
     * 
     * @return language
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "fr", value = "Use this parameter to set the language of the video. When this parameter is set, the API creates a transcript of the video using the language you specify. You must use the [IETF language tag](https://en.wikipedia.org/wiki/IETF_language_tag) format.  `language` is a permanent attribute of the video. You can update it to another language using the [`PATCH /videos/{videoId}`](https://docs.api.video/reference/api/Videos#update-a-video-object) operation. This triggers the API to generate a new transcript using a different language.")

    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }

    public VideoCreationPayload transcript(Boolean transcript) {
        this.transcript = transcript;
        return this;
    }

    /**
     * Use this parameter to enable transcription. - When &#x60;true&#x60;, the API generates a transcript for the
     * video. - The default value is &#x60;false&#x60;. - If you define a video language using the &#x60;language&#x60;
     * parameter, the API uses that language to transcribe the video. If you do not define a language, the API detects
     * it based on the video. - When the API generates a transcript, it will be available as a caption for the video.
     * 
     * @return transcript
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Use this parameter to enable transcription.   - When `true`, the API generates a transcript for the video. - The default value is `false`. - If you define a video language using the `language` parameter, the API uses that language to transcribe the video. If you do not define a language, the API detects it based on the video.  - When the API generates a transcript, it will be available as a caption for the video.")

    public Boolean getTranscript() {
        return transcript;
    }

    public void setTranscript(Boolean transcript) {
        this.transcript = transcript;
    }

    public VideoCreationPayload transcriptSummary(Boolean transcriptSummary) {
        this.transcriptSummary = transcriptSummary;
        return this;
    }

    /**
     * Use this parameter to enable summarization. We recommend using this parameter together with &#x60;transcript:
     * true&#x60;. - When &#x60;true&#x60;, the API generates a summary for the video, based on the transcription. - The
     * default value is &#x60;false&#x60;. - If you define a video language using the &#x60;language&#x60; parameter,
     * the API uses that language to summarize the video. If you do not define a language, the API detects it based on
     * the video.
     * 
     * @return transcriptSummary
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Use this parameter to enable summarization. We recommend using this parameter together with `transcript: true`.  - When `true`, the API generates a summary for the video, based on the transcription. - The default value is `false`. - If you define a video language using the `language` parameter, the API uses that language to summarize the video. If you do not define a language, the API detects it based on the video.")

    public Boolean getTranscriptSummary() {
        return transcriptSummary;
    }

    public void setTranscriptSummary(Boolean transcriptSummary) {
        this.transcriptSummary = transcriptSummary;
    }

    public VideoCreationPayload transcriptSummaryAttributes(
            List<TranscriptSummaryAttributesEnum> transcriptSummaryAttributes) {
        this.transcriptSummaryAttributes = transcriptSummaryAttributes;
        return this;
    }

    public VideoCreationPayload addTranscriptSummaryAttributesItem(
            TranscriptSummaryAttributesEnum transcriptSummaryAttributesItem) {
        if (this.transcriptSummaryAttributes == null) {
            this.transcriptSummaryAttributes = new ArrayList<>();
        }
        this.transcriptSummaryAttributes.add(transcriptSummaryAttributesItem);
        return this;
    }

    /**
     * Use this parameter to define the elements of a summary that you want to generate. If you do not define this
     * parameter, the API generates a full summary with all attributes. The possible values are &#x60;abstract&#x60; and
     * &#x60;takeaways&#x60;.
     * 
     * @return transcriptSummaryAttributes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Use this parameter to define the elements of a summary that you want to generate. If you do not define this parameter, the API generates a full summary with all attributes. The possible values are `abstract` and `takeaways`.")

    public List<TranscriptSummaryAttributesEnum> getTranscriptSummaryAttributes() {
        return transcriptSummaryAttributes;
    }

    public void setTranscriptSummaryAttributes(List<TranscriptSummaryAttributesEnum> transcriptSummaryAttributes) {
        this.transcriptSummaryAttributes = transcriptSummaryAttributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VideoCreationPayload videoCreationPayload = (VideoCreationPayload) o;
        return Objects.equals(this.title, videoCreationPayload.title)
                && Objects.equals(this.subtitle, videoCreationPayload.subtitle)
                && Objects.equals(this.description, videoCreationPayload.description)
                && Objects.equals(this.source, videoCreationPayload.source)
                && Objects.equals(this._public, videoCreationPayload._public)
                && Objects.equals(this.panoramic, videoCreationPayload.panoramic)
                && Objects.equals(this.mp4Support, videoCreationPayload.mp4Support)
                && Objects.equals(this.playerId, videoCreationPayload.playerId)
                && Objects.equals(this.tags, videoCreationPayload.tags)
                && Objects.equals(this.metadata, videoCreationPayload.metadata)
                && Objects.equals(this.clip, videoCreationPayload.clip)
                && Objects.equals(this.watermark, videoCreationPayload.watermark)
                && Objects.equals(this.language, videoCreationPayload.language)
                && Objects.equals(this.transcript, videoCreationPayload.transcript)
                && Objects.equals(this.transcriptSummary, videoCreationPayload.transcriptSummary)
                && Objects.equals(this.transcriptSummaryAttributes, videoCreationPayload.transcriptSummaryAttributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, subtitle, description, source, _public, panoramic, mp4Support, playerId, tags,
                metadata, clip, watermark, language, transcript, transcriptSummary, transcriptSummaryAttributes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VideoCreationPayload {\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    subtitle: ").append(toIndentedString(subtitle)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
        sb.append("    panoramic: ").append(toIndentedString(panoramic)).append("\n");
        sb.append("    mp4Support: ").append(toIndentedString(mp4Support)).append("\n");
        sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    clip: ").append(toIndentedString(clip)).append("\n");
        sb.append("    watermark: ").append(toIndentedString(watermark)).append("\n");
        sb.append("    language: ").append(toIndentedString(language)).append("\n");
        sb.append("    transcript: ").append(toIndentedString(transcript)).append("\n");
        sb.append("    transcriptSummary: ").append(toIndentedString(transcriptSummary)).append("\n");
        sb.append("    transcriptSummaryAttributes: ").append(toIndentedString(transcriptSummaryAttributes))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
