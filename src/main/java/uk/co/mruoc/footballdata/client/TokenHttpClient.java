package uk.co.mruoc.footballdata.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.mruoc.http.client.Headers;
import uk.co.mruoc.http.client.Response;
import uk.co.mruoc.http.client.SimpleHttpClient;

public class TokenHttpClient extends SimpleHttpClient {

    private final String token;

    public TokenHttpClient() {
        this(System.getProperty("footballDataApiToken"));
    }

    public TokenHttpClient(String token) {
        this.token = token;
    }

    @Override
    public Response get(String endpoint) {
        Headers headers = new Headers();
        return this.get(endpoint, headers);
    }

    @Override
    public Response get(String endpoint, Headers headers) {
        if (!headers.hasAuthToken())
            headers.addAuthToken(token);
        return super.get(endpoint, headers);
    }

}
