package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.footballdata.model.Competition.CompetitionBuilder;

import java.util.*;

public class CompetitionParser {

    private final JsonParser parser = new JsonParser();

    public Collection<Competition> toCompetitions(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        if (element.isJsonArray())
            return toCompetitions(element.getAsJsonArray());
        return toCompetitions(element.getAsJsonObject());
    }

    public Competition toCompetition(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        JsonObject json = element.getAsJsonObject();
        return toCompetition(json);
    }

    private Collection<Competition> toCompetitions(JsonArray array) {
        List<Competition> competitions = new ArrayList<>();
        array.forEach(item -> competitions.add(toCompetition(item.getAsJsonObject())));
        return competitions;
    }

    private Collection<Competition> toCompetitions(JsonObject json) {
        return Collections.singletonList(toCompetition(json));
    }

    private Competition toCompetition(JsonObject json) {
        return new CompetitionBuilder()
                .setId(parseId(json))
                .setCaption(parseName(json))
                .build();
    }

    private int parseId(JsonObject json) {
        return json.get("id").getAsInt();
    }

    private String parseName(JsonObject json) {
        return json.get("caption").getAsString();
    }

}
