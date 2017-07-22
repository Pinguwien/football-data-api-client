package uk.co.mruoc.footballdata.client;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class EnvironmentVariableTokenProvider implements TokenProvider {

    private static final String TOKEN_VARIABLE_NAME = "FOOTBALL_DATA_API_TOKEN";

    @Override
    public String getToken() {
        Map<String, String> environmentVariables = System.getenv();
        if (!environmentVariables.containsKey(TOKEN_VARIABLE_NAME))
            return EMPTY;

        return environmentVariables.get(TOKEN_VARIABLE_NAME);
    }

    @Override
    public boolean hasToken() {
        String token = getToken();
        return StringUtils.isNotEmpty(token);
    }

}
