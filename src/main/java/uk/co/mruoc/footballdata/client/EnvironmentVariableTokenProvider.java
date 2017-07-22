package uk.co.mruoc.footballdata.client;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class EnvironmentVariableTokenProvider implements TokenProvider {

    private static final String TOKEN_VARIABLE_NAME = "FOOTBALL_DATA_API_TOKEN";
    private static final String TOKEN = loadToken();

    private static String loadToken() {
        Map<String, String> environmentVariables = System.getenv();
        if (!environmentVariables.containsKey(TOKEN_VARIABLE_NAME))
            return EMPTY;

        String token = environmentVariables.get(TOKEN_VARIABLE_NAME);
        if (token == null)
            return EMPTY;

        return token;
    }

    @Override
    public String getToken() {
        return TOKEN;
    }

    @Override
    public boolean hasToken() {
        return StringUtils.isNotEmpty(TOKEN);
    }

}
