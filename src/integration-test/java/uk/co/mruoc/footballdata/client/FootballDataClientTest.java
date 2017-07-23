package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.footballdata.model.Player;
import uk.co.mruoc.footballdata.model.Team;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FootballDataClientTest {

    private final FootballDataClient client = new FootballDataClient();

    @Test
    public void shouldGetCompetitions() {
        List<Competition> competitions = client.getCompetitions();

        assertThat(competitions.size()).isEqualTo(11);
    }

    @Test
    public void shouldGetCompetition() {
        int competitionId = 445;

        Competition competition = client.getCompetition(competitionId);

        assertThat(competition.getId()).isEqualTo(competitionId);
    }

    @Test
    public void shouldGetCompetitionTeams() {
        int competitionId = 445;

        List<Team> teams = client.getCompetitionTeams(competitionId);

        assertThat(teams.size()).isEqualTo(20);
    }

    @Test
    public void shouldGetTeam() {
        int teamId = 57;

        Team team = client.getTeam(teamId);

        assertThat(team.getId()).isEqualTo(teamId);
    }

    @Test
    public void shouldGetTeamPlayers() {
        int teamId = 57;

        List<Player> players = client.getTeamPlayers(teamId);

        assertThat(players.size()).isEqualTo(28);
    }
    
}
