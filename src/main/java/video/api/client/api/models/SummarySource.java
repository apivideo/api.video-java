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
 * SummarySource
 */

public class SummarySource implements Serializable, DeepObject {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_ABSTRACT = "abstract";
    @SerializedName(SERIALIZED_NAME_ABSTRACT)
    private String _abstract;

    public static final String SERIALIZED_NAME_TAKEAWAYS = "takeaways";
    @SerializedName(SERIALIZED_NAME_TAKEAWAYS)
    private List<String> takeaways = null;

    public SummarySource _abstract(String _abstract) {
        this._abstract = _abstract;
        return this;
    }

    /**
     * A short outline of the contents of the video. The length of an &#x60;abstract&#x60; depends on the amount of
     * content in a video that can be transcribed. The API condenses the contents into minimum 20, maximum 300 words.
     * 
     * @return _abstract
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "In this lecture, we discuss how complicated quantum theory is, using the famous example of Schrödingers cat. We also discuss practical applications like quantum computing.", value = "A short outline of the contents of the video. The length of an `abstract` depends on the amount of content in a video that can be transcribed. The API condenses the contents into minimum 20, maximum 300 words.")

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public SummarySource takeaways(List<String> takeaways) {
        this.takeaways = takeaways;
        return this;
    }

    public SummarySource addTakeawaysItem(String takeawaysItem) {
        if (this.takeaways == null) {
            this.takeaways = new ArrayList<>();
        }
        this.takeaways.add(takeawaysItem);
        return this;
    }

    /**
     * A list of 3 key points from the video, in chronological order.
     * 
     * @return takeaways
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"Quantum theory is complicated.\",\"Schrödinger's cat is neither dead, nor alive.\",\"Quantum computers are super cool.\"]", value = "A list of 3 key points from the video, in chronological order.")

    public List<String> getTakeaways() {
        return takeaways;
    }

    public void setTakeaways(List<String> takeaways) {
        this.takeaways = takeaways;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SummarySource summarySource = (SummarySource) o;
        return Objects.equals(this._abstract, summarySource._abstract)
                && Objects.equals(this.takeaways, summarySource.takeaways);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_abstract, takeaways);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SummarySource {\n");
        sb.append("    _abstract: ").append(toIndentedString(_abstract)).append("\n");
        sb.append("    takeaways: ").append(toIndentedString(takeaways)).append("\n");
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
