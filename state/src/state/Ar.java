/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author W.Shraideh
 */
public class Ar implements Connection{
       @Override
    public void open() {
        System.out.println("Ar conn opened");
    }

    @Override
    public void log() {
        System.out.println("Ar conn logged in");
    }

    @Override
    public void close() {
        System.out.println("Ar conn closed");
    }

    @Override
    public void update() {
        System.out.println("Ar conn updated");
    }
}
