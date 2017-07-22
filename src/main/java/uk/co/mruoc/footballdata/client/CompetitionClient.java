package uk.co.mruoc.footballdata.client;

import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.http.client.ReadOnlyHttpClient;
import uk.co.mruoc.http.client.Response;

import java.util.List;

public class CompetitionClient {

    private final CompetitionsParser parser = new CompetitionsParser();
    private final ReadOnlyHttpClient httpClient;
    private final EndpointProvider endpointProvider;

    public CompetitionClient(ReadOnlyHttpClient httpClient, EndpointProvider endpointProvider) {
        this.httpClient = httpClient;
        this.endpointProvider = endpointProvider;
    }

    public List<Competition> load() {
        Response response = httpClient.get(endpointProvider.getCompetitions());
        return parser.toCompetitions(response.getBody());
    }

    public Competition load(int id) {
        String endpoint = endpointProvider.getCompetition(id);
        Response response = httpClient.get(endpoint);
        return parser.toCompetition(response.getBody());
    }

}
