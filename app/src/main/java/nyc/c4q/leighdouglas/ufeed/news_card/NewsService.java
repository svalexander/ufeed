package nyc.c4q.leighdouglas.ufeed.news_card;

import nyc.c4q.leighdouglas.ufeed.news_card.news_model.NewsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shannonalexander-navarro on 1/6/17.
 */

public interface NewsService {

    @GET("v1/articles")
    Call<NewsResponse> getArticles(@Query("source") String source,
                                   @Query("sortBy") String sort,
                                   @Query("apiKey") String apiKey);
}
