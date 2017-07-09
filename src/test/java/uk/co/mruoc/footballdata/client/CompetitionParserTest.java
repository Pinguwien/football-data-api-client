package uk.co.mruoc.footballdata.client;

import org.joda.time.DateTime;
import org.junit.Test;
import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class CompetitionParserTest {

    private static final String JSON_FILE_PATH = "/competition.json";

    private final FileContentLoader loader = new ClasspathFileContentLoader();
    private final CompetitionParser parser = new CompetitionParser();

    @Test
    public void shouldLoadSelfLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getSelfLink()).isEqualTo("http://api.football-data.org/v1/competitions/445");
    }

    @Test
    public void shouldLoadTeamsLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getTeamsLink()).isEqualTo("http://api.football-data.org/v1/competitions/445/teams");
    }

    @Test
    public void shouldLoadFixturesLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getFixturesLink()).isEqualTo("http://api.football-data.org/v1/competitions/445/fixtures");
    }

    @Test
    public void shouldLoadLeagueTableLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getLeagueTableLink()).isEqualTo("http://api.football-data.org/v1/competitions/445/leagueTable");
    }

    @Test
    public void shouldLoadId() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getId()).isEqualTo(445);
    }

    @Test
    public void shouldLoadCaption() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getCaption()).isEqualTo("Premier League 2017/18");
    }

    @Test
    public void shouldLoadLeague() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getLeague()).isEqualTo("PL");
    }

    @Test
    public void shouldLoadYear() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getYear()).isEqualTo("2017");
    }

    @Test
    public void shouldLoadCurrentMatchday() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getCurrentMatchday()).isEqualTo(1);
    }

    @Test
    public void shouldLoadNumberOfMatchdays() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getNumberOfMatchdays()).isEqualTo(38);
    }

    @Test
    public void shouldLoadNumberOfTeams() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getNumberOfTeams()).isEqualTo(20);
    }

    @Test
    public void shouldLoadNumberOfGames() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getNumberOfGames()).isEqualTo(380);
    }

    @Test
    public void shouldLoadLastUpdated() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getLastUpdated()).isEqualTo(new DateTime()
                .withDate(2017, 6, 27)
                .withTime(14, 10, 19, 0));
    }

}
