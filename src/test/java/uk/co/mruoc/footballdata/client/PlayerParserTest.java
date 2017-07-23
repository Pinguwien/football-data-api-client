package uk.co.mruoc.footballdata.client;

import org.joda.time.LocalDate;
import org.junit.Test;
import uk.co.mruoc.footballdata.model.Player;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerParserTest {

    private static final String JSON_FILE_PATH = "/player.json";

    private final FileContentLoader loader = new ClasspathFileContentLoader();
    private final PlayerParser parser = new PlayerParser();

    @Test
    public void shouldParseName() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Player player = parser.toPlayer(json);

        assertThat(player.getName()).isEqualTo("Petr Cech");
    }

    @Test
    public void shouldParsePosition() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Player player = parser.toPlayer(json);

        assertThat(player.getPosition()).isEqualTo("Keeper");
    }

    @Test
    public void shouldParseJerseyNumber() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Player player = parser.toPlayer(json);

        assertThat(player.getJerseyNumber()).isEqualTo(33);
    }

    @Test
    public void shouldParseDateOfBirth() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Player player = parser.toPlayer(json);

        assertThat(player.getDateOfBirth()).isEqualTo(new LocalDate()
                .withDayOfMonth(20)
                .withMonthOfYear(5)
                .withYear(1982));
    }

    @Test
    public void shouldParseNationality() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Player player = parser.toPlayer(json);

        assertThat(player.getNationality()).isEqualTo("Czech Republic");
    }

    @Test
    public void shouldParseContractUntil() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Player player = parser.toPlayer(json);

        assertThat(player.getContractUntil()).isEqualTo(new LocalDate()
                .withDayOfMonth(30)
                .withMonthOfYear(6)
                .withYear(2019));
    }

    @Test
    public void shouldParseMarketValue() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Player player = parser.toPlayer(json);

        assertThat(player.getMarketValue()).isEqualTo(BigDecimal.ZERO);
    }

}
