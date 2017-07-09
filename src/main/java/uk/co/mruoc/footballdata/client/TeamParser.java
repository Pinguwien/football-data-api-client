package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import uk.co.mruoc.footballdata.model.Team;
import uk.co.mruoc.footballdata.model.Team.TeamBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TeamParser {

    private final JsonParser parser = new JsonParser();
    private final JsonExractor exractor = new JsonExractor();
    private final TeamUrlConverter teamUrlConverter = new TeamUrlConverter();

    public Collection<Team> toTeams(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonElement teams = element.getAsJsonObject().get("teams");
        if (teams.isJsonArray())
            return toTeams(teams.getAsJsonArray());
        return toTeams(teams.getAsJsonObject());
    }

    private Collection<Team> toTeams(JsonArray array) {
        List<Team> competitions = new ArrayList<>();
        array.forEach(item -> competitions.add(toTeam(item.getAsJsonObject())));
        return competitions;
    }

    private Collection<Team> toTeams(JsonObject json) {
        return Collections.singletonList(toTeam(json));
    }

    private Team toTeam(JsonObject json) {
        return new TeamBuilder()
                .setName(parseName(json))
                .setShortName(parseShortName(json))
                .setCode(parseCode(json))
                .setBadgeUrl(parseBadgeUrl(json))
                .setId(parseId(json))
                .build();
    }

    private int parseId(JsonObject json) {
        String selfUrl = parseSelfUrl(json);
        return teamUrlConverter.toId(selfUrl);
    }

    private String parseName(JsonObject json) {
        return exractor.extractString(json, "name");
    }

    private String parseShortName(JsonObject json) {
        return exractor.extractString(json, "shortName");
    }

    private String parseCode(JsonObject json) {
        return exractor.extractString(json, "code");
    }

    private String parseBadgeUrl(JsonObject json) {
        return exractor.extractString(json, "crestUrl");
    }

    private String parseSelfUrl(JsonObject json) {
        return parseLinksUrl(json, "self");
    }

    private String parseLinksUrl(JsonObject json, String name) {
        JsonObject links = json.getAsJsonObject("_links");
        JsonObject teams = links.getAsJsonObject(name);
        return exractor.extractString(teams, "href");
    }



}
