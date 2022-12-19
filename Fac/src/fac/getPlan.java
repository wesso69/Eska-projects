package fac;

public class getPlan {

    public Plan getPlanFactory(String ptype) {
        if (ptype == null) {
            return null;
        }
        if (ptype.equalsIgnoreCase("PlanA")) {
            return new planA();
        } else if (ptype.equalsIgnoreCase("PlanB")) {
            return new Planb();
        } 
        return null;
    }
}
