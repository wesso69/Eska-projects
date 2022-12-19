package abstractfac;

public class FactoryProcdure {

    public static AbstractFactory getFactory(boolean rounded) {

        if (rounded == true) {
            return new RoundedShapeFactory();
        } else {
            return new shapeFactory();
        }

    }
}
