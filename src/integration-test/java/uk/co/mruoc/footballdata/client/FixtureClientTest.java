package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.footballdata.model.Fixture;
import uk.co.mruoc.footballdata.model.FixtureStatus;
import uk.co.mruoc.http.client.ReadOnlyHttpClient;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FixtureClientTest {

    private final ReadOnlyHttpClient httpClient = new TokenHttpClient();
    private final EndpointProvider endpointProvider = new V1EndpointProvider();
    private final FixtureClient fixtureClient = new FixtureClient(httpClient, endpointProvider);

    @Test
    public void shouldLoadFixtures() {
        List<Fixture> fixtures = fixtureClient.load();

        assertThat(fixtures.size()).isEqualTo(85);
        Fixture firstFixture = fixtures.get(0);
        assertThat(firstFixture.getSelfLink()).isEqualTo("http://api.football-data.org/v1/fixtures/158033");
    }

    @Test
    public void shouldLoadFixture() {
        int id = 162001;

        Fixture fixture = fixtureClient.load(id);

        assertThat(fixture.getSelfLink()).isEqualTo("http://api.football-data.org/v1/fixtures/162001");
        assertThat(fixture.getCompetitionLink()).isEqualTo("http://api.football-data.org/v1/competitions/451");
        assertThat(fixture.getHomeTeamLink()).isEqualTo("http://api.football-data.org/v1/teams/519");
        assertThat(fixture.getAwayTeamLink()).isEqualTo("http://api.football-data.org/v1/teams/546");

        assertThat(fixture.getDate()).isEqualTo(expectedDate());
        assertThat(fixture.getStatus()).isEqualTo(FixtureStatus.TIMED);
        assertThat(fixture.getMatchDay()).isEqualTo(1);
        assertThat(fixture.getHomeTeamName()).isEqualTo("AJ Auxerre");
        assertThat(fixture.getAwayTeamName()).isEqualTo("RC Lens");
        assertThat(fixture.getHomeTeamGoals()).isEqualTo(0);
        assertThat(fixture.getAwayTeamGoals()).isEqualTo(0);
        assertThat(fixture.getOdds()).isEqualTo("");
    }

    private LocalDateTime expectedDate() {
        return LocalDateTime.of(2017,7, 31, 18, 45, 0);
    }

}
