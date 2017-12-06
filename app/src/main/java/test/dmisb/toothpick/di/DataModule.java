package test.dmisb.toothpick.di;

import android.content.Context;

import com.squareup.moshi.Moshi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import test.dmisb.toothpick.data.Prefs;
import test.dmisb.toothpick.data.Repository;
import test.dmisb.toothpick.network.RestService;
import test.dmisb.toothpick.utils.AppConfig;
import toothpick.config.Module;

public class DataModule extends Module {

    public DataModule(Context context) {
        // Network
        RestService service = createService(RestService.class);
        // SharedPreferences
        Prefs prefs = new Prefs(context);
        // Repository
        bind(Repository.class).toInstance(new Repository(prefs, service));
    }

    private OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(AppConfig.MAX_CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(AppConfig.MAX_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(AppConfig.MAX_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
    }

    private static Converter.Factory createConvertFactory() {
        return MoshiConverterFactory.create(new Moshi.Builder()
                .build());
    }

    private static Retrofit createRetrofit(OkHttpClient okHttp) {
        return new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addConverterFactory(createConvertFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttp)
                .build();
    }

    private <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = createRetrofit(createClient());
        return retrofit.create(serviceClass);
    }
}
