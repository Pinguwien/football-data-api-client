package uk.co.mruoc.footballdata.client;

import uk.co.mruoc.footballdata.model.Team;
import uk.co.mruoc.http.client.ReadOnlyHttpClient;
import uk.co.mruoc.http.client.Response;

import java.util.List;

public class TeamClient {

    private final TeamsParser parser = new TeamsParser();
    private final ReadOnlyHttpClient httpClient;
    private final EndpointProvider endpointProvider;

    public TeamClient(ReadOnlyHttpClient httpClient, EndpointProvider endpointProvider) {
        this.httpClient = httpClient;
        this.endpointProvider = endpointProvider;
    }

    public List<Team> loadCompetitionTeams(int competitionId) {
        String endpoint = endpointProvider.getTeams(competitionId);
        Response response = httpClient.get(endpoint);
        return parser.toTeams(response.getBody());
    }

    public Team load(int teamId) {
        String endpoint = endpointProvider.getTeam(teamId);
        Response response = httpClient.get(endpoint);
        return parser.toTeam(response.getBody());
    }

}
