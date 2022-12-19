package fly;

public class ThinPen implements Pen {

    final BrushSize brushsize = BrushSize.Thin;
    private String color = null;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void drow(String content) {
        System.out.println("Drowing with Thinpen " + color);
    }

}
