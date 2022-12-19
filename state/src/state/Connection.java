
package state;

public interface Connection {
    public void open();
    public void log();
    public void close();
    public void update();
}
