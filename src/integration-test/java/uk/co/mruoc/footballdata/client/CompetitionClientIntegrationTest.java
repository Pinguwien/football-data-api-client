package uk.co.mruoc.footballdata.client;

import org.joda.time.DateTime;
import org.junit.Test;
import uk.co.mruoc.footballdata.model.Competition;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompetitionClientIntegrationTest {

    private final TokenHttpClient httpClient = new TokenHttpClient();
    private final EndpointProvider endpointProvider = new V1EndpointProvider();
    private final CompetitionClient competitionClient = new CompetitionClient(httpClient, endpointProvider);

    @Test
    public void shouldLoadCompetitions() {
        List<Competition> competitions = competitionClient.load();

        assertThat(competitions.size()).isEqualTo(11);
        assertThat(competitions.get(0).getId()).isEqualTo(444);
        assertThat(competitions.get(9).getId()).isEqualTo(453);
    }

    @Test
    public void shouldLoadCompetition() {
        int id = 445;

        Competition competition = competitionClient.load(id);

        assertThat(competition.getSelfLink()).isEqualTo("http://api.football-data.org/v1/competitions/445");
        assertThat(competition.getTeamsLink()).isEqualTo("http://api.football-data.org/v1/competitions/445/teams");
        assertThat(competition.getFixturesLink()).isEqualTo("http://api.football-data.org/v1/competitions/445/fixtures");
        assertThat(competition.getLeagueTableLink()).isEqualTo("http://api.football-data.org/v1/competitions/445/leagueTable");

        assertThat(competition.getId()).isEqualTo(id);
        assertThat(competition.getCaption()).isEqualTo("Premier League 2017/18");
        assertThat(competition.getLeague()).isEqualTo("PL");
        assertThat(competition.getYear()).isEqualTo("2017");
        assertThat(competition.getCurrentMatchday()).isEqualTo(1);
        assertThat(competition.getNumberOfMatchdays()).isEqualTo(38);
        assertThat(competition.getNumberOfTeams()).isEqualTo(20);
        assertThat(competition.getNumberOfGames()).isEqualTo(380);
        assertThat(competition.getLastUpdated()).isEqualTo(expectedLastUpdatedDateTime());
    }

    private DateTime expectedLastUpdatedDateTime() {
        return new DateTime()
                .withDate(2017,6, 27)
                .withTime(14, 10, 19, 0);
    }

}
