package uk.co.mruoc.footballdata.model;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Fixture.FixtureBuilder;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.footballdata.model.FixtureStatus.SCHEDULED;

public class FixtureTest {

    private final FixtureBuilder builder = new FixtureBuilder();

    @Test
    public void shouldSetSelfLink() {
        String selfLink = "http://api.football-data.org/v1/fixtures/159316";

        Fixture fixture = builder
                .setSelfLink(selfLink)
                .build();

        assertThat(fixture.getSelfLink()).isEqualTo(selfLink);
    }

    @Test
    public void shouldSetCompetitionLink() {
        String competitionLink = "http://api.football-data.org/v1/competitions/445";

        Fixture fixture = builder
                .setCompetitionLink(competitionLink)
                .build();

        assertThat(fixture.getCompetitionLink()).isEqualTo(competitionLink);
    }

    @Test
    public void shouldSetHomeTeamLink() {
        String homeTeamLink = "http://api.football-data.org/v1/teams/57";

        Fixture fixture = builder
                .setHomeTeamLink(homeTeamLink)
                .build();

        assertThat(fixture.getHomeTeamLink()).isEqualTo(homeTeamLink);
    }

    @Test
    public void shouldSetAwayTeamLink() {
        String awayTeamLink = "http://api.football-data.org/v1/teams/338";

        Fixture fixture = builder
                .setAwayTeamLink(awayTeamLink)
                .build();

        assertThat(fixture.getAwayTeamLink()).isEqualTo(awayTeamLink);
    }

    @Test
    public void shouldSetDate() {
        LocalDateTime date = LocalDateTime.now();

        Fixture fixture = builder
                .setDate(date)
                .build();

        assertThat(fixture.getDate()).isEqualTo(date);
    }

    @Test
    public void shouldSetStatus() {
        FixtureStatus status = SCHEDULED;

        Fixture fixture = builder
                .setStatus(status)
                .build();

        assertThat(fixture.getStatus()).isEqualTo(status);
    }

    @Test
    public void shouldSetMatchDay() {
        int matchDay = 10;

        Fixture fixture = builder
                .setMatchDay(matchDay)
                .build();

        assertThat(fixture.getMatchDay()).isEqualTo(matchDay);
    }

    @Test
    public void shouldSetHomeTeamName() {
        String homeTeamName = "Arsenal FC";

        Fixture fixture = builder
                .setHomeTeamName(homeTeamName)
                .build();

        assertThat(fixture.getHomeTeamName()).isEqualTo(homeTeamName);
    }

    @Test
    public void shouldSetAwayTeamName() {
        String awayTeamName = "Leicester City FC";

        Fixture fixture = builder
                .setAwayTeamName(awayTeamName)
                .build();

        assertThat(fixture.getAwayTeamName()).isEqualTo(awayTeamName);
    }

    @Test
    public void shouldSetHomeTeamGoals() {
        int homeTeamGoals = 1;

        Fixture fixture = builder
                .setHomeTeamGoals(homeTeamGoals)
                .build();

        assertThat(fixture.getHomeTeamGoals()).isEqualTo(homeTeamGoals);
    }

    @Test
    public void shouldSetAwayTeamGoals() {
        int awayTeamGoals = 1;

        Fixture fixture = builder
                .setAwayTeamGoals(awayTeamGoals)
                .build();

        assertThat(fixture.getAwayTeamGoals()).isEqualTo(awayTeamGoals);
    }

    @Test
    public void shouldSetOdds() {
        String odds = "1/2";

        Fixture fixture = builder
                .setOdds(odds)
                .build();

        assertThat(fixture.getOdds()).isEqualTo(odds);
    }

}
