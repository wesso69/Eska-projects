/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sing1;

/**
 *
 * @author W.Shraideh
 */
public class main {
    public static void main(String[] args) {
        printer p = printer.getInstance();
        p.setName("Waseem");
        p.setNum(3);
        p.printname();
    }
}
