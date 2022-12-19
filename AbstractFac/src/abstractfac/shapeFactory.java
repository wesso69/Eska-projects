package abstractfac;

public class shapeFactory extends AbstractFactory{

    @Override
    public shape  getshape(String s) {
        if (s != null) {
            if (s.equalsIgnoreCase("rectangle")) {
                return new rectangle();
            } else if (s.equalsIgnoreCase("square")) {
                return new Square();
            }
        }
        return null;
    }

}
