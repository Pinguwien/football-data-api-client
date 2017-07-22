package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import uk.co.mruoc.footballdata.model.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamsParser {

    private final JsonParser jsonParser = new JsonParser();
    private final TeamParser teamParser = new TeamParser();

    public List<Team> toTeams(String jsonString) {
        JsonElement element = jsonParser.parse(jsonString);
        if (element.isJsonArray())
            return toTeams(element.getAsJsonArray());
        JsonObject object = element.getAsJsonObject();
        if (object.has("teams"))
            return toTeams(object.get("teams").getAsJsonArray());
        return toTeams(object);
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
