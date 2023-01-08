/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

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
