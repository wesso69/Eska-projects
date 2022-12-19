package state2;

public class StartMusic implements Music {

    

    @Override
    public void doAction(Actions action) {
        System.out.println("Start music");
    }

}
