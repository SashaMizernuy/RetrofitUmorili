package ua.genesis.sasha.retrofitumorili;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Третья сущность
 */

public class Controller {
    static final String BASE_URL="http://umorili.herokuapp.com/";



    public static UmoriliApi getApi(){

        Gson gson=new GsonBuilder()
                .setLenient()
                .create();


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        UmoriliApi umoriliApi=retrofit.create(UmoriliApi.class);


        return umoriliApi;
    }
}
