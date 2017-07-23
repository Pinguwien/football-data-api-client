package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class JsonExtractor {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private final DateTimeFormatter localDateFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    public String extractString(JsonObject json, String name) {
        if (!json.has(name))
            return EMPTY;
        JsonElement element = json.get(name);
        if (element.isJsonNull())
            return EMPTY;
        return element.getAsString();
    }

    public int extractInt(JsonObject json, String name) {
        if (!json.has(name))
            return 0;
        JsonElement element = json.get(name);
        if (element.isJsonNull())
            return 0;
        return element.getAsInt();
    }

    public BigDecimal extractBigDecimal(JsonObject json, String name) {
        if (!json.has(name))
            return BigDecimal.ZERO;
        JsonElement element = json.get(name);
        if (element.isJsonNull())
            return BigDecimal.ZERO;
        return element.getAsBigDecimal();
    }

    public String extractLink(JsonObject json, String name) {
        JsonObject links = json.get("_links").getAsJsonObject();
        JsonObject item = links.get(name).getAsJsonObject();
        return extractString(item, "href");
    }

    public DateTime extractDateTime(JsonObject json, String name) {
        String dateString = json.get(name).getAsString();
        return DateTime.parse(dateString, dateTimeFormatter);
    }

    public LocalDate extractLocalDate(JsonObject json, String name) {
        String dateString = json.get(name).getAsString();
        return LocalDate.parse(dateString, localDateFormatter);
    }
}
