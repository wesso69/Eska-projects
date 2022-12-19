package fly;

public class Fly {
    
    public static void main(String[] args) {
        Pen yellowthinpin = PenFactory.getThinPen("yellow");
        yellowthinpin.drow("hello there");
        Pen yellowthickpin = PenFactory.getThickPen("yellow");
        yellowthickpin.drow("hellos");
        Pen yellowmeduimpin = PenFactory.getMeduimPen("yellow");
        yellowmeduimpin.drow("hi");
    }
    
}
