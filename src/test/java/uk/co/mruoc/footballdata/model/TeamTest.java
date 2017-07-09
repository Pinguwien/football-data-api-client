package uk.co.mruoc.footballdata.model;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Team.TeamBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamTest {

    private final TeamBuilder builder = new TeamBuilder();

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
    public void shouldSetBadgeUrl() {
        String badgeUrl = "code";

        Team team = builder
                .setBadgeUrl(badgeUrl)
                .build();

        assertThat(team.getBadgeUrl()).isEqualTo(badgeUrl);
    }

}
