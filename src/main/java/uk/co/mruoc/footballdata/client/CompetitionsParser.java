package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import uk.co.mruoc.footballdata.model.Competition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CompetitionsParser {

    private final CompetitionParser competitionParser = new CompetitionParser();
    private final JsonParser parser = new JsonParser();

    public Collection<Competition> toCompetitions(String jsonString) {
        JsonElement element = parser.parse(jsonString);
        if (element.isJsonArray())
            return toCompetitions(element.getAsJsonArray());
        return toCompetitions(element.getAsJsonObject());
    }

    public Competition toCompetition(String jsonString) {
        return competitionParser.toCompetition(jsonString);
    }

    private Collection<Competition> toCompetitions(JsonArray array) {
        List<Competition> competitions = new ArrayList<>();
        array.forEach(item -> competitions.add(toCompetition(item.getAsJsonObject())));
        return competitions;
    }

    private Collection<Competition> toCompetitions(JsonObject json) {
        return Collections.singletonList(toCompetition(json));
    }

    private Competition toCompetition(JsonObject object) {
        return toCompetition(object.toString());
    }

}
