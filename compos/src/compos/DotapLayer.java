package compos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DotapLayer implements Player {

    int id;
    String name;
    int rank;

    public DotapLayer(int id, String name, int rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }
    List<Player> playerslist = new ArrayList<>();

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
        playerslist.add(p);
    }

    @Override
    public void remove(Player p) {
        playerslist.remove(p);
    }

    @Override
    public Player getPlayer(int i) {
        return playerslist.get(i);
    }

    @Override
    public void print() {
        System.out.println("=======================");
        System.out.println("Dota player id:" + getId());
        System.out.println("Dota player name " + getName());
        System.out.println("Rank" + getRank());
        System.out.println("=======================");

        Iterator<Player> it = playerslist.iterator();
        
        while (it.hasNext()){
            Player p = it.next();
            p.print();
        }
    }

}
