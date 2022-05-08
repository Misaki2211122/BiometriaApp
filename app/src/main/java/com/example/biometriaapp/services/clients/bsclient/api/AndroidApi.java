/*
 * BiometriaService
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.example.biometriaapp.services.clients.bsclient.api;

import com.example.biometriaapp.services.clients.bsclient.ApiCallback;
import com.example.biometriaapp.services.clients.bsclient.ApiClient;
import com.example.biometriaapp.services.clients.bsclient.ApiException;
import com.example.biometriaapp.services.clients.bsclient.ApiResponse;
import com.example.biometriaapp.services.clients.bsclient.Configuration;
import com.example.biometriaapp.services.clients.bsclient.Pair;
import com.example.biometriaapp.services.clients.bsclient.ProgressRequestBody;
import com.example.biometriaapp.services.clients.bsclient.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.example.biometriaapp.services.clients.bsclient.model.DeviceIdAuthorizeRequest;
import com.example.biometriaapp.services.clients.bsclient.model.DeviceIdAuthorizeResponse;
import com.example.biometriaapp.services.clients.bsclient.model.GetDeviceIdRequest;
import com.example.biometriaapp.services.clients.bsclient.model.GetDeviceIdResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidApi {
    private ApiClient apiClient;

    public AndroidApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AndroidApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for androidDeviceIdAuthorizePost
     * @param deviceId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call androidDeviceIdAuthorizePostCall(String deviceId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/android/deviceIdAuthorize";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (deviceId != null)
        localVarFormParams.put("DeviceId", deviceId);

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call androidDeviceIdAuthorizePostValidateBeforeCall(String deviceId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = androidDeviceIdAuthorizePostCall(deviceId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 
     * 
     * @param deviceId  (optional)
     * @return DeviceIdAuthorizeRequest
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeviceIdAuthorizeRequest androidDeviceIdAuthorizePost(String deviceId) throws ApiException {
        ApiResponse<DeviceIdAuthorizeRequest> resp = androidDeviceIdAuthorizePostWithHttpInfo(deviceId);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param deviceId  (optional)
     * @return ApiResponse&lt;DeviceIdAuthorizeRequest&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DeviceIdAuthorizeRequest> androidDeviceIdAuthorizePostWithHttpInfo(String deviceId) throws ApiException {
        com.squareup.okhttp.Call call = androidDeviceIdAuthorizePostValidateBeforeCall(deviceId, null, null);
        Type localVarReturnType = new TypeToken<DeviceIdAuthorizeRequest>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param deviceId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call androidDeviceIdAuthorizePostAsync(String deviceId, final ApiCallback<DeviceIdAuthorizeRequest> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = androidDeviceIdAuthorizePostValidateBeforeCall(deviceId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DeviceIdAuthorizeRequest>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for androidGetDeviceIdGet
     * @param deviceId  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call androidGetDeviceIdGetCall(String deviceId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/android/getDeviceId";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (deviceId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("DeviceId", deviceId));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call androidGetDeviceIdGetValidateBeforeCall(String deviceId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = androidGetDeviceIdGetCall(deviceId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 
     * 
     * @param deviceId  (optional)
     * @return GetDeviceIdRequest
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetDeviceIdRequest androidGetDeviceIdGet(String deviceId) throws ApiException {
        ApiResponse<GetDeviceIdRequest> resp = androidGetDeviceIdGetWithHttpInfo(deviceId);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param deviceId  (optional)
     * @return ApiResponse&lt;GetDeviceIdRequest&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetDeviceIdRequest> androidGetDeviceIdGetWithHttpInfo(String deviceId) throws ApiException {
        com.squareup.okhttp.Call call = androidGetDeviceIdGetValidateBeforeCall(deviceId, null, null);
        Type localVarReturnType = new TypeToken<GetDeviceIdRequest>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param deviceId  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call androidGetDeviceIdGetAsync(String deviceId, final ApiCallback<GetDeviceIdRequest> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = androidGetDeviceIdGetValidateBeforeCall(deviceId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GetDeviceIdRequest>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}