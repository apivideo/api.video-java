

# SummaryCreationPayload

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**videoId** | **String** | Create a summary of a video using the video ID. | 
**origin** | [**OriginEnum**](#OriginEnum) | Use this parameter to define how the API generates the summary. The only allowed value is &#x60;auto&#x60;, which means that the API generates a summary automatically.  If you do not set this parameter, **the API will not generate a summary automatically**.  In this case, &#x60;sourceStatus&#x60; will return &#x60;missing&#x60;, and you have to manually add a summary using the &#x60;PATCH /summaries/{summaryId}/source&#x60; endpoint operation. |  [optional]
**attributes** | [**List&lt;AttributesEnum&gt;**](#List&lt;AttributesEnum&gt;) | Use this parameter to define the elements of a summary that you want to generate. If you do not define this parameter, the API generates a full summary with all attributes. |  [optional]



## Enum: OriginEnum

Name | Value
---- | -----
AUTO | &quot;auto&quot;



## Enum: List&lt;AttributesEnum&gt;

Name | Value
---- | -----
ABSTRACT | &quot;abstract&quot;
TAKEAWAYS | &quot;takeaways&quot;


## Implemented Interfaces

* Serializable
* DeepObject


