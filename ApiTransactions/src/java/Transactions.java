public class Transactions {

    private int TRANSACTION_ID;
    private String priority;
    private String AppointmentNo;
    private String FeasibilityId;
    private boolean is_success;
    
    public Transactions(){
    }
    
    public int getTRANSACTION_ID() {
        return TRANSACTION_ID;
    }

    public void setTRANSACTION_ID(int TRANSACTION_ID) {
        this.TRANSACTION_ID = TRANSACTION_ID;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAppointmentNo() {
        return AppointmentNo;
    }

    public void setAppointmentNo(String AppointmentNo) {
        this.AppointmentNo = AppointmentNo;
    }

    public String getFeasibilityId() {
        return FeasibilityId;
    }

    public void setFeasibilityId(String FeasibilityId) {
        this.FeasibilityId = FeasibilityId;
    }

    public boolean GetIs_success() {
        return is_success;
    }

    public void setIs_success(boolean is_success) {
        this.is_success = is_success;
    }
    
    
    
}
