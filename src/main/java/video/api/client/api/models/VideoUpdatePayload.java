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
import java.io.Serializable;

/**
 * VideoUpdatePayload
 */

public class VideoUpdatePayload implements Serializable, DeepObject {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_PLAYER_ID = "playerId";
    @SerializedName(SERIALIZED_NAME_PLAYER_ID)
    private Nullable<String> playerId;

    public static final String SERIALIZED_NAME_TITLE = "title";
    @SerializedName(SERIALIZED_NAME_TITLE)
    private String title;

    public static final String SERIALIZED_NAME_DESCRIPTION = "description";
    @SerializedName(SERIALIZED_NAME_DESCRIPTION)
    private String description;

    public static final String SERIALIZED_NAME_PUBLIC = "public";
    @SerializedName(SERIALIZED_NAME_PUBLIC)
    private Boolean _public;

    public static final String SERIALIZED_NAME_PANORAMIC = "panoramic";
    @SerializedName(SERIALIZED_NAME_PANORAMIC)
    private Boolean panoramic;

    public static final String SERIALIZED_NAME_MP4_SUPPORT = "mp4Support";
    @SerializedName(SERIALIZED_NAME_MP4_SUPPORT)
    private Boolean mp4Support;

    public static final String SERIALIZED_NAME_TAGS = "tags";
    @SerializedName(SERIALIZED_NAME_TAGS)
    private List<String> tags = null;

    public static final String SERIALIZED_NAME_METADATA = "metadata";
    @SerializedName(SERIALIZED_NAME_METADATA)
    private List<Metadata> metadata = null;

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

    public VideoUpdatePayload playerId(String playerId) {
        this.playerId = new Nullable<String>(playerId);

        return this;
    }

    public VideoUpdatePayload unsetPlayerId() {
        this.playerId = null;
        return this;
    }

