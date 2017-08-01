package uk.co.mruoc.footballdata.client;

public interface EndpointProvider {

    String getBase();

    String getCompetitions();

    String getCompetition(int competitionId);

    String getTeams(int competitionId);

    String getTeam(int teamId);

    String getPlayers(int teamId);

    String getFixtures();

    String getFixture(int fixtureId);

}
