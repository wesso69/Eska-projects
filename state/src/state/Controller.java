package state;

public class Controller {

    public static company comp;
    public static hyperMarket hype;
    public static Ar ar;
    public static genR genr;

    private static Connection con;

    Controller() {
        comp = new company();
        hype = new hyperMarket();
        ar = new Ar();
        genr =new genR();
    }

    public void setCompany() {
        con = comp;
    }

    public void setHyper() {
        con = hype;
    }

    public void setAr() {
        con = ar;
    }
    
    public void setGenr(){
        con= genr;
    }
    
    public void open() {
        con.open();
    }

    public void close() {
        con.close();
    }

    public void log() {
        con.log();
    }

    public void update() {
        con.update();
    }

}
