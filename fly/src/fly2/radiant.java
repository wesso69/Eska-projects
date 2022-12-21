package fly2;

public class radiant implements Player {

    private final String Task;

    String Role;
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
        System.out.println("A dota player with a role of " + Role + "with a radiant mission in this game in the " + lane + " is " + Task);
    }

    @Override
    public void assignRole(String role) {
        this.Role = role;
    }

}
