package Test.sing;

public class VehichleSpeed {

    private int speed;
    private int speedlimit;
    static VehichleSpeed instance = null;

    private VehichleSpeed() {};
    
    public static VehichleSpeed getSpeed() {

        if (instance == null) {
            instance = new VehichleSpeed();
        }
        return instance;
    }

    public void setSpeed(int s) {
        this.speed = s;
    }

    public int getspeed() {
        return speed;
    }

    public void setSpeedlimit(int s) {
        this.speedlimit = s;
    }

    public int getspeedlimit() {
        return speedlimit;
    }

    public void getVehichleSpeed() {

        if (speed > speedlimit) {
            System.out.println("Speed must be lower than :" + speedlimit);
        } else if (speed > speedlimit) {
            System.out.println("maximum speedlimit  should be " + speedlimit);
        } else if (speed > 0 && speed <= 40) {
            System.out.println("you can go faster than " + speed);
        } else if (speed > 40 && speed < 80) {
            System.out.println("Nice youre speed is :" + speed);
        } else if (speed > 80 && speed < 100) {
            System.out.println("slow down ur speed is :" + speed);
        } else {
            System.out.println("slow down your speeding up too much");
        }

    }

}
