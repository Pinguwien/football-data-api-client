package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonObject;
import org.junit.Test;

import java.math.BigDecimal;

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
    public void shouldReturnZeroIfIntegerValueIsNotPresent() {
        assertThat(extractor.extractInt(json, "value")).isEqualTo(0);
    }

    @Test
    public void shouldReturnZeroIfIntegerValueIsNullElement() {
        json.add("value", null);

        assertThat(extractor.extractInt(json, "value")).isEqualTo(0);
    }

    @Test
    public void shouldReturnValueIfIntegerValueFound() {
        json.addProperty("value", 25);

        assertThat(extractor.extractInt(json, "value")).isEqualTo(25);
    }

    @Test
    public void shouldReturnZeroIfBigDecimalValueIsNotPresent() {
        assertThat(extractor.extractBigDecimal(json, "value")).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void shouldReturnZeroIfBigDecimalValueIsNullElement() {
        json.add("value", null);

        assertThat(extractor.extractBigDecimal(json, "value")).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void shouldReturnValueIfBigDecimalValueFound() {
        json.addProperty("value", 25);

        assertThat(extractor.extractBigDecimal(json, "value")).isEqualTo(BigDecimal.valueOf(25));
    }

}
