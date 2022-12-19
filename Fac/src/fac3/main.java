package fac3;

public class main {

    public static void main(String[] args) {
        GameFactory gf = new GameFactory();
        gf.getGametype("csgo").getGame();
    }

}
