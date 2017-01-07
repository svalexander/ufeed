package nyc.c4q.leighdouglas.ufeed.news_card.news_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shannonalexander-navarro on 1/6/17.
 */

public class NewsResponse {

    private String status;
    private String source;
    private String sortBy;
    private List<Article> articles = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
