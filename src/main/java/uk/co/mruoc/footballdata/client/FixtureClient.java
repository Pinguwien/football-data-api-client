package uk.co.mruoc.footballdata.client;

import uk.co.mruoc.footballdata.model.Fixture;
import uk.co.mruoc.http.client.ReadOnlyHttpClient;
import uk.co.mruoc.http.client.Response;

import java.util.List;

public class FixtureClient {

    private final FixturesParser parser = new FixturesParser();
    private final ReadOnlyHttpClient httpClient;
    private final EndpointProvider endpointProvider;

    public FixtureClient(ReadOnlyHttpClient httpClient, EndpointProvider endpointProvider) {
        this.httpClient = httpClient;
        this.endpointProvider = endpointProvider;
    }

    public List<Fixture> load() {
        Response response = httpClient.get(endpointProvider.getFixtures());
        return parser.toFixtures(response.getBody());
    }

    public Fixture load(int fixtureId) {
        String endpoint = endpointProvider.getFixture(fixtureId);
        Response response = httpClient.get(endpoint);
        return parser.toFixture(response.getBody());
    }

}
