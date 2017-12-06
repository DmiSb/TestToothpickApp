package test.dmisb.toothpick.data.model;

public class Post {
    private int id;
    private String title;
    private String body;

    public Post(String title, String body) {
        this.id = 0;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
