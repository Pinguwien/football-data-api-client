package uk.co.mruoc.footballdata.client;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.RestoreSystemProperties;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;

public class SystemPropertyTokenProviderTokenSetTest {

    private static final String TOKEN_PROPERTY_NAME = "footballDataApiToken";

    @Rule
    public final RestoreSystemProperties restoreSystemProperties = new RestoreSystemProperties();

    private final TokenProvider tokenProvider = new SystemPropertyTokenProvider();

    @Test
    public void shouldNotReturnTokenWhenEmpty() {
        System.setProperty(TOKEN_PROPERTY_NAME, EMPTY);

        assertThat(tokenProvider.getToken()).isEmpty();
        assertThat(tokenProvider.hasToken()).isFalse();
    }

    @Test
    public void shouldReturnTokenWhenSet() {
        String tokenValue = "my-token";
        System.setProperty(TOKEN_PROPERTY_NAME, tokenValue);

        assertThat(tokenProvider.getToken()).isEqualTo(tokenValue);
        assertThat(tokenProvider.hasToken()).isTrue();
    }

}
