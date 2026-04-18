package Instagram;
import java.awt.List;
import java.util.*;

class Instagram_Manager {
    int PostIds = 101;
    Scanner sc = new Scanner(System.in);
    private HashMap<Integer,User> users = new HashMap<>();
    private LinkedHashMap<Integer,Post> posts = new LinkedHashMap<>();

    public void addUser(User user){
        users.put(user.getId(),user);
    }

    public boolean addPost(int id,String post){
        if (!users.containsKey(id)){
            return false;
        }

        Post new_post = new Post(post,users.get(id),PostIds);
        posts.put(PostIds,new_post);
        PostIds++;
        System.out.println("------------------------------");
        System.out.println("Post By: "+users.get(id).getName());
        System.out.println("Post: "+post);
        return true;
    }

    public void ViewPosts(){
        for (int i: posts.keySet()){
            Post post = posts.get(i);
            System.out.println("\nID: "+post.getId()+" : Post By "+post.getPostBy().getName()+" : "+post.getPostHere()+" Likes: "+post.getLikes());
            System.out.println("> Comments <");
            post.getComments();
            System.out.println("------------------------------------------------------------------------");
        }

        System.out.println("\nLikes And Comments That You Can Perform!");
        boolean isTrue = true;
        while(isTrue){
            System.out.print("Enter Post Id (or Press 0 to Cancel): ");
            int post_id = sc.nextInt();
            if (post_id==0){
                break;
            }
            System.out.println("Enter User ID: ");
            int user_id = sc.nextInt();
            System.out.println("1.Add Comment\n2.Like the Post\n3.Back");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    if (!posts.containsKey(post_id)){
                        return;
                    }
                    sc.nextLine();
                    System.out.println("Enter Comment Here: ");
                    String comment_msg = sc.nextLine();
                    Comment comment = new Comment(users.get(user_id),comment_msg);
                    posts.get(post_id).addComments(comment);
                    break;

                case 2:
                    if (posts.containsKey(post_id)){
                        posts.get(post_id).addLikes();
                    }
                    break;

                case 3:
                    isTrue = false;
                    break;
            }
        }
    }

    public void PostByUser(int id) {
        if (!users.containsKey(id)){
            return;
        }
        User user = users.get(id);
        for (int i: posts.keySet()){
            Post post = posts.get(i);
            if (post.getPostBy().equals(user)){
                System.out.println("\nID: "+post.getId()+" : Post By "+post.getPostBy().getName()+" : "+post.getPostHere()+" Likes: "+post.getLikes());
                System.out.println("> Comments <");
                post.getComments();
                System.out.println("------------------------------------------------------------------------");
            }
        }
    }
}
