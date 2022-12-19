package Test1;

public class ColorFactory extends AbstractFactory {

    @Override
    <T> T getType(String s) {
        if (s != null) {
            if (s.equalsIgnoreCase("white")) {
                return (T) new white();
            } else if (s.equalsIgnoreCase("red")) {
                return (T) new red();
            }
        }
        return null;
    }

}
