package compos;

public interface Player {

    public int getId();

    public String getName();

    public int getRank();

    public void print();

    public void add(Player p);

    public void remove(Player p);

    public Player getPlayer(int i);
}
