# VideosApi

All URIs are relative to *https://ws.api.video*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](VideosApi.md#create) | **POST** /videos | Create a video object
[**upload**](VideosApi.md#upload) | **POST** /videos/{videoId}/source | Upload a video
[**uploadWithUploadToken**](VideosApi.md#uploadWithUploadToken) | **POST** /upload | Upload with an delegated upload token
[**get**](VideosApi.md#get) | **GET** /videos/{videoId} | Retrieve a video object
[**update**](VideosApi.md#update) | **PATCH** /videos/{videoId} | Update a video object
[**delete**](VideosApi.md#delete) | **DELETE** /videos/{videoId} | Delete a video object
[**list**](VideosApi.md#list) | **GET** /videos | List all video objects
[**uploadThumbnail**](VideosApi.md#uploadThumbnail) | **POST** /videos/{videoId}/thumbnail | Upload a thumbnail
[**pickThumbnail**](VideosApi.md#pickThumbnail) | **PATCH** /videos/{videoId}/thumbnail | Set a thumbnail
[**getDiscarded**](VideosApi.md#getDiscarded) | **GET** /discarded/videos/{videoId} | Retrieve a discarded video object
[**getStatus**](VideosApi.md#getStatus) | **GET** /videos/{videoId}/status | Retrieve video status and details
[**listDiscarded**](VideosApi.md#listDiscarded) | **GET** /discarded/videos | List all discarded video objects
[**updateDiscarded**](VideosApi.md#updateDiscarded) | **PATCH** /discarded/videos/{videoId} | Update a discarded video object


<a name="create"></a>
# **create**
> Video create(videoCreationPayload)
> okhttp3.Call createAsync(videoCreationPayload, callback)
> ApiResponse<Video> createWithHttpInfo(videoCreationPayload)

Create a video object

Creates a video object. More information on video objects can be found [here](https://docs.api.video/reference/api/Videos). 

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    VideoCreationPayload videoCreationPayload = new VideoCreationPayload(); // video to create
    videoCreationPayload.setTitle("Maths video"); // The title of your new video.
    videoCreationPayload.setDescription("A video about string theory."); // A brief description of your video.
    videoCreationPayload.setSource("https://www.myvideo.url.com/video.mp4 OR vi4k0jvEUuaTdRAEjQ4JfOyl"); // You can either add a video already on the web, by entering the URL of the video, or you can also enter the &#x60;videoId&#x60; of one of the videos you already have on your api.video acccount, and this will generate a copy of your video. Creating a copy of a video can be especially useful if you want to keep your original video and trim or apply a watermark onto the copy you would create.
    videoCreationPayload.setPublic(true); // Default: True. If set to &#x60;false&#x60; the video will become private. More information on private videos can be found [here](https://docs.api.video/delivery/video-privacy-access-management)
    videoCreationPayload.setPanoramic(false); // Indicates if your video is a 360/immersive video.
    videoCreationPayload.setMp4Support(true); // Enables mp4 version in addition to streamed version.
    videoCreationPayload.setPlayerId("pl45KFKdlddgk654dspkze"); // The unique identification number for your video player.
    videoCreationPayload.setTags(Arrays.asList("maths", "string theory", "video")); // A list of tags you want to use to describe your video.
    videoCreationPayload.setMetadata(Collections.<Metadata>emptyList()); // A list of key value pairs that you use to provide metadata for your video.
    videoCreationPayload.setClip(); // 
    videoCreationPayload.setWatermark(); // 
    videoCreationPayload.setLanguage(""fr""); // Use this parameter to set the language of the video. When this parameter is set, the API creates a transcript of the video using the language you specify. You must use the [IETF language tag](https://en.wikipedia.org/wiki/IETF_language_tag) format.

&#x60;language&#x60; is a permanent attribute of the video. You can update it to another language using the [&#x60;PATCH /videos/{videoId}&#x60;](https://docs.api.video/reference/api/Videos#update-a-video-object) operation. This triggers the API to generate a new transcript using a different language.
    videoCreationPayload.setTranscript(); // Use this parameter to enable transcription. 

- When &#x60;true&#x60;, the API generates a transcript for the video.
- The default value is &#x60;false&#x60;.
- If you define a video language using the &#x60;language&#x60; parameter, the API uses that language to transcribe the video. If you do not define a language, the API detects it based on the video. 
- When the API generates a transcript, it will be available as a caption for the video.
    videoCreationPayload.setTranscriptSummary(); // Use this parameter to enable summarization. We recommend using this parameter together with &#x60;transcript: true&#x60;.

- When &#x60;true&#x60;, the API generates a summary for the video, based on the transcription.
- The default value is &#x60;false&#x60;.
- If you define a video language using the &#x60;language&#x60; parameter, the API uses that language to summarize the video. If you do not define a language, the API detects it based on the video.
    videoCreationPayload.setTranscriptSummaryAttributes(); // Use this parameter to define the elements of a summary that you want to generate. If you do not define this parameter, the API generates a full summary with all attributes. The possible values are &#x60;abstract&#x60; and &#x60;takeaways&#x60;.


    try {
      Video result = apiInstance.create(videoCreationPayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#create");
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
 **videoCreationPayload** | [**VideoCreationPayload**](VideoCreationPayload.md)| video to create |

### Return type


[**Video**](Video.md)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**202** | Accepted |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad Request |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="upload"></a>
# **upload**
> Video upload(videoId, file)
> ApiResponse<Video> uploadWithHttpInfo(videoId, file)

Upload a video

To upload a video to the videoId you created. You can only upload your video to the videoId once.



We offer 2 types of upload: 

* Regular upload 

* Progressive upload

The latter allows you to split a video source into X chunks and send those chunks independently (concurrently or sequentially). The 2 main goals for our users are to

  * allow the upload of video sources > 200 MiB (200 MiB = the max. allowed file size for regular upload)

  * allow to send a video source "progressively", i.e., before before knowing the total size of the video.

  Once all chunks have been sent, they are reaggregated to one source file. The video source is considered as "completely sent" when the "last" chunk is sent (i.e., the chunk that "completes" the upload).



### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String videoId = "vi4k0jvEUuaTdRAEjQ4Jfrgz"; // Enter the videoId you want to use to upload your video.
    File file = new File("/path/to/file"); // The path to the video you would like to upload. The path must be local. If you want to use a video from an online source, you must use the \\\"/videos\\\" endpoint and add the \\\"source\\\" parameter when you create a new video.

    try {
      Video result = apiInstance.upload(videoId, file);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#upload");
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
 **videoId** | **String**| Enter the videoId you want to use to upload your video. |
 **file** | **File**| The path to the video you would like to upload. The path must be local. If you want to use a video from an online source, you must use the \\\&quot;/videos\\\&quot; endpoint and add the \\\&quot;source\\\&quot; parameter when you create a new video. |


### Upload chunks

Large files are broken into chunks for upload. You can control the size of the chunks using the `setUploadChunkSize()` of method of `ApiVideoClient` before uploading:

```java
apiVideoClient.setUploadChunkSize(50*1024*1024); // use 50MB chunks
apiVideoClient.videos().upload(videoId, file);
```

### Progressive uploads

Progressive uploads make it possible to upload a video source "progressively," i.e., before knowing the total size of the video. This is done by sending chunks of the video source file sequentially.
The last chunk is sent by calling a different method, so api.video knows that it is time to reassemble the different chunks that were received.

```java
String videoId = "vi4k0jvEUuaTdRAEjQ4Jfrgz"; // Enter the videoId you want to use to upload your video.;

UploadProgressiveSession session = apiVideoClient.createUploadProgressiveSession(videoId)

session.uploadPart(new File("sample.mp4.part1"));
session.uploadPart(new File("sample.mp4.part2"));
// ...
Video result = session.uploadLastPart(new File("sample.mp4.partn"));
```


### Return type


[**Video**](Video.md)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad Request |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**404** | Not Found |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="uploadWithUploadToken"></a>
# **uploadWithUploadToken**
> Video uploadWithUploadToken(token, file)
> ApiResponse<Video> uploadWithUploadTokenWithHttpInfo(token, file)

Upload with an delegated upload token

This method allows you to send a video using an upload token. Upload tokens are especially useful when the upload is done from the client side. If you want to upload a video from your server-side application, you'd better use the [standard upload method](#upload).

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient();
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient(Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String token = "to1tcmSFHeYY5KzyhOqVKMKb"; // The unique identifier for the token you want to use to upload a video.
    File file = new File("/path/to/file"); // The path to the video you want to upload.

    try {
      Video result = apiInstance.uploadWithUploadToken(token, file);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#uploadWithUploadToken");
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
 **token** | **String**| The unique identifier for the token you want to use to upload a video. |
 **file** | **File**| The path to the video you want to upload. |


### Upload chunks

Large files are broken into chunks for upload. You can control the size of the chunks using the `setUploadChunkSize()` of method of `ApiVideoClient` before uploading:

```java
apiVideoClient.setUploadChunkSize(50*1024*1024); // use 50MB chunks
apiVideoClient.videos().uploadWithUploadToken(token, file);
```

### Progressive uploads

Progressive uploads make it possible to upload a video source "progressively," i.e., before knowing the total size of the video. This is done by sending chunks of the video source file sequentially.
The last chunk is sent by calling a different method, so api.video knows that it is time to reassemble the different chunks that were received.

```java
String token = "to1tcmSFHeYY5KzyhOqVKMKb"; // The unique identifier for the token you want to use to upload a video.;

UploadWithUploadTokenProgressiveSession session = apiVideoClient.createUploadWithUploadTokenProgressiveSession(token)

session.uploadPart(new File("sample.mp4.part1"));
session.uploadPart(new File("sample.mp4.part2"));
// ...
Video result = session.uploadLastPart(new File("sample.mp4.partn"));
```


### Return type


[**Video**](Video.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad Request |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="get"></a>
# **get**
> Video get(videoId)
> okhttp3.Call getAsync(videoId, callback)
> ApiResponse<Video> getWithHttpInfo(videoId)

Retrieve a video object

This call provides the same information provided on video creation. For private videos, it will generate a unique token url. Use this to retrieve any details you need about a video, or set up a private viewing URL.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String videoId = "videoId_example"; // The unique identifier for the video you want details about.

    try {
      Video result = apiInstance.get(videoId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#get");
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
 **videoId** | **String**| The unique identifier for the video you want details about. |

### Return type


[**Video**](Video.md)

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
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="update"></a>
# **update**
> Video update(videoId, videoUpdatePayload)
> okhttp3.Call updateAsync(videoId, videoUpdatePayload, callback)
> ApiResponse<Video> updateWithHttpInfo(videoId, videoUpdatePayload)

Update a video object

Updates the parameters associated with a video ID. The video object you are updating is determined by the video ID you provide. 



NOTE: If you are updating an array, you must provide the entire array as what you provide here overwrites what is in the system rather than appending to it.



### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String videoId = "vi4k0jvEUuaTdRAEjQ4Jfrgz"; // The video ID for the video you want to update.
    VideoUpdatePayload videoUpdatePayload = new VideoUpdatePayload(); // 
    videoUpdatePayload.setPlayerId("pl4k0jvEUuaTdRAEjQ4Jfrgz"); // The unique ID for the player you want to associate with your video.
    videoUpdatePayload.setTitle("null"); // The title you want to use for your video.
    videoUpdatePayload.setDescription("A film about good books."); // A brief description of the video.
    videoUpdatePayload.setPublic(true); // Whether the video is publicly available or not. False means it is set to private. Default is true. Tutorials on [private videos](https://api.video/blog/endpoints/private-videos/).
    videoUpdatePayload.setPanoramic(false); // Whether the video is a 360 degree or immersive video.
    videoUpdatePayload.setMp4Support(true); // Whether the player supports the mp4 format.
    videoUpdatePayload.setTags(Arrays.asList("maths", "string theory", "video")); // A list of terms or words you want to tag the video with. Make sure the list includes all the tags you want as whatever you send in this list will overwrite the existing list for the video.
    videoUpdatePayload.setMetadata(Collections.<Metadata>emptyList()); // A list (array) of dictionaries where each dictionary contains a key value pair that describes the video. As with tags, you must send the complete list of metadata you want as whatever you send here will overwrite the existing metadata for the video.
    videoUpdatePayload.setLanguage(""fr""); // Use this parameter to set the language of the video. When this parameter is set, the API creates a transcript of the video using the language you specify. You must use the [IETF language tag](https://en.wikipedia.org/wiki/IETF_language_tag) format.

&#x60;language&#x60; is a permanent attribute of the video. You can update it to another language using the [&#x60;PATCH /videos/{videoId}&#x60;](https://docs.api.video/reference/api/Videos#update-a-video-object) operation. This triggers the API to generate a new transcript using a different language.
    videoUpdatePayload.setTranscript(); // Use this parameter to enable transcription. 

- When &#x60;true&#x60;, the API generates a transcript for the video.
- The default value is &#x60;false&#x60;.
- If you define a video language using the &#x60;language&#x60; parameter, the API uses that language to transcribe the video. If you do not define a language, the API detects it based on the video. 
- When the API generates a transcript, it will be available as a caption for the video.
    videoUpdatePayload.setTranscriptSummary(); // Use this parameter to enable summarization. 

- When &#x60;true&#x60;, the API generates a summary for the video, based on the transcription.
- The default value is &#x60;false&#x60;.
- If you define a video language using the &#x60;language&#x60; parameter, the API uses that language to summarize the video. If you do not define a language, the API detects it based on the video.
    videoUpdatePayload.setTranscriptSummaryAttributes(); // Use this parameter to define the elements of a summary that you want to generate. If you do not define this parameter, the API generates a full summary with all attributes. The possible values are &#x60;abstract&#x60; and &#x60;takeaways&#x60;.


    try {
      Video result = apiInstance.update(videoId, videoUpdatePayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#update");
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
 **videoId** | **String**| The video ID for the video you want to update. |
 **videoUpdatePayload** | [**VideoUpdatePayload**](VideoUpdatePayload.md)|  |

### Return type


[**Video**](Video.md)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad Request |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**404** | Not Found |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**409** | Conflict |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="delete"></a>
# **delete**
> delete(videoId)
> okhttp3.Call deleteAsync(videoId, callback)
> ApiResponse<Void> deleteWithHttpInfo(videoId)

Delete a video object

If you do not need a video any longer, you can send a request to delete it. All you need is the videoId. By default, deleted videos cannot be recovered. If you have the Video Restore feature enabled, this operation will discard the video instead of permanently deleting it. Make sure you subscribe to the Video Restore feature if you want to be able to restore deleted videos! The Video Restore feature retains videos for 90 days, after which the videos are permanently deleted

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String videoId = "vi4k0jvEUuaTdRAEjQ4Jfrgz"; // The video ID for the video you want to delete.

    try {
      apiInstance.delete(videoId);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#delete");
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
 **videoId** | **String**| The video ID for the video you want to delete. |

### Return type


null (empty response body)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | No Content |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**404** | Not Found |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="list"></a>
# **list**
> VideosListResponse list().title(title).tags(tags).metadata(metadata).description(description).liveStreamId(liveStreamId).sortBy(sortBy).sortOrder(sortOrder).currentPage(currentPage).pageSize(pageSize).execute()
> okhttp3.Call executeAsync(callback) 
> ApiResponse<VideosListResponse> executeWithHttpInfo()

List all video objects

This method returns a list of your videos (with all their details). With no parameters added, the API returns the first page of all videos. You can filter videos using the parameters described below.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String title = "My Video.mp4"; // The title of a specific video you want to find. The search will match exactly to what term you provide and return any videos that contain the same term as part of their titles.
    List<String> tags = Arrays.asList(); // A tag is a category you create and apply to videos. You can search for videos with particular tags by listing one or more here. Only videos that have all the tags you list will be returned.
    Map<String, String> metadata = new HashMap(); // Videos can be tagged with metadata tags in key:value pairs. You can search for videos with specific key value pairs using this parameter.
    String description = "New Zealand"; // Retrieve video objects by `description`.
    String liveStreamId = "li400mYKSgQ6xs7taUeSaEKr"; // Retrieve video objects that were recorded from a live stream by `liveStreamId`.
    String sortBy = "title"; // Use this parameter to sort videos by the their created time, published time, updated time, or by title.
    String sortOrder = "asc"; // Use this parameter to sort results. `asc` is ascending and sorts from A to Z. `desc` is descending and sorts from Z to A.
    Integer currentPage = 1; // Choose the number of search results to return per page. Minimum value: 1
    Integer pageSize = 25; // Results per page. Allowed values 1-100, default is 25.

    try {
      Page<Video> result = apiInstance.list()
            .title(title)
            .tags(tags)
            .metadata(metadata)
            .description(description)
            .liveStreamId(liveStreamId)
            .sortBy(sortBy)
            .sortOrder(sortOrder)
            .currentPage(currentPage)
            .pageSize(pageSize)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#list");
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
 **title** | **String**| The title of a specific video you want to find. The search will match exactly to what term you provide and return any videos that contain the same term as part of their titles. | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| A tag is a category you create and apply to videos. You can search for videos with particular tags by listing one or more here. Only videos that have all the tags you list will be returned. | [optional]
 **metadata** | [**Map&lt;String, String&gt;**](String.md)| Videos can be tagged with metadata tags in key:value pairs. You can search for videos with specific key value pairs using this parameter. | [optional]
 **description** | **String**| Retrieve video objects by &#x60;description&#x60;. | [optional]
 **liveStreamId** | **String**| Retrieve video objects that were recorded from a live stream by &#x60;liveStreamId&#x60;. | [optional]
 **sortBy** | **String**| Use this parameter to sort videos by the their created time, published time, updated time, or by title. | [optional] [enum: title, createdAt, publishedAt, updatedAt]
 **sortOrder** | **String**| Use this parameter to sort results. &#x60;asc&#x60; is ascending and sorts from A to Z. &#x60;desc&#x60; is descending and sorts from Z to A. | [optional] [enum: asc, desc]
 **currentPage** | **Integer**| Choose the number of search results to return per page. Minimum value: 1 | [optional] [default to 1]
 **pageSize** | **Integer**| Results per page. Allowed values 1-100, default is 25. | [optional] [default to 25]

### Return type

[**Page**](pagination.md)<[**Video**](Video.md)>


### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad Request |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="uploadThumbnail"></a>
# **uploadThumbnail**
> Video uploadThumbnail(videoId, file)
> okhttp3.Call uploadThumbnailAsync(videoId, file, callback)
> ApiResponse<Video> uploadThumbnailWithHttpInfo(videoId, file)

Upload a thumbnail

The thumbnail is the poster that appears in the player window before video playback begins.



This endpoint allows you to upload an image for the thumbnail.



To select a still frame from the video using a time stamp, use the [dedicated method](#pickThumbnail) to pick a time in the video.



Note: There may be a short delay before the new thumbnail is delivered to our CDN.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String videoId = "videoId_example"; // Unique identifier of the chosen video 
    File file = new File("/path/to/file"); // The image to be added as a thumbnail. The mime type should be image/jpeg, image/png or image/webp. The max allowed size is 8 MiB.

    try {
      Video result = apiInstance.uploadThumbnail(videoId, file);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#uploadThumbnail");
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
 **videoId** | **String**| Unique identifier of the chosen video  |
 **file** | **File**| The image to be added as a thumbnail. The mime type should be image/jpeg, image/png or image/webp. The max allowed size is 8 MiB. |

### Return type


[**Video**](Video.md)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad Request |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**404** | Not Found |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="pickThumbnail"></a>
# **pickThumbnail**
> Video pickThumbnail(videoId, videoThumbnailPickPayload)
> okhttp3.Call pickThumbnailAsync(videoId, videoThumbnailPickPayload, callback)
> ApiResponse<Video> pickThumbnailWithHttpInfo(videoId, videoThumbnailPickPayload)

Set a thumbnail

Pick a thumbnail from the given time code. 



If you'd like to upload an image for your thumbnail, use the dedicated [method](#uploadThumbnail). 



There may be a short delay for the thumbnail to update.



### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String videoId = "vi4k0jvEUuaTdRAEjQ4Jfrgz"; // Unique identifier of the video you want to add a thumbnail to, where you use a section of your video as the thumbnail.
    VideoThumbnailPickPayload videoThumbnailPickPayload = new VideoThumbnailPickPayload(); // 
    videoThumbnailPickPayload.setTimecode("null"); // Frame in video to be used as a placeholder before the video plays. 
Example: &#39;&quot;00:01:00.000&quot; for 1 minute into the video.&#39;
Valid Patterns: 
&quot;hh:mm:ss.ms&quot;
&quot;hh:mm:ss:frameNumber&quot;
&quot;124&quot; (integer value is reported as seconds) 
If selection is out of range, &quot;00:00:00.00&quot; will be chosen.


    try {
      Video result = apiInstance.pickThumbnail(videoId, videoThumbnailPickPayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#pickThumbnail");
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
 **videoId** | **String**| Unique identifier of the video you want to add a thumbnail to, where you use a section of your video as the thumbnail. |
 **videoThumbnailPickPayload** | [**VideoThumbnailPickPayload**](VideoThumbnailPickPayload.md)|  |

### Return type


[**Video**](Video.md)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**404** | Not Found |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="getDiscarded"></a>
# **getDiscarded**
> Video getDiscarded(videoId)
> okhttp3.Call getDiscardedAsync(videoId, callback)
> ApiResponse<Video> getDiscardedWithHttpInfo(videoId)

Retrieve a discarded video object

This call provides the same information provided on video creation. For private videos, it will generate a unique token url. Use this to retrieve any details you need about a video, or set up a private viewing URL.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String videoId = "videoId_example"; // The unique identifier for the video you want details about.

    try {
      Video result = apiInstance.getDiscarded(videoId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#getDiscarded");
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
 **videoId** | **String**| The unique identifier for the video you want details about. |

### Return type


[**Video**](Video.md)

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
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="getStatus"></a>
# **getStatus**
> VideoStatus getStatus(videoId)
> okhttp3.Call getStatusAsync(videoId, callback)
> ApiResponse<VideoStatus> getStatusWithHttpInfo(videoId)

Retrieve video status and details

This method provides upload status &amp; encoding status to determine when the video is uploaded or ready to playback. Once encoding is completed, the response also lists the available stream qualities.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String videoId = "vi4k0jvEUuaTdRAEjQ4Jfrgz"; // The unique identifier for the video you want the status for.

    try {
      VideoStatus result = apiInstance.getStatus(videoId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#getStatus");
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
 **videoId** | **String**| The unique identifier for the video you want the status for. |

### Return type


[**VideoStatus**](VideoStatus.md)

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
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="listDiscarded"></a>
# **listDiscarded**
> VideosListResponse listDiscarded().title(title).tags(tags).metadata(metadata).description(description).liveStreamId(liveStreamId).sortBy(sortBy).sortOrder(sortOrder).currentPage(currentPage).pageSize(pageSize).execute()
> okhttp3.Call executeAsync(callback) 
> ApiResponse<VideosListResponse> executeWithHttpInfo()

List all discarded video objects

This method returns a list of your discarded videos (with all their details). With no parameters added, the API returns the first page of all discarded videos. You can filter discarded videos using the parameters described below.

### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String title = "My Video.mp4"; // The title of a specific video you want to find. The search will match exactly to what term you provide and return any videos that contain the same term as part of their titles.
    List<String> tags = Arrays.asList(); // A tag is a category you create and apply to videos. You can search for videos with particular tags by listing one or more here. Only videos that have all the tags you list will be returned.
    Map<String, String> metadata = new HashMap(); // Videos can be tagged with metadata tags in key:value pairs. You can search for videos with specific key value pairs using this parameter.
    String description = "New Zealand"; // Retrieve video objects by `description`.
    String liveStreamId = "li400mYKSgQ6xs7taUeSaEKr"; // Retrieve video objects that were recorded from a live stream by `liveStreamId`.
    String sortBy = "title"; // Use this parameter to sort videos by the their created time, published time, updated time, or by title.
    String sortOrder = "asc"; // Use this parameter to sort results. `asc` is ascending and sorts from A to Z. `desc` is descending and sorts from Z to A.
    Integer currentPage = 1; // Choose the number of search results to return per page. Minimum value: 1
    Integer pageSize = 25; // Results per page. Allowed values 1-100, default is 25.

    try {
      Page<Video> result = apiInstance.listDiscarded()
            .title(title)
            .tags(tags)
            .metadata(metadata)
            .description(description)
            .liveStreamId(liveStreamId)
            .sortBy(sortBy)
            .sortOrder(sortOrder)
            .currentPage(currentPage)
            .pageSize(pageSize)
            .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#listDiscarded");
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
 **title** | **String**| The title of a specific video you want to find. The search will match exactly to what term you provide and return any videos that contain the same term as part of their titles. | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| A tag is a category you create and apply to videos. You can search for videos with particular tags by listing one or more here. Only videos that have all the tags you list will be returned. | [optional]
 **metadata** | [**Map&lt;String, String&gt;**](String.md)| Videos can be tagged with metadata tags in key:value pairs. You can search for videos with specific key value pairs using this parameter. | [optional]
 **description** | **String**| Retrieve video objects by &#x60;description&#x60;. | [optional]
 **liveStreamId** | **String**| Retrieve video objects that were recorded from a live stream by &#x60;liveStreamId&#x60;. | [optional]
 **sortBy** | **String**| Use this parameter to sort videos by the their created time, published time, updated time, or by title. | [optional] [enum: title, createdAt, publishedAt, updatedAt]
 **sortOrder** | **String**| Use this parameter to sort results. &#x60;asc&#x60; is ascending and sorts from A to Z. &#x60;desc&#x60; is descending and sorts from Z to A. | [optional] [enum: asc, desc]
 **currentPage** | **Integer**| Choose the number of search results to return per page. Minimum value: 1 | [optional] [default to 1]
 **pageSize** | **Integer**| Results per page. Allowed values 1-100, default is 25. | [optional] [default to 25]

### Return type

[**Page**](pagination.md)<[**Video**](Video.md)>


### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad Request |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

<a name="updateDiscarded"></a>
# **updateDiscarded**
> Video updateDiscarded(videoId, discardedVideoUpdatePayload)
> okhttp3.Call updateDiscardedAsync(videoId, discardedVideoUpdatePayload, callback)
> ApiResponse<Video> updateDiscardedWithHttpInfo(videoId, discardedVideoUpdatePayload)

Update a discarded video object

Use this endpoint to restore a discarded video when you have the Video Restore feature enabled.



### Example
```java
// Import classes:
import video.api.client.ApiVideoClient;
import video.api.client.api.ApiException;
import video.api.client.api.models.*;
import video.api.client.api.clients.VideosApi;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiVideoClient client = new ApiVideoClient("YOUR_API_KEY");
    // if you rather like to use the sandbox environment:
    // ApiVideoClient client = new ApiVideoClient("YOUR_SANDBOX_API_KEY", Environment.SANDBOX);

    VideosApi apiInstance = client.videos();
    
    String videoId = "vi4k0jvEUuaTdRAEjQ4Jfrgz"; // The video ID for the video you want to restore.
    DiscardedVideoUpdatePayload discardedVideoUpdatePayload = new DiscardedVideoUpdatePayload(); // 
    discardedVideoUpdatePayload.setDiscarded(); // Use this parameter to restore a discarded video when you have the Video Restore feature enabled. This parameter only accepts &#x60;false&#x60; as a value!


    try {
      Video result = apiInstance.updateDiscarded(videoId, discardedVideoUpdatePayload);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VideosApi#updateDiscarded");
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
 **videoId** | **String**| The video ID for the video you want to restore. |
 **discardedVideoUpdatePayload** | [**DiscardedVideoUpdatePayload**](DiscardedVideoUpdatePayload.md)|  |

### Return type


[**Video**](Video.md)

### Authorization

[API key](../README.md#api-key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**400** | Bad Request |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**404** | Not Found |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |
**429** | Too Many Requests |  * X-RateLimit-Limit - The request limit per minute. <br>  * X-RateLimit-Remaining - The number of available requests left for the current time window. <br>  * X-RateLimit-Retry-After - The number of seconds left until the current rate limit window resets. <br>  |

