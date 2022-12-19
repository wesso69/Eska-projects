/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly2;

import java.util.HashMap;

/**
 *
 * @author W.Shraideh
 */
public class PlayerFactory {

    private static final HashMap<String, Player> playersmap = new HashMap<>();

    public Player getPlayerteam(String k) {
        Player p = null;
        if (playersmap.containsKey(k)) {
            p = playersmap.get(k);
        } else {
            switch (k) {
                case "Dire":
                    System.out.println("Dire team created ");
                    p = new dire();
                    break;
                case "Radiant":
                    System.out.println("Radiant team created");
                    p = new radiant();
                    break;
                default:
                    System.out.println(" error 404");
            }
            playersmap.put(k, p);
        }
        return p;
    }
}
