package fly;

public class ThickPen implements Pen {

    final BrushSize brushsize = BrushSize.Thick;
    private String color = null;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void drow(String content) {
        System.out.println("Drowing with Thickpen "+ color);
    }

}
