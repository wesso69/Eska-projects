/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly3;

import java.util.HashMap;

/**
 *
 * @author W.Shraideh
 */
public class shawermaFactory {

    public static final HashMap<String, Shawerma> shawermaMap = new HashMap<>();

    public Shawerma getShawermaType(String type) {
        Shawerma s = null;
        if (shawermaMap.containsKey(type)) {
            s = shawermaMap.get(type);
        } else {
            switch (type) {
                case "regular":
                    System.out.println("rugular meal  created ");
                    s = new regular();
                    break;
                case "double":
                    System.out.println("double meal  created");
                    s = new Double();
                    break;
                case "trible":
                    System.out.println("trible meal  created");
                    s = new trible();
                    break;
                default:
                    System.out.println(" error 404");
            }
            shawermaMap.put(type, s);
        }
        return s;
    }
}
