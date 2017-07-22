package uk.co.mruoc.footballdata.client;

import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class SystemPropertyTokenProvider implements TokenProvider {

    private static final String TOKEN_PROPERTY_NAME = "footballDataApiToken";
    private static final String TOKEN = loadToken();

    private static String loadToken() {
        Properties systemProperties = System.getProperties();
        if (!systemProperties.containsKey(TOKEN_PROPERTY_NAME))
            return EMPTY;

        String token = systemProperties.getProperty(TOKEN_PROPERTY_NAME);
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
