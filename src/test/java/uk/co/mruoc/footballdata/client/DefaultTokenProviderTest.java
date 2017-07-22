package uk.co.mruoc.footballdata.client;

import org.apache.commons.lang3.StringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.contrib.java.lang.system.RestoreSystemProperties;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultTokenProviderTest {

    private static final String PROPERTY_NAME = "footballDataApiToken";
    private static final String PROPERTY_VALUE = "my-property-token";

    private static final String VARIABLE_NAME = "FOOTBALL_DATA_API_TOKEN";
    private static final String VARIABLE_VALUE = "my-variable-token";

    @Rule
    public final RestoreSystemProperties restoreSystemProperties = new RestoreSystemProperties();

    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    private final TokenProvider tokenProvider = new DefaultTokenProvider();

    @Test
    public void propertyShouldTakePrecedenceEvenWhenPropertyAndVariableAreSet() {
        System.setProperty(PROPERTY_NAME, PROPERTY_VALUE);
        environmentVariables.set(VARIABLE_NAME, VARIABLE_VALUE);

        assertThat(tokenProvider.getToken()).isEqualTo(PROPERTY_VALUE);
        assertThat(tokenProvider.hasToken()).isTrue();
    }

    @Test
    public void propertyShouldBeReturnedWhenSet() {
        System.setProperty(PROPERTY_NAME, PROPERTY_VALUE);

        assertThat(tokenProvider.getToken()).isEqualTo(PROPERTY_VALUE);
        assertThat(tokenProvider.hasToken()).isTrue();
    }

    @Test
    public void variableShouldBeReturnedWhenSet() {
        environmentVariables.set(VARIABLE_NAME, VARIABLE_VALUE);

        assertThat(tokenProvider.getToken()).isEqualTo(VARIABLE_VALUE);
        assertThat(tokenProvider.hasToken()).isTrue();
    }

    @Test
    public void noValueShouldBeReturnedWhenNeitherPropertyOrVariableIsSet() {
        System.setProperty(PROPERTY_NAME, EMPTY);
        environmentVariables.set(VARIABLE_NAME, EMPTY);

        assertThat(tokenProvider.getToken()).isEmpty();
        assertThat(tokenProvider.hasToken()).isFalse();
    }

}