    /**
     * The unique ID for the player you want to associate with your video.
     * 
     * @return playerId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "pl4k0jvEUuaTdRAEjQ4Jfrgz", value = "The unique ID for the player you want to associate with your video.")

    public String getPlayerId() {
        return playerId == null ? null : playerId.getValue();
    }

    public void setPlayerId(String playerId) {
        this.playerId = new Nullable<>(playerId);
    }

    public VideoUpdatePayload title(String title) {
        this.title = title;
        return this;
    }

    /**
     * The title you want to use for your video.
     * 
     * @return title
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The title you want to use for your video.")

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VideoUpdatePayload description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A brief description of the video.
     * 
     * @return description
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "A film about good books.", value = "A brief description of the video.")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VideoUpdatePayload _public(Boolean _public) {
        this._public = _public;
        return this;
    }

    /**
     * Whether the video is publicly available or not. False means it is set to private. Default is true. Tutorials on
     * [private videos](https://api.video/blog/endpoints/private-videos/).
     * 
     * @return _public
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "true", value = "Whether the video is publicly available or not. False means it is set to private. Default is true. Tutorials on [private videos](https://api.video/blog/endpoints/private-videos/).")

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    public VideoUpdatePayload panoramic(Boolean panoramic) {
        this.panoramic = panoramic;
        return this;
    }

    /**
     * Whether the video is a 360 degree or immersive video.
     * 
     * @return panoramic
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "false", value = "Whether the video is a 360 degree or immersive video.")

    public Boolean getPanoramic() {
        return panoramic;
    }

    public void setPanoramic(Boolean panoramic) {
        this.panoramic = panoramic;
    }

    public VideoUpdatePayload mp4Support(Boolean mp4Support) {
        this.mp4Support = mp4Support;
        return this;
    }

    /**
     * Whether the player supports the mp4 format.
     * 
     * @return mp4Support
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "true", value = "Whether the player supports the mp4 format.")

    public Boolean getMp4Support() {
        return mp4Support;
    }

    public void setMp4Support(Boolean mp4Support) {
        this.mp4Support = mp4Support;
    }

    public VideoUpdatePayload tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public VideoUpdatePayload addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * A list of terms or words you want to tag the video with. Make sure the list includes all the tags you want as
     * whatever you send in this list will overwrite the existing list for the video.
     * 
     * @return tags
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"maths\", \"string theory\", \"video\"]", value = "A list of terms or words you want to tag the video with. Make sure the list includes all the tags you want as whatever you send in this list will overwrite the existing list for the video.")

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public VideoUpdatePayload metadata(List<Metadata> metadata) {
        this.metadata = metadata;
        return this;
    }

    public VideoUpdatePayload addMetadataItem(Metadata metadataItem) {
        if (this.metadata == null) {
            this.metadata = new ArrayList<>();
        }
        this.metadata.add(metadataItem);
        return this;
    }

    /**
     * A list (array) of dictionaries where each dictionary contains a key value pair that describes the video. As with
     * tags, you must send the complete list of metadata you want as whatever you send here will overwrite the existing
     * metadata for the video.
     * 
     * @return metadata
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "A list (array) of dictionaries where each dictionary contains a key value pair that describes the video. As with tags, you must send the complete list of metadata you want as whatever you send here will overwrite the existing metadata for the video.")

    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    public VideoUpdatePayload language(LanguageEnum language) {
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

    public VideoUpdatePayload transcript(Boolean transcript) {
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

    public VideoUpdatePayload transcriptSummary(Boolean transcriptSummary) {
        this.transcriptSummary = transcriptSummary;
        return this;
    }

    /**
     * Use this parameter to enable summarization. - When &#x60;true&#x60;, the API generates a summary for the video,
     * based on the transcription. - The default value is &#x60;false&#x60;. - If you define a video language using the
     * &#x60;language&#x60; parameter, the API uses that language to summarize the video. If you do not define a
     * language, the API detects it based on the video.
     * 
     * @return transcriptSummary
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Use this parameter to enable summarization.   - When `true`, the API generates a summary for the video, based on the transcription. - The default value is `false`. - If you define a video language using the `language` parameter, the API uses that language to summarize the video. If you do not define a language, the API detects it based on the video.")

    public Boolean getTranscriptSummary() {
        return transcriptSummary;
    }

    public void setTranscriptSummary(Boolean transcriptSummary) {
        this.transcriptSummary = transcriptSummary;
    }

    public VideoUpdatePayload transcriptSummaryAttributes(
            List<TranscriptSummaryAttributesEnum> transcriptSummaryAttributes) {
        this.transcriptSummaryAttributes = transcriptSummaryAttributes;
        return this;
    }

    public VideoUpdatePayload addTranscriptSummaryAttributesItem(
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
        VideoUpdatePayload videoUpdatePayload = (VideoUpdatePayload) o;
        return Objects.equals(this.playerId, videoUpdatePayload.playerId)
                && Objects.equals(this.title, videoUpdatePayload.title)
                && Objects.equals(this.description, videoUpdatePayload.description)
                && Objects.equals(this._public, videoUpdatePayload._public)
                && Objects.equals(this.panoramic, videoUpdatePayload.panoramic)
                && Objects.equals(this.mp4Support, videoUpdatePayload.mp4Support)
                && Objects.equals(this.tags, videoUpdatePayload.tags)
                && Objects.equals(this.metadata, videoUpdatePayload.metadata)
                && Objects.equals(this.language, videoUpdatePayload.language)
                && Objects.equals(this.transcript, videoUpdatePayload.transcript)
                && Objects.equals(this.transcriptSummary, videoUpdatePayload.transcriptSummary)
                && Objects.equals(this.transcriptSummaryAttributes, videoUpdatePayload.transcriptSummaryAttributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, title, description, _public, panoramic, mp4Support, tags, metadata, language,
                transcript, transcriptSummary, transcriptSummaryAttributes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VideoUpdatePayload {\n");
        sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
        sb.append("    panoramic: ").append(toIndentedString(panoramic)).append("\n");
        sb.append("    mp4Support: ").append(toIndentedString(mp4Support)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
