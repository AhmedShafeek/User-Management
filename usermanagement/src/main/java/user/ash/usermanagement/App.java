package user.ash.usermanagement;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * Created by ID on 3/26/2017.
 */

public class App extends MultiDexApplication {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}