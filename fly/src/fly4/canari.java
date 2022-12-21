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
public class canari implements bird {

    private boolean fly;
    private String color;

    public canari() {
        this.color = "yellow";
        this.fly = true;
    }

    @Override
    public boolean fly() {
        return fly;
    }

    @Override
    public void type() {
        if (fly == true) {
            System.out.println("this is canari bird and i can fly and my color is " + color);
        } else {
            System.out.println("this is canari bird and i can't fly and my color is " + color);
        }
    }

    @Override
    public void color() {
        System.out.println(this.color);
    }

}
