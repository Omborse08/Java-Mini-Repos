package Instagram;

import java.util.*;

class Post{
    private int id;
    private String postHere;
    private User postBy;
    private int likes = 0;
    private LinkedList<Comment> comments = new LinkedList<>();

    Post(String postHere, User postBy, int id){
        this.id = id;
        this.postHere = postHere;
        this.postBy = postBy;
    }

    public void addComments(Comment comments) {
        this.comments.add(comments);
    }

    public int getId() {
        return id;
    }

    public void addLikes() {
        this.likes += 1;
    }

    public String getPostHere() {
        return postHere;
    }

    public User getPostBy() {
        return postBy;
    }

    public int getLikes() {
        return likes;
    }

    public void getComments() {
        for (int i=0;i<comments.size();i++){
            Comment c = comments.get(i);
            System.out.println(c.getTime()+" : Message: "+c.getMessage()+" By "+c.getUser().getName());
        }
    }
}
