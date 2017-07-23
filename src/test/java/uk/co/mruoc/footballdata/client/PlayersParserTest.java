package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Player;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersParserTest {

    private static final String JSON_FILE_PATH = "/players.json";

    private final FileContentLoader loader = new ClasspathFileContentLoader();
    private final PlayersParser parser = new PlayersParser();

    @Test
    public void shouldParseMultiplePlayers() {
        String json = loader.loadContent(JSON_FILE_PATH);

        Collection<Player> players = parser.toPlayers(json);

        assertThat(players.size()).isEqualTo(2);
    }

    @Test
    public void shouldParseFirstPlayer() {
        String json = loader.loadContent(JSON_FILE_PATH);

        List<Player> players = parser.toPlayers(json);

        Player player = players.get(0);
        assertThat(player.getName()).isEqualTo("Petr Cech");
    }

    @Test
    public void shouldParseSecondPlayer() {
        String json = loader.loadContent(JSON_FILE_PATH);

        List<Player> players = parser.toPlayers(json);

        Player player = players.get(1);
        assertThat(player.getName()).isEqualTo("David Ospina");
    }

    @Test
    public void shouldParsePlayerTeam() {
        String json = loader.loadContent("/player.json");

        Player player = parser.toPlayer(json);

        assertThat(player.getName()).isEqualTo("Petr Cech");
    }

    @Test
    public void shouldParseSinglePlayerToList() {
        String json = loader.loadContent("/player.json");

        Collection<Player> players = parser.toPlayers(json);

        assertThat(players.size()).isEqualTo(1);
    }

}
