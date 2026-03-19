package ScheduledJob;

class Workers{
    private int id;
    private String name;
    private String Status;

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatus() {
        return Status;
    }

    public Workers(int id, String name) {
        this.id = id;
        this.name = name;
        Status = "ONLINE";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
