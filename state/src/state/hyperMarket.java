
package state;

public class hyperMarket implements Connection{
     @Override
    public void open() {
        System.out.println("hyperMarket conn opened");
    }

    @Override
    public void log() {
        System.out.println("hyperMarket conn logged in");
    }

    @Override
    public void close() {
        System.out.println("hyperMarket conn closed");
    }

    @Override
    public void update() {
        System.out.println("hyperMarket conn updated");
    }
}
