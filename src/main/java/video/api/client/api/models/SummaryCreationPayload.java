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
import java.io.Serializable;

/**
 * SummaryCreationPayload
 */

public class SummaryCreationPayload implements Serializable, DeepObject {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_VIDEO_ID = "videoId";
    @SerializedName(SERIALIZED_NAME_VIDEO_ID)
    private String videoId;

    /**
     * Use this parameter to define how the API generates the summary. The only allowed value is &#x60;auto&#x60;, which
     * means that the API generates a summary automatically. If you do not set this parameter, **the API will not
     * generate a summary automatically**. In this case, &#x60;sourceStatus&#x60; will return &#x60;missing&#x60;, and
     * you have to manually add a summary using the &#x60;PATCH /summaries/{summaryId}/source&#x60; endpoint operation.
     */
    @JsonAdapter(OriginEnum.Adapter.class)
    public enum OriginEnum {
        AUTO("auto");

        private String value;

        OriginEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static OriginEnum fromValue(String value) {
            for (OriginEnum b : OriginEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<OriginEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final OriginEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public OriginEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return OriginEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_ORIGIN = "origin";
    @SerializedName(SERIALIZED_NAME_ORIGIN)
    private OriginEnum origin;

    /**
     * Gets or Sets attributes
     */
    @JsonAdapter(AttributesEnum.Adapter.class)
    public enum AttributesEnum {
        ABSTRACT("abstract"),

        TAKEAWAYS("takeaways");

        private String value;

        AttributesEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static AttributesEnum fromValue(String value) {
            for (AttributesEnum b : AttributesEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<AttributesEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AttributesEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public AttributesEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return AttributesEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_ATTRIBUTES = "attributes";
    @SerializedName(SERIALIZED_NAME_ATTRIBUTES)
    private List<AttributesEnum> attributes = null;

    public SummaryCreationPayload videoId(String videoId) {
        this.videoId = videoId;
        return this;
    }

    /**
     * Create a summary of a video using the video ID.
     * 
     * @return videoId
     **/
    @ApiModelProperty(example = "vi4k0jvEUuaTdRAEjQ4Jfrgz", required = true, value = "Create a summary of a video using the video ID.")

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public SummaryCreationPayload origin(OriginEnum origin) {
        this.origin = origin;
        return this;
    }

    /**
     * Use this parameter to define how the API generates the summary. The only allowed value is &#x60;auto&#x60;, which
     * means that the API generates a summary automatically. If you do not set this parameter, **the API will not
     * generate a summary automatically**. In this case, &#x60;sourceStatus&#x60; will return &#x60;missing&#x60;, and
     * you have to manually add a summary using the &#x60;PATCH /summaries/{summaryId}/source&#x60; endpoint operation.
     * 
     * @return origin
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "auto", value = "Use this parameter to define how the API generates the summary. The only allowed value is `auto`, which means that the API generates a summary automatically.  If you do not set this parameter, **the API will not generate a summary automatically**.  In this case, `sourceStatus` will return `missing`, and you have to manually add a summary using the `PATCH /summaries/{summaryId}/source` endpoint operation.")

    public OriginEnum getOrigin() {
        return origin;
    }

    public void setOrigin(OriginEnum origin) {
        this.origin = origin;
    }

    public SummaryCreationPayload attributes(List<AttributesEnum> attributes) {
        this.attributes = attributes;
        return this;
    }

    public SummaryCreationPayload addAttributesItem(AttributesEnum attributesItem) {
        if (this.attributes == null) {
            this.attributes = new ArrayList<>();
        }
        this.attributes.add(attributesItem);
        return this;
    }

    /**
     * Use this parameter to define the elements of a summary that you want to generate. If you do not define this
     * parameter, the API generates a full summary with all attributes. The possible values are &#x60;abstract&#x60; and
     * &#x60;takeaways&#x60;.
     * 
     * @return attributes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Use this parameter to define the elements of a summary that you want to generate. If you do not define this parameter, the API generates a full summary with all attributes. The possible values are `abstract` and `takeaways`.")

    public List<AttributesEnum> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributesEnum> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SummaryCreationPayload summaryCreationPayload = (SummaryCreationPayload) o;
        return Objects.equals(this.videoId, summaryCreationPayload.videoId)
                && Objects.equals(this.origin, summaryCreationPayload.origin)
                && Objects.equals(this.attributes, summaryCreationPayload.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoId, origin, attributes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SummaryCreationPayload {\n");
        sb.append("    videoId: ").append(toIndentedString(videoId)).append("\n");
        sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
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
