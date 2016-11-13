package nyc.c4q.leighdouglas.ufeed.InstagramItems;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InstagramService {
    static final String BASE_URL = "https://api.instagram.com/";

    @GET("v1/tags/{hashtag}/media/recent")
    Call<InstagramPojo> getInstagramImage(@Path("hashtag") String hashtag, @Query("access_token") String token);

}
