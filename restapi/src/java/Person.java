
public class Person {

    private String name ;
    private String about ;
    private int birthyear;

    public Person(String name, String about, int birthyear) {
        this.name = name;
        this.about = about;
        this.birthyear = birthyear;
    }
    public String getName(){
        return name;
    }
     public String getAbout(){
        return about;
    }
      public int getBirthYear(){
        return birthyear;
    }
}
