package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.footballdata.model.Competition.CompetitionBuilder;

public class CompetitionParser {

    private final DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private final JsonParser parser = new JsonParser();

    public Competition toCompetition(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toCompetition(json);
    }

    private Competition toCompetition(JsonObject json) {
        return new CompetitionBuilder()
                .setSelfLink(parseSelfLink(json))
                .setTeamsLink(parseTeamsLink(json))
                .setFixturesLink(parseFixturesLink(json))
                .setLeagueTableLink(parseLeagueTableLink(json))
                .setId(parseId(json))
                .setCaption(parseName(json))
                .setLeague(parseLeague(json))
                .setYear(parseYear(json))
                .setCurrentMatchday(parseCurrentMatchday(json))
                .setNumberOfMatchdays(parseNumberOfMatchdays(json))
                .setNumberOfTeams(parseNumberOfTeams(json))
                .setNumberOfGames(parseNumberOfGames(json))
                .setLastUpdated(parseLastUpdated(json))
                .build();
    }

    private String parseSelfLink(JsonObject json) {
        return loadLink(json, "self");
    }

    private String parseTeamsLink(JsonObject json) {
        return loadLink(json, "teams");
    }

    private String parseFixturesLink(JsonObject json) {
        return loadLink(json, "fixtures");
    }

    private String parseLeagueTableLink(JsonObject json) {
        return loadLink(json, "leagueTable");
    }

    private int parseId(JsonObject json) {
        return json.get("id").getAsInt();
    }

    private String parseName(JsonObject json) {
        return json.get("caption").getAsString();
    }

    private String parseLeague(JsonObject json) {
        return json.get("league").getAsString();
    }

    private String parseYear(JsonObject json) {
        return json.get("year").getAsString();
    }

    private int parseCurrentMatchday(JsonObject json) {
        return json.get("currentMatchday").getAsInt();
    }

    private int parseNumberOfMatchdays(JsonObject json) {
        return json.get("numberOfMatchdays").getAsInt();
    }

    private int parseNumberOfTeams(JsonObject json) {
        return json.get("numberOfTeams").getAsInt();
    }

    private int parseNumberOfGames(JsonObject json) {
        return json.get("numberOfGames").getAsInt();
    }

    private DateTime parseLastUpdated(JsonObject json) {
        String dateString = json.get("lastUpdated").getAsString();
        return DateTime.parse(dateString, dateFormatter);
    }

    private String loadLink(JsonObject json, String name) {
        JsonObject links = json.get("_links").getAsJsonObject();
        JsonObject item = links.get(name).getAsJsonObject();
        return item.get("href").getAsString();
    }

}
