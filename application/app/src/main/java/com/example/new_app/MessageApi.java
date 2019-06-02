package com.example.new_app;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MessageApi {
    @GET("app.json")
    Call<List<User>> messages(@Query("id") int id);
}
