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
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Webhook
 */

public class Webhook implements Serializable, DeepObject {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_WEBHOOK_ID = "webhookId";
    @SerializedName(SERIALIZED_NAME_WEBHOOK_ID)
    private String webhookId;

    public static final String SERIALIZED_NAME_CREATED_AT = "createdAt";
    @SerializedName(SERIALIZED_NAME_CREATED_AT)
    private OffsetDateTime createdAt;

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
    private List<EventsEnum> events = null;

    public static final String SERIALIZED_NAME_URL = "url";
    @SerializedName(SERIALIZED_NAME_URL)
    private String url;

    public static final String SERIALIZED_NAME_SIGNATURE_SECRET = "signatureSecret";
    @SerializedName(SERIALIZED_NAME_SIGNATURE_SECRET)
    private String signatureSecret;

    public Webhook webhookId(String webhookId) {
        this.webhookId = webhookId;
        return this;
    }

    /**
     * A unique identifier of the webhook you subscribed to.
     * 
     * @return webhookId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "webhook_XXXXXXXXXXXXXXX", value = "A unique identifier of the webhook you subscribed to.")

    public String getWebhookId() {
        return webhookId;
    }

    public void setWebhookId(String webhookId) {
        this.webhookId = webhookId;
    }

    public Webhook createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The time and date when you created this webhook subscription, in ATOM UTC format.
     * 
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2019-06-24T11:45:01Z", value = "The time and date when you created this webhook subscription, in ATOM UTC format.")

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Webhook events(List<EventsEnum> events) {
        this.events = events;
        return this;
    }

    public Webhook addEventsItem(EventsEnum eventsItem) {
        if (this.events == null) {
            this.events = new ArrayList<>();
        }
        this.events.add(eventsItem);
        return this;
    }

    /**
     * A list of events that you subscribed to. When these events occur, the API triggers a webhook call to the URL you
     * provided.
     * 
     * @return events
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"video.encoding.quality.completed\"]", value = "A list of events that you subscribed to. When these events occur, the API triggers a webhook call to the URL you provided.")

    public List<EventsEnum> getEvents() {
        return events;
    }

    public void setEvents(List<EventsEnum> events) {
        this.events = events;
    }

    public Webhook url(String url) {
        this.url = url;
        return this;
    }

    /**
     * The URL where the API sends the webhook.
     * 
     * @return url
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "http://clientnotificationserver.com/notif?myquery=query", value = "The URL where the API sends the webhook.")

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Webhook signatureSecret(String signatureSecret) {
        this.signatureSecret = signatureSecret;
        return this;
    }

    /**
     * A secret key for the webhook you subscribed to. You can use it to verify the origin of the webhook call that you
     * receive.
     * 
     * @return signatureSecret
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "A secret key for the webhook you subscribed to. You can use it to verify the origin of the webhook call that you receive.")

    public String getSignatureSecret() {
        return signatureSecret;
    }

    public void setSignatureSecret(String signatureSecret) {
        this.signatureSecret = signatureSecret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Webhook webhook = (Webhook) o;
        return Objects.equals(this.webhookId, webhook.webhookId) && Objects.equals(this.createdAt, webhook.createdAt)
                && Objects.equals(this.events, webhook.events) && Objects.equals(this.url, webhook.url)
                && Objects.equals(this.signatureSecret, webhook.signatureSecret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webhookId, createdAt, events, url, signatureSecret);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Webhook {\n");
        sb.append("    webhookId: ").append(toIndentedString(webhookId)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    events: ").append(toIndentedString(events)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    signatureSecret: ").append(toIndentedString(signatureSecret)).append("\n");
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
