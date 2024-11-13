

# Webhook

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**webhookId** | **String** | A unique identifier of the webhook you subscribed to. |  [optional]
**createdAt** | **OffsetDateTime** | The time and date when you created this webhook subscription, in ATOM UTC format. |  [optional]
**events** | [**List&lt;EventsEnum&gt;**](#List&lt;EventsEnum&gt;) | A list of events that you subscribed to. When these events occur, the API triggers a webhook call to the URL you provided. |  [optional]
**url** | **String** | The URL where the API sends the webhook. |  [optional]
**signatureSecret** | **String** | A secret key for the webhook you subscribed to. You can use it to verify the origin of the webhook call that you receive. |  [optional]



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


