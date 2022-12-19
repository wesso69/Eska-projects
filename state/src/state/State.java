package state;

public class State {

    Controller c;

    State(String con) {
        c = new Controller();
        if (con.equalsIgnoreCase("Company")) 
            c.setCompany();
      
        if (con.equalsIgnoreCase("hype")) 
            c.setHyper();
        
        if (con.equalsIgnoreCase("ar")) 
            c.setAr();
        if(con.equalsIgnoreCase("genr"))
            c.setGenr();
        c.open();
        c.log();
        c.close();
        c.update();
        
    }

    

}
