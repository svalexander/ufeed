package nyc.c4q.leighdouglas.ufeed.InstagramItems;

/**
 * Created by leighdouglas on 11/12/16.
 */

public class InstagramData {
    String type;
    InstagramImage images;
    InstagramLikes likes;
    InstagramComments comments;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InstagramImage getImages() {
        return images;
    }

    public void setImages(InstagramImage images) {
        this.images = images;
    }

    public InstagramLikes getLikes() {
        return likes;
    }

    public void setLikes(InstagramLikes likes) {
        this.likes = likes;
    }

    public InstagramComments getComments() {
        return comments;
    }

    public void setComments(InstagramComments comments) {
        this.comments = comments;
    }
}
