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
 * WebhooksCreationPayload
 */

public class WebhooksCreationPayload implements Serializable, DeepObject {
    private static final long serialVersionUID = 1L;

    /**
     * Gets or Sets events
     */
    @JsonAdapter(EventsEnum.Adapter.class)
    public enum EventsEnum {
        LIVE_STREAM_BROADCAST_STARTED("live-stream.broadcast.started"),

        LIVE_STREAM_BROADCAST_ENDED("live-stream.broadcast.ended"),

        VIDEO_SOURCE_RECORDED("video.source.recorded"),

        VIDEO_ENCODING_QUALITY_COMPLETED("video.encoding.quality.completed"),

        VIDEO_CAPTION_GENERATED("video.caption.generated"),

        VIDEO_SUMMARY_GENERATED("video.summary.generated");

        private String value;

        EventsEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static EventsEnum fromValue(String value) {
            for (EventsEnum b : EventsEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<EventsEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final EventsEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public EventsEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return EventsEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_EVENTS = "events";
    @SerializedName(SERIALIZED_NAME_EVENTS)
    private List<EventsEnum> events = new ArrayList<>();

    public static final String SERIALIZED_NAME_URL = "url";
    @SerializedName(SERIALIZED_NAME_URL)
    private String url;

    public WebhooksCreationPayload events(List<EventsEnum> events) {
        this.events = events;
        return this;
    }

    public WebhooksCreationPayload addEventsItem(EventsEnum eventsItem) {
        this.events.add(eventsItem);
        return this;
    }

    /**
     * An array of webhook events that you want to subscribe to.
     * 
     * @return events
     **/
    @ApiModelProperty(example = "[\"video.encoding.quality.completed\"]", required = true, value = "An array of webhook events that you want to subscribe to.")

    public List<EventsEnum> getEvents() {
        return events;
    }

    public void setEvents(List<EventsEnum> events) {
        this.events = events;
    }

    public WebhooksCreationPayload url(String url) {
        this.url = url;
        return this;
    }

    /**
     * The the url to which HTTP notifications are sent. It could be any http or https URL.
     * 
     * @return url
     **/
    @ApiModelProperty(example = "https://example.com/webhooks", required = true, value = "The the url to which HTTP notifications are sent. It could be any http or https URL.")

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WebhooksCreationPayload webhooksCreationPayload = (WebhooksCreationPayload) o;
        return Objects.equals(this.events, webhooksCreationPayload.events)
                && Objects.equals(this.url, webhooksCreationPayload.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(events, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WebhooksCreationPayload {\n");
        sb.append("    events: ").append(toIndentedString(events)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
