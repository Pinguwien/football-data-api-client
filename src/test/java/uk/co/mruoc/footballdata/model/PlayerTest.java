package uk.co.mruoc.footballdata.model;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Player.PlayerBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private final PlayerBuilder builder = new PlayerBuilder();

    @Test
    public void shouldSetId() {
        int id = 123;

        Player player = builder
                .setId(id)
                .build();

        assertThat(player.getId()).isEqualTo(id);
    }

    @Test
    public void shouldSetName() {
        String name = "player-name";

        Player player = builder
                .setName(name)
                .build();

        assertThat(player.getName()).isEqualTo(name);
    }

}
