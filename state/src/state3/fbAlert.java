/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state3;

/**
 *
 * @author W.Shraideh
 */
public class fbAlert implements  alertNotification{

    @Override
    public void alert(String s) {
        System.out.println("Facebook alert Notification");
    }
    
}
