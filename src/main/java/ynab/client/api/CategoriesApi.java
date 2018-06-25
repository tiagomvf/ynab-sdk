/*
 * YNAB API Endpoints
 * Our API uses a REST based design, leverages the JSON data format, and relies upon HTTPS for transport. We respond with meaningful HTTP response codes and if an error occurs, we include error details in the response body.  API Documentation is at https://api.youneedabudget.com
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ynab.client.api;

import ynab.client.invoker.ApiCallback;
import ynab.client.invoker.ApiClient;
import ynab.client.invoker.ApiException;
import ynab.client.invoker.ApiResponse;
import ynab.client.invoker.Configuration;
import ynab.client.invoker.Pair;
import ynab.client.invoker.ProgressRequestBody;
import ynab.client.invoker.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import ynab.client.model.CategoriesResponse;
import ynab.client.model.CategoryResponse;
import ynab.client.model.ErrorResponse;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesApi {
    private ApiClient apiClient;

    public CategoriesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CategoriesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getCategories
     * @param budgetId The ID of the Budget. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCategoriesCall(UUID budgetId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/budgets/{budget_id}/categories"
            .replaceAll("\\{" + "budget_id" + "\\}", apiClient.escapeString(budgetId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

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

        String[] localVarAuthNames = new String[] { "bearer" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCategoriesValidateBeforeCall(UUID budgetId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling getCategories(Async)");
        }
        

        com.squareup.okhttp.Call call = getCategoriesCall(budgetId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List categories
     * Returns all categories grouped by category group.
     * @param budgetId The ID of the Budget. (required)
     * @return CategoriesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CategoriesResponse getCategories(UUID budgetId) throws ApiException {
        ApiResponse<CategoriesResponse> resp = getCategoriesWithHttpInfo(budgetId);
        return resp.getData();
    }

    /**
     * List categories
     * Returns all categories grouped by category group.
     * @param budgetId The ID of the Budget. (required)
     * @return ApiResponse&lt;CategoriesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CategoriesResponse> getCategoriesWithHttpInfo(UUID budgetId) throws ApiException {
        com.squareup.okhttp.Call call = getCategoriesValidateBeforeCall(budgetId, null, null);
        Type localVarReturnType = new TypeToken<CategoriesResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List categories (asynchronously)
     * Returns all categories grouped by category group.
     * @param budgetId The ID of the Budget. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCategoriesAsync(UUID budgetId, final ApiCallback<CategoriesResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getCategoriesValidateBeforeCall(budgetId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CategoriesResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCategoryById
     * @param budgetId The ID of the Budget. (required)
     * @param categoryId The ID of the Category. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCategoryByIdCall(UUID budgetId, UUID categoryId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/budgets/{budget_id}/categories/{category_id}"
            .replaceAll("\\{" + "budget_id" + "\\}", apiClient.escapeString(budgetId.toString()))
            .replaceAll("\\{" + "category_id" + "\\}", apiClient.escapeString(categoryId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

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

        String[] localVarAuthNames = new String[] { "bearer" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCategoryByIdValidateBeforeCall(UUID budgetId, UUID categoryId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling getCategoryById(Async)");
        }
        
        // verify the required parameter 'categoryId' is set
        if (categoryId == null) {
            throw new ApiException("Missing the required parameter 'categoryId' when calling getCategoryById(Async)");
        }
        

        com.squareup.okhttp.Call call = getCategoryByIdCall(budgetId, categoryId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Single category
     * Returns a single category
     * @param budgetId The ID of the Budget. (required)
     * @param categoryId The ID of the Category. (required)
     * @return CategoryResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CategoryResponse getCategoryById(UUID budgetId, UUID categoryId) throws ApiException {
        ApiResponse<CategoryResponse> resp = getCategoryByIdWithHttpInfo(budgetId, categoryId);
        return resp.getData();
    }

    /**
     * Single category
     * Returns a single category
     * @param budgetId The ID of the Budget. (required)
     * @param categoryId The ID of the Category. (required)
     * @return ApiResponse&lt;CategoryResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CategoryResponse> getCategoryByIdWithHttpInfo(UUID budgetId, UUID categoryId) throws ApiException {
        com.squareup.okhttp.Call call = getCategoryByIdValidateBeforeCall(budgetId, categoryId, null, null);
        Type localVarReturnType = new TypeToken<CategoryResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Single category (asynchronously)
     * Returns a single category
     * @param budgetId The ID of the Budget. (required)
     * @param categoryId The ID of the Category. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCategoryByIdAsync(UUID budgetId, UUID categoryId, final ApiCallback<CategoryResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getCategoryByIdValidateBeforeCall(budgetId, categoryId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CategoryResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
