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

import ynab.client.invoker.ApiException;
import ynab.client.model.ErrorResponse;
import ynab.client.model.PayeeLocationResponse;
import ynab.client.model.PayeeLocationsResponse;
import java.util.UUID;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PayeeLocationsApi
 */
@Ignore
public class PayeeLocationsApiTest {

    private final PayeeLocationsApi api = new PayeeLocationsApi();

    
    /**
     * Single payee location
     *
     * Returns a single payee location
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPayeeLocationByIdTest() throws ApiException {
        UUID budgetId = null;
        UUID payeeLocationId = null;
        PayeeLocationResponse response = api.getPayeeLocationById(budgetId, payeeLocationId);

        // TODO: test validations
    }
    
    /**
     * List payee locations
     *
     * Returns all payee locations
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPayeeLocationsTest() throws ApiException {
        UUID budgetId = null;
        PayeeLocationsResponse response = api.getPayeeLocations(budgetId);

        // TODO: test validations
    }
    
    /**
     * List locations for a payee
     *
     * Returns all payee locations for the specified payee
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPayeeLocationsByPayeeTest() throws ApiException {
        UUID budgetId = null;
        UUID payeeId = null;
        PayeeLocationsResponse response = api.getPayeeLocationsByPayee(budgetId, payeeId);

        // TODO: test validations
    }
    
}
