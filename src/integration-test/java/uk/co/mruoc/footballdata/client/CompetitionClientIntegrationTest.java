package uk.co.mruoc.footballdata.client;

import org.junit.Test;
import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.http.client.HttpClient;

import static org.assertj.core.api.Assertions.assertThat;

public class CompetitionClientIntegrationTest {

    private final HttpClient httpClient = new TokenHttpClient();
    private final EndpointProvider endpointProvider = new V1EndpointProvider();
    private final CompetitionClient competitionClient = new CompetitionClient(httpClient, endpointProvider);

    @Test
    public void shouldLoadCompetition() {
        int id = 445;

        Competition competition = competitionClient.load(id);

        assertThat(competition.getId()).isEqualTo(id);
        assertThat(competition.getCaption()).isEqualTo("Premier League 2017/18");
    }

}
