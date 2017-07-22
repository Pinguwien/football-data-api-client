package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import uk.co.mruoc.footballdata.model.Team;
import uk.co.mruoc.footballdata.model.Team.TeamBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamsParser {

    private final JsonParser jsonParser = new JsonParser();
    private final TeamParser teamParser = new TeamParser();

    public List<Team> toTeams(String jsonString) {
        JsonElement element = jsonParser.parse(jsonString);
        JsonElement teams = element.getAsJsonObject().get("teams");
        if (teams.isJsonArray())
            return toTeams(teams.getAsJsonArray());
        return toTeams(teams.getAsJsonObject());
    }

    public Team toTeam(String jsonString) {
        return teamParser.toTeam(jsonString);
    }

    private List<Team> toTeams(JsonArray array) {
        List<Team> competitions = new ArrayList<>();
        array.forEach(item -> competitions.add(toTeam(item.getAsJsonObject())));
        return competitions;
    }

    private List<Team> toTeams(JsonObject json) {
        return Collections.singletonList(toTeam(json));
    }

    private Team toTeam(JsonObject json) {
        return teamParser.toTeam(json);
    }

}
