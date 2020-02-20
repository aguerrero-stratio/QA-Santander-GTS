package utils;

public enum WebServiceEndPoints {
    //*****************************************************//
    //*** ONE TRADE ENDPOINTS                            **//
    //*****************************************************//

    //Dev Environment
    BASE_URI_DEV("https://gts-kong.sgcto-int.stratio.com/onetrade"),
    //Test Environment
    BASE_URI_TEST("https://gts-kong.sgcto-int.stratio.com/onetrade"),

    DOMAIN_PAYMENTS("payments"),
    DOMAIN_ACCOUNTS("accounts"),
    DOMAIN_TRANSACTION("transactions"),

    GET_PAYMENTS("/payments?pageNumber=0&pageSize=1000&status=ACSP"),
    GET_PAYMENTS_BY_ID("/payments?pageNumber=0&pageSize=1000&paymentId="),
    GET_PAYMENTS_ACCOUNT_ID("/payments?account_id="),

    ACCOUNT_SEARCH("/accounts/search"),
    GET_USER("/users/1/accounts"),

    //*****************************************************//
    //*** SPARTA ENDPOINTS                            **//
    //*****************************************************//
    BASE_URI_DEV_SPARTA("https://gts-sparta.sgcto-int.stratio.com:443/gts-sparta"),
    BASE_URI_SPARTA_SWAGGER("https://gts-sparta.sgcto-int.stratio.com/gts-sparta"),


    SPARTA_USER ("sparta"),
    SPARTA_PASSWORD ("stratio"),
    SPARTA_SWAGGER_STATUS("/swagger/appStatus"),
    GET_DOWNLOAD_WORKFLOW("/workflows/download/"),
    WORKFLOW_RUN("/workflows/run/"),
    WORKFLOW_EXECUTION("/workflowExecutions/"),
    WORKFLOW_RUNWITHVARIABLES("/workflows/runWithVariables");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
