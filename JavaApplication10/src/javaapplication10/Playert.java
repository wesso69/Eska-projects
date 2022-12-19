package javaapplication10;

public class Playert {

    private int id;
    private String fname;
    private String lname;
    private String about;
    private int age;

    public Playert() {
    }

    public Playert(int id, String fname, String lname, String about, int age) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.about = about;
        this.age = age;
    }

  

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
