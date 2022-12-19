package state2;

public class StopMusic implements Music {

    

    @Override
    public void doAction(Actions action) {
        System.out.println("stop music !");
    }

}
