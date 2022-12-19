/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestState;

/**
 *
 * @author W.Shraideh
 */
public class main {

    public static void main(String[] args) {
        state s = new state(new printer());
        s.print();
        //////// 
        state s2 = new state(new scanner());
        s2.print();
        ////////
        state s3 = new state();
        printer p = new printer();
        s3.setPrinter(p);
        s3.getPainter().drow();
        ///////
    }

}
