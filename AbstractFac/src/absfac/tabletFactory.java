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
public class tabletFactory extends tabletabstractFactory {

    tablet t = null;

    @Override
    tablet getType(String s) {
        if (s.equalsIgnoreCase("ipad")) {
            t = new ipad();
        } else if (s.equalsIgnoreCase("s7tablet")) {
            t = new s7tablet();
        }
        return t;
    }

}
