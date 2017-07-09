package uk.co.mruoc.footballdata.model;

import org.joda.time.DateTime;

public class Competition {

    private final String selfLink;
    private final String teamsLink;
    private final String fixturesLink;
    private final String leagueTableLink;

    private final int id;
    private final String name;
    private final String league;
    private final String year;
    private final int currentMatchday;
    private final int numberOfMatchdays;
    private final int numberOfTeams;
    private final int numberOfGames;
    private final DateTime lastUpdated;

    private Competition(CompetitionBuilder builder) {
        this.selfLink = builder.selfLink;
        this.teamsLink = builder.teamsLink;
        this.fixturesLink = builder.fixturesLink;
        this.leagueTableLink = builder.leagueTableLink;

        this.id = builder.id;
        this.name = builder.name;
        this.league = builder.league;
        this.year = builder.year;
        this.currentMatchday = builder.currentMatchday;
        this.numberOfMatchdays = builder.numberOfMatchdays;
        this.numberOfTeams = builder.numberOfTeams;
        this.numberOfGames = builder.numberOfGames;
        this.lastUpdated = builder.lastUpdated;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public String getTeamsLink() {
        return teamsLink;
    }

    public String getFixturesLink() {
        return fixturesLink;
    }

    public String getLeagueTableLink() {
        return leagueTableLink;
    }

    public int getId() {
        return id;
    }

    public String getCaption() {
        return name;
    }

    public String getLeague() {
        return league;
    }

    public String getYear() {
        return year;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public int getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public DateTime getLastUpdated() {
        return lastUpdated;
    }

    public static class CompetitionBuilder {

        private String selfLink;
        private String teamsLink;
        private String fixturesLink;
        private String leagueTableLink;

        private int id;
        private String name;
        private String league;
        private String year;
        private int currentMatchday;
        private int numberOfMatchdays;
        private int numberOfTeams;
        private int numberOfGames;
        private DateTime lastUpdated;

        public CompetitionBuilder setSelfLink(String selfLink) {
            this.selfLink = selfLink;
            return this;
        }

        public CompetitionBuilder setTeamsLink(String teamsLink) {
            this.teamsLink = teamsLink;
            return this;
        }

        public CompetitionBuilder setFixturesLink(String fixturesLink) {
            this.fixturesLink = fixturesLink;
            return this;
        }

        public CompetitionBuilder setLeagueTableLink(String leagueTableLink) {
            this.leagueTableLink = leagueTableLink;
            return this;
        }

        public CompetitionBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CompetitionBuilder setCaption(String name) {
            this.name = name;
            return this;
        }

        public CompetitionBuilder setLeague(String league) {
            this.league = league;
            return this;
        }

        public CompetitionBuilder setYear(String year) {
            this.year = year;
            return this;
        }

        public CompetitionBuilder setCurrentMatchday(int currentMatchday) {
            this.currentMatchday = currentMatchday;
            return this;
        }

        public CompetitionBuilder setNumberOfMatchdays(int numberOfMatchdays) {
            this.numberOfMatchdays = numberOfMatchdays;
            return this;
        }

        public CompetitionBuilder setNumberOfTeams(int numberOfTeams) {
            this.numberOfTeams = numberOfTeams;
            return this;
        }

        public CompetitionBuilder setNumberOfGames(int numberOfGames) {
            this.numberOfGames = numberOfGames;
            return this;
        }

        public CompetitionBuilder setLastUpdated(DateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public Competition build() {
            return new Competition(this);
        }

    }

}
