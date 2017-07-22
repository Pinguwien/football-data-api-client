package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Team;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamParserTest {

    private static final String JSON_FILE_PATH = "/team.json";

    private final FileContentLoader loader = new ClasspathFileContentLoader();
    private final TeamParser parser = new TeamParser();

    @Test
    public void shouldParseSelfLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Team team = parser.toTeam(json);

        assertThat(team.getSelfLink()).isEqualTo("http://api.football-data.org/v1/teams/57");
    }

    @Test
    public void shouldParseFixturesLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Team team = parser.toTeam(json);

        assertThat(team.getFixturesLink()).isEqualTo("http://api.football-data.org/v1/teams/57/fixtures");
    }

    @Test
    public void shouldParsePlayersLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Team team = parser.toTeam(json);

        assertThat(team.getPlayersLink()).isEqualTo("http://api.football-data.org/v1/teams/57/players");
    }

    @Test
    public void shouldParseId() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Team team = parser.toTeam(json);

        assertThat(team.getId()).isEqualTo(57);
    }

    @Test
    public void shouldParseName() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Team team = parser.toTeam(json);

        assertThat(team.getName()).isEqualTo("Arsenal FC");
    }

    @Test
    public void shouldParseCode() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Team team = parser.toTeam(json);

        assertThat(team.getCode()).isEqualTo("AFC");
    }

    @Test
    public void shouldParseShortName() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Team team = parser.toTeam(json);

        assertThat(team.getShortName()).isEqualTo("Arsenal");
    }

    @Test
    public void shouldParseSquadMarketValue() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Team team = parser.toTeam(json);

        assertThat(team.getSquadMarketValue()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void shouldParseCrestUrl() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Team team = parser.toTeam(json);

        assertThat(team.getCrestUrl()).isEqualTo("http://upload.wikimedia.org/wikipedia/en/5/53/Arsenal_FC.svg");
    }

}
