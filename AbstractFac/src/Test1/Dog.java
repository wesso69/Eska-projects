package Test1;

public class Dog implements Animal {

    @Override
    public String getType() {
        return "dog";
    }

    @Override
    public String makeSound() {
        return "park";
    }

}
