package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Player;
import uk.co.mruoc.footballdata.model.Team;
import uk.co.mruoc.http.client.ReadOnlyHttpClient;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerClientIntegrationTest {

    private final ReadOnlyHttpClient httpClient = new TokenHttpClient();
    private final EndpointProvider endpointProvider = new V1EndpointProvider();
    private final PlayerClient playerClient = new PlayerClient(httpClient, endpointProvider);

    @Test
    public void shouldLoadTeamPlayers() {
        int teamId = 57;

        List<Player> players = playerClient.loadTeamPlayers(teamId);

        assertThat(players.size()).isEqualTo(28);
        assertThat(players.get(0).getName()).isEqualTo("Petr Cech");
        assertThat(players.get(27).getName()).isEqualTo("Yaya Sanogo");
    }

}
