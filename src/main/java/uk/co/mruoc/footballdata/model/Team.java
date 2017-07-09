package uk.co.mruoc.footballdata.model;

public class Team {

    private final int id;
    private final String name;
    private final String shortName;
    private final String code;
    private final String badgeUrl;

    private Team(TeamBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.shortName = builder.shortName;
        this.code = builder.code;
        this.badgeUrl = builder.badgeUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getCode() {
        return code;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public static class TeamBuilder {

        private int id;
        private String name;
        private String shortName;
        private String code;
        private String badgeUrl;

        public TeamBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public TeamBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public TeamBuilder setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public TeamBuilder setCode(String code) {
            this.code = code;
            return this;
        }

        public TeamBuilder setBadgeUrl(String badgeUrl) {
            this.badgeUrl = badgeUrl;
            return this;
        }

        public Team build() {
            return new Team(this);
        }

    }

}
