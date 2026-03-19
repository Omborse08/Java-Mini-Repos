package ScheduledJob;

class Job{
    private int id;
    private String name;
    private int Time;
    private String Status;

    Job(int id,String name,int time) {
        this.id = id;
        this.name = name;
        this.Time = time;
        this.Status = "PENDING";
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return Time;
    }

    public String getStatus() {
        return Status;
    }
}
