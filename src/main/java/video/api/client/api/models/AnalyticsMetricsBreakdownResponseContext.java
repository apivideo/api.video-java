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
import video.api.client.api.models.AnalyticsAggregatedMetricsResponseContextTimeframe;
import java.io.Serializable;

/**
 * AnalyticsMetricsBreakdownResponseContext
 */

public class AnalyticsMetricsBreakdownResponseContext implements Serializable, DeepObject {
    private static final long serialVersionUID = 1L;

    /**
     * Returns the metric and relevant parameters you selected.
     */
    @JsonAdapter(MetricEnum.Adapter.class)
    public enum MetricEnum {
        PLAY("play"),

        PLAY_RATE("play-rate"),

        START("start"),

        END("end"),

        IMPRESSION("impression"),

        CCV_AVERAGE("ccv-average"),

        CCV_PEAK("ccv-peak"),

        UNIQUE_CCV_AVERAGE("unique-ccv-average"),

        UNIQUE_CCV_PEAK("unique-ccv-peak"),

        VIEW_3("view-3"),

        VIEW_5("view-5"),

        VIEW_10("view-10"),

        VIEW_30("view-30"),

        UNIQUE_VIEW("unique-view"),

        UNIQUE_VIEW_3("unique-view-3"),

        UNIQUE_VIEW_5("unique-view-5"),

        UNIQUE_VIEW_10("unique-view-10"),

        UNIQUE_VIEW_30("unique-view-30");

        private String value;

        MetricEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static MetricEnum fromValue(String value) {
            for (MetricEnum b : MetricEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<MetricEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final MetricEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public MetricEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return MetricEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_METRIC = "metric";
    @SerializedName(SERIALIZED_NAME_METRIC)
    private MetricEnum metric;

    /**
     * Returns the dimension you selected.
     */
    @JsonAdapter(BreakdownEnum.Adapter.class)
    public enum BreakdownEnum {
        MEDIA_ID("media-id"),

        MEDIA_TYPE("media-type"),

        CONTINENT("continent"),

        COUNTRY("country"),

        DEVICE_TYPE("device-type"),

        OPERATING_SYSTEM("operating-system"),

        BROWSER("browser");

        private String value;

        BreakdownEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static BreakdownEnum fromValue(String value) {
            for (BreakdownEnum b : BreakdownEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<BreakdownEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final BreakdownEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public BreakdownEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return BreakdownEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_BREAKDOWN = "breakdown";
    @SerializedName(SERIALIZED_NAME_BREAKDOWN)
    private BreakdownEnum breakdown;

    public static final String SERIALIZED_NAME_TIMEFRAME = "timeframe";
    @SerializedName(SERIALIZED_NAME_TIMEFRAME)
    private AnalyticsAggregatedMetricsResponseContextTimeframe timeframe;

    public AnalyticsMetricsBreakdownResponseContext metric(MetricEnum metric) {
        this.metric = metric;
        return this;
    }

    /**
     * Returns the metric and relevant parameters you selected.
     * 
     * @return metric
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "impression", value = "Returns the metric and relevant parameters you selected.")

    public MetricEnum getMetric() {
        return metric;
    }

    public void setMetric(MetricEnum metric) {
        this.metric = metric;
    }

    public AnalyticsMetricsBreakdownResponseContext breakdown(BreakdownEnum breakdown) {
        this.breakdown = breakdown;
        return this;
    }

    /**
     * Returns the dimension you selected.
     * 
     * @return breakdown
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "country", value = "Returns the dimension you selected.")

    public BreakdownEnum getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(BreakdownEnum breakdown) {
        this.breakdown = breakdown;
    }

    public AnalyticsMetricsBreakdownResponseContext timeframe(
            AnalyticsAggregatedMetricsResponseContextTimeframe timeframe) {
        this.timeframe = timeframe;
        return this;
    }

    /**
     * Get timeframe
     * 
     * @return timeframe
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public AnalyticsAggregatedMetricsResponseContextTimeframe getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(AnalyticsAggregatedMetricsResponseContextTimeframe timeframe) {
        this.timeframe = timeframe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnalyticsMetricsBreakdownResponseContext analyticsMetricsBreakdownResponseContext = (AnalyticsMetricsBreakdownResponseContext) o;
        return Objects.equals(this.metric, analyticsMetricsBreakdownResponseContext.metric)
                && Objects.equals(this.breakdown, analyticsMetricsBreakdownResponseContext.breakdown)
                && Objects.equals(this.timeframe, analyticsMetricsBreakdownResponseContext.timeframe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metric, breakdown, timeframe);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AnalyticsMetricsBreakdownResponseContext {\n");
        sb.append("    metric: ").append(toIndentedString(metric)).append("\n");
        sb.append("    breakdown: ").append(toIndentedString(breakdown)).append("\n");
        sb.append("    timeframe: ").append(toIndentedString(timeframe)).append("\n");
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
