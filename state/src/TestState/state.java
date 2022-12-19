/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestState;

/**
 *
 * @author W.Shraideh
 */
public class state {
    printer p;
    scanner s;
    private Painter painter;
    
    public  state(){
        this.painter=null;
    }
    public state (Painter p){
       painter = p;
    }
    public void setPrinter(Painter paint){
        this.painter =paint;
    }
    public Painter getPainter(){
        return painter;
    }
    public void print(){
        painter.drow();
    }
    
}
