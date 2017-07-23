package uk.co.mruoc.footballdata.client;

import uk.co.mruoc.footballdata.model.Player;
import uk.co.mruoc.http.client.ReadOnlyHttpClient;
import uk.co.mruoc.http.client.Response;

import java.util.List;

public class PlayerClient {

    private final PlayersParser parser = new PlayersParser();
    private final ReadOnlyHttpClient httpClient;
    private final EndpointProvider endpointProvider;

    public PlayerClient(ReadOnlyHttpClient httpClient, EndpointProvider endpointProvider) {
        this.httpClient = httpClient;
        this.endpointProvider = endpointProvider;
    }

    public List<Player> loadTeamPlayers(int teamId) {
        String endpoint = endpointProvider.getPlayers(teamId);
        Response response = httpClient.get(endpoint);
        return parser.toPlayers(response.getBody());
    }

}
