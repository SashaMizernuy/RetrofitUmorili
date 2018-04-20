package ua.genesis.sasha.retrofitumorili;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Вторая сущность
 */

public interface UmoriliApi {
    @GET("/api/get")
    //В аннотации будем использовать метод GET, который к базовому  URL добавит
    ///api/get?name=  первый параметр
    //&num=  второй параметр



    Call<List<PostModel>> getData(@Query("name") String resourceName, @Query("num") int count);

    //getData-метод возвращающий объект типа Call<List<PostModel>>.
    //Методы должны всегда возвращать объект типа Call<T> и иметь аннотацию типа запроса (GET, POST, PUT, DELETE).

    //Аннотация @Query("name") String resourceName показывает Retrofit'у, что в качестве параметра запроса нужно поставить пару name=<Значение строки resourceName>.

}
