package org.example.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("toutiao/index?key=a2924a746f129e1f4b37d81dc5fea156")
    Call<String> getDataFromNet(@Query("type") String type);
    @GET("/s?wd=%E4%BD%A0%E5%A5%BD")
    Call<String> getResult();

}