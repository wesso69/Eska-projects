package fac2;

public class mainfac {

    public static void main(String[] args) {
        notifactionFactory nf = new notifactionFactory();
        Notification not = nf.createNotification("sms");
        not.notifyuser();

    }
}
