package Test1;

public class AnimalFactory extends AbstractFactory {
    
    @Override
    <T> T getType(String animaltype) {
         if (animaltype != null) {
            if (animaltype.equalsIgnoreCase("Dog")) {
                return (T) new Dog();
            } else if (animaltype.equalsIgnoreCase("bear")) {
                return (T) new bear();
            }
        }
        return null;
    }

}