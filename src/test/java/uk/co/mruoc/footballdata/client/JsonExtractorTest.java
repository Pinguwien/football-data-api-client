package uk.co.mruoc.footballdata.client;

import com.google.gson.JsonObject;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Test
    public void shouldExtractDateTime() {
        json.addProperty("value", "2017-06-27T14:10:19Z");

        assertThat(extractor.extractDateTime(json, "value")).isEqualTo(expectedDateTime());
    }

    @Test
    public void shouldExtractLocalDate() {
        json.addProperty("value", "2017-06-27");

        assertThat(extractor.extractLocalDate(json, "value")).isEqualTo(expectedLocalDate());
    }

    @Test
    public void shouldReturnDefaultValueIfValueIsNull() {
        json.add("value", null);

        LocalDate defaultValue = LocalDate.MAX;

        assertThat(extractor.extractLocalDate(json, "value", defaultValue)).isEqualTo(defaultValue);
    }

    private LocalDateTime expectedDateTime() {
        return LocalDateTime.of(2017,6, 27, 14, 10, 19, 0);
    }

    private LocalDate expectedLocalDate() {
        return LocalDate.of(2017, 6, 27);
    }

}
