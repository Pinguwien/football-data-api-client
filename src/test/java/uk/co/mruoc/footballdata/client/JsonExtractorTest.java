package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonObject;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonExtractorTest {

    private final JsonExtractor extractor = new JsonExtractor();

    private final JsonObject json = new JsonObject();

    @Test
    public void shouldReturnEmptyStringIfValueIsNotPresent() {
        assertThat(extractor.extractString(json, "value")).isEmpty();
    }

    @Test
    public void shouldReturnEmptyStringIfValueIsNullElement() {
        json.add("value", null);

        assertThat(extractor.extractString(json, "value")).isEmpty();
    }

    @Test
    public void shouldReturnStringIfValueFound() {
        json.addProperty("value", "some-string");

        assertThat(extractor.extractString(json, "value")).isEqualTo("some-string");
    }

    @Test
    public void shouldReturnZeroIfValueIsNotPresent() {
        assertThat(extractor.extractInt(json, "value")).isEqualTo(0);
    }

    @Test
    public void shouldReturnZeroIfValueIsNullElement() {
        json.add("value", null);

        assertThat(extractor.extractInt(json, "value")).isEqualTo(0);
    }

    @Test
    public void shouldReturnValueIfValueFound() {
        json.addProperty("value", 25);

        assertThat(extractor.extractInt(json, "value")).isEqualTo(25);
    }

}
