package fly;

public class MeduimPen implements Pen {

    final BrushSize brushsize = BrushSize.Meduim;
    private String color = null;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void drow(String content) {
        System.out.println("Drowing with Meduimpen " + color);
    }

}
