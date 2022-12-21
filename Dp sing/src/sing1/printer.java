package sing1;

public class printer {

    private int num;
    private String name;
    private static printer instance = null;

    private printer() {};
    
    public static printer getInstance() {
        if (instance == null) {
            instance = new printer();
        }
        return instance;
    }

    public void print() {
        System.out.println("Hello there!");
    }

    public void setNum(int n) {
        this.num = n;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printname() {
        System.out.println("the name entered :" + this.name + "the num entered is :" + this.num);
    }
}
