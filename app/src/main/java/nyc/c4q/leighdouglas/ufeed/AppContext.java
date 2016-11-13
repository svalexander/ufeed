package nyc.c4q.leighdouglas.ufeed;

import android.app.Application;
import android.content.Context;

/**
 * Created by shannonalexander-navarro on 11/8/16.
 */

public class AppContext extends Application {
    private static Context context;

    public static Context getAppContext() {
        return AppContext.context;
    }

    public void onCreate() {
        super.onCreate();
        AppContext.context = getApplicationContext();
    }

}
