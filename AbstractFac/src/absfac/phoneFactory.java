/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absfac;

/**
 *
 * @author W.Shraideh
 */
public class phoneFactory extends phoneabstractFactory {

    Phone p = null;

    @Override
    Phone getType(String s) {
        if (s.equalsIgnoreCase("iphone")) {
            p = new iphone();
        } else if (s.equalsIgnoreCase("samsung")) {
            p = new Samsung();
        } else if (s.equalsIgnoreCase("huaweie")) {
            p = new huaweie();
        }
        return p;
    }

}
