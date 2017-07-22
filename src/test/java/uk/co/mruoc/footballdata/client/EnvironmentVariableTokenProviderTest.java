package uk.co.mruoc.footballdata.client;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import static org.assertj.core.api.Assertions.assertThat;

public class EnvironmentVariableTokenProviderTest {

    private static final String TOKEN_VARIABLE_NAME = "FOOTBALL_DATA_API_TOKEN";

    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    private final TokenProvider tokenProvider = new EnvironmentVariableTokenProvider();

    @Test
    public void shouldNotReturnTokenWhenEmpty() {
        environmentVariables.set(TOKEN_VARIABLE_NAME, "");

        assertThat(tokenProvider.getToken()).isEmpty();
        assertThat(tokenProvider.hasToken()).isFalse();
    }

    @Test
    public void shouldReturnTokenWhenSet() {
        String tokenValue = "my-token";
        environmentVariables.set(TOKEN_VARIABLE_NAME, tokenValue);

        assertThat(tokenProvider.getToken()).isEqualTo(tokenValue);
        assertThat(tokenProvider.hasToken()).isTrue();
    }

}
