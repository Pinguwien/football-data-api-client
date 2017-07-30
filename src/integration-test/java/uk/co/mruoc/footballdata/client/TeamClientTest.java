package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Team;
import uk.co.mruoc.http.client.ReadOnlyHttpClient;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamClientTest {

    private final ReadOnlyHttpClient httpClient = new TokenHttpClient();
    private final EndpointProvider endpointProvider = new V1EndpointProvider();
    private final TeamClient teamClient = new TeamClient(httpClient, endpointProvider);

    @Test
    public void shouldLoadCompetitionTeams() {
        int competitionId = 445;

        List<Team> teams = teamClient.loadCompetitionTeams(competitionId);

        assertThat(teams.size()).isEqualTo(20);
        assertThat(teams.get(0).getName()).isEqualTo("Arsenal FC");
        assertThat(teams.get(19).getName()).isEqualTo("West Ham United FC");
    }

    @Test
    public void shouldLoadTeam() {
        int teamId = 57;
        Team team = teamClient.load(teamId);

        assertThat(team.getSelfLink()).isEqualTo("http://api.football-data.org/v1/teams/57");
        assertThat(team.getFixturesLink()).isEqualTo("http://api.football-data.org/v1/teams/57/fixtures");
        assertThat(team.getPlayersLink()).isEqualTo("http://api.football-data.org/v1/teams/57/players");

        assertThat(team.getId()).isEqualTo(teamId);
        assertThat(team.getName()).isEqualTo("Arsenal FC");
        assertThat(team.getShortName()).isEqualTo("Arsenal");
        assertThat(team.getCode()).isEqualTo("AFC");
        assertThat(team.getCrestUrl()).isEqualTo("http://upload.wikimedia.org/wikipedia/en/5/53/Arsenal_FC.svg");
        assertThat(team.getSquadMarketValue()).isEqualByComparingTo(BigDecimal.ZERO);
    }

}
