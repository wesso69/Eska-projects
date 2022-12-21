package fly2;

import java.util.Random;

public class Dotagame {

    private static final String[] Teams = {"Dire", "Radiant"};
    private static final String[] Lanes = {"top Lane", "Bot Lane", "mid Lane", "(Direjungle )", "(Radiantjungle)", "(Diretriangle)", "(Radianttriangle)"};
    
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Player player = new PlayerFactory().getPlayerteam(getRandomTeam());
            player.assignLane(getRandLane());
            player.mission();

        }
    }

    public static String getRandomTeam() {
        Random r = new Random();
        int randteam = r.nextInt(Teams.length);

        return Teams[randteam];
    }

    public static String getRandLane() {
        Random r = new Random();
        int randlane = r.nextInt(Lanes.length);
        return Lanes[randlane];
    }
}
