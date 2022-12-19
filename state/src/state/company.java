package state;

public class company implements Connection {

    @Override
    public void open() {
        System.out.println("company conn opened");
    }

    @Override
    public void log() {
        System.out.println("company conn logged in");
    }

    @Override
    public void close() {
        System.out.println("company conn closed");
    }

    @Override
    public void update() {
        System.out.println("company conn updated");
    }

}
