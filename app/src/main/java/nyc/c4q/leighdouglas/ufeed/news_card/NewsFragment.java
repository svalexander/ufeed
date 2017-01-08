package nyc.c4q.leighdouglas.ufeed.news_card;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.ufeed.BuildConfig;
import nyc.c4q.leighdouglas.ufeed.R;
import nyc.c4q.leighdouglas.ufeed.news_card.news_model.Article;
import nyc.c4q.leighdouglas.ufeed.news_card.news_model.NewsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shannonalexander-navarro on 1/6/17.
 */

public class NewsFragment extends Fragment {

    FrameLayout newsLayout;
    public static final String NEWS_URL = "https://newsapi.org/";
    List<Article> articleList = new ArrayList<>();
    NewsAdapter newsAdapter;
    RecyclerView newsRV;
    private static final String TAG = "success";
    private static final String API_KEY = BuildConfig.NEWS_API_KEY;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.news_fragment, container, false);

        newsLayout = (FrameLayout) root.findViewById(R.id.news_frag);
        newsRV = (RecyclerView) root.findViewById(R.id.news_rv);
        newsRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        return root;

    }

    @Override
    public void onStart() {
        super.onStart();
        getsNewsJson();
    }

    private void getsNewsJson(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NEWS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService newsService = retrofit.create(NewsService.class);

        Call<NewsResponse> call = newsService.getArticles("techcrunch", "top", API_KEY);

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {

                NewsResponse newsResponse = response.body();

             //   List<Article> ourArticles = response.body().getArticles();
               // articleList = ourArticles;
                newsAdapter = new NewsAdapter(newsResponse.getArticles());
                newsRV.setAdapter(newsAdapter);

                if (response.isSuccessful()) {

                    Log.d(TAG, "Success: " + newsResponse.getArticles().get(0).getAuthor());
                } else {
                    try {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

                Log.e("FAILURE", "GOT NOTHING" + t);
            }
        });
    }
}
