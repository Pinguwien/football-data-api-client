package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CompetitionParserTest {

    private static final String JSON_FILE_PATH = "/competition.json";

    private final FileContentLoader loader = new ClasspathFileContentLoader();
    private final CompetitionParser parser = new CompetitionParser();

    @Test
    public void shouldParseSelfLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getSelfLink()).isEqualTo("http://api.football-data.org/v1/competitions/445");
    }

    @Test
    public void shouldParseTeamsLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getTeamsLink()).isEqualTo("http://api.football-data.org/v1/competitions/445/teams");
    }

    @Test
    public void shouldParseFixturesLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getFixturesLink()).isEqualTo("http://api.football-data.org/v1/competitions/445/fixtures");
    }

    @Test
    public void shouldParseLeagueTableLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getLeagueTableLink()).isEqualTo("http://api.football-data.org/v1/competitions/445/leagueTable");
    }

    @Test
    public void shouldParseId() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getId()).isEqualTo(445);
    }

    @Test
    public void shouldParseCaption() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getCaption()).isEqualTo("Premier League 2017/18");
    }

    @Test
    public void shouldParseLeague() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getLeague()).isEqualTo("PL");
    }

    @Test
    public void shouldParseYear() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getYear()).isEqualTo("2017");
    }

    @Test
    public void shouldParseCurrentMatchday() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getCurrentMatchDay()).isEqualTo(1);
    }

    @Test
    public void shouldParseNumberOfMatchdays() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getNumberOfMatchDays()).isEqualTo(38);
    }

    @Test
    public void shouldParseNumberOfTeams() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getNumberOfTeams()).isEqualTo(20);
    }

    @Test
    public void shouldParseNumberOfGames() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getNumberOfGames()).isEqualTo(380);
    }

    @Test
    public void shouldParseLastUpdated() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Competition competition = parser.toCompetition(json);

        assertThat(competition.getLastUpdated()).isEqualTo(expectedLastUpdated());
    }

    private LocalDateTime expectedLastUpdated() {
        return LocalDateTime.of(2017, 6, 27, 14, 10, 19, 0);
    }

}
