package uk.co.mruoc.footballdata.client;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DefaultTokenProvider implements TokenProvider {

    private SystemPropertyTokenProvider systemPropertyTokenProvider = new SystemPropertyTokenProvider();
    private EnvironmentVariableTokenProvider environmentVariableTokenProvider = new EnvironmentVariableTokenProvider();

    @Override
    public String getToken() {
        if (systemPropertyTokenProvider.hasToken())
            return systemPropertyTokenProvider.getToken();

        if (environmentVariableTokenProvider.hasToken())
            return environmentVariableTokenProvider.getToken();

        return EMPTY;
    }

    @Override
    public boolean hasToken() {
        return systemPropertyTokenProvider.hasToken() || environmentVariableTokenProvider.hasToken();
    }

}
