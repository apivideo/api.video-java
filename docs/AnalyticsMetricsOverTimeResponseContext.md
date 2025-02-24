

# AnalyticsMetricsOverTimeResponseContext

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**metric** | [**MetricEnum**](#MetricEnum) | Returns the metric and relevant parameters you selected. |  [optional]
**interval** | [**IntervalEnum**](#IntervalEnum) | Returns the interval you selected. |  [optional]
**timeframe** | [**AnalyticsAggregatedMetricsResponseContextTimeframe**](AnalyticsAggregatedMetricsResponseContextTimeframe.md) |  |  [optional]



## Enum: MetricEnum

Name | Value
---- | -----
PLAY | &quot;play&quot;
PLAY_RATE | &quot;play-rate&quot;
START | &quot;start&quot;
END | &quot;end&quot;
IMPRESSION | &quot;impression&quot;
CCV_AVERAGE | &quot;ccv-average&quot;
CCV_PEAK | &quot;ccv-peak&quot;
UNIQUE_CCV_AVERAGE | &quot;unique-ccv-average&quot;
UNIQUE_CCV_PEAK | &quot;unique-ccv-peak&quot;
VIEW_3 | &quot;view-3&quot;
VIEW_5 | &quot;view-5&quot;
VIEW_10 | &quot;view-10&quot;
VIEW_30 | &quot;view-30&quot;
UNIQUE_VIEW | &quot;unique-view&quot;
UNIQUE_VIEW_3 | &quot;unique-view-3&quot;
UNIQUE_VIEW_5 | &quot;unique-view-5&quot;
UNIQUE_VIEW_10 | &quot;unique-view-10&quot;
UNIQUE_VIEW_30 | &quot;unique-view-30&quot;



## Enum: IntervalEnum

Name | Value
---- | -----
MINUTE | &quot;minute&quot;
HOUR | &quot;hour&quot;
DAY | &quot;day&quot;


## Implemented Interfaces

* Serializable
* DeepObject


