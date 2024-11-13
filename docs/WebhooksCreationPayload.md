

# WebhooksCreationPayload

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**events** | [**List&lt;EventsEnum&gt;**](#List&lt;EventsEnum&gt;) | An array of webhook events that you want to subscribe to. | 
**url** | **String** | The the url to which HTTP notifications are sent. It could be any http or https URL. | 



## Enum: List&lt;EventsEnum&gt;

Name | Value
---- | -----
LIVE_STREAM_BROADCAST_STARTED | &quot;live-stream.broadcast.started&quot;
LIVE_STREAM_BROADCAST_ENDED | &quot;live-stream.broadcast.ended&quot;
VIDEO_SOURCE_RECORDED | &quot;video.source.recorded&quot;
VIDEO_ENCODING_QUALITY_COMPLETED | &quot;video.encoding.quality.completed&quot;
VIDEO_CAPTION_GENERATED | &quot;video.caption.generated&quot;
VIDEO_SUMMARY_GENERATED | &quot;video.summary.generated&quot;


## Implemented Interfaces

* Serializable
* DeepObject


