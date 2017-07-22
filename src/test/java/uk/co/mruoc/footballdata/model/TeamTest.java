package uk.co.mruoc.footballdata.model;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Team.TeamBuilder;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamTest {

    private final TeamBuilder builder = new TeamBuilder();

    @Test
    public void shouldSetSelfLink() {
        String selfLink = "http://api.football-data.org/v1/teams/57";

        Team team = builder
                .setSelfLink(selfLink)
                .build();

        assertThat(team.getSelfLink()).isEqualTo(selfLink);
    }

    @Test
    public void shouldSetFixturesLink() {
        String fixturesLink = "http://api.football-data.org/v1/teams/57/fixtures";

        Team team = builder
                .setFixturesLink(fixturesLink)
                .build();

        assertThat(team.getFixturesLink()).isEqualTo(fixturesLink);
    }

    @Test
    public void shouldSetPlayersLink() {
        String playersLink = "http://api.football-data.org/v1/teams/57/players";

        Team team = builder
                .setPlayersLink(playersLink)
                .build();

        assertThat(team.getPlayersLink()).isEqualTo(playersLink);
    }

    @Test
    public void shouldSetId() {
        int id = 123;

        Team team = builder
                .setId(id)
                .build();

        assertThat(team.getId()).isEqualTo(id);
    }

    @Test
    public void shouldSetName() {
        String name = "team-name";

        Team team = builder
                .setName(name)
                .build();

        assertThat(team.getName()).isEqualTo(name);
    }

    @Test
    public void shouldSetShortName() {
        String shortName = "short-name";

        Team team = builder
                .setShortName(shortName)
                .build();

        assertThat(team.getShortName()).isEqualTo(shortName);
    }

    @Test
    public void shouldSetCode() {
        String code = "code";

        Team team = builder
                .setCode(code)
                .build();

        assertThat(team.getCode()).isEqualTo(code);
    }

    @Test
    public void shouldSetCrestUrl() {
        String crestUrl = "http://crest-url.com";

        Team team = builder
                .setCrestUrl(crestUrl)
                .build();

        assertThat(team.getCrestUrl()).isEqualTo(crestUrl);
    }

    @Test
    public void shouldSetSquadMarketValue() {
        BigDecimal squadMarketValue = BigDecimal.TEN;

        Team team = builder
                .setSquadMarketValue(squadMarketValue)
                .build();

        assertThat(team.getSquadMarketValue()).isEqualTo(squadMarketValue);
    }

}
