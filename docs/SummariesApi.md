# SummariesApi

All URIs are relative to *https://ws.api.video*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](SummariesApi.md#create) | **POST** /summaries | Generate video summary
[**update**](SummariesApi.md#update) | **PATCH** /summaries/{summaryId}/source | Update summary details
[**delete**](SummariesApi.md#delete) | **DELETE** /summaries/{summaryId} | Delete video summary
[**list**](SummariesApi.md#list) | **GET** /summaries | List summaries
[**getSummarySource**](SummariesApi.md#getSummarySource) | **GET** /summaries/{summaryId}/source | Get summary details


<a name="create"></a>
# **create**
> Summary create(summaryCreationPayload)
> okhttp3.Call createAsync(summaryCreationPayload, callback)
> ApiResponse<Summary> createWithHttpInfo(summaryCreationPayload)

Generate video summary

Generate an abstract and key takeaways for a video.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.SummariesApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    SummariesApi apiInstance = client.summaries();
    
    SummaryCreationPayload summaryCreationPayload = new SummaryCreationPayload(); // 
    summaryCreationPayload.setVideoId("vi4k0jvEUuaTdRAEjQ4Jfrgz"); // Create a summary of a video using the video ID.
    summaryCreationPayload.setOrigin("auto"); // Use this parameter to define how the API generates the summary. The only allowed value is &#x60;auto&#x60;, which means that the API generates a summary automatically.

If you do not set this parameter, **the API will not generate a summary automatically**.

In this case, &#x60;sourceStatus&#x60; will return &#x60;missing&#x60;, and you have to manually add a summary using the &#x60;PATCH /summaries/{summaryId}/source&#x60; endpoint operation.
    summaryCreationPayload.setAttributes(); // Use this parameter to define the elements of a summary that you want to generate. If you do not define this parameter, the API generates a full summary with all attributes.


    try {
      Summary result = apiInstance.create(summaryCreationPayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SummariesApi#create");
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
 **summaryCreationPayload** | [**SummaryCreationPayload**](SummaryCreationPayload.md)|  |

### Return type


[**Summary**](Summary.md)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**409** | Conflict |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="update"></a>
# **update**
> SummarySource update(summaryId, summaryUpdatePayload)
> okhttp3.Call updateAsync(summaryId, summaryUpdatePayload, callback)
> ApiResponse<SummarySource> updateWithHttpInfo(summaryId, summaryUpdatePayload)

Update summary details

Update details for a summary.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.SummariesApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient();
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient(Environment.SANDBOX);

    SummariesApi apiInstance = client.summaries();
    
    String summaryId = "summary_1CGHWuXjhxmeH4WiZ51234"; // The unique identifier of the summary source you want to update.
    SummaryUpdatePayload summaryUpdatePayload = new SummaryUpdatePayload(); // 
    summaryUpdatePayload.setAbstract("In this lecture, we discuss how complicated quantum theory is, using the famous example of Schrödingers cat. We also discuss practical applications like quantum computing."); // A short outline of the contents of the video.
    summaryUpdatePayload.setTakeaways(Arrays.asList("Quantum theory is complicated.","Schrödinger's cat is neither dead, nor alive.","Quantum computers are super cool.")); // A list of 3 key points from the video, in chronological order.


    try {
      SummarySource result = apiInstance.update(summaryId, summaryUpdatePayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SummariesApi#update");
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
 **summaryId** | **String**| The unique identifier of the summary source you want to update. |
 **summaryUpdatePayload** | [**SummaryUpdatePayload**](SummaryUpdatePayload.md)|  |

### Return type


[**SummarySource**](SummarySource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**409** | Conflict |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="delete"></a>
# **delete**
> delete(summaryId)
> okhttp3.Call deleteAsync(summaryId, callback)
> ApiResponse<Void> deleteWithHttpInfo(summaryId)

Delete video summary

Delete a summary tied to a video.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.SummariesApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    SummariesApi apiInstance = client.summaries();
    
    String summaryId = "summary_1CGHWuXjhxmeH4WiZ51234"; // The unique identifier of the summary you want to delete.

    try {
      apiInstance.delete(summaryId);
    } catch (ApiException e) {
      System.err.println("Exception when calling SummariesApi#delete");
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
 **summaryId** | **String**| The unique identifier of the summary you want to delete. |

### Return type


null (empty response body)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | No Content |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="list"></a>
# **list**
> SummariesListResponse list().videoId(videoId).origin(origin).sourceStatus(sourceStatus).sortBy(sortBy).sortOrder(sortOrder).currentPage(currentPage).pageSize(pageSize).execute()
> okhttp3.Call executeAsync(callback) 
> ApiResponse<SummariesListResponse> executeWithHttpInfo()

List summaries

List all summarries for your videos in a project.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.SummariesApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient();
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient(Environment.SANDBOX);

    SummariesApi apiInstance = client.summaries();
    
    String videoId = "vilkR8K3N7yrRcxcMt91234"; // Use this parameter to filter for a summary that belongs to a specific video.
    String origin = "auto"; // Use this parameter to filter for summaries based on the way they were created: automatically or manually via the API.
    String sourceStatus = "missing"; // Use this parameter to filter for summaries based on the current status of the summary source.  These are the available statuses:  `missing`: the input for a summary is not present. `waiting` : the input video is being processed and a summary will be generated. `failed`: a technical issue prevented summary generation. `completed`: the summary is generated. `unprocessable`: the API rules the source video to be unsuitable for summary generation. An example for this is an input video that has no audio. 
    String sortBy = "createdAt"; // Use this parameter to choose which field the API will use to sort the response data. The default is `value`.  These are the available fields to sort by:  - `createdAt`: Sorts the results based on date and timestamps when summaries were created. - `updatedAt`: Sorts the results based on date and timestamps when summaries were last updated. - `videoId`: Sorts the results based on video IDs. 
    String sortOrder = "asc"; // Use this parameter to sort results. `asc` is ascending and sorts from A to Z. `desc` is descending and sorts from Z to A.
    Integer currentPage = 1; // Choose the number of search results to return per page. Minimum value: 1
    Integer pageSize = 25; // Results per page. Allowed values 1-100, default is 25.

    try {
      Page<Summary> result = apiInstance.list()
            .videoId(videoId)
            .origin(origin)
            .sourceStatus(sourceStatus)
            .sortBy(sortBy)
            .sortOrder(sortOrder)
            .currentPage(currentPage)
            .pageSize(pageSize)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SummariesApi#list");
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
 **videoId** | **String**| Use this parameter to filter for a summary that belongs to a specific video. | [optional]
 **origin** | **String**| Use this parameter to filter for summaries based on the way they were created: automatically or manually via the API. | [optional] [enum: auto, api]
 **sourceStatus** | **String**| Use this parameter to filter for summaries based on the current status of the summary source.  These are the available statuses:  &#x60;missing&#x60;: the input for a summary is not present. &#x60;waiting&#x60; : the input video is being processed and a summary will be generated. &#x60;failed&#x60;: a technical issue prevented summary generation. &#x60;completed&#x60;: the summary is generated. &#x60;unprocessable&#x60;: the API rules the source video to be unsuitable for summary generation. An example for this is an input video that has no audio.  | [optional] [enum: missing, waiting, failed, completed, unprocessable]
 **sortBy** | **String**| Use this parameter to choose which field the API will use to sort the response data. The default is &#x60;value&#x60;.  These are the available fields to sort by:  - &#x60;createdAt&#x60;: Sorts the results based on date and timestamps when summaries were created. - &#x60;updatedAt&#x60;: Sorts the results based on date and timestamps when summaries were last updated. - &#x60;videoId&#x60;: Sorts the results based on video IDs.  | [optional] [enum: createdAt, updatedAt, videoId]
 **sortOrder** | **String**| Use this parameter to sort results. &#x60;asc&#x60; is ascending and sorts from A to Z. &#x60;desc&#x60; is descending and sorts from Z to A. | [optional] [enum: asc, desc]
 **currentPage** | **Integer**| Choose the number of search results to return per page. Minimum value: 1 | [optional] [default to 1]
 **pageSize** | **Integer**| Results per page. Allowed values 1-100, default is 25. | [optional] [default to 25]

### Return type

[**Page**](pagination.md)<[**Summary**](Summary.md)>


### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Created |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="getSummarySource"></a>
# **getSummarySource**
> SummarySource getSummarySource(summaryId)
> okhttp3.Call getSummarySourceAsync(summaryId, callback)
> ApiResponse<SummarySource> getSummarySourceWithHttpInfo(summaryId)

Get summary details

Get all details for a summary.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.SummariesApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    SummariesApi apiInstance = client.summaries();
    
    String summaryId = "summary_1CGHWuXjhxmeH4WiZ51234"; // The unique identifier of the summary source you want to retrieve.

    try {
      SummarySource result = apiInstance.getSummarySource(summaryId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SummariesApi#getSummarySource");
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
 **summaryId** | **String**| The unique identifier of the summary source you want to retrieve. |

### Return type


[**SummarySource**](SummarySource.md)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**404** | Not Found |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

