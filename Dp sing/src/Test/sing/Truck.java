
package Test.sing;


public class Truck {
    public void truckSpeed(){
        VehichleSpeed vh = VehichleSpeed.getSpeed();
        vh.setSpeed(70);
        vh.setSpeedlimit(120);
        vh.getVehichleSpeed();
    }
}
