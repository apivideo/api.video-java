

# VideoUpdatePayload

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**playerId** | **String** | The unique ID for the player you want to associate with your video. |  [optional]
**title** | **String** | The title you want to use for your video. |  [optional]
**description** | **String** | A brief description of the video. |  [optional]
**_public** | **Boolean** | Whether the video is publicly available or not. False means it is set to private. Default is true. Tutorials on [private videos](https://api.video/blog/endpoints/private-videos/). |  [optional]
**panoramic** | **Boolean** | Whether the video is a 360 degree or immersive video. |  [optional]
**mp4Support** | **Boolean** | Whether the player supports the mp4 format. |  [optional]
**tags** | **List&lt;String&gt;** | A list of terms or words you want to tag the video with. Make sure the list includes all the tags you want as whatever you send in this list will overwrite the existing list for the video. |  [optional]
**metadata** | [**List&lt;Metadata&gt;**](Metadata.md) | A list (array) of dictionaries where each dictionary contains a key value pair that describes the video. As with tags, you must send the complete list of metadata you want as whatever you send here will overwrite the existing metadata for the video. |  [optional]
**language** | [**LanguageEnum**](#LanguageEnum) | Use this parameter to set the language of the video. When this parameter is set, the API creates a transcript of the video using the language you specify. You must use the [IETF language tag](https://en.wikipedia.org/wiki/IETF_language_tag) format.  &#x60;language&#x60; is a permanent attribute of the video. You can update it to another language using the [&#x60;PATCH /videos/{videoId}&#x60;](https://docs.api.video/reference/api/Videos#update-a-video-object) operation. This triggers the API to generate a new transcript using a different language. |  [optional]
**transcript** | **Boolean** | Use this parameter to enable transcription.   - When &#x60;true&#x60;, the API generates a transcript for the video. - The default value is &#x60;false&#x60;. - If you define a video language using the &#x60;language&#x60; parameter, the API uses that language to transcribe the video. If you do not define a language, the API detects it based on the video.  - When the API generates a transcript, it will be available as a caption for the video. |  [optional]
**transcriptSummary** | **Boolean** | Use this parameter to enable summarization.   - When &#x60;true&#x60;, the API generates a summary for the video, based on the transcription. - The default value is &#x60;false&#x60;. - If you define a video language using the &#x60;language&#x60; parameter, the API uses that language to summarize the video. If you do not define a language, the API detects it based on the video. |  [optional]
**transcriptSummaryAttributes** | [**List&lt;TranscriptSummaryAttributesEnum&gt;**](#List&lt;TranscriptSummaryAttributesEnum&gt;) | Use this parameter to define the elements of a summary that you want to generate. If you do not define this parameter, the API generates a full summary with all attributes. |  [optional]



## Enum: LanguageEnum

Name | Value
---- | -----
AR | &quot;ar&quot;
CA | &quot;ca&quot;
CS | &quot;cs&quot;
DA | &quot;da&quot;
DE | &quot;de&quot;
EL | &quot;el&quot;
EN | &quot;en&quot;
ES | &quot;es&quot;
FA | &quot;fa&quot;
FI | &quot;fi&quot;
FR | &quot;fr&quot;
HE | &quot;he&quot;
HI | &quot;hi&quot;
HR | &quot;hr&quot;
HU | &quot;hu&quot;
IT | &quot;it&quot;
JA | &quot;ja&quot;
KO | &quot;ko&quot;
ML | &quot;ml&quot;
NL | &quot;nl&quot;
NN | &quot;nn&quot;
FALSE | &quot;false&quot;
PL | &quot;pl&quot;
PT | &quot;pt&quot;
RU | &quot;ru&quot;
SK | &quot;sk&quot;
SL | &quot;sl&quot;
TE | &quot;te&quot;
TR | &quot;tr&quot;
UK | &quot;uk&quot;
UR | &quot;ur&quot;
VI | &quot;vi&quot;
ZH | &quot;zh&quot;



## Enum: List&lt;TranscriptSummaryAttributesEnum&gt;

Name | Value
---- | -----
ABSTRACT | &quot;abstract&quot;
TAKEAWAYS | &quot;takeaways&quot;


## Implemented Interfaces

* Serializable
* DeepObject


