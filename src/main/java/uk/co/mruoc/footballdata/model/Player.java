package uk.co.mruoc.footballdata.model;

public class Player {

    private final int id;
    private final String name;

    private Player(PlayerBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class PlayerBuilder {

        private int id;
        private String name;

        public PlayerBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public PlayerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Player build() {
            return new Player(this);
        }

    }

}
