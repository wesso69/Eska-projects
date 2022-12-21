/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly4;

import java.util.HashMap;

/**
 *
 * @author W.Shraideh
 */
public class birdsFactory {

    private static HashMap<String, bird> birdsmap = new HashMap<>();

    public bird birdsfactory(String k) {
        bird b = null;
        if (birdsmap.containsKey(k)) {
            b = birdsmap.get(k);
        } else {
            switch (k) {
                case "canari":
                    b = new canari();
                    b.type();
                    break;
                case "parrot":
                    b = new parrot();
                    b.type();
                    break;
                default:
                    System.out.println("no bird found in here");
            }
            birdsmap.put(k, b);
        }
        return b;
    }
}
