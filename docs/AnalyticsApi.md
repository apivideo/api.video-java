# AnalyticsApi

All URIs are relative to *https://ws.api.video*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAggregatedMetrics**](AnalyticsApi.md#getAggregatedMetrics) | **GET** /data/metrics/{metric}/{aggregation} | Retrieve aggregated metrics
[**getMetricsBreakdown**](AnalyticsApi.md#getMetricsBreakdown) | **GET** /data/buckets/{metric}/{breakdown} | Retrieve metrics in a breakdown of dimensions
[**getMetricsOverTime**](AnalyticsApi.md#getMetricsOverTime) | **GET** /data/timeseries/{metric} | Retrieve metrics over time


<a name="getAggregatedMetrics"></a>
# **getAggregatedMetrics**
> AnalyticsAggregatedMetricsResponse getAggregatedMetrics(metric, aggregation).from(from).to(to).unique(unique).viewDuration(viewDuration).filterBy(filterBy).execute()
> okhttp3.Call executeAsync(callback) 
> ApiResponse<AnalyticsAggregatedMetricsResponse> executeWithHttpInfo()

Retrieve aggregated metrics

Retrieve time-based and countable metrics like average watch time or the number of impressions over a certain period of time.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.AnalyticsApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    AnalyticsApi apiInstance = client.analytics();
    
    String metric = "play"; // Use this path parameter to select a metric that you want analytics for.  - `play` is the number of times your content has been played. You can use the aggregations `count`, `rate`, and `total` with the `play` metric. - `start` is the number of times playback was started. You can use the aggregation `count` with this metric. - `end` is the number of times playback has ended with the content watch until the end. You can use the aggregation `count` with this metric. - `impression` is the number of times your content has been loaded and was ready for playback. You can use the aggregation `count` with this metric. - `impression-time` is the time in milliseconds that your content was loading for until the first video frame is displayed. You can use the aggregations `average` and `sum` with this metric. - `watch-time` is the cumulative time in seconds that the user has spent watching your content. You can use the aggregations `average` and `sum` with this metric. - `ccv`: is the number of concurrent viewers, or users watching at the same time. - `view`: the total number of viewers until this point in time. 
    String aggregation = "count"; // Use this path parameter to define a way of collecting data for the metric that you want analytics for.  - `count` returns the overall number of events for the `play` metric. - `rate` returns the ratio that calculates the number of plays your content receives divided by its impressions. This aggregation can be used only with the `play` metric. - `total` calculates the total number of events for the `play` metric.  - `average` calculates an average value for the selected metric. - `sum` adds up the total value of the select metric. - `peak` shows the highest value of the `ccv` metric in the timeframe of your request. You can use this aggregation only with the `ccv` metric. - `live` shows the highest value of the `ccv` metric from the last 20 seconds. You can use this aggregation only with the `ccv` metric. 
    OffsetDateTime from = OffsetDateTime.parse("2024-02-05T00:00:00+01:00"); // Use this query parameter to define the starting date-time of the period you want analytics for.  - If you do not set a value for `from`, the default assigned value is 1 day ago, based on the `to` parameter. - The maximum value is 30 days ago. - The value you provide should follow the ATOM date-time format: `2024-02-05T00:00:00+01:00` - The API ignores this parameter when you call `/data/metrics/play/total`. 
    OffsetDateTime to = OffsetDateTime.parse("2024-02-06T00:00:00+01:00"); // Use this query parameter to define the ending date-time of the period you want analytics for.  - If you do not set a value for `to`, the default assigned value is `now`. - The API ignores this parameter when you call `/data/metrics/play/total`. - The value for `to` is a non-inclusive value: the API returns data **before** the date-time that you set. 
    Boolean unique = true; // Use this query parameter to control how viewer data is counted:  - `true` means that a single user watching multiple times counts as 1 unique viewer - `false` means that all views count, even if from the same user.  The API accepts this parameter only when you use the `ccv` or `view` metric.            Viewers are unique for 1 day.  The API determines uniqueness based on a viewer's `user-agent` and IP address. This means that the API can filter viewers using multiple tabs to watch the same video multiple times, but cannot filter for viewers who use multiple browsers to watch the same content multiple times. 
    String viewDuration = "3s"; // Use this query parameter to define how many seconds a view has to last to be counted in analytics data.  - You can only use this parameter with the `view` metric. - The accepted values are `3s`, `5s`, `10s`, and `30s`.  - If you do not set this parameter, the API defaults to `5s`. 
    FilterBy2 filterBy = new HashMap(); // Use this parameter to filter the API's response based on different data dimensions. You can serialize filters in your query to receive more detailed breakdowns of your analytics.  - If you do not set a value for `filterBy`, the API returns the full dataset for your project. - The API only accepts the `mediaId` and `mediaType` filters when you call `/data/metrics/play/total` or `/data/buckets/play-total/media-id`.  These are the available breakdown dimensions:  - `mediaId`: Returns analytics based on the unique identifiers of a video or a live stream. - `mediaType`: Returns analytics based on the type of content. Possible values: `video` and `live-stream`.  - `continent`: Returns analytics based on the viewers' continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example `EU`. Possible values are: `AS`, `AF`, `NA`, `SA`, `AN`, `EU`, `AZ`.  - `country`: Returns analytics based on the viewers' country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example `FR`. - `deviceType`: Returns analytics based on the type of device used by the viewers. Response values can include: `computer`, `phone`, `tablet`, `tv`, `console`, `wearable`, `unknown`. - `operatingSystem`: Returns analytics based on the operating system used by the viewers. Response values can include `windows`, `mac osx`, `android`, `ios`, `linux`. - `browser`: Returns analytics based on the browser used by the viewers. Response values can include `chrome`, `firefox`, `edge`, `opera`. - `tag`: Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read more about tagging your videos [here](https://docs.api.video/vod/tags-metadata). - `referrer`: Filters data based on the URL where the view is originating from. Accepts an empty string as a value to filter view events where no referrer is available. 
    filterBy.setMediaId(Arrays.asList(Arrays.asList(Arrays.asList("vi4blUQJFrYWbaG44NChkH27")))); // Returns analytics based on the unique identifiers of a video or a live stream.
    filterBy.setMediaType("""video"""); // 
    filterBy.setContinent(Arrays.asList(Arrays.asList(Arrays.asList("EU")))); // Returns analytics based on the viewers&#39; continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;EU&#x60;.
    filterBy.setCountry(Arrays.asList(Arrays.asList(Arrays.asList("FR")))); // Returns analytics based on the viewers&#39; country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;FR&#x60;.
    filterBy.setDeviceType(Arrays.asList(Arrays.asList(Arrays.asList("computer")))); // Returns analytics based on the type of device used by the viewers. Response values can include: &#x60;computer&#x60;, &#x60;phone&#x60;, &#x60;tablet&#x60;, &#x60;tv&#x60;, &#x60;console&#x60;, &#x60;wearable&#x60;, &#x60;unknown&#x60;.
    filterBy.setOperatingSystem(Arrays.asList(Arrays.asList(Arrays.asList("windows")))); // Returns analytics based on the operating system used by the viewers. Response values can include &#x60;windows&#x60;, &#x60;mac osx&#x60;, &#x60;android&#x60;, &#x60;ios&#x60;, &#x60;linux&#x60;.
    filterBy.setBrowser(Arrays.asList(Arrays.asList(Arrays.asList("firefox")))); // Returns analytics based on the browser used by the viewers. Response values can include &#x60;chrome&#x60;, &#x60;firefox&#x60;, &#x60;edge&#x60;, &#x60;opera&#x60;.
    filterBy.setTag("""Cool videos"""); // Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read more about tagging your videos [here](https://docs.api.video/vod/tags-metadata).
    filterBy.setReferrer(Collections.<URI>emptyList()); // Filters data based on the URL where the view is originating from. This filter parameter accepts an empty string to filter view events where no referrer is available.

- The API filters for exact matches. Include the trailing &#x60;/&#x60; characters if needed.
- The URLs you add must be URL encoded.


    try {
      AnalyticsAggregatedMetricsResponse result = apiInstance.getAggregatedMetrics(metric, aggregation)
            .from(from)
            .to(to)
            .unique(unique)
            .viewDuration(viewDuration)
            .filterBy(filterBy)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsApi#getAggregatedMetrics");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getMessage());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **metric** | **String**| Use this path parameter to select a metric that you want analytics for.  - &#x60;play&#x60; is the number of times your content has been played. You can use the aggregations &#x60;count&#x60;, &#x60;rate&#x60;, and &#x60;total&#x60; with the &#x60;play&#x60; metric. - &#x60;start&#x60; is the number of times playback was started. You can use the aggregation &#x60;count&#x60; with this metric. - &#x60;end&#x60; is the number of times playback has ended with the content watch until the end. You can use the aggregation &#x60;count&#x60; with this metric. - &#x60;impression&#x60; is the number of times your content has been loaded and was ready for playback. You can use the aggregation &#x60;count&#x60; with this metric. - &#x60;impression-time&#x60; is the time in milliseconds that your content was loading for until the first video frame is displayed. You can use the aggregations &#x60;average&#x60; and &#x60;sum&#x60; with this metric. - &#x60;watch-time&#x60; is the cumulative time in seconds that the user has spent watching your content. You can use the aggregations &#x60;average&#x60; and &#x60;sum&#x60; with this metric. - &#x60;ccv&#x60;: is the number of concurrent viewers, or users watching at the same time. - &#x60;view&#x60;: the total number of viewers until this point in time.  | [enum: play, start, end, impression, impression-time, watch-time, ccv, view]
 **aggregation** | **String**| Use this path parameter to define a way of collecting data for the metric that you want analytics for.  - &#x60;count&#x60; returns the overall number of events for the &#x60;play&#x60; metric. - &#x60;rate&#x60; returns the ratio that calculates the number of plays your content receives divided by its impressions. This aggregation can be used only with the &#x60;play&#x60; metric. - &#x60;total&#x60; calculates the total number of events for the &#x60;play&#x60; metric.  - &#x60;average&#x60; calculates an average value for the selected metric. - &#x60;sum&#x60; adds up the total value of the select metric. - &#x60;peak&#x60; shows the highest value of the &#x60;ccv&#x60; metric in the timeframe of your request. You can use this aggregation only with the &#x60;ccv&#x60; metric. - &#x60;live&#x60; shows the highest value of the &#x60;ccv&#x60; metric from the last 20 seconds. You can use this aggregation only with the &#x60;ccv&#x60; metric.  | [enum: count, rate, total, average, sum, peak, live]
 **from** | **OffsetDateTime**| Use this query parameter to define the starting date-time of the period you want analytics for.  - If you do not set a value for &#x60;from&#x60;, the default assigned value is 1 day ago, based on the &#x60;to&#x60; parameter. - The maximum value is 30 days ago. - The value you provide should follow the ATOM date-time format: &#x60;2024-02-05T00:00:00+01:00&#x60; - The API ignores this parameter when you call &#x60;/data/metrics/play/total&#x60;.  | [optional]
 **to** | **OffsetDateTime**| Use this query parameter to define the ending date-time of the period you want analytics for.  - If you do not set a value for &#x60;to&#x60;, the default assigned value is &#x60;now&#x60;. - The API ignores this parameter when you call &#x60;/data/metrics/play/total&#x60;. - The value for &#x60;to&#x60; is a non-inclusive value: the API returns data **before** the date-time that you set.  | [optional]
 **unique** | **Boolean**| Use this query parameter to control how viewer data is counted:  - &#x60;true&#x60; means that a single user watching multiple times counts as 1 unique viewer - &#x60;false&#x60; means that all views count, even if from the same user.  The API accepts this parameter only when you use the &#x60;ccv&#x60; or &#x60;view&#x60; metric.            Viewers are unique for 1 day.  The API determines uniqueness based on a viewer&#39;s &#x60;user-agent&#x60; and IP address. This means that the API can filter viewers using multiple tabs to watch the same video multiple times, but cannot filter for viewers who use multiple browsers to watch the same content multiple times.  | [optional]
 **viewDuration** | **String**| Use this query parameter to define how many seconds a view has to last to be counted in analytics data.  - You can only use this parameter with the &#x60;view&#x60; metric. - The accepted values are &#x60;3s&#x60;, &#x60;5s&#x60;, &#x60;10s&#x60;, and &#x60;30s&#x60;.  - If you do not set this parameter, the API defaults to &#x60;5s&#x60;.  | [optional] [enum: 3s, 5s, 10s, 30s]
 **filterBy** | [**FilterBy2**](.md)| Use this parameter to filter the API&#39;s response based on different data dimensions. You can serialize filters in your query to receive more detailed breakdowns of your analytics.  - If you do not set a value for &#x60;filterBy&#x60;, the API returns the full dataset for your project. - The API only accepts the &#x60;mediaId&#x60; and &#x60;mediaType&#x60; filters when you call &#x60;/data/metrics/play/total&#x60; or &#x60;/data/buckets/play-total/media-id&#x60;.  These are the available breakdown dimensions:  - &#x60;mediaId&#x60;: Returns analytics based on the unique identifiers of a video or a live stream. - &#x60;mediaType&#x60;: Returns analytics based on the type of content. Possible values: &#x60;video&#x60; and &#x60;live-stream&#x60;.  - &#x60;continent&#x60;: Returns analytics based on the viewers&#39; continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;EU&#x60;. Possible values are: &#x60;AS&#x60;, &#x60;AF&#x60;, &#x60;NA&#x60;, &#x60;SA&#x60;, &#x60;AN&#x60;, &#x60;EU&#x60;, &#x60;AZ&#x60;.  - &#x60;country&#x60;: Returns analytics based on the viewers&#39; country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;FR&#x60;. - &#x60;deviceType&#x60;: Returns analytics based on the type of device used by the viewers. Response values can include: &#x60;computer&#x60;, &#x60;phone&#x60;, &#x60;tablet&#x60;, &#x60;tv&#x60;, &#x60;console&#x60;, &#x60;wearable&#x60;, &#x60;unknown&#x60;. - &#x60;operatingSystem&#x60;: Returns analytics based on the operating system used by the viewers. Response values can include &#x60;windows&#x60;, &#x60;mac osx&#x60;, &#x60;android&#x60;, &#x60;ios&#x60;, &#x60;linux&#x60;. - &#x60;browser&#x60;: Returns analytics based on the browser used by the viewers. Response values can include &#x60;chrome&#x60;, &#x60;firefox&#x60;, &#x60;edge&#x60;, &#x60;opera&#x60;. - &#x60;tag&#x60;: Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read more about tagging your videos [here](https://docs.api.video/vod/tags-metadata). - &#x60;referrer&#x60;: Filters data based on the URL where the view is originating from. Accepts an empty string as a value to filter view events where no referrer is available.  | [optional]

### Return type


[**AnalyticsAggregatedMetricsResponse**](AnalyticsAggregatedMetricsResponse.md)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad request error |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**404** | Unrecognized request URL |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="getMetricsBreakdown"></a>
# **getMetricsBreakdown**
> AnalyticsMetricsBreakdownResponse getMetricsBreakdown(metric, breakdown).from(from).to(to).sortBy(sortBy).sortOrder(sortOrder).unique(unique).viewDuration(viewDuration).filterBy(filterBy).currentPage(currentPage).pageSize(pageSize).execute()
> okhttp3.Call executeAsync(callback) 
> ApiResponse<AnalyticsMetricsBreakdownResponse> executeWithHttpInfo()

Retrieve metrics in a breakdown of dimensions

Retrieve detailed analytics play-rate and number of impressions segmented by dimensions like country or device type.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.AnalyticsApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    AnalyticsApi apiInstance = client.analytics();
    
    String metric = "play"; // Use this path parameter to select a metric that you want analytics for.  - `play` is the number of times your content has been played. - `play-rate` is the ratio that calculates the number of plays your content receives divided by its impressions. - `play-total` is the total number of times a specific content has been played. You can only use the `media-id` breakdown with this metric. - `start` is the number of times playback was started. - `end` is the number of times playback has ended with the content watch until the end. - `impression` is the number of times your content has been loaded and was ready for playback. - `ccv-peak` is the highest number of concurrent viewers in the timeframe of your request. - `ccv-average` is the average number of concurrent viewers in the timeframe of your request. - `view` is the total number of viewers until this point in time. 
    String breakdown = "media-id"; // Use this path parameter to define a dimension for segmenting analytics data. You must use `kebab-case` for path parameters.  These are the available dimensions:  - `media-id`: Returns analytics based on the unique identifiers of a video or a live stream. - `media-type`: Returns analytics based on the type of content. Possible values: `video` and `live-stream`.  - `continent`: Returns analytics based on the viewers' continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). Possible values are: `AS`, `AF`, `NA`, `SA`, `AN`, `EU`, `AZ`.  - `country`: Returns analytics based on the viewers' country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). - `device-type`: Returns analytics based on the type of device used by the viewers. Response values can include: `computer`, `phone`, `tablet`, `tv`, `console`, `wearable`, `unknown`. - `operating-system`: Returns analytics based on the operating system used by the viewers. Response values can include `windows`, `mac osx`, `android`, `ios`, `linux`. - `browser`: Returns analytics based on the browser used by the viewers. Response values can include `chrome`, `firefox`, `edge`, `opera`. - `referrer`: Returns the URL where the view originates from, for example a website where the video is embedded. View events from Android and iOS return empty strings as the value for `referrer`. 
    OffsetDateTime from = OffsetDateTime.parse("2024-02-05T00:00:00+01:00"); // Use this query parameter to define the starting date-time of the period you want analytics for.  - If you do not set a value for `from`, the default assigned value is 1 day ago, based on the `to` parameter. - The maximum value is 30 days ago. - The value you provide should follow the ATOM date-time format: `2024-02-05T00:00:00+01:00` 
    OffsetDateTime to = OffsetDateTime.parse("2024-02-06T00:00:00+01:00"); // Use this query parameter to define the ending date-time of the period you want analytics for.  - If you do not set a value for `to`, the default assigned value is `now`. - The value for `to` is a non-inclusive value: the API returns data **before** the date-time that you set. 
    String sortBy = "metricValue"; // Use this parameter to choose which field the API will use to sort the analytics data.  These are the available fields to sort by:  - `metricValue`: Sorts the results based on the **metric** you selected in your request. - `dimensionValue`: Sorts the results based on the **dimension** you selected in your request. 
    String sortOrder = "asc"; // Use this parameter to define the sort order of results.  These are the available sort orders:  - `asc`: Sorts the results in ascending order: `A to Z` and `0 to 9`. - `desc`: Sorts the results in descending order: `Z to A` and `9 to 0`. 
    Boolean unique = true; // Use this query parameter to control how viewer data is counted:  - `true` means that a single user watching multiple times counts as 1 unique viewer - `false` means that all views count, even if from the same user.  The API accepts this parameter only when you use the `ccv-peak`, `ccv-average`, or `view` metric.            Viewers are unique for 1 day.  The API determines uniqueness based on a viewer's `user-agent` and IP address. This means that the API can filter viewers using multiple tabs to watch the same video multiple times, but cannot filter for viewers who use multiple browsers to watch the same content multiple times. 
    String viewDuration = "3s"; // Use this query parameter to define how many seconds a view has to last to be counted in analytics data.  - You can only use this parameter together with the `view` metric. - The accepted values are `3s`, `5s`, `10s`, and `30s`.  - If you do not set this parameter, the API defaults to `5s`. 
    FilterBy2 filterBy = new HashMap(); // Use this parameter to filter the API's response based on different data dimensions. You can serialize filters in your query to receive more detailed breakdowns of your analytics.  - If you do not set a value for `filterBy`, the API returns the full dataset for your project. - The API only accepts the `mediaId` and `mediaType` filters when you call `/data/metrics/play/total` or `/data/buckets/play-total/media-id`.  These are the available breakdown dimensions:  - `mediaId`: Returns analytics based on the unique identifiers of a video or a live stream. - `mediaType`: Returns analytics based on the type of content. Possible values: `video` and `live-stream`.  - `continent`: Returns analytics based on the viewers' continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example `EU`. Possible values are: `AS`, `AF`, `NA`, `SA`, `AN`, `EU`, `AZ`.  - `country`: Returns analytics based on the viewers' country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example `FR`. - `deviceType`: Returns analytics based on the type of device used by the viewers. Response values can include: `computer`, `phone`, `tablet`, `tv`, `console`, `wearable`, `unknown`. - `operatingSystem`: Returns analytics based on the operating system used by the viewers. Response values can include `windows`, `mac osx`, `android`, `ios`, `linux`. - `browser`: Returns analytics based on the browser used by the viewers. Response values can include `chrome`, `firefox`, `edge`, `opera`. - `tag`: Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read more about tagging your videos [here](https://docs.api.video/vod/tags-metadata). - `referrer`: Filters data based on the URL where the view is originating from. Accepts an empty string as a value to filter view events where no referrer is available. 
    filterBy.setMediaId(Arrays.asList(Arrays.asList(Arrays.asList("vi4blUQJFrYWbaG44NChkH27")))); // Returns analytics based on the unique identifiers of a video or a live stream.
    filterBy.setMediaType("""video"""); // 
    filterBy.setContinent(Arrays.asList(Arrays.asList(Arrays.asList("EU")))); // Returns analytics based on the viewers&#39; continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;EU&#x60;.
    filterBy.setCountry(Arrays.asList(Arrays.asList(Arrays.asList("FR")))); // Returns analytics based on the viewers&#39; country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;FR&#x60;.
    filterBy.setDeviceType(Arrays.asList(Arrays.asList(Arrays.asList("computer")))); // Returns analytics based on the type of device used by the viewers. Response values can include: &#x60;computer&#x60;, &#x60;phone&#x60;, &#x60;tablet&#x60;, &#x60;tv&#x60;, &#x60;console&#x60;, &#x60;wearable&#x60;, &#x60;unknown&#x60;.
    filterBy.setOperatingSystem(Arrays.asList(Arrays.asList(Arrays.asList("windows")))); // Returns analytics based on the operating system used by the viewers. Response values can include &#x60;windows&#x60;, &#x60;mac osx&#x60;, &#x60;android&#x60;, &#x60;ios&#x60;, &#x60;linux&#x60;.
    filterBy.setBrowser(Arrays.asList(Arrays.asList(Arrays.asList("firefox")))); // Returns analytics based on the browser used by the viewers. Response values can include &#x60;chrome&#x60;, &#x60;firefox&#x60;, &#x60;edge&#x60;, &#x60;opera&#x60;.
    filterBy.setTag("""Cool videos"""); // Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read more about tagging your videos [here](https://docs.api.video/vod/tags-metadata).
    filterBy.setReferrer(Collections.<URI>emptyList()); // Filters data based on the URL where the view is originating from. This filter parameter accepts an empty string to filter view events where no referrer is available.

- The API filters for exact matches. Include the trailing &#x60;/&#x60; characters if needed.
- The URLs you add must be URL encoded.

    Integer currentPage = 1; // Choose the number of search results to return per page. Minimum value: 1
    Integer pageSize = 25; // Results per page. Allowed values 1-100, default is 25.

    try {
      Page<AnalyticsMetricsBreakdownResponseData> result = apiInstance.getMetricsBreakdown(metric, breakdown)
            .from(from)
            .to(to)
            .sortBy(sortBy)
            .sortOrder(sortOrder)
            .unique(unique)
            .viewDuration(viewDuration)
            .filterBy(filterBy)
            .currentPage(currentPage)
            .pageSize(pageSize)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsApi#getMetricsBreakdown");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getMessage());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **metric** | **String**| Use this path parameter to select a metric that you want analytics for.  - &#x60;play&#x60; is the number of times your content has been played. - &#x60;play-rate&#x60; is the ratio that calculates the number of plays your content receives divided by its impressions. - &#x60;play-total&#x60; is the total number of times a specific content has been played. You can only use the &#x60;media-id&#x60; breakdown with this metric. - &#x60;start&#x60; is the number of times playback was started. - &#x60;end&#x60; is the number of times playback has ended with the content watch until the end. - &#x60;impression&#x60; is the number of times your content has been loaded and was ready for playback. - &#x60;ccv-peak&#x60; is the highest number of concurrent viewers in the timeframe of your request. - &#x60;ccv-average&#x60; is the average number of concurrent viewers in the timeframe of your request. - &#x60;view&#x60; is the total number of viewers until this point in time.  | [enum: play, play-rate, play-total, start, end, impression, ccv-peak, ccv-average, view]
 **breakdown** | **String**| Use this path parameter to define a dimension for segmenting analytics data. You must use &#x60;kebab-case&#x60; for path parameters.  These are the available dimensions:  - &#x60;media-id&#x60;: Returns analytics based on the unique identifiers of a video or a live stream. - &#x60;media-type&#x60;: Returns analytics based on the type of content. Possible values: &#x60;video&#x60; and &#x60;live-stream&#x60;.  - &#x60;continent&#x60;: Returns analytics based on the viewers&#39; continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). Possible values are: &#x60;AS&#x60;, &#x60;AF&#x60;, &#x60;NA&#x60;, &#x60;SA&#x60;, &#x60;AN&#x60;, &#x60;EU&#x60;, &#x60;AZ&#x60;.  - &#x60;country&#x60;: Returns analytics based on the viewers&#39; country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). - &#x60;device-type&#x60;: Returns analytics based on the type of device used by the viewers. Response values can include: &#x60;computer&#x60;, &#x60;phone&#x60;, &#x60;tablet&#x60;, &#x60;tv&#x60;, &#x60;console&#x60;, &#x60;wearable&#x60;, &#x60;unknown&#x60;. - &#x60;operating-system&#x60;: Returns analytics based on the operating system used by the viewers. Response values can include &#x60;windows&#x60;, &#x60;mac osx&#x60;, &#x60;android&#x60;, &#x60;ios&#x60;, &#x60;linux&#x60;. - &#x60;browser&#x60;: Returns analytics based on the browser used by the viewers. Response values can include &#x60;chrome&#x60;, &#x60;firefox&#x60;, &#x60;edge&#x60;, &#x60;opera&#x60;. - &#x60;referrer&#x60;: Returns the URL where the view originates from, for example a website where the video is embedded. View events from Android and iOS return empty strings as the value for &#x60;referrer&#x60;.  | [enum: media-id, media-type, continent, country, device-type, operating-system, browser, referrer]
 **from** | **OffsetDateTime**| Use this query parameter to define the starting date-time of the period you want analytics for.  - If you do not set a value for &#x60;from&#x60;, the default assigned value is 1 day ago, based on the &#x60;to&#x60; parameter. - The maximum value is 30 days ago. - The value you provide should follow the ATOM date-time format: &#x60;2024-02-05T00:00:00+01:00&#x60;  | [optional]
 **to** | **OffsetDateTime**| Use this query parameter to define the ending date-time of the period you want analytics for.  - If you do not set a value for &#x60;to&#x60;, the default assigned value is &#x60;now&#x60;. - The value for &#x60;to&#x60; is a non-inclusive value: the API returns data **before** the date-time that you set.  | [optional]
 **sortBy** | **String**| Use this parameter to choose which field the API will use to sort the analytics data.  These are the available fields to sort by:  - &#x60;metricValue&#x60;: Sorts the results based on the **metric** you selected in your request. - &#x60;dimensionValue&#x60;: Sorts the results based on the **dimension** you selected in your request.  | [optional] [enum: metricValue, dimensionValue]
 **sortOrder** | **String**| Use this parameter to define the sort order of results.  These are the available sort orders:  - &#x60;asc&#x60;: Sorts the results in ascending order: &#x60;A to Z&#x60; and &#x60;0 to 9&#x60;. - &#x60;desc&#x60;: Sorts the results in descending order: &#x60;Z to A&#x60; and &#x60;9 to 0&#x60;.  | [optional] [enum: asc, desc]
 **unique** | **Boolean**| Use this query parameter to control how viewer data is counted:  - &#x60;true&#x60; means that a single user watching multiple times counts as 1 unique viewer - &#x60;false&#x60; means that all views count, even if from the same user.  The API accepts this parameter only when you use the &#x60;ccv-peak&#x60;, &#x60;ccv-average&#x60;, or &#x60;view&#x60; metric.            Viewers are unique for 1 day.  The API determines uniqueness based on a viewer&#39;s &#x60;user-agent&#x60; and IP address. This means that the API can filter viewers using multiple tabs to watch the same video multiple times, but cannot filter for viewers who use multiple browsers to watch the same content multiple times.  | [optional]
 **viewDuration** | **String**| Use this query parameter to define how many seconds a view has to last to be counted in analytics data.  - You can only use this parameter together with the &#x60;view&#x60; metric. - The accepted values are &#x60;3s&#x60;, &#x60;5s&#x60;, &#x60;10s&#x60;, and &#x60;30s&#x60;.  - If you do not set this parameter, the API defaults to &#x60;5s&#x60;.  | [optional] [enum: 3s, 5s, 10s, 30s]
 **filterBy** | [**FilterBy2**](.md)| Use this parameter to filter the API&#39;s response based on different data dimensions. You can serialize filters in your query to receive more detailed breakdowns of your analytics.  - If you do not set a value for &#x60;filterBy&#x60;, the API returns the full dataset for your project. - The API only accepts the &#x60;mediaId&#x60; and &#x60;mediaType&#x60; filters when you call &#x60;/data/metrics/play/total&#x60; or &#x60;/data/buckets/play-total/media-id&#x60;.  These are the available breakdown dimensions:  - &#x60;mediaId&#x60;: Returns analytics based on the unique identifiers of a video or a live stream. - &#x60;mediaType&#x60;: Returns analytics based on the type of content. Possible values: &#x60;video&#x60; and &#x60;live-stream&#x60;.  - &#x60;continent&#x60;: Returns analytics based on the viewers&#39; continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;EU&#x60;. Possible values are: &#x60;AS&#x60;, &#x60;AF&#x60;, &#x60;NA&#x60;, &#x60;SA&#x60;, &#x60;AN&#x60;, &#x60;EU&#x60;, &#x60;AZ&#x60;.  - &#x60;country&#x60;: Returns analytics based on the viewers&#39; country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;FR&#x60;. - &#x60;deviceType&#x60;: Returns analytics based on the type of device used by the viewers. Response values can include: &#x60;computer&#x60;, &#x60;phone&#x60;, &#x60;tablet&#x60;, &#x60;tv&#x60;, &#x60;console&#x60;, &#x60;wearable&#x60;, &#x60;unknown&#x60;. - &#x60;operatingSystem&#x60;: Returns analytics based on the operating system used by the viewers. Response values can include &#x60;windows&#x60;, &#x60;mac osx&#x60;, &#x60;android&#x60;, &#x60;ios&#x60;, &#x60;linux&#x60;. - &#x60;browser&#x60;: Returns analytics based on the browser used by the viewers. Response values can include &#x60;chrome&#x60;, &#x60;firefox&#x60;, &#x60;edge&#x60;, &#x60;opera&#x60;. - &#x60;tag&#x60;: Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read more about tagging your videos [here](https://docs.api.video/vod/tags-metadata). - &#x60;referrer&#x60;: Filters data based on the URL where the view is originating from. Accepts an empty string as a value to filter view events where no referrer is available.  | [optional]
 **currentPage** | **Integer**| Choose the number of search results to return per page. Minimum value: 1 | [optional] [default to 1]
 **pageSize** | **Integer**| Results per page. Allowed values 1-100, default is 25. | [optional] [default to 25]

### Return type

[**Page**](pagination.md)<[**AnalyticsMetricsBreakdownResponseData**](AnalyticsMetricsBreakdownResponseData.md)>


### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad request error |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**404** | Unrecognized request URL |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="getMetricsOverTime"></a>
# **getMetricsOverTime**
> AnalyticsMetricsOverTimeResponse getMetricsOverTime(metric).from(from).to(to).interval(interval).sortBy(sortBy).sortOrder(sortOrder).unique(unique).viewDuration(viewDuration).filterBy(filterBy).currentPage(currentPage).pageSize(pageSize).execute()
> okhttp3.Call executeAsync(callback) 
> ApiResponse<AnalyticsMetricsOverTimeResponse> executeWithHttpInfo()

Retrieve metrics over time

Retrieve countable metrics like the number of plays or impressions, grouped by the time at which they occurred

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.AnalyticsApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    AnalyticsApi apiInstance = client.analytics();
    
    String metric = "play"; // Use this path parameter to select a metric that you want analytics for.  - `play` is the number of times your content has been played. - `play-rate` is the ratio that calculates the number of plays your content receives divided by its impressions. - `start` is the number of times playback was started. - `end` is the number of times playback has ended with the content watch until the end. - `impression` is the number of times your content has been loaded and was ready for playback. - `ccv-peak` is the highest number of concurrent viewers in the timeframe of your request. - `ccv-average` is the average number of concurrent viewers in the timeframe of your request. - `view` is the total number of viewers.  
    OffsetDateTime from = OffsetDateTime.parse("2024-02-05T00:00:00+01:00"); // Use this query parameter to define the starting date-time of the period you want analytics for.  - If you do not set a value for `from`, the default assigned value is 1 day ago, based on the `to` parameter. - The maximum value is 30 days ago. - The value you provide should follow the ATOM date-time format: `2024-02-05T00:00:00+01:00` 
    OffsetDateTime to = OffsetDateTime.parse("2024-02-06T00:00:00+01:00"); // Use this query parameter to define the ending date-time of the period you want analytics for.  - If you do not set a value for `to`, the default assigned value is `now`. - The value for `to` is a non-inclusive value: the API returns data **before** the date-time that you set. 
    String interval = "minute"; // Use this query parameter to define the granularity of the data. Possible values: `minute`, `hour`, `day`.  - If you do not set a value for `interval`, and the period you set using the `from` and `to` parameters is less than or equals to 2 days, then the default assigned value is `hour`. Otherwise the API sets it to `day`. - When you set `minute` as interval, the timeframe you define with the `from` and `to` parameters must be less than 60 minutes. 
    String sortBy = "metricValue"; // Use this parameter to choose which field the API will use to sort the analytics data.  These are the available fields to sort by:  - `metricValue`: Sorts the results based on the **metric** you selected in your request. - `emittedAt`: Sorts the results based on the **timestamp** of the event in ATOM date-time format. 
    String sortOrder = "asc"; // Use this parameter to define the sort order of results.  These are the available sort orders:  - `asc`: Sorts the results in ascending order: `A to Z` and `0 to 9`. - `desc`: Sorts the results in descending order: `Z to A` and `9 to 0`. 
    Boolean unique = true; // Use this query parameter to control how viewer data is counted:  - `true` means that a single user watching multiple times counts as 1 unique viewer - `false` means that all views count, even if from the same user.  The API accepts this parameter only when you use the `ccv-peak`, `ccv-average`, or `view` metric.            Viewers are unique for 1 day.  The API determines uniqueness based on a viewer's `user-agent` and IP address. This means that the API can filter viewers using multiple tabs to watch the same video multiple times, but cannot filter for viewers who use multiple browsers to watch the same content multiple times. 
    String viewDuration = "3s"; // Use this query parameter to define how many seconds a view has to last to be counted in analytics data.  - You can only use this parameter together with the `view` metric. - The accepted values are `3s`, `5s`, `10s`, and `30s`.  - If you do not set this parameter, the API defaults to `5s`. 
    FilterBy2 filterBy = new HashMap(); // Use this parameter to filter the API's response based on different data dimensions. You can serialize filters in your query to receive more detailed breakdowns of your analytics.  - If you do not set a value for `filterBy`, the API returns the full dataset for your project. - The API only accepts the `mediaId` and `mediaType` filters when you call `/data/metrics/play/total` or `/data/buckets/play-total/media-id`.  These are the available breakdown dimensions:  - `mediaId`: Returns analytics based on the unique identifiers of a video or a live stream. - `mediaType`: Returns analytics based on the type of content. Possible values: `video` and `live-stream`.  - `continent`: Returns analytics based on the viewers' continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example `EU`. Possible values are: `AS`, `AF`, `NA`, `SA`, `AN`, `EU`, `AZ`.  - `country`: Returns analytics based on the viewers' country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example `FR`. - `deviceType`: Returns analytics based on the type of device used by the viewers. Response values can include: `computer`, `phone`, `tablet`, `tv`, `console`, `wearable`, `unknown`. - `operatingSystem`: Returns analytics based on the operating system used by the viewers. Response values can include `windows`, `mac osx`, `android`, `ios`, `linux`. - `browser`: Returns analytics based on the browser used by the viewers. Response values can include `chrome`, `firefox`, `edge`, `opera`. - `tag`: Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read more about tagging your videos [here](https://docs.api.video/vod/tags-metadata). - `referrer`: Filters data based on the URL where the view is originating from. Accepts an empty string as a value to filter view events where no referrer is available. 
    filterBy.setMediaId(Arrays.asList(Arrays.asList(Arrays.asList("vi4blUQJFrYWbaG44NChkH27")))); // Returns analytics based on the unique identifiers of a video or a live stream.
    filterBy.setMediaType("""video"""); // 
    filterBy.setContinent(Arrays.asList(Arrays.asList(Arrays.asList("EU")))); // Returns analytics based on the viewers&#39; continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;EU&#x60;.
    filterBy.setCountry(Arrays.asList(Arrays.asList(Arrays.asList("FR")))); // Returns analytics based on the viewers&#39; country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;FR&#x60;.
    filterBy.setDeviceType(Arrays.asList(Arrays.asList(Arrays.asList("computer")))); // Returns analytics based on the type of device used by the viewers. Response values can include: &#x60;computer&#x60;, &#x60;phone&#x60;, &#x60;tablet&#x60;, &#x60;tv&#x60;, &#x60;console&#x60;, &#x60;wearable&#x60;, &#x60;unknown&#x60;.
    filterBy.setOperatingSystem(Arrays.asList(Arrays.asList(Arrays.asList("windows")))); // Returns analytics based on the operating system used by the viewers. Response values can include &#x60;windows&#x60;, &#x60;mac osx&#x60;, &#x60;android&#x60;, &#x60;ios&#x60;, &#x60;linux&#x60;.
    filterBy.setBrowser(Arrays.asList(Arrays.asList(Arrays.asList("firefox")))); // Returns analytics based on the browser used by the viewers. Response values can include &#x60;chrome&#x60;, &#x60;firefox&#x60;, &#x60;edge&#x60;, &#x60;opera&#x60;.
    filterBy.setTag("""Cool videos"""); // Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read more about tagging your videos [here](https://docs.api.video/vod/tags-metadata).
    filterBy.setReferrer(Collections.<URI>emptyList()); // Filters data based on the URL where the view is originating from. This filter parameter accepts an empty string to filter view events where no referrer is available.

- The API filters for exact matches. Include the trailing &#x60;/&#x60; characters if needed.
- The URLs you add must be URL encoded.

    Integer currentPage = 1; // Choose the number of search results to return per page. Minimum value: 1
    Integer pageSize = 25; // Results per page. Allowed values 1-100, default is 25.

    try {
      Page<AnalyticsMetricsOverTimeResponseData> result = apiInstance.getMetricsOverTime(metric)
            .from(from)
            .to(to)
            .interval(interval)
            .sortBy(sortBy)
            .sortOrder(sortOrder)
            .unique(unique)
            .viewDuration(viewDuration)
            .filterBy(filterBy)
            .currentPage(currentPage)
            .pageSize(pageSize)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsApi#getMetricsOverTime");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getMessage());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **metric** | **String**| Use this path parameter to select a metric that you want analytics for.  - &#x60;play&#x60; is the number of times your content has been played. - &#x60;play-rate&#x60; is the ratio that calculates the number of plays your content receives divided by its impressions. - &#x60;start&#x60; is the number of times playback was started. - &#x60;end&#x60; is the number of times playback has ended with the content watch until the end. - &#x60;impression&#x60; is the number of times your content has been loaded and was ready for playback. - &#x60;ccv-peak&#x60; is the highest number of concurrent viewers in the timeframe of your request. - &#x60;ccv-average&#x60; is the average number of concurrent viewers in the timeframe of your request. - &#x60;view&#x60; is the total number of viewers.   | [enum: play, play-rate, start, end, impression, ccv-peak, ccv-average, view]
 **from** | **OffsetDateTime**| Use this query parameter to define the starting date-time of the period you want analytics for.  - If you do not set a value for &#x60;from&#x60;, the default assigned value is 1 day ago, based on the &#x60;to&#x60; parameter. - The maximum value is 30 days ago. - The value you provide should follow the ATOM date-time format: &#x60;2024-02-05T00:00:00+01:00&#x60;  | [optional]
 **to** | **OffsetDateTime**| Use this query parameter to define the ending date-time of the period you want analytics for.  - If you do not set a value for &#x60;to&#x60;, the default assigned value is &#x60;now&#x60;. - The value for &#x60;to&#x60; is a non-inclusive value: the API returns data **before** the date-time that you set.  | [optional]
 **interval** | **String**| Use this query parameter to define the granularity of the data. Possible values: &#x60;minute&#x60;, &#x60;hour&#x60;, &#x60;day&#x60;.  - If you do not set a value for &#x60;interval&#x60;, and the period you set using the &#x60;from&#x60; and &#x60;to&#x60; parameters is less than or equals to 2 days, then the default assigned value is &#x60;hour&#x60;. Otherwise the API sets it to &#x60;day&#x60;. - When you set &#x60;minute&#x60; as interval, the timeframe you define with the &#x60;from&#x60; and &#x60;to&#x60; parameters must be less than 60 minutes.  | [optional] [enum: minute, hour, day]
 **sortBy** | **String**| Use this parameter to choose which field the API will use to sort the analytics data.  These are the available fields to sort by:  - &#x60;metricValue&#x60;: Sorts the results based on the **metric** you selected in your request. - &#x60;emittedAt&#x60;: Sorts the results based on the **timestamp** of the event in ATOM date-time format.  | [optional] [enum: metricValue, emittedAt]
 **sortOrder** | **String**| Use this parameter to define the sort order of results.  These are the available sort orders:  - &#x60;asc&#x60;: Sorts the results in ascending order: &#x60;A to Z&#x60; and &#x60;0 to 9&#x60;. - &#x60;desc&#x60;: Sorts the results in descending order: &#x60;Z to A&#x60; and &#x60;9 to 0&#x60;.  | [optional] [enum: asc, desc]
 **unique** | **Boolean**| Use this query parameter to control how viewer data is counted:  - &#x60;true&#x60; means that a single user watching multiple times counts as 1 unique viewer - &#x60;false&#x60; means that all views count, even if from the same user.  The API accepts this parameter only when you use the &#x60;ccv-peak&#x60;, &#x60;ccv-average&#x60;, or &#x60;view&#x60; metric.            Viewers are unique for 1 day.  The API determines uniqueness based on a viewer&#39;s &#x60;user-agent&#x60; and IP address. This means that the API can filter viewers using multiple tabs to watch the same video multiple times, but cannot filter for viewers who use multiple browsers to watch the same content multiple times.  | [optional]
 **viewDuration** | **String**| Use this query parameter to define how many seconds a view has to last to be counted in analytics data.  - You can only use this parameter together with the &#x60;view&#x60; metric. - The accepted values are &#x60;3s&#x60;, &#x60;5s&#x60;, &#x60;10s&#x60;, and &#x60;30s&#x60;.  - If you do not set this parameter, the API defaults to &#x60;5s&#x60;.  | [optional] [enum: 3s, 5s, 10s, 30s]
 **filterBy** | [**FilterBy2**](.md)| Use this parameter to filter the API&#39;s response based on different data dimensions. You can serialize filters in your query to receive more detailed breakdowns of your analytics.  - If you do not set a value for &#x60;filterBy&#x60;, the API returns the full dataset for your project. - The API only accepts the &#x60;mediaId&#x60; and &#x60;mediaType&#x60; filters when you call &#x60;/data/metrics/play/total&#x60; or &#x60;/data/buckets/play-total/media-id&#x60;.  These are the available breakdown dimensions:  - &#x60;mediaId&#x60;: Returns analytics based on the unique identifiers of a video or a live stream. - &#x60;mediaType&#x60;: Returns analytics based on the type of content. Possible values: &#x60;video&#x60; and &#x60;live-stream&#x60;.  - &#x60;continent&#x60;: Returns analytics based on the viewers&#39; continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;EU&#x60;. Possible values are: &#x60;AS&#x60;, &#x60;AF&#x60;, &#x60;NA&#x60;, &#x60;SA&#x60;, &#x60;AN&#x60;, &#x60;EU&#x60;, &#x60;AZ&#x60;.  - &#x60;country&#x60;: Returns analytics based on the viewers&#39; country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example &#x60;FR&#x60;. - &#x60;deviceType&#x60;: Returns analytics based on the type of device used by the viewers. Response values can include: &#x60;computer&#x60;, &#x60;phone&#x60;, &#x60;tablet&#x60;, &#x60;tv&#x60;, &#x60;console&#x60;, &#x60;wearable&#x60;, &#x60;unknown&#x60;. - &#x60;operatingSystem&#x60;: Returns analytics based on the operating system used by the viewers. Response values can include &#x60;windows&#x60;, &#x60;mac osx&#x60;, &#x60;android&#x60;, &#x60;ios&#x60;, &#x60;linux&#x60;. - &#x60;browser&#x60;: Returns analytics based on the browser used by the viewers. Response values can include &#x60;chrome&#x60;, &#x60;firefox&#x60;, &#x60;edge&#x60;, &#x60;opera&#x60;. - &#x60;tag&#x60;: Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read more about tagging your videos [here](https://docs.api.video/vod/tags-metadata). - &#x60;referrer&#x60;: Filters data based on the URL where the view is originating from. Accepts an empty string as a value to filter view events where no referrer is available.  | [optional]
 **currentPage** | **Integer**| Choose the number of search results to return per page. Minimum value: 1 | [optional] [default to 1]
 **pageSize** | **Integer**| Results per page. Allowed values 1-100, default is 25. | [optional] [default to 25]

### Return type

[**Page**](pagination.md)<[**AnalyticsMetricsOverTimeResponseData**](AnalyticsMetricsOverTimeResponseData.md)>


### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad request error |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**404** | Unrecognized request URL |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

