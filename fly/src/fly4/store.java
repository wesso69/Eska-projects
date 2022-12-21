/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly4;

/**
 *
 * @author W.Shraideh
 */
public class store {
     public static void main(String[] args) {
        bird b = new birdsFactory().birdsfactory("canari");
        b.fly();
    }
}
