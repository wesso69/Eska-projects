package compos;

public class Compos {

    public static void main(String[] args) {
        Player p1 = new csgoplayers(1, 1820, "waseem");
        Player p2 = new csgoplayers(2, 1270, "dani");
        Player p3 = new Lolplayers(3, 1520, "jawad");
        Player p4 = new DotapLayer(4, "gaben", 10000);

        p4.add(p1);
        p4.add(p2);
        p4.add(p3);
        p4.print();

    }

}
