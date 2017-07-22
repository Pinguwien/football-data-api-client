package uk.co.mruoc.footballdata.client;

import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class SystemPropertyTokenProvider implements TokenProvider {

    private static final String TOKEN_PROPERTY_NAME = "footballDataApiToken";

    @Override
    public String getToken() {
        Properties systemProperties = System.getProperties();
        if (!systemProperties.containsKey(TOKEN_PROPERTY_NAME))
            return EMPTY;

        return systemProperties.getProperty(TOKEN_PROPERTY_NAME);
    }

    @Override
    public boolean hasToken() {
        String token = getToken();
        return StringUtils.isNotEmpty(token);
    }

}
