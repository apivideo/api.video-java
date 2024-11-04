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
 * AnalyticsAggregatedMetricsResponseContext
 */

public class AnalyticsAggregatedMetricsResponseContext implements Serializable, DeepObject {
    private static final long serialVersionUID = 1L;

    /**
     * Returns the metric and relevant parameters you selected.
     */
    @JsonAdapter(MetricEnum.Adapter.class)
    public enum MetricEnum {
        PLAY("play"),

        START("start"),

        END("end"),

        IMPRESSION("impression"),

        IMPRESSION_TIME("impression-time"),

        WATCH_TIME("watch-time"),

        CCV("ccv"),

        UNIQUE_CCV("unique-ccv"),

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
     * Returns the aggregation you selected.
     */
    @JsonAdapter(AggregationEnum.Adapter.class)
    public enum AggregationEnum {
        COUNT("count"),

        RATE("rate"),

        TOTAL("total"),

        AVERAGE("average"),

        SUM("sum");

        private String value;

        AggregationEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static AggregationEnum fromValue(String value) {
            for (AggregationEnum b : AggregationEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<AggregationEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final AggregationEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public AggregationEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return AggregationEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_AGGREGATION = "aggregation";
    @SerializedName(SERIALIZED_NAME_AGGREGATION)
    private AggregationEnum aggregation;

    public static final String SERIALIZED_NAME_TIMEFRAME = "timeframe";
    @SerializedName(SERIALIZED_NAME_TIMEFRAME)
    private AnalyticsAggregatedMetricsResponseContextTimeframe timeframe;

    public AnalyticsAggregatedMetricsResponseContext metric(MetricEnum metric) {
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

    public AnalyticsAggregatedMetricsResponseContext aggregation(AggregationEnum aggregation) {
        this.aggregation = aggregation;
        return this;
    }

    /**
     * Returns the aggregation you selected.
     * 
     * @return aggregation
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "count", value = "Returns the aggregation you selected.")

    public AggregationEnum getAggregation() {
        return aggregation;
    }

    public void setAggregation(AggregationEnum aggregation) {
        this.aggregation = aggregation;
    }

    public AnalyticsAggregatedMetricsResponseContext timeframe(
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
        AnalyticsAggregatedMetricsResponseContext analyticsAggregatedMetricsResponseContext = (AnalyticsAggregatedMetricsResponseContext) o;
        return Objects.equals(this.metric, analyticsAggregatedMetricsResponseContext.metric)
                && Objects.equals(this.aggregation, analyticsAggregatedMetricsResponseContext.aggregation)
                && Objects.equals(this.timeframe, analyticsAggregatedMetricsResponseContext.timeframe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metric, aggregation, timeframe);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AnalyticsAggregatedMetricsResponseContext {\n");
        sb.append("    metric: ").append(toIndentedString(metric)).append("\n");
        sb.append("    aggregation: ").append(toIndentedString(aggregation)).append("\n");
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
