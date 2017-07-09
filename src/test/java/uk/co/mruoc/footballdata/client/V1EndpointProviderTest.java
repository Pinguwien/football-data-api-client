package uk.co.mruoc.footballdata.client;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class V1EndpointProviderTest {

    private static final String BASE_URL = "http://api.football-data.org/v1/";

    private final EndpointProvider provider = new V1EndpointProvider();

    @Test
    public void shouldReturnV1BaseUrl() {
        assertThat(provider.getBase()).isEqualTo(BASE_URL);
    }

    @Test
    public void shouldReturnCompetitionsUrl() {
        assertThat(provider.getCompetitions()).isEqualTo(BASE_URL + "competitions/");
    }

    @Test
    public void shouldReturnCompetitionUrl() {
        assertThat(provider.getCompetition(123)).isEqualTo(BASE_URL + "competitions/123/");
    }

    @Test
    public void shouldReturnTeamsUrl() {
        assertThat(provider.getTeams(456)).isEqualTo(BASE_URL + "competitions/456/teams/");
    }

    @Test
    public void shouldReturnTeamUrl() {
        assertThat(provider.getTeam(789)).isEqualTo(BASE_URL + "teams/789/");
    }

    @Test
    public void shouldReturnPlayersUrl() {
        assertThat(provider.getPlayers(101)).isEqualTo(BASE_URL + "teams/101/players/");
    }

}
