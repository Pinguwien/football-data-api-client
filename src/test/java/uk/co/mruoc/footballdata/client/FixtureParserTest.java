package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Fixture;
import uk.co.mruoc.footballdata.model.FixtureStatus;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class FixtureParserTest {

    private static final String JSON_FILE_PATH = "/fixture.json";

    private final FileContentLoader loader = new ClasspathFileContentLoader();
    private final FixtureParser parser = new FixtureParser();

    @Test
    public void shouldParseSelfLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getSelfLink()).isEqualTo("http://api.football-data.org/v1/fixtures/159316");
    }

    @Test
    public void shouldParseCompetitionLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getCompetitionLink()).isEqualTo("http://api.football-data.org/v1/competitions/445");
    }

    @Test
    public void shouldParseHomeTeamLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getHomeTeamLink()).isEqualTo("http://api.football-data.org/v1/teams/57");
    }

    @Test
    public void shouldParseAwayTeamLink() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getAwayTeamLink()).isEqualTo("http://api.football-data.org/v1/teams/338");
    }

    @Test
    public void shouldParseDate() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getDate()).isEqualTo(LocalDateTime.of(2017,8, 11, 18, 45, 0));
    }

    @Test
    public void shouldParseStatus() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getStatus()).isEqualTo(FixtureStatus.TIMED);
    }

    @Test
    public void shouldParseMatchDay() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getMatchDay()).isEqualTo(1);
    }

    @Test
    public void shouldParseHomeTeamName() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getHomeTeamName()).isEqualTo("Arsenal FC");
    }

    @Test
    public void shouldParseAwayTeamName() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getAwayTeamName()).isEqualTo("Leicester City FC");
    }

    @Test
    public void shouldParseHomeTeamGoals() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getHomeTeamGoals()).isEqualTo(0);
    }

    @Test
    public void shouldParseAwayTeamGoals() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getAwayTeamGoals()).isEqualTo(0);
    }

    @Test
    public void shouldParseOdds() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Fixture fixture = parser.toFixture(json);

        assertThat(fixture.getOdds()).isEmpty();
    }

}
