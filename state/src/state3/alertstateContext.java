package state3;

public class alertstateContext {

    private alertNotification currentstate;

    public alertstateContext() {
     currentstate = new  fbAlert();
    }
    public void setState(alertNotification a){    
      this.currentstate = a;
    }
    public void alert (String s){
       if (s.equalsIgnoreCase("facebook")){
           currentstate.alert(s);
       } else if (s.equalsIgnoreCase("whatsapp")){
          currentstate = new whatsappAlert();
          currentstate.alert(s);
       }
    }
}
