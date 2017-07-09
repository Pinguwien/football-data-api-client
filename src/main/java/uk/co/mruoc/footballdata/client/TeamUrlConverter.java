package uk.co.mruoc.footballdata.client;

public class TeamUrlConverter {

    public int toId(String teamUrl) {
        String[] parts = teamUrl.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }

}
