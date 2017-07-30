package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Fixture;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FixturesParserTest {

    private static final String JSON_FILE_PATH = "/fixtures.json";

    private final FileContentLoader loader = new ClasspathFileContentLoader();
    private final FixturesParser parser = new FixturesParser();

    @Test
    public void shouldParseMultipleFixtures() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Collection<Fixture> fixtures = parser.toFixtures(json);

        assertThat(fixtures.size()).isEqualTo(2);
    }

    @Test
    public void shouldParseFirstFixture() {
        String json = loader.loadContent(JSON_FILE_PATH);

        List<Fixture> fixtures = parser.toFixtures(json);

        Fixture fixture = fixtures.get(0);
        assertThat(fixture.getHomeTeamName()).isEqualTo("Arsenal FC");
        assertThat(fixture.getAwayTeamName()).isEqualTo("Leicester City FC");
    }

    @Test
    public void shouldParseSecondFixture() {
        String json = loader.loadContent(JSON_FILE_PATH);

        List<Fixture> fixtures = parser.toFixtures(json);

        Fixture fixture = fixtures.get(1);
        assertThat(fixture.getHomeTeamName()).isEqualTo("Watford FC");
        assertThat(fixture.getAwayTeamName()).isEqualTo("Liverpool FC");
    }

    @Test
    public void shouldParseSingleFixture() {
        String singleJsonFilePath = "/fixture.json";
        String json = loader.loadContent(singleJsonFilePath);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getHomeTeamName()).isEqualTo("Arsenal FC");
        assertThat(fixture.getAwayTeamName()).isEqualTo("Leicester City FC");
    }

    @Test
    public void shouldParseSingleFixtureToList() {
        String singleJsonFilePath = "/fixture.json";
        String json = loader.loadContent(singleJsonFilePath);

        Collection<Fixture> fixtures = parser.toFixtures(json);

        assertThat(fixtures.size()).isEqualTo(1);
    }

}
