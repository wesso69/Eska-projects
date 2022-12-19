/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test1;

/**
 *
 * @author W.Shraideh
 */
public class main {

    public static void main(String[] args) {
        AbstractFactory abf = FactoryProvider.getFactory(true);
        Animal a = abf.getType("bear");
        abf = FactoryProvider.getFactory(false);
        color c = abf.getType("red");
        System.out.println(a.getType());
        System.out.println(c.getColor());
//
//        color c = abf.getType("white");
//        System.out.println(c.getColor());

    }
}
