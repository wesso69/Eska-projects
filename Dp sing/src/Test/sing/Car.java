package Test.sing;

public class Car {

    private int Carspeed;
    private final String color = "Red";

    public void setCarspeed(int c) {
        this.Carspeed = c;
    }

    public void CarSpeed() {
        VehichleSpeed vh = VehichleSpeed.getSpeed();
        vh.setSpeed(Carspeed);
        vh.setSpeedlimit(140);
        vh.getVehichleSpeed();
    }

    public void carInfo() {
        System.out.println("the speed of the car is :" + Carspeed);
        System.out.println("the color of the color :" + color);
    }

}
