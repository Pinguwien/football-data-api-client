package uk.co.mruoc.footballdata.client;

import uk.co.mruoc.footballdata.model.Team;
import uk.co.mruoc.http.client.HttpClient;
import uk.co.mruoc.http.client.Response;

import java.util.Collection;

public class TeamClient {

    private final TeamParser parser = new TeamParser();
    private final HttpClient httpClient;
    private final EndpointProvider endpointProvider;

    public TeamClient(HttpClient httpClient, EndpointProvider endpointProvider) {
        this.httpClient = httpClient;
        this.endpointProvider = endpointProvider;
    }

    public Collection<Team> load(int competitionId) {
        String endpoint = endpointProvider.getTeams(competitionId);
        Response response = httpClient.get(endpoint);
        return parser.toTeams(response.getBody());
    }

}
