package uk.co.mruoc.footballdata.model;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Player.PlayerBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private final PlayerBuilder builder = new PlayerBuilder();

    @Test
    public void shouldSetName() {
        String name = "player-name";

        Player player = builder
                .setName(name)
                .build();

        assertThat(player.getName()).isEqualTo(name);
    }

    @Test
    public void shouldSetPosition() {
        String position = "Defender";

        Player player = builder
                .setPosition(position)
                .build();

        assertThat(player.getPosition()).isEqualTo(position);
    }

    @Test
    public void shouldSetJerseyNumber() {
        int jerseyNumber = 5;

        Player player = builder
                .setJerseyNumber(jerseyNumber)
                .build();

        assertThat(player.getJerseyNumber()).isEqualTo(jerseyNumber);
    }

    @Test
    public void shouldSetDateOfBirth() {
        LocalDate dateOfBirth = LocalDate.now();

        Player player = builder
                .setDateOfBirth(dateOfBirth)
                .build();

        assertThat(player.getDateOfBirth()).isEqualTo(dateOfBirth);
    }

    @Test
    public void shouldSetNationality() {
        String nationality = "Italian";

        Player player = builder
                .setNationality(nationality)
                .build();

        assertThat(player.getNationality()).isEqualTo(nationality);
    }

    @Test
    public void shouldSetContractUntil() {
        LocalDate contractUntil = LocalDate.now();

        Player player = builder
                .setContractUntil(contractUntil)
                .build();

        assertThat(player.getContractUntil()).isEqualTo(contractUntil);
    }

    @Test
    public void shouldSetMarketValue() {
        BigDecimal marketValue = BigDecimal.valueOf(5000000);

        Player player = builder
                .setMarketValue(marketValue)
                .build();

        assertThat(player.getMarketValue()).isEqualTo(marketValue);
    }

}
