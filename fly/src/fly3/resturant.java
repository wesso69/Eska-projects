/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly3;

/**
 *
 * @author W.Shraideh
 */
public class resturant {
    public static void main(String[] args) {
        Shawerma s = new shawermaFactory().getShawermaType("trible");
        s.eat();
    }
}
