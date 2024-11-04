

# AnalyticsAggregatedMetricsResponseContext

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**metric** | [**MetricEnum**](#MetricEnum) | Returns the metric and relevant parameters you selected. |  [optional]
**aggregation** | [**AggregationEnum**](#AggregationEnum) | Returns the aggregation you selected. |  [optional]
**timeframe** | [**AnalyticsAggregatedMetricsResponseContextTimeframe**](AnalyticsAggregatedMetricsResponseContextTimeframe.md) |  |  [optional]



## Enum: MetricEnum

Name | Value
---- | -----
PLAY | &quot;play&quot;
START | &quot;start&quot;
END | &quot;end&quot;
IMPRESSION | &quot;impression&quot;
IMPRESSION_TIME | &quot;impression-time&quot;
WATCH_TIME | &quot;watch-time&quot;
CCV | &quot;ccv&quot;
UNIQUE_CCV | &quot;unique-ccv&quot;
VIEW_3 | &quot;view-3&quot;
VIEW_5 | &quot;view-5&quot;
VIEW_10 | &quot;view-10&quot;
VIEW_30 | &quot;view-30&quot;
UNIQUE_VIEW | &quot;unique-view&quot;
UNIQUE_VIEW_3 | &quot;unique-view-3&quot;
UNIQUE_VIEW_5 | &quot;unique-view-5&quot;
UNIQUE_VIEW_10 | &quot;unique-view-10&quot;
UNIQUE_VIEW_30 | &quot;unique-view-30&quot;



## Enum: AggregationEnum

Name | Value
---- | -----
COUNT | &quot;count&quot;
RATE | &quot;rate&quot;
TOTAL | &quot;total&quot;
AVERAGE | &quot;average&quot;
SUM | &quot;sum&quot;


## Implemented Interfaces

* Serializable
* DeepObject


