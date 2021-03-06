package br.com.eduardo.restservice.httprequests;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LuisEduardo on 24/04/2017.
 */
public class ServiceGenerator {
    protected static final String IP = "localhost";
    protected static final String PORT = "8080";
    protected static final String CONTEXT = "RESTService";
    protected static final String URL_SERVIDOR= "http://"+IP+":"+PORT+"/"+CONTEXT+"/";

    public static <S> S creativeService(Class<S> serviceClass) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS);
        httpClient.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_SERVIDOR)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient.build())
                .build();

        return retrofit.create(serviceClass);
    }
}
