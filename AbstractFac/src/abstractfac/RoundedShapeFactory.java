/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfac;

public class RoundedShapeFactory extends AbstractFactory{

    @Override
    public shape getshape(String rounded) {
        if (rounded != null) {
            if (rounded.equalsIgnoreCase("rectangle")) {
                return new roundedRect();
            } else if (rounded.equalsIgnoreCase("square")) {
                return new roundedSquare();
            }
        }
        return null;
    }
}
