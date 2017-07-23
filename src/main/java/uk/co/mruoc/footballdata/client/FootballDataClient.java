package uk.co.mruoc.footballdata.client;

import uk.co.mruoc.footballdata.model.Competition;
import uk.co.mruoc.footballdata.model.Player;
import uk.co.mruoc.footballdata.model.Team;
import uk.co.mruoc.http.client.ReadOnlyHttpClient;

import java.util.List;

public class FootballDataClient {

    private final CompetitionClient competitionClient;
    private final TeamClient teamClient;
    private final PlayerClient playerClient;

    public FootballDataClient() {
        this(new TokenHttpClient(), new V1EndpointProvider());
    }

    public FootballDataClient(ReadOnlyHttpClient httpClient, EndpointProvider endpointProvider) {
        this.competitionClient = new CompetitionClient(httpClient, endpointProvider);
        this.teamClient = new TeamClient(httpClient, endpointProvider);
        this.playerClient = new PlayerClient(httpClient, endpointProvider);
    }

    public List<Competition> getCompetitions() {
        return competitionClient.load();
    }

    public Competition getCompetition(int competitionId) {
        return competitionClient.load(competitionId);
    }

    public List<Team> getCompetitionTeams(int competitionId) {
        return teamClient.loadCompetitionTeams(competitionId);
    }

    public Team getTeam(int teamId) {
        return teamClient.load(teamId);
    }

    public List<Player> getTeamPlayers(int teamId) {
        return playerClient.loadTeamPlayers(teamId);
    }

}
