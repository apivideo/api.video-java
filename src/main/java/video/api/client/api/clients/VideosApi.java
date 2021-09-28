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

package video.api.client.api.clients;

import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;

import video.api.client.api.models.*;
import video.api.client.api.upload.*;
import video.api.client.api.*;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideosApi {
    private ApiClient localVarApiClient;

    public VideosApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for delete
     * 
     * @param videoId
     *            The video ID for the video you want to delete. (required)
     * @param _callback
     *            Callback for upload/download progress
     * 
     * @return Call to execute
     * 
     * @throws ApiException
     *             If fail to serialize the request body object
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>204</td>
     *                        <td>No Content</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    private okhttp3.Call deleteCall(String videoId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/videos/{videoId}".replaceAll("\\{" + "videoId" + "\\}",
                localVarApiClient.escapeString(videoId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteValidateBeforeCall(String videoId, final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'videoId' is set
        if (videoId == null) {
            throw new ApiException("Missing the required parameter 'videoId' when calling delete");
        }

        okhttp3.Call localVarCall = deleteCall(videoId, _callback);
        return localVarCall;
    }

    /**
     * Delete a video If you do not need a video any longer, you can send a request to delete it. All you need is the
     * videoId. Tutorials using [video deletion](https://api.video/blog/endpoints/video-delete).
     * 
     * @param videoId
     *            The video ID for the video you want to delete. (required)
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>204</td>
     *                        <td>No Content</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public void delete(String videoId) throws ApiException {
        deleteWithHttpInfo(videoId);
    }

    /**
     * Delete a video If you do not need a video any longer, you can send a request to delete it. All you need is the
     * videoId. Tutorials using [video deletion](https://api.video/blog/endpoints/video-delete).
     * 
     * @param videoId
     *            The video ID for the video you want to delete. (required)
     * 
     * @return ApiResponse&lt;Void&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>204</td>
     *                        <td>No Content</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<Void> deleteWithHttpInfo(String videoId) throws ApiException {
        okhttp3.Call localVarCall = deleteValidateBeforeCall(videoId, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Build call for get
     * 
     * @param videoId
     *            The unique identifier for the video you want details about. (required)
     * @param _callback
     *            Callback for upload/download progress
     * 
     * @return Call to execute
     * 
     * @throws ApiException
     *             If fail to serialize the request body object
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    private okhttp3.Call getCall(String videoId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/videos/{videoId}".replaceAll("\\{" + "videoId" + "\\}",
                localVarApiClient.escapeString(videoId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getValidateBeforeCall(String videoId, final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'videoId' is set
        if (videoId == null) {
            throw new ApiException("Missing the required parameter 'videoId' when calling get");
        }

        okhttp3.Call localVarCall = getCall(videoId, _callback);
        return localVarCall;
    }

    /**
     * Show a video This call provides the same JSON information provided on video creation. For private videos, it will
     * generate a unique token url. Use this to retrieve any details you need about a video, or set up a private viewing
     * URL. Tutorials using [video GET](https://api.video/blog/endpoints/video-get).
     * 
     * @param videoId
     *            The unique identifier for the video you want details about. (required)
     * 
     * @return Video
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public Video get(String videoId) throws ApiException {
        ApiResponse<Video> localVarResp = getWithHttpInfo(videoId);
        return localVarResp.getData();
    }

    /**
     * Show a video This call provides the same JSON information provided on video creation. For private videos, it will
     * generate a unique token url. Use this to retrieve any details you need about a video, or set up a private viewing
     * URL. Tutorials using [video GET](https://api.video/blog/endpoints/video-get).
     * 
     * @param videoId
     *            The unique identifier for the video you want details about. (required)
     * 
     * @return ApiResponse&lt;Video&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<Video> getWithHttpInfo(String videoId) throws ApiException {
        okhttp3.Call localVarCall = getValidateBeforeCall(videoId, null);
        Type localVarReturnType = new TypeToken<Video>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Build call for getStatus
     * 
     * @param videoId
     *            The unique identifier for the video you want the status for. (required)
     * @param _callback
     *            Callback for upload/download progress
     * 
     * @return Call to execute
     * 
     * @throws ApiException
     *             If fail to serialize the request body object
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    private okhttp3.Call getStatusCall(String videoId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/videos/{videoId}/status".replaceAll("\\{" + "videoId" + "\\}",
                localVarApiClient.escapeString(videoId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getStatusValidateBeforeCall(String videoId, final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'videoId' is set
        if (videoId == null) {
            throw new ApiException("Missing the required parameter 'videoId' when calling getStatus");
        }

        okhttp3.Call localVarCall = getStatusCall(videoId, _callback);
        return localVarCall;
    }

    /**
     * Show video status This API provides upload status &amp; encoding status to determine when the video is uploaded
     * or ready to playback. Once encoding is completed, the response also lists the available stream qualities.
     * Tutorials using [video status](https://api.video/blog/endpoints/video-status).
     * 
     * @param videoId
     *            The unique identifier for the video you want the status for. (required)
     * 
     * @return VideoStatus
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public VideoStatus getStatus(String videoId) throws ApiException {
        ApiResponse<VideoStatus> localVarResp = getStatusWithHttpInfo(videoId);
        return localVarResp.getData();
    }

    /**
     * Show video status This API provides upload status &amp; encoding status to determine when the video is uploaded
     * or ready to playback. Once encoding is completed, the response also lists the available stream qualities.
     * Tutorials using [video status](https://api.video/blog/endpoints/video-status).
     * 
     * @param videoId
     *            The unique identifier for the video you want the status for. (required)
     * 
     * @return ApiResponse&lt;VideoStatus&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<VideoStatus> getStatusWithHttpInfo(String videoId) throws ApiException {
        okhttp3.Call localVarCall = getStatusValidateBeforeCall(videoId, null);
        Type localVarReturnType = new TypeToken<VideoStatus>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listCall(String title, List<String> tags, Map<String, String> metadata, String description,
            String liveStreamId, String sortBy, String sortOrder, Integer currentPage, Integer pageSize,
            final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/videos";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (title != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("title", title));
        }

        if (tags != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "tags", tags));
        }

        if (metadata != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("metadata", metadata));
        }

        if (description != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("description", description));
        }

        if (liveStreamId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("liveStreamId", liveStreamId));
        }

        if (sortBy != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sortBy", sortBy));
        }

        if (sortOrder != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sortOrder", sortOrder));
        }

        if (currentPage != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("currentPage", currentPage));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("pageSize", pageSize));
        }

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {

        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listValidateBeforeCall(String title, List<String> tags, Map<String, String> metadata,
            String description, String liveStreamId, String sortBy, String sortOrder, Integer currentPage,
            Integer pageSize, final ApiCallback _callback) throws ApiException {

        okhttp3.Call localVarCall = listCall(title, tags, metadata, description, liveStreamId, sortBy, sortOrder,
                currentPage, pageSize, _callback);
        return localVarCall;
    }

    private ApiResponse<VideosListResponse> listWithHttpInfo(String title, List<String> tags,
            Map<String, String> metadata, String description, String liveStreamId, String sortBy, String sortOrder,
            Integer currentPage, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = listValidateBeforeCall(title, tags, metadata, description, liveStreamId, sortBy,
                sortOrder, currentPage, pageSize, null);
        Type localVarReturnType = new TypeToken<VideosListResponse>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    public class APIlistRequest {
        private String title;
        private List<String> tags;
        private Map<String, String> metadata;
        private String description;
        private String liveStreamId;
        private String sortBy;
        private String sortOrder;
        private Integer currentPage;
        private Integer pageSize;

        private APIlistRequest() {
        }

        /**
         * Set title
         * 
         * @param title
         *            The title of a specific video you want to find. The search will match exactly to what term you
         *            provide and return any videos that contain the same term as part of their titles. (optional)
         * 
         * @return APIlistRequest
         */
        public APIlistRequest title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Set tags
         * 
         * @param tags
         *            A tag is a category you create and apply to videos. You can search for videos with particular tags
         *            by listing one or more here. Only videos that have all the tags you list will be returned.
         *            (optional)
         * 
         * @return APIlistRequest
         */
        public APIlistRequest tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        /**
         * Set metadata
         * 
         * @param metadata
         *            Videos can be tagged with metadata tags in key:value pairs. You can search for videos with
         *            specific key value pairs using this parameter. (optional)
         * 
         * @return APIlistRequest
         */
        public APIlistRequest metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Set description
         * 
         * @param description
         *            If you described a video with a term or sentence, you can add it here to return videos containing
         *            this string. (optional)
         * 
         * @return APIlistRequest
         */
        public APIlistRequest description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Set liveStreamId
         * 
         * @param liveStreamId
         *            If you know the ID for a live stream, you can retrieve the stream by adding the ID for it here.
         *            (optional)
         * 
         * @return APIlistRequest
         */
        public APIlistRequest liveStreamId(String liveStreamId) {
            this.liveStreamId = liveStreamId;
            return this;
        }

        /**
         * Set sortBy
         * 
         * @param sortBy
         *            Allowed: publishedAt, title. You can search by the time videos were published at, or by title.
         *            (optional)
         * 
         * @return APIlistRequest
         */
        public APIlistRequest sortBy(String sortBy) {
            this.sortBy = sortBy;
            return this;
        }

        /**
         * Set sortOrder
         * 
         * @param sortOrder
         *            Allowed: asc, desc. asc is ascending and sorts from A to Z. desc is descending and sorts from Z to
         *            A. (optional)
         * 
         * @return APIlistRequest
         */
        public APIlistRequest sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Set currentPage
         * 
         * @param currentPage
         *            Choose the number of search results to return per page. Minimum value: 1 (optional, default to 1)
         * 
         * @return APIlistRequest
         */
        public APIlistRequest currentPage(Integer currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        /**
         * Set pageSize
         * 
         * @param pageSize
         *            Results per page. Allowed values 1-100, default is 25. (optional, default to 25)
         * 
         * @return APIlistRequest
         */
        public APIlistRequest pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        /**
         * Build call for list
         * 
         * @param _callback
         *            ApiCallback API callback
         * 
         * @return Call to execute
         * 
         * @throws ApiException
         *             If fail to serialize the request body object
         * 
         * @http.response.details
         *                        <table summary="Response Details" border="1">
         *                        <tr>
         *                        <td>Status Code</td>
         *                        <td>Description</td>
         *                        <td>Response Headers</td>
         *                        </tr>
         *                        <tr>
         *                        <td>200</td>
         *                        <td>Success</td>
         *                        <td>-</td>
         *                        </tr>
         *                        <tr>
         *                        <td>400</td>
         *                        <td>Bad Request</td>
         *                        <td>-</td>
         *                        </tr>
         *                        </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listCall(title, tags, metadata, description, liveStreamId, sortBy, sortOrder, currentPage, pageSize,
                    _callback);
        }

        /**
         * Execute list request
         * 
         * @return VideosListResponse
         * 
         * @throws ApiException
         *             If fail to call the API, e.g. server error or cannot deserialize the response body
         * 
         * @http.response.details
         *                        <table summary="Response Details" border="1">
         *                        <tr>
         *                        <td>Status Code</td>
         *                        <td>Description</td>
         *                        <td>Response Headers</td>
         *                        </tr>
         *                        <tr>
         *                        <td>200</td>
         *                        <td>Success</td>
         *                        <td>-</td>
         *                        </tr>
         *                        <tr>
         *                        <td>400</td>
         *                        <td>Bad Request</td>
         *                        <td>-</td>
         *                        </tr>
         *                        </table>
         */
        public Page<Video> execute() throws ApiException {
            ApiResponse<VideosListResponse> localVarResp = listWithHttpInfo(title, tags, metadata, description,
                    liveStreamId, sortBy, sortOrder, currentPage, pageSize);
            return new Page<>(localVarResp.getData().getData(), localVarResp.getData().getPagination(), () -> {
                try {
                    return copy().currentPage((currentPage == null ? 1 : currentPage) + 1).execute();
                } catch (ApiException e) {
                    throw new RuntimeException(e);
                }
            }); //
        }

        private APIlistRequest copy() {
            APIlistRequest copy = new APIlistRequest();
            copy.title(title);
            copy.tags(tags);
            copy.metadata(metadata);
            copy.description(description);
            copy.liveStreamId(liveStreamId);
            copy.sortBy(sortBy);
            copy.sortOrder(sortOrder);
            copy.currentPage(currentPage);
            copy.pageSize(pageSize);
            return copy;
        }

        /**
         * Execute list request with HTTP info returned
         * 
         * @return ApiResponse&lt;VideosListResponse&gt;
         * 
         * @throws ApiException
         *             If fail to call the API, e.g. server error or cannot deserialize the response body
         * 
         * @http.response.details
         *                        <table summary="Response Details" border="1">
         *                        <tr>
         *                        <td>Status Code</td>
         *                        <td>Description</td>
         *                        <td>Response Headers</td>
         *                        </tr>
         *                        <tr>
         *                        <td>200</td>
         *                        <td>Success</td>
         *                        <td>-</td>
         *                        </tr>
         *                        <tr>
         *                        <td>400</td>
         *                        <td>Bad Request</td>
         *                        <td>-</td>
         *                        </tr>
         *                        </table>
         */
        public ApiResponse<VideosListResponse> executeWithHttpInfo() throws ApiException {
            return listWithHttpInfo(title, tags, metadata, description, liveStreamId, sortBy, sortOrder, currentPage,
                    pageSize);
        }

        /**
         * Execute list request (asynchronously)
         * 
         * @param _callback
         *            The callback to be executed when the API call finishes
         * 
         * @return The request call
         * 
         * @throws ApiException
         *             If fail to process the API call, e.g. serializing the request body object
         * 
         * @http.response.details
         *                        <table summary="Response Details" border="1">
         *                        <tr>
         *                        <td>Status Code</td>
         *                        <td>Description</td>
         *                        <td>Response Headers</td>
         *                        </tr>
         *                        <tr>
         *                        <td>200</td>
         *                        <td>Success</td>
         *                        <td>-</td>
         *                        </tr>
         *                        <tr>
         *                        <td>400</td>
         *                        <td>Bad Request</td>
         *                        <td>-</td>
         *                        </tr>
         *                        </table>
         * 
         *                        public okhttp3.Call executeAsync(final ApiCallback<VideosListResponse> _callback)
         *                        throws ApiException { return listAsync(title, tags, metadata, description,
         *                        liveStreamId, sortBy, sortOrder, currentPage, pageSize, _callback); }
         */
    }

    /**
     * List all videos Requests to this endpoint return a list of your videos (with all their details). With no
     * parameters added to this query, the API returns all videos. You can filter what videos the API returns using the
     * parameters described below. We have [several tutorials](https://api.video/blog/endpoints/video-list) that
     * demonstrate this endpoint..
     * 
     * @return APIlistRequest
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public APIlistRequest list() {
        return new APIlistRequest();
    }

    /**
     * Build call for update
     * 
     * @param videoId
     *            The video ID for the video you want to delete. (required)
     * @param videoUpdatePayload
     *            (required)
     * @param _callback
     *            Callback for upload/download progress
     * 
     * @return Call to execute
     * 
     * @throws ApiException
     *             If fail to serialize the request body object
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    private okhttp3.Call updateCall(String videoId, VideoUpdatePayload videoUpdatePayload, final ApiCallback _callback)
            throws ApiException {
        Object localVarPostBody = videoUpdatePayload;

        // create path and map variables
        String localVarPath = "/videos/{videoId}".replaceAll("\\{" + "videoId" + "\\}",
                localVarApiClient.escapeString(videoId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateValidateBeforeCall(String videoId, VideoUpdatePayload videoUpdatePayload,
            final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'videoId' is set
        if (videoId == null) {
            throw new ApiException("Missing the required parameter 'videoId' when calling update");
        }

        // verify the required parameter 'videoUpdatePayload' is set
        if (videoUpdatePayload == null) {
            throw new ApiException("Missing the required parameter 'videoUpdatePayload' when calling update");
        }

        okhttp3.Call localVarCall = updateCall(videoId, videoUpdatePayload, _callback);
        return localVarCall;
    }

    /**
     * Update a video Use this endpoint to update the parameters associated with your video. The video you are updating
     * is determined by the video ID you provide in the path. For each parameter you want to update, include the update
     * in the request body. NOTE: If you are updating an array, you must provide the entire array as what you provide
     * here overwrites what is in the system rather than appending to it. Tutorials using [video
     * update](https://api.video/blog/endpoints/video-update).
     * 
     * @param videoId
     *            The video ID for the video you want to delete. (required)
     * @param videoUpdatePayload
     *            (required)
     * 
     * @return Video
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public Video update(String videoId, VideoUpdatePayload videoUpdatePayload) throws ApiException {
        ApiResponse<Video> localVarResp = updateWithHttpInfo(videoId, videoUpdatePayload);
        return localVarResp.getData();
    }

    /**
     * Update a video Use this endpoint to update the parameters associated with your video. The video you are updating
     * is determined by the video ID you provide in the path. For each parameter you want to update, include the update
     * in the request body. NOTE: If you are updating an array, you must provide the entire array as what you provide
     * here overwrites what is in the system rather than appending to it. Tutorials using [video
     * update](https://api.video/blog/endpoints/video-update).
     * 
     * @param videoId
     *            The video ID for the video you want to delete. (required)
     * @param videoUpdatePayload
     *            (required)
     * 
     * @return ApiResponse&lt;Video&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<Video> updateWithHttpInfo(String videoId, VideoUpdatePayload videoUpdatePayload)
            throws ApiException {
        okhttp3.Call localVarCall = updateValidateBeforeCall(videoId, videoUpdatePayload, null);
        Type localVarReturnType = new TypeToken<Video>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Build call for pickThumbnail
     * 
     * @param videoId
     *            Unique identifier of the video you want to add a thumbnail to, where you use a section of your video
     *            as the thumbnail. (required)
     * @param videoThumbnailPickPayload
     *            (required)
     * @param _callback
     *            Callback for upload/download progress
     * 
     * @return Call to execute
     * 
     * @throws ApiException
     *             If fail to serialize the request body object
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    private okhttp3.Call pickThumbnailCall(String videoId, VideoThumbnailPickPayload videoThumbnailPickPayload,
            final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = videoThumbnailPickPayload;

        // create path and map variables
        String localVarPath = "/videos/{videoId}/thumbnail".replaceAll("\\{" + "videoId" + "\\}",
                localVarApiClient.escapeString(videoId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call pickThumbnailValidateBeforeCall(String videoId,
            VideoThumbnailPickPayload videoThumbnailPickPayload, final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'videoId' is set
        if (videoId == null) {
            throw new ApiException("Missing the required parameter 'videoId' when calling pickThumbnail");
        }

        // verify the required parameter 'videoThumbnailPickPayload' is set
        if (videoThumbnailPickPayload == null) {
            throw new ApiException(
                    "Missing the required parameter 'videoThumbnailPickPayload' when calling pickThumbnail");
        }

        if (videoThumbnailPickPayload.getTimecode() == null) {
            throw new ApiException(
                    "Missing the required parameter 'videoThumbnailPickPayload.timecode' when calling pickThumbnail");
        }

        if (videoThumbnailPickPayload.getTimecode() == null) {
            throw new ApiException(
                    "Missing the required parameter 'videoThumbnailPickPayload.timecode' when calling pickThumbnail");
        }

        okhttp3.Call localVarCall = pickThumbnailCall(videoId, videoThumbnailPickPayload, _callback);
        return localVarCall;
    }

    /**
     * Pick a thumbnail Pick a thumbnail from the given time code. If you&#39;d like to upload an image for your
     * thumbnail, use the [Upload a Thumbnail](https://docs.api.video/reference#post_videos-videoid-thumbnail) endpoint.
     * There may be a short delay for the thumbnail to update. Tutorials using [Thumbnail
     * picking](https://api.video/blog/endpoints/video-pick-a-thumbnail).
     * 
     * @param videoId
     *            Unique identifier of the video you want to add a thumbnail to, where you use a section of your video
     *            as the thumbnail. (required)
     * @param videoThumbnailPickPayload
     *            (required)
     * 
     * @return Video
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public Video pickThumbnail(String videoId, VideoThumbnailPickPayload videoThumbnailPickPayload)
            throws ApiException {
        ApiResponse<Video> localVarResp = pickThumbnailWithHttpInfo(videoId, videoThumbnailPickPayload);
        return localVarResp.getData();
    }

    /**
     * Pick a thumbnail Pick a thumbnail from the given time code. If you&#39;d like to upload an image for your
     * thumbnail, use the [Upload a Thumbnail](https://docs.api.video/reference#post_videos-videoid-thumbnail) endpoint.
     * There may be a short delay for the thumbnail to update. Tutorials using [Thumbnail
     * picking](https://api.video/blog/endpoints/video-pick-a-thumbnail).
     * 
     * @param videoId
     *            Unique identifier of the video you want to add a thumbnail to, where you use a section of your video
     *            as the thumbnail. (required)
     * @param videoThumbnailPickPayload
     *            (required)
     * 
     * @return ApiResponse&lt;Video&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<Video> pickThumbnailWithHttpInfo(String videoId,
            VideoThumbnailPickPayload videoThumbnailPickPayload) throws ApiException {
        okhttp3.Call localVarCall = pickThumbnailValidateBeforeCall(videoId, videoThumbnailPickPayload, null);
        Type localVarReturnType = new TypeToken<Video>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Build call for uploadWithUploadToken
     * 
     * @param token
     *            The unique identifier for the token you want to use to upload a video. (required)
     * @param file
     *            The path to the video you want to upload. (required)
     * @param _callback
     *            Callback for upload/download progress
     * 
     * @return Call to execute
     * 
     * @throws ApiException
     *             If fail to serialize the request body object
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    private okhttp3.Call uploadWithUploadTokenCall(String token, File file, final ApiCallback _callback)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/upload";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (file != null) {
            localVarFormParams.put("file", file);
        }

        if (token != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("token", token));
        }

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = { "multipart/form-data" };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {};
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    private okhttp3.Call uploadWithUploadTokenChunkCall(String token, File file, String videoId, long chunkStart,
            long chunkEnd, long totalBytes, Integer chunksCount, Integer chunkNum,
            UploadProgressListener progressListener, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/upload";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (file != null) {
            localVarFormParams.put("file", new UploadChunkRequestBody(file, chunksCount, chunkNum, totalBytes,
                    chunkStart, chunkEnd + 1, progressListener));
        }

        if (token != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("token", token));
        }

        localVarHeaderParams.put("Content-Range", "bytes " + chunkStart + "-" + chunkEnd + "/" + totalBytes);

        if (videoId != null) {
            localVarFormParams.put("videoId", videoId);
        }

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = { "multipart/form-data" };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {};
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call uploadWithUploadTokenValidateBeforeCall(String token, File file, final ApiCallback _callback)
            throws ApiException {

        // verify the required parameter 'token' is set
        if (token == null) {
            throw new ApiException("Missing the required parameter 'token' when calling uploadWithUploadToken");
        }

        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling uploadWithUploadToken");
        }

        okhttp3.Call localVarCall = uploadWithUploadTokenCall(token, file, _callback);
        return localVarCall;
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call uploadWithUploadTokenChunkValidateBeforeCall(String token, File file, String videoId,
            long chunkStart, long chunkEnd, long totalBytes, Integer chunksCount, Integer chunkNum,
            UploadProgressListener progressListener, final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'token' is set
        if (token == null) {
            throw new ApiException("Missing the required parameter 'token' when calling uploadWithUploadToken(Async)");
        }

        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling uploadWithUploadToken(Async)");
        }

        okhttp3.Call localVarCall = uploadWithUploadTokenChunkCall(token, file, videoId, chunkStart, chunkEnd,
                totalBytes, chunksCount, chunkNum, progressListener, _callback);
        return localVarCall;

    }

    /**
     * Upload with an upload token When given a token, anyone can upload a file to the URI
     * &#x60;https://ws.api.video/upload?token&#x3D;&lt;tokenId&gt;&#x60;. Example with cURL: &#x60;&#x60;&#x60;curl $
     * curl --request POST --url &#39;https://ws.api.video/upload?token&#x3D;toXXX&#39; --header &#39;content-type:
     * multipart/form-data&#39; -F file&#x3D;@video.mp4 &#x60;&#x60;&#x60; Or in an HTML form, with a little JavaScript
     * to convert the form into JSON: &#x60;&#x60;&#x60;html &lt;!--form for user interaction--&gt; &lt;form
     * name&#x3D;\&quot;videoUploadForm\&quot; &gt; &lt;label for&#x3D;video&gt;Video:&lt;/label&gt; &lt;input
     * type&#x3D;file name&#x3D;source/&gt;&lt;br/&gt; &lt;input value&#x3D;\&quot;Submit\&quot;
     * type&#x3D;\&quot;submit\&quot;&gt; &lt;/form&gt; &lt;div&gt;&lt;/div&gt; &lt;!--JS takes the form data uses
     * FormData to turn the response into JSON. then uses POST to upload the video file. Update the token parameter in
     * the url to your upload token. --&gt; &lt;script&gt; var form &#x3D;
     * document.forms.namedItem(\&quot;videoUploadForm\&quot;); form.addEventListener(&#39;submit&#39;, function(ev) {
     * ev.preventDefault(); var oOutput &#x3D; document.querySelector(\&quot;div\&quot;), oData &#x3D; new
     * FormData(form); var oReq &#x3D; new XMLHttpRequest(); oReq.open(\&quot;POST\&quot;,
     * \&quot;https://ws.api.video/upload?token&#x3D;toXXX\&quot;, true); oReq.send(oData); oReq.onload &#x3D;
     * function(oEvent) { if (oReq.status &#x3D;&#x3D;201) { oOutput.innerHTML &#x3D; \&quot;Your video is
     * uploaded!&lt;br/&gt;\&quot; + oReq.response; } else { oOutput.innerHTML &#x3D; \&quot;Error \&quot; + oReq.status
     * + \&quot; occurred when trying to upload your file.&lt;br /&gt;\&quot;; } }; }, false); &lt;/script&gt;
     * &#x60;&#x60;&#x60; ### Dealing with large files We have created a &lt;a
     * href&#x3D;&#39;https://api.video/blog/tutorials/uploading-large-files-with-javascript&#39;&gt;tutorial&lt;/a&gt;
     * to walk through the steps required.
     * 
     * @param token
     *            The unique identifier for the token you want to use to upload a video. (required)
     * @param file
     *            The path to the video you want to upload. (required)
     * 
     * @return Video
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public Video uploadWithUploadToken(String token, File file) throws ApiException {
        ApiResponse<Video> localVarResp = uploadWithUploadTokenWithHttpInfo(token, file);
        return localVarResp.getData();
    }

    /**
     * Upload with an upload token When given a token, anyone can upload a file to the URI
     * &#x60;https://ws.api.video/upload?token&#x3D;&lt;tokenId&gt;&#x60;. Example with cURL: &#x60;&#x60;&#x60;curl $
     * curl --request POST --url &#39;https://ws.api.video/upload?token&#x3D;toXXX&#39; --header &#39;content-type:
     * multipart/form-data&#39; -F file&#x3D;@video.mp4 &#x60;&#x60;&#x60; Or in an HTML form, with a little JavaScript
     * to convert the form into JSON: &#x60;&#x60;&#x60;html &lt;!--form for user interaction--&gt; &lt;form
     * name&#x3D;\&quot;videoUploadForm\&quot; &gt; &lt;label for&#x3D;video&gt;Video:&lt;/label&gt; &lt;input
     * type&#x3D;file name&#x3D;source/&gt;&lt;br/&gt; &lt;input value&#x3D;\&quot;Submit\&quot;
     * type&#x3D;\&quot;submit\&quot;&gt; &lt;/form&gt; &lt;div&gt;&lt;/div&gt; &lt;!--JS takes the form data uses
     * FormData to turn the response into JSON. then uses POST to upload the video file. Update the token parameter in
     * the url to your upload token. --&gt; &lt;script&gt; var form &#x3D;
     * document.forms.namedItem(\&quot;videoUploadForm\&quot;); form.addEventListener(&#39;submit&#39;, function(ev) {
     * ev.preventDefault(); var oOutput &#x3D; document.querySelector(\&quot;div\&quot;), oData &#x3D; new
     * FormData(form); var oReq &#x3D; new XMLHttpRequest(); oReq.open(\&quot;POST\&quot;,
     * \&quot;https://ws.api.video/upload?token&#x3D;toXXX\&quot;, true); oReq.send(oData); oReq.onload &#x3D;
     * function(oEvent) { if (oReq.status &#x3D;&#x3D;201) { oOutput.innerHTML &#x3D; \&quot;Your video is
     * uploaded!&lt;br/&gt;\&quot; + oReq.response; } else { oOutput.innerHTML &#x3D; \&quot;Error \&quot; + oReq.status
     * + \&quot; occurred when trying to upload your file.&lt;br /&gt;\&quot;; } }; }, false); &lt;/script&gt;
     * &#x60;&#x60;&#x60; ### Dealing with large files We have created a &lt;a
     * href&#x3D;&#39;https://api.video/blog/tutorials/uploading-large-files-with-javascript&#39;&gt;tutorial&lt;/a&gt;
     * to walk through the steps required.
     * 
     * @param token
     *            The unique identifier for the token you want to use to upload a video. (required)
     * @param file
     *            The path to the video you want to upload. (required)
     * @param uploadProgressListener
     *            An upload progress listener
     * 
     * @return Video
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public Video uploadWithUploadToken(String token, File file, UploadProgressListener uploadProgressListener)
            throws ApiException {
        ApiResponse<Video> localVarResp = uploadWithUploadTokenWithHttpInfo(token, file, uploadProgressListener);
        return localVarResp.getData();
    }

    /**
     * Upload with an upload token When given a token, anyone can upload a file to the URI
     * &#x60;https://ws.api.video/upload?token&#x3D;&lt;tokenId&gt;&#x60;. Example with cURL: &#x60;&#x60;&#x60;curl $
     * curl --request POST --url &#39;https://ws.api.video/upload?token&#x3D;toXXX&#39; --header &#39;content-type:
     * multipart/form-data&#39; -F file&#x3D;@video.mp4 &#x60;&#x60;&#x60; Or in an HTML form, with a little JavaScript
     * to convert the form into JSON: &#x60;&#x60;&#x60;html &lt;!--form for user interaction--&gt; &lt;form
     * name&#x3D;\&quot;videoUploadForm\&quot; &gt; &lt;label for&#x3D;video&gt;Video:&lt;/label&gt; &lt;input
     * type&#x3D;file name&#x3D;source/&gt;&lt;br/&gt; &lt;input value&#x3D;\&quot;Submit\&quot;
     * type&#x3D;\&quot;submit\&quot;&gt; &lt;/form&gt; &lt;div&gt;&lt;/div&gt; &lt;!--JS takes the form data uses
     * FormData to turn the response into JSON. then uses POST to upload the video file. Update the token parameter in
     * the url to your upload token. --&gt; &lt;script&gt; var form &#x3D;
     * document.forms.namedItem(\&quot;videoUploadForm\&quot;); form.addEventListener(&#39;submit&#39;, function(ev) {
     * ev.preventDefault(); var oOutput &#x3D; document.querySelector(\&quot;div\&quot;), oData &#x3D; new
     * FormData(form); var oReq &#x3D; new XMLHttpRequest(); oReq.open(\&quot;POST\&quot;,
     * \&quot;https://ws.api.video/upload?token&#x3D;toXXX\&quot;, true); oReq.send(oData); oReq.onload &#x3D;
     * function(oEvent) { if (oReq.status &#x3D;&#x3D;201) { oOutput.innerHTML &#x3D; \&quot;Your video is
     * uploaded!&lt;br/&gt;\&quot; + oReq.response; } else { oOutput.innerHTML &#x3D; \&quot;Error \&quot; + oReq.status
     * + \&quot; occurred when trying to upload your file.&lt;br /&gt;\&quot;; } }; }, false); &lt;/script&gt;
     * &#x60;&#x60;&#x60; ### Dealing with large files We have created a &lt;a
     * href&#x3D;&#39;https://api.video/blog/tutorials/uploading-large-files-with-javascript&#39;&gt;tutorial&lt;/a&gt;
     * to walk through the steps required.
     * 
     * @param token
     *            The unique identifier for the token you want to use to upload a video. (required)
     * @param file
     *            The path to the video you want to upload. (required)
     * 
     * @return ApiResponse&lt;Video&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<Video> uploadWithUploadTokenWithHttpInfo(String token, File file) throws ApiException {
        return uploadWithUploadTokenWithHttpInfo(token, file, null);
    }

    /**
     * Upload with an upload token When given a token, anyone can upload a file to the URI
     * &#x60;https://ws.api.video/upload?token&#x3D;&lt;tokenId&gt;&#x60;. Example with cURL: &#x60;&#x60;&#x60;curl $
     * curl --request POST --url &#39;https://ws.api.video/upload?token&#x3D;toXXX&#39; --header &#39;content-type:
     * multipart/form-data&#39; -F file&#x3D;@video.mp4 &#x60;&#x60;&#x60; Or in an HTML form, with a little JavaScript
     * to convert the form into JSON: &#x60;&#x60;&#x60;html &lt;!--form for user interaction--&gt; &lt;form
     * name&#x3D;\&quot;videoUploadForm\&quot; &gt; &lt;label for&#x3D;video&gt;Video:&lt;/label&gt; &lt;input
     * type&#x3D;file name&#x3D;source/&gt;&lt;br/&gt; &lt;input value&#x3D;\&quot;Submit\&quot;
     * type&#x3D;\&quot;submit\&quot;&gt; &lt;/form&gt; &lt;div&gt;&lt;/div&gt; &lt;!--JS takes the form data uses
     * FormData to turn the response into JSON. then uses POST to upload the video file. Update the token parameter in
     * the url to your upload token. --&gt; &lt;script&gt; var form &#x3D;
     * document.forms.namedItem(\&quot;videoUploadForm\&quot;); form.addEventListener(&#39;submit&#39;, function(ev) {
     * ev.preventDefault(); var oOutput &#x3D; document.querySelector(\&quot;div\&quot;), oData &#x3D; new
     * FormData(form); var oReq &#x3D; new XMLHttpRequest(); oReq.open(\&quot;POST\&quot;,
     * \&quot;https://ws.api.video/upload?token&#x3D;toXXX\&quot;, true); oReq.send(oData); oReq.onload &#x3D;
     * function(oEvent) { if (oReq.status &#x3D;&#x3D;201) { oOutput.innerHTML &#x3D; \&quot;Your video is
     * uploaded!&lt;br/&gt;\&quot; + oReq.response; } else { oOutput.innerHTML &#x3D; \&quot;Error \&quot; + oReq.status
     * + \&quot; occurred when trying to upload your file.&lt;br /&gt;\&quot;; } }; }, false); &lt;/script&gt;
     * &#x60;&#x60;&#x60; ### Dealing with large files We have created a &lt;a
     * href&#x3D;&#39;https://api.video/blog/tutorials/uploading-large-files-with-javascript&#39;&gt;tutorial&lt;/a&gt;
     * to walk through the steps required.
     * 
     * @param token
     *            The unique identifier for the token you want to use to upload a video. (required)
     * @param file
     *            The path to the video you want to upload. (required)
     * @param uploadProgressListener
     *            An upload progress listener
     * 
     * @return ApiResponse&lt;Video&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<Video> uploadWithUploadTokenWithHttpInfo(String token, File file,
            UploadProgressListener uploadProgressListener) throws ApiException {
        String videoId = null;

        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling upload");
        }
        long totalBytes = file.length();
        long chunkSize = getApiClient().getUploadChunkSize();
        if (totalBytes > chunkSize) {
            int chunkNum = 0;
            ApiResponse<Video> lastRes = null;
            for (long i = 0; i < totalBytes; i += chunkSize) {
                okhttp3.Call localVarCall = uploadWithUploadTokenChunkValidateBeforeCall(token, file, videoId, i,
                        Math.min(i + chunkSize, totalBytes) - 1, totalBytes,
                        (int) Math.ceil((float) totalBytes / chunkSize), chunkNum + 1, uploadProgressListener, null);
                Type localVarReturnType = new TypeToken<Video>() {
                }.getType();
                lastRes = localVarApiClient.execute(localVarCall, localVarReturnType);
                if (videoId == null) {
                    videoId = lastRes.getData().getVideoId();
                }
                chunkNum++;
            }
            return lastRes;
        } else {
            ApiCallback apiCallback = new ApiCallback() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map responseHeaders) {
                }

                @Override
                public void onSuccess(Object result, int statusCode, Map responseHeaders) {
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
                    if (uploadProgressListener != null) {
                        uploadProgressListener.onProgress(bytesWritten - (contentLength - totalBytes), totalBytes, 1,
                                1);
                    }
                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
                }
            };

            okhttp3.Call localVarCall = uploadWithUploadTokenValidateBeforeCall(token, file, apiCallback);
            Type localVarReturnType = new TypeToken<Video>() {
            }.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        }

    }

    /**
     * Build call for create
     * 
     * @param videoCreationPayload
     *            video to create (required)
     * @param _callback
     *            Callback for upload/download progress
     * 
     * @return Call to execute
     * 
     * @throws ApiException
     *             If fail to serialize the request body object
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>202</td>
     *                        <td>Accepted</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    private okhttp3.Call createCall(VideoCreationPayload videoCreationPayload, final ApiCallback _callback)
            throws ApiException {
        Object localVarPostBody = videoCreationPayload;

        // create path and map variables
        String localVarPath = "/videos";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createValidateBeforeCall(VideoCreationPayload videoCreationPayload,
            final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'videoCreationPayload' is set
        if (videoCreationPayload == null) {
            throw new ApiException("Missing the required parameter 'videoCreationPayload' when calling create");
        }

        if (videoCreationPayload.getTitle() == null) {
            throw new ApiException("Missing the required parameter 'videoCreationPayload.title' when calling create");
        }

        okhttp3.Call localVarCall = createCall(videoCreationPayload, _callback);
        return localVarCall;
    }

    /**
     * Create a video To create a video, you create its metadata first, before adding the video file (exception - when
     * using an existing HTTP source). * Videos are public by default. [Learn about Private
     * videos](https://api.video/blog/tutorials/tutorial-private-videos) * Up to 6 responsive video streams will be
     * created (from 240p to 4k) * Mp4 encoded versions are created at the highest quality (max 1080p) by default. *
     * Panoramic videos are for videos recorded in 360 degrees. You can toggle this after your 360 video upload. *
     * Searchable parameters: title, description, tags and metadata &#x60;&#x60;&#x60;shell $ curl
     * https://ws.api.video/videos \\ -H &#39;Authorization: Bearer {access_token} \\ -d
     * &#39;{\&quot;title\&quot;:\&quot;My video\&quot;, \&quot;description\&quot;:\&quot;so many details\&quot;,
     * \&quot;mp4Support\&quot;:true }&#39; &#x60;&#x60;&#x60; ### add an URL to upload on creation You can also create
     * a video directly from a video hosted on a third-party server by giving its URI in &#x60;source&#x60; parameter:
     * &#x60;&#x60;&#x60;shell $ curl https://ws.api.video/videos \\ -H &#39;Authorization: Bearer {access_token} \\ -d
     * &#39;{\&quot;source\&quot;:\&quot;http://uri/to/video.mp4\&quot;, \&quot;title\&quot;:\&quot;My
     * video\&quot;}&#39; &#x60;&#x60;&#x60; In this case, the service will respond &#x60;202 Accepted&#x60; and
     * download the video asynchronously. ### Track users with Dynamic Metadata Metadata values can be a key:value where
     * the values are predefined, but Dynamic metadata allows you to enter *any* value for a defined key. To defined a
     * dynamic metadata pair use: &#x60;&#x60;&#x60; \&quot;metadata\&quot;:[{\&quot;dynamicKey\&quot;:
     * \&quot;__dynamicKey__\&quot;}] &#x60;&#x60;&#x60; The double underscore on both sides of the value allows any
     * variable to be added for a given video session. Added the the url you might have: &#x60;&#x60;&#x60; &lt;iframe
     * type&#x3D;\&quot;text/html\&quot;
     * src&#x3D;\&quot;https://embed.api.video/vod/vi6QvU9dhYCzW3BpPvPsZUa8?metadata[classUserName]&#x3D;Doug\&quot;
     * width&#x3D;\&quot;960\&quot; height&#x3D;\&quot;320\&quot; frameborder&#x3D;\&quot;0\&quot;
     * scrollling&#x3D;\&quot;no\&quot;&gt;&lt;/iframe&gt; &#x60;&#x60;&#x60; This video session will be tagged as
     * watched by Doug - allowing for in-depth analysis on how each viewer interacts with the videos. We have tutorials
     * on: * [Creating and uploading videos](https://api.video/blog/tutorials/video-upload-tutorial) * [Uploading large
     * videos](https://api.video/blog/tutorials/video-upload-tutorial-large-videos) * [Using tags with
     * videos](https://api.video/blog/tutorials/video-tagging-best-practices) * [Private
     * videos](https://api.video/blog/tutorials/tutorial-private-videos) * [Using Dynamic
     * Metadata](https://api.video/blog/tutorials/dynamic-metadata) * Full list of
     * [tutorials](https://api.video/blog/endpoints/video-create) that demonstrate this endpoint.
     * 
     * @param videoCreationPayload
     *            video to create (required)
     * 
     * @return Video
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>202</td>
     *                        <td>Accepted</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public Video create(VideoCreationPayload videoCreationPayload) throws ApiException {
        ApiResponse<Video> localVarResp = createWithHttpInfo(videoCreationPayload);
        return localVarResp.getData();
    }

    /**
     * Create a video To create a video, you create its metadata first, before adding the video file (exception - when
     * using an existing HTTP source). * Videos are public by default. [Learn about Private
     * videos](https://api.video/blog/tutorials/tutorial-private-videos) * Up to 6 responsive video streams will be
     * created (from 240p to 4k) * Mp4 encoded versions are created at the highest quality (max 1080p) by default. *
     * Panoramic videos are for videos recorded in 360 degrees. You can toggle this after your 360 video upload. *
     * Searchable parameters: title, description, tags and metadata &#x60;&#x60;&#x60;shell $ curl
     * https://ws.api.video/videos \\ -H &#39;Authorization: Bearer {access_token} \\ -d
     * &#39;{\&quot;title\&quot;:\&quot;My video\&quot;, \&quot;description\&quot;:\&quot;so many details\&quot;,
     * \&quot;mp4Support\&quot;:true }&#39; &#x60;&#x60;&#x60; ### add an URL to upload on creation You can also create
     * a video directly from a video hosted on a third-party server by giving its URI in &#x60;source&#x60; parameter:
     * &#x60;&#x60;&#x60;shell $ curl https://ws.api.video/videos \\ -H &#39;Authorization: Bearer {access_token} \\ -d
     * &#39;{\&quot;source\&quot;:\&quot;http://uri/to/video.mp4\&quot;, \&quot;title\&quot;:\&quot;My
     * video\&quot;}&#39; &#x60;&#x60;&#x60; In this case, the service will respond &#x60;202 Accepted&#x60; and
     * download the video asynchronously. ### Track users with Dynamic Metadata Metadata values can be a key:value where
     * the values are predefined, but Dynamic metadata allows you to enter *any* value for a defined key. To defined a
     * dynamic metadata pair use: &#x60;&#x60;&#x60; \&quot;metadata\&quot;:[{\&quot;dynamicKey\&quot;:
     * \&quot;__dynamicKey__\&quot;}] &#x60;&#x60;&#x60; The double underscore on both sides of the value allows any
     * variable to be added for a given video session. Added the the url you might have: &#x60;&#x60;&#x60; &lt;iframe
     * type&#x3D;\&quot;text/html\&quot;
     * src&#x3D;\&quot;https://embed.api.video/vod/vi6QvU9dhYCzW3BpPvPsZUa8?metadata[classUserName]&#x3D;Doug\&quot;
     * width&#x3D;\&quot;960\&quot; height&#x3D;\&quot;320\&quot; frameborder&#x3D;\&quot;0\&quot;
     * scrollling&#x3D;\&quot;no\&quot;&gt;&lt;/iframe&gt; &#x60;&#x60;&#x60; This video session will be tagged as
     * watched by Doug - allowing for in-depth analysis on how each viewer interacts with the videos. We have tutorials
     * on: * [Creating and uploading videos](https://api.video/blog/tutorials/video-upload-tutorial) * [Uploading large
     * videos](https://api.video/blog/tutorials/video-upload-tutorial-large-videos) * [Using tags with
     * videos](https://api.video/blog/tutorials/video-tagging-best-practices) * [Private
     * videos](https://api.video/blog/tutorials/tutorial-private-videos) * [Using Dynamic
     * Metadata](https://api.video/blog/tutorials/dynamic-metadata) * Full list of
     * [tutorials](https://api.video/blog/endpoints/video-create) that demonstrate this endpoint.
     * 
     * @param videoCreationPayload
     *            video to create (required)
     * 
     * @return ApiResponse&lt;Video&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>202</td>
     *                        <td>Accepted</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<Video> createWithHttpInfo(VideoCreationPayload videoCreationPayload) throws ApiException {
        okhttp3.Call localVarCall = createValidateBeforeCall(videoCreationPayload, null);
        Type localVarReturnType = new TypeToken<Video>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Build call for upload
     * 
     * @param videoId
     *            Enter the videoId you want to use to upload your video. (required)
     * @param file
     *            The path to the video you would like to upload. The path must be local. If you want to use a video
     *            from an online source, you must use the \\\&quot;/videos\\\&quot; endpoint and add the
     *            \\\&quot;source\\\&quot; parameter when you create a new video. (required)
     * @param _callback
     *            Callback for upload/download progress
     * 
     * @return Call to execute
     * 
     * @throws ApiException
     *             If fail to serialize the request body object
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    private okhttp3.Call uploadCall(String videoId, File file, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/videos/{videoId}/source".replaceAll("\\{" + "videoId" + "\\}",
                localVarApiClient.escapeString(videoId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (file != null) {
            localVarFormParams.put("file", file);
        }

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = { "multipart/form-data" };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    private okhttp3.Call uploadChunkCall(String videoId, File file, long chunkStart, long chunkEnd, long totalBytes,
            Integer chunksCount, Integer chunkNum, UploadProgressListener progressListener, final ApiCallback _callback)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/videos/{videoId}/source".replaceAll("\\{" + "videoId" + "\\}",
                localVarApiClient.escapeString(videoId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (file != null) {
            localVarFormParams.put("file", new UploadChunkRequestBody(file, chunksCount, chunkNum, totalBytes,
                    chunkStart, chunkEnd + 1, progressListener));
        }

        localVarHeaderParams.put("Content-Range", "bytes " + chunkStart + "-" + chunkEnd + "/" + totalBytes);

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = { "multipart/form-data" };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call uploadValidateBeforeCall(String videoId, File file, final ApiCallback _callback)
            throws ApiException {

        // verify the required parameter 'videoId' is set
        if (videoId == null) {
            throw new ApiException("Missing the required parameter 'videoId' when calling upload");
        }

        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling upload");
        }

        okhttp3.Call localVarCall = uploadCall(videoId, file, _callback);
        return localVarCall;
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call uploadChunkValidateBeforeCall(String videoId, File file, long chunkStart, long chunkEnd,
            long totalBytes, Integer chunksCount, Integer chunkNum, UploadProgressListener progressListener,
            final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'videoId' is set
        if (videoId == null) {
            throw new ApiException("Missing the required parameter 'videoId' when calling upload(Async)");
        }

        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling upload(Async)");
        }

        okhttp3.Call localVarCall = uploadChunkCall(videoId, file, chunkStart, chunkEnd, totalBytes, chunksCount,
                chunkNum, progressListener, _callback);
        return localVarCall;

    }

    /**
     * Upload a video To upload a video to the videoId you created. Replace {videoId} with the id you&#39;d like to use,
     * {access_token} with your token, and /path/to/video.mp4 with the path to the video you&#39;d like to upload. You
     * can only upload your video to the videoId once. &#x60;&#x60;&#x60;bash curl
     * https://ws.api.video/videos/{videoId}/source \\ -H &#39;Authorization: Bearer {access_token}&#39; \\ -F
     * file&#x3D;@/path/to/video.mp4 &#x60;&#x60;&#x60; Tutorials using [video
     * upload](https://api.video/blog/endpoints/video-upload)
     * 
     * @param videoId
     *            Enter the videoId you want to use to upload your video. (required)
     * @param file
     *            The path to the video you would like to upload. The path must be local. If you want to use a video
     *            from an online source, you must use the \\\&quot;/videos\\\&quot; endpoint and add the
     *            \\\&quot;source\\\&quot; parameter when you create a new video. (required)
     * 
     * @return Video
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public Video upload(String videoId, File file) throws ApiException {
        ApiResponse<Video> localVarResp = uploadWithHttpInfo(videoId, file);
        return localVarResp.getData();
    }

    /**
     * Upload a video To upload a video to the videoId you created. Replace {videoId} with the id you&#39;d like to use,
     * {access_token} with your token, and /path/to/video.mp4 with the path to the video you&#39;d like to upload. You
     * can only upload your video to the videoId once. &#x60;&#x60;&#x60;bash curl
     * https://ws.api.video/videos/{videoId}/source \\ -H &#39;Authorization: Bearer {access_token}&#39; \\ -F
     * file&#x3D;@/path/to/video.mp4 &#x60;&#x60;&#x60; Tutorials using [video
     * upload](https://api.video/blog/endpoints/video-upload)
     * 
     * @param videoId
     *            Enter the videoId you want to use to upload your video. (required)
     * @param file
     *            The path to the video you would like to upload. The path must be local. If you want to use a video
     *            from an online source, you must use the \\\&quot;/videos\\\&quot; endpoint and add the
     *            \\\&quot;source\\\&quot; parameter when you create a new video. (required)
     * @param uploadProgressListener
     *            An upload progress listener
     * 
     * @return Video
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public Video upload(String videoId, File file, UploadProgressListener uploadProgressListener) throws ApiException {
        ApiResponse<Video> localVarResp = uploadWithHttpInfo(videoId, file, uploadProgressListener);
        return localVarResp.getData();
    }

    /**
     * Upload a video To upload a video to the videoId you created. Replace {videoId} with the id you&#39;d like to use,
     * {access_token} with your token, and /path/to/video.mp4 with the path to the video you&#39;d like to upload. You
     * can only upload your video to the videoId once. &#x60;&#x60;&#x60;bash curl
     * https://ws.api.video/videos/{videoId}/source \\ -H &#39;Authorization: Bearer {access_token}&#39; \\ -F
     * file&#x3D;@/path/to/video.mp4 &#x60;&#x60;&#x60; Tutorials using [video
     * upload](https://api.video/blog/endpoints/video-upload)
     * 
     * @param videoId
     *            Enter the videoId you want to use to upload your video. (required)
     * @param file
     *            The path to the video you would like to upload. The path must be local. If you want to use a video
     *            from an online source, you must use the \\\&quot;/videos\\\&quot; endpoint and add the
     *            \\\&quot;source\\\&quot; parameter when you create a new video. (required)
     * 
     * @return ApiResponse&lt;Video&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<Video> uploadWithHttpInfo(String videoId, File file) throws ApiException {
        return uploadWithHttpInfo(videoId, file, null);
    }

    /**
     * Upload a video To upload a video to the videoId you created. Replace {videoId} with the id you&#39;d like to use,
     * {access_token} with your token, and /path/to/video.mp4 with the path to the video you&#39;d like to upload. You
     * can only upload your video to the videoId once. &#x60;&#x60;&#x60;bash curl
     * https://ws.api.video/videos/{videoId}/source \\ -H &#39;Authorization: Bearer {access_token}&#39; \\ -F
     * file&#x3D;@/path/to/video.mp4 &#x60;&#x60;&#x60; Tutorials using [video
     * upload](https://api.video/blog/endpoints/video-upload)
     * 
     * @param videoId
     *            Enter the videoId you want to use to upload your video. (required)
     * @param file
     *            The path to the video you would like to upload. The path must be local. If you want to use a video
     *            from an online source, you must use the \\\&quot;/videos\\\&quot; endpoint and add the
     *            \\\&quot;source\\\&quot; parameter when you create a new video. (required)
     * @param uploadProgressListener
     *            An upload progress listener
     * 
     * @return ApiResponse&lt;Video&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>201</td>
     *                        <td>Created</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<Video> uploadWithHttpInfo(String videoId, File file,
            UploadProgressListener uploadProgressListener) throws ApiException {

        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling upload");
        }
        long totalBytes = file.length();
        long chunkSize = getApiClient().getUploadChunkSize();
        if (totalBytes > chunkSize) {
            int chunkNum = 0;
            ApiResponse<Video> lastRes = null;
            for (long i = 0; i < totalBytes; i += chunkSize) {
                okhttp3.Call localVarCall = uploadChunkValidateBeforeCall(videoId, file, i,
                        Math.min(i + chunkSize, totalBytes) - 1, totalBytes,
                        (int) Math.ceil((float) totalBytes / chunkSize), chunkNum + 1, uploadProgressListener, null);
                Type localVarReturnType = new TypeToken<Video>() {
                }.getType();
                lastRes = localVarApiClient.execute(localVarCall, localVarReturnType);
                chunkNum++;
            }
            return lastRes;
        } else {
            ApiCallback apiCallback = new ApiCallback() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map responseHeaders) {
                }

                @Override
                public void onSuccess(Object result, int statusCode, Map responseHeaders) {
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
                    if (uploadProgressListener != null) {
                        uploadProgressListener.onProgress(bytesWritten - (contentLength - totalBytes), totalBytes, 1,
                                1);
                    }
                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
                }
            };

            okhttp3.Call localVarCall = uploadValidateBeforeCall(videoId, file, apiCallback);
            Type localVarReturnType = new TypeToken<Video>() {
            }.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        }

    }

    /**
     * Build call for uploadThumbnail
     * 
     * @param videoId
     *            Unique identifier of the chosen video (required)
     * @param file
     *            The image to be added as a thumbnail. (required)
     * @param _callback
     *            Callback for upload/download progress
     * 
     * @return Call to execute
     * 
     * @throws ApiException
     *             If fail to serialize the request body object
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    private okhttp3.Call uploadThumbnailCall(String videoId, File file, final ApiCallback _callback)
            throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/videos/{videoId}/thumbnail".replaceAll("\\{" + "videoId" + "\\}",
                localVarApiClient.escapeString(videoId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (file != null) {
            localVarFormParams.put("file", file);
        }

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = { "multipart/form-data" };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames,
                _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call uploadThumbnailValidateBeforeCall(String videoId, File file, final ApiCallback _callback)
            throws ApiException {

        // verify the required parameter 'videoId' is set
        if (videoId == null) {
            throw new ApiException("Missing the required parameter 'videoId' when calling uploadThumbnail");
        }

        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling uploadThumbnail");
        }

        okhttp3.Call localVarCall = uploadThumbnailCall(videoId, file, _callback);
        return localVarCall;
    }

    /**
     * Upload a thumbnail The thumbnail is the poster that appears in the player window before video playback begins.
     * This endpoint allows you to upload an image for the thumbnail. To select a still frame from the video using a
     * time stamp, use [Pick a Thumbnail](https://docs.api.video/reference#patch_videos-videoid-thumbnail) to pick a
     * time in the video. Note: There may be a short delay before the new thumbnail is delivered to our CDN. Tutorials
     * using [Thumbnail upload](https://api.video/blog/endpoints/videos-upload-a-thumbnail).
     * 
     * @param videoId
     *            Unique identifier of the chosen video (required)
     * @param file
     *            The image to be added as a thumbnail. (required)
     * 
     * @return Video
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public Video uploadThumbnail(String videoId, File file) throws ApiException {
        ApiResponse<Video> localVarResp = uploadThumbnailWithHttpInfo(videoId, file);
        return localVarResp.getData();
    }

    /**
     * Upload a thumbnail The thumbnail is the poster that appears in the player window before video playback begins.
     * This endpoint allows you to upload an image for the thumbnail. To select a still frame from the video using a
     * time stamp, use [Pick a Thumbnail](https://docs.api.video/reference#patch_videos-videoid-thumbnail) to pick a
     * time in the video. Note: There may be a short delay before the new thumbnail is delivered to our CDN. Tutorials
     * using [Thumbnail upload](https://api.video/blog/endpoints/videos-upload-a-thumbnail).
     * 
     * @param videoId
     *            Unique identifier of the chosen video (required)
     * @param file
     *            The image to be added as a thumbnail. (required)
     * 
     * @return ApiResponse&lt;Video&gt;
     * 
     * @throws ApiException
     *             If fail to call the API, e.g. server error or cannot deserialize the response body
     * 
     * @http.response.details
     *                        <table summary="Response Details" border="1">
     *                        <tr>
     *                        <td>Status Code</td>
     *                        <td>Description</td>
     *                        <td>Response Headers</td>
     *                        </tr>
     *                        <tr>
     *                        <td>200</td>
     *                        <td>Success</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>400</td>
     *                        <td>Bad Request</td>
     *                        <td>-</td>
     *                        </tr>
     *                        <tr>
     *                        <td>404</td>
     *                        <td>Not Found</td>
     *                        <td>-</td>
     *                        </tr>
     *                        </table>
     */
    public ApiResponse<Video> uploadThumbnailWithHttpInfo(String videoId, File file) throws ApiException {
        okhttp3.Call localVarCall = uploadThumbnailValidateBeforeCall(videoId, file, null);
        Type localVarReturnType = new TypeToken<Video>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

}
