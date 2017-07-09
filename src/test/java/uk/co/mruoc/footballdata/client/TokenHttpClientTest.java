package uk.co.mruoc.footballdata.client;

import org.apache.http.HttpStatus;
import org.junit.Test;
import uk.co.mruoc.http.client.Headers;
import uk.co.mruoc.http.client.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenHttpClientTest {

    private static final String ENDPOINT = "http://api.football-data.org/v1/competitions/";
    private static final String VALID_TOKEN = System.getProperty("footballDataApiToken");
    private static final String INVALID_TOKEN = "INVALID_TOKEN";

    private final TokenHttpClient client = new TokenHttpClient();

    
    @Test
    public void shouldPopulateTokenOnHeaderIfNotProvided() {
        Headers headers = new Headers();

        client.get(ENDPOINT, headers);

        assertThat(headers.getAuthToken()).isEqualTo(VALID_TOKEN);
    }

    @Test
    public void shouldNotPopulateTokenOnHeaderIfAlreadyProvided() {
        Headers headers = new Headers();
        headers.addAuthToken(INVALID_TOKEN);

        client.get(ENDPOINT, headers);

        assertThat(headers.getAuthToken()).isEqualTo(INVALID_TOKEN);
    }

    @Test
    public void callShouldReturnSuccessfully() {
        Headers headers = new Headers();

        Response response = client.get(ENDPOINT, headers);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    public void callShouldReturnSuccessfullyWithNoHeaders() {
        Response response = client.get(ENDPOINT);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    public void callShouldFailWithInvalidToken() {
        Headers headers = new Headers();
        headers.addAuthToken(INVALID_TOKEN);

        Response response = client.get(ENDPOINT, headers);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }

}
