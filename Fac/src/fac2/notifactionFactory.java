package fac2;

public class notifactionFactory {

    public Notification createNotification(String notify) {
        if (notify != null) {
            if (notify.equalsIgnoreCase("sms")) {
                return new SMSnotif();
            } else if (notify.equalsIgnoreCase("email")) {
                return new Emailnotif();
            }
        }
        return null;
    }
}
