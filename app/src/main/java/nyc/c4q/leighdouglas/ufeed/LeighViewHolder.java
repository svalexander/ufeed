package nyc.c4q.leighdouglas.ufeed;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import nyc.c4q.leighdouglas.ufeed.InstagramItems.InstagramData;
import nyc.c4q.leighdouglas.ufeed.InstagramItems.InstagramPojo;
import nyc.c4q.leighdouglas.ufeed.InstagramItems.InstagramService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeighViewHolder extends RecyclerView.ViewHolder{
    private WebView myWebView;
    private ImageView myImageView;
    public final String TAG = "Access Token";
    private String accessToken;
    private String instagramImageUrl;
    private EditText userHashTag;
    private String hashTag;
    private Button submitHashTagBttn;
    private Layout linearLayout;
    private String TAG1 = "user hashtag";
    private String TAG2 = "is it successful?";
    private Retrofit retrofit;
    private InstagramService service;
    private Context mContext;

    public LeighViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mContext = itemView.getContext();

        retrofit = new Retrofit.Builder()
                .baseUrl(InstagramService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(InstagramService.class);

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        accessToken = sharedPrefs.getString("access token", "no token");
        hashTag = sharedPrefs.getString("users hashtag", "none");
        Log.d(TAG, accessToken);
        myImageView = (ImageView) itemView.findViewById(R.id.my_image_view);
        myWebView = (WebView) itemView.findViewById(R.id.my_web_view);
        userHashTag = (EditText) itemView.findViewById(R.id.hash_tag_editText);
        submitHashTagBttn = (Button) itemView.findViewById(R.id.submit_hashtag);

        if (!accessToken.equals("no token") && hashTag.equals("none")) {
            setHashTag();
        } else if(!accessToken.equals("no token") && !hashTag.equals("none")){
            setPicture();
        }

        myWebView.loadUrl("https://api.instagram.com/oauth/authorize/?client_id=5c42e8e24ad64c10b53386daa642000d&redirect_uri=http://localhost/&response_type=token&scope=likes+comments+relationships+basic");

        myWebView.setWebViewClient(new WebViewClient() {


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains("https://api.instagram.com/oauth/authorize/?client_id=5c42e8e24ad64c10b53386daa642000d&redirect_uri=http://localhost/&response_type=token&scope=likes+comments+relationships+basic")){
                    return true;
                }
                if (url.contains("https://instagram.com/oauth/authorize/?client_id=5c42e8e24ad64c10b53386daa642000d&redirect_uri=http://localhost/&response_type=token&scope=likes+comments+relationships+basic")
                        || !url.contains("https://www.instagram.com/accounts/login/?force_classic_login=&next=/oauth/authorize/%3Fclient_id%3D5c42e8e24ad64c10b53386daa642000d%26redirect_uri%3Dhttp%3A//localhost/%26response_type%3Dtoken%26scope%3Dlikes%2Bcomments%2Brelationships%2Bbasic")) {
                    String accessToken = url.substring(31);
                     Log.d(TAG, accessToken);
                    SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString("access token", accessToken);
                    editor.apply();
                    setHashTag();
                }
                return false;
            }
        });



    }

    public void setHashTag() {
        myWebView.setVisibility(View.GONE);
        userHashTag.setVisibility(View.VISIBLE);
        submitHashTagBttn.setVisibility(View.VISIBLE);
        submitHashTagBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hashTag = userHashTag.getText().toString();
                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.putString("users hashtag", hashTag);
                editor.apply();
                Log.d(TAG1, hashTag);
//                baseUrl = "https://api.instagram.com/v1/tags/" + hashTag + "/media/";
                setPicture();
            }
        });
    }

    public void setPicture() {
//        userHashTag.setVisibility(View.GONE);
//        submitHashTagBttn.setVisibility(View.GONE);

        myImageView.setVisibility(View.VISIBLE);

        Call<InstagramPojo> call = service.getInstagramImage(hashTag, accessToken);

        call.enqueue(new Callback<InstagramPojo>() {
            @Override
            public void onResponse(Call<InstagramPojo> call, Response<InstagramPojo> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG2, "Success: " + response.body().toString());
                        InstagramData[] instagramDataArray = response.body().getData();

                        for (int i = 0; i < instagramDataArray.length; i++) {
                            if (instagramDataArray[i].getType().equals("image")) {
                                instagramImageUrl = instagramDataArray[i].getImages().getStandard_resolution().getUrl();
                                Picasso.with(mContext).load(instagramImageUrl).into(myImageView);
                                break;
                            }
                        }

                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<InstagramPojo> call, Throwable t) {
                // Something went completely wrong (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });
    }


    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.leigh_card, parent, false);
    }

    public void bind(Integer integer) {

    }
}
