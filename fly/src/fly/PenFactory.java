package fly;

import java.util.HashMap;

public class PenFactory {

    private static final HashMap<String, Pen> pensmap = new HashMap<>();

    public static Pen getThickPen(String color) {
        String key = color + "THICK";
        Pen pen = pensmap.get(key);
        if (pen != null) {
            return pen;
        } else {
            pen = new ThickPen();
            pen.setColor(color);
            pensmap.put(key, pen);
        }
        return pen;
    }

    public static Pen getThinPen(String color) {
        String key = color + "THIN";
        Pen pen = pensmap.get(key);
        if (pen != null) {
            return pen;
        } else {
            pen = new ThinPen();
            pen.setColor(color);
            pensmap.put(key, pen);
        }
        return pen;
    }

    public static Pen getMeduimPen(String color) {
        String key = color + "MEDUIM";
        Pen pen = pensmap.get(key);
        if (pen != null) {
            return pen;
        } else {
            pen = new MeduimPen();
            pen.setColor(color);
            pensmap.put(key, pen);
        }
        return pen;
    }
}
