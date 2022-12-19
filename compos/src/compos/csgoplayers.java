package compos;

import java.util.Iterator;

public class csgoplayers implements Player {

    int id;
    String name;
    int rank;

    public csgoplayers(int id, int rank, String name) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public void add(Player p) {

    }

    @Override
    public Player getPlayer(int i) {
        return null;
    }

    @Override
    public void print() {
        System.out.println("=======================");
        System.out.println("Csgo player id:" + getId());
        System.out.println("Csgo player name " + getName());
        System.out.println("Rank" + getRank());
        System.out.println("=======================");

    }

    @Override
    public void remove(Player p) {
    }
}
