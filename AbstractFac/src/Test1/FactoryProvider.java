package Test1;

public class FactoryProvider {

    public static AbstractFactory getFactory(boolean b) {
        if (b == true) {
            return new AnimalFactory();
        } 
        return new ColorFactory();
    }
}
