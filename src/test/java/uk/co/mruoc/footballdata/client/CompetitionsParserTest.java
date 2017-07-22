package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompetitionsParserTest {

    private static final String JSON_FILE_PATH = "/competitions.json";

    private final FileContentLoader loader = new ClasspathFileContentLoader();
    private final CompetitionsParser parser = new CompetitionsParser();

    @Test
    public void shouldParseMultipleCompetitions() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Collection<Competition> competitions = parser.toCompetitions(json);

        assertThat(competitions.size()).isEqualTo(2);
    }

    @Test
    public void shouldParseFirstCompetition() {
        String json = loader.loadContent(JSON_FILE_PATH);

        List<Competition> competitions = parser.toCompetitions(json);

        Competition competition = competitions.get(0);
        assertThat(competition.getId()).isEqualTo(444);
    }

    @Test
    public void shouldParseSecondCompetition() {
        String json = loader.loadContent(JSON_FILE_PATH);

        List<Competition> competitions = parser.toCompetitions(json);

        Competition competition = competitions.get(1);
        assertThat(competition.getId()).isEqualTo(445);
    }

    @Test
    public void shouldParseSingleCompetition() {
        String singleJsonFilePath = "/competition.json";
        String json = loader.loadContent(singleJsonFilePath);

        Collection<Competition> competitions = parser.toCompetitions(json);

        assertThat(competitions.size()).isEqualTo(1);
    }

}
