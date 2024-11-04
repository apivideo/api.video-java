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
import video.api.client.api.models.AnalyticsMetricsOverTimeResponseContext;
import video.api.client.api.models.AnalyticsMetricsOverTimeResponseData;
import video.api.client.api.models.Pagination;
import java.io.Serializable;

/**
 * AnalyticsMetricsOverTimeResponse
 */

public class AnalyticsMetricsOverTimeResponse implements Serializable, DeepObject {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_CONTEXT = "context";
    @SerializedName(SERIALIZED_NAME_CONTEXT)
    private AnalyticsMetricsOverTimeResponseContext context;

    public static final String SERIALIZED_NAME_DATA = "data";
    @SerializedName(SERIALIZED_NAME_DATA)
    private List<AnalyticsMetricsOverTimeResponseData> data = new ArrayList<>();

    public static final String SERIALIZED_NAME_PAGINATION = "pagination";
    @SerializedName(SERIALIZED_NAME_PAGINATION)
    private Pagination pagination;

    public AnalyticsMetricsOverTimeResponse context(AnalyticsMetricsOverTimeResponseContext context) {
        this.context = context;
        return this;
    }

    /**
     * Get context
     * 
     * @return context
     **/
    @ApiModelProperty(required = true, value = "")

    public AnalyticsMetricsOverTimeResponseContext getContext() {
        return context;
    }

    public void setContext(AnalyticsMetricsOverTimeResponseContext context) {
        this.context = context;
    }

    public AnalyticsMetricsOverTimeResponse data(List<AnalyticsMetricsOverTimeResponseData> data) {
        this.data = data;
        return this;
    }

    public AnalyticsMetricsOverTimeResponse addDataItem(AnalyticsMetricsOverTimeResponseData dataItem) {
        this.data.add(dataItem);
        return this;
    }

    /**
     * Returns an array of metrics and the timestamps.
     * 
     * @return data
     **/
    @ApiModelProperty(required = true, value = "Returns an array of metrics and the timestamps.")

    public List<AnalyticsMetricsOverTimeResponseData> getData() {
        return data;
    }

    public void setData(List<AnalyticsMetricsOverTimeResponseData> data) {
        this.data = data;
    }

    public AnalyticsMetricsOverTimeResponse pagination(Pagination pagination) {
        this.pagination = pagination;
        return this;
    }

    /**
     * Get pagination
     * 
     * @return pagination
     **/
    @ApiModelProperty(required = true, value = "")

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnalyticsMetricsOverTimeResponse analyticsMetricsOverTimeResponse = (AnalyticsMetricsOverTimeResponse) o;
        return Objects.equals(this.context, analyticsMetricsOverTimeResponse.context)
                && Objects.equals(this.data, analyticsMetricsOverTimeResponse.data)
                && Objects.equals(this.pagination, analyticsMetricsOverTimeResponse.pagination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(context, data, pagination);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AnalyticsMetricsOverTimeResponse {\n");
        sb.append("    context: ").append(toIndentedString(context)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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
