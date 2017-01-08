package nyc.c4q.leighdouglas.ufeed.news_card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import nyc.c4q.leighdouglas.ufeed.R;
import nyc.c4q.leighdouglas.ufeed.news_card.news_model.Article;

/**
 * Created by shannonalexander-navarro on 1/7/17.
 */

public class NewsViewHolder extends RecyclerView.ViewHolder {
    
    TextView articleTitle, articleAuthor, articleDescription, articleUrl, articleDate;
    LinearLayout articleLayout;
    
    public NewsViewHolder(View itemView) {
        super(itemView);
        initViews();
    }

    private void initViews() {
        articleLayout = (LinearLayout) itemView.findViewById(R.id.article_layout);
        articleTitle = (TextView) itemView.findViewById(R.id.article_title);
        articleAuthor = (TextView) itemView.findViewById(R.id.article_author);
        articleDescription = (TextView) itemView.findViewById(R.id.article_description);
        articleUrl = (TextView) itemView.findViewById(R.id.article_url);
        articleDate = (TextView) itemView.findViewById(R.id.article_date);
    }

    public void bind(Article article) {
        articleTitle.setText(article.getTitle());
        articleAuthor.setText(article.getAuthor());
        articleDescription.setText(article.getDescription());
        articleUrl.setText(article.getUrl());
        articleDate.setText(article.getPublishedAt());
    }
}
