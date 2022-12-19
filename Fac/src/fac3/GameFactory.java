package fac3;

public class GameFactory {

    public Game getGametype(String s) {
        if (s != null) {
            if (s.equalsIgnoreCase("dota")) {
                return new Dota();
            } else if (s.equalsIgnoreCase("csgo")) {
                return new CsGo();
            } else if (s.equalsIgnoreCase("pubg")) {
                return new Pubg();
            }

        }
        return null;
    }
}
