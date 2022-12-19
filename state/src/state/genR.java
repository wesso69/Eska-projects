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
public class genR implements Connection {

    @Override
    public void open() {
        System.out.println("conn opened with genr");
    }

    @Override
    public void log() {
        System.out.println("conn loged with genr");
    }

    @Override
    public void close() {
        System.out.println("conn closed with genr");
    }

    @Override
    public void update() {
        System.out.println("conn updated with genr");
    }

}
