package user.ash.usermanagement.MVP.Presenter;

import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import user.ash.usermanagement.ApiServices;
import user.ash.usermanagement.App;
import user.ash.usermanagement.StaticMethods;


/**
 * Created by Ayman on 3/3/2017.
 */

public class BasePresenter implements Presenter {

    private String mDevice="";
    private Gson mGson;
    private String error;
    private static String  baseUrl;

    public BasePresenter() {
        mGson=new Gson();
    }

    public BasePresenter(String baseUrl) {
        mGson=new Gson();
        this.baseUrl = baseUrl;
    }



    protected ApiServices getRetrofit() {
        if (StaticMethods.isNetworkAvailable()) {
            return new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(get_HTTPClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(ApiServices.class);
        } else {
            Toast.makeText(App.mContext, "Connection Error", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    protected <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    public void setDeviceType() {
        mDevice ="android";
    }

    @Override
    public void onDestroy() {
    }


    private OkHttpClient get_HTTPClient() {
        final Map<String, String> headers = new HashMap<>();
//        String token = SharedManager.newInstance().getCashValue(SharedManager.ACCESS_TOKEN);
//        if (!TextUtils.isEmpty(token) && token != null) {
//            headers.put("Authorization", "bearer " + token);
//        }
//
//        if(mDevice!=null && !TextUtils.isEmpty(mDevice)){
//            headers.put("device",mDevice);
//        }
//
//        boolean isLogin=SharedManager.newInstance().getCashBoolean(SharedManager.IS_LOGIN);
//        if(isLogin){
//            String lang = SharedManager.newInstance().getCashValue(SharedManager.LANG);
//            if (lang == null || TextUtils.isEmpty(lang) || lang.equalsIgnoreCase(SharedManager.ENGLISH)) {
//                headers.put("locale", "en");
//            } else {
//                headers.put("locale", "ar");
//            }
//        }

        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json; charset=utf-8");

        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers

                Request.Builder requestBuilder = original.newBuilder(); // <-- this is the important line

                for (Map.Entry<String, String> pairs : headers.entrySet()) {
                    if (pairs.getValue() != null) {
                        requestBuilder.header(pairs.getKey(), pairs.getValue());
                    }
                }

                requestBuilder.method(original.method(), original.body());
                Request request = requestBuilder.build();

                return chain.proceed(request);

            }
        });

        return httpClient.build();

    }
}
