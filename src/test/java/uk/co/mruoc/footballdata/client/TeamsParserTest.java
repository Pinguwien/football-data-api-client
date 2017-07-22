package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Team;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamsParserTest {

    private static final String JSON_FILE_PATH = "/teams.json";

    private final FileContentLoader loader = new ClasspathFileContentLoader();
    private final TeamsParser parser = new TeamsParser();

    @Test
    public void shouldParseMultipleTeams() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Collection<Team> teams = parser.toTeams(json);

        assertThat(teams.size()).isEqualTo(2);
    }

    @Test
    public void shouldParseFirstTeam() {
        String json = loader.loadContent(JSON_FILE_PATH);

        List<Team> teams = parser.toTeams(json);

        Team team = teams.get(0);
        assertThat(team.getId()).isEqualTo(57);
    }

    @Test
    public void shouldParseSecondTeam() {
        String json = loader.loadContent(JSON_FILE_PATH);

        List<Team> teams = parser.toTeams(json);

        Team team = teams.get(1);
        assertThat(team.getId()).isEqualTo(338);
    }

    @Test
    public void shouldParseSingleTeam() {
        String singleJsonFilePath = "/team.json";
        String json = loader.loadContent(singleJsonFilePath);

        Collection<Team> teams = parser.toTeams(json);

        assertThat(teams.size()).isEqualTo(1);
    }

}
