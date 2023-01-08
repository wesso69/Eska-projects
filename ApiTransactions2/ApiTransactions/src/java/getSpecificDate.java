

import java.time.LocalTime;

/**
 *
 * @author W.Shraideh
 */
public class getSpecificDate {

    public getSpecificDate() {
    }

    public static String getDate() {
        LocalTime timeObj = LocalTime.now();
        String reply_date = timeObj.toString();
        return reply_date;
    }

}
