package nyc.c4q.leighdouglas.ufeed.news_card;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.ufeed.R;
import nyc.c4q.leighdouglas.ufeed.news_card.news_model.Article;

/**
 * Created by shannonalexander-navarro on 1/7/17.
 */

public class NewsAdapter extends RecyclerView.Adapter {

    List<Article> articleList = new ArrayList<>();

    public NewsAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        NewsViewHolder newsViewHolder = (NewsViewHolder) holder;
        Article article = articleList.get(position);
        newsViewHolder.bind(article);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
