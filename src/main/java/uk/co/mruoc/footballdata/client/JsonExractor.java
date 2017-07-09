package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class JsonExractor {

    public String extractString(JsonObject json, String name) {
        JsonElement element = json.get(name);
        if (element.isJsonNull())
            return EMPTY;
        return element.getAsString();
    }

}
