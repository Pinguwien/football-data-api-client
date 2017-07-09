package uk.co.mruoc.footballdata.client;

import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.http.client.HttpClient;
import uk.co.mruoc.http.client.Response;

import java.util.Collection;

public class CompetitionClient {

    private final CompetitionParser parser = new CompetitionParser();
    private final HttpClient httpClient;
    private final EndpointProvider endpointProvider;

    public CompetitionClient(HttpClient httpClient, EndpointProvider endpointProvider) {
        this.httpClient = httpClient;
        this.endpointProvider = endpointProvider;
    }

    public Collection<Competition> load() {
        Response response = httpClient.get(endpointProvider.getBase());
        return toCompetitions(response);
    }

    public Competition load(int id) {
        String endpoint = endpointProvider.getCompetition(id);
        Response response = httpClient.get(endpoint);
        return toCompetition(response);
    }

    private Collection<Competition> toCompetitions(Response response) {
        return parser.toCompetitions(response.getBody());
    }

    private Competition toCompetition(Response response) {
        return parser.toCompetition(response.getBody());
    }

}
