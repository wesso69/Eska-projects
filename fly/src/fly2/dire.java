/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly2;

/**
 *
 * @author W.Shraideh
 */
public class dire implements Player {

    private final String Task;

    String lane;

    public dire() {
        Task = ("winning the lane and get the Radiant ancient");
    }

    @Override
    public void assignLane(String lane) {
        this.lane = lane;
    }

    @Override
    public void mission() {
        System.out.println("dire mission in this game in the " + lane + " is " + Task);
    }

}
