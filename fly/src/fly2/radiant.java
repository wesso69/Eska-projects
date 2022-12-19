package fly2;

public class radiant implements Player {

    private final String Task;

    String lane;

    public radiant() {
        Task = ("winning the lane and get the Dire ancient");
    }
    
    @Override
    public void assignLane(String lane) {
        this.lane = lane;
    }
    
    @Override
    public void mission() {
        System.out.println("radiant mission in this game in the "+ lane +" is "+Task);
    }

    

}
