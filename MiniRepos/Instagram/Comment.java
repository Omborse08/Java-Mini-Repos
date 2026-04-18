package Instagram;

import java.time.LocalTime;

class Comment {
    private User user;
    private String message;
    private LocalTime localTime;

    Comment(User user, String message){
        this.user = user;
        this.message = message;
        this.localTime = LocalTime.now();
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public LocalTime getTime() {
        return localTime;
    }
}
