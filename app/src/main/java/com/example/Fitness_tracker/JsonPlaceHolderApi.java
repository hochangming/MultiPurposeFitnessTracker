package com.example.Fitness_tracker;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @GET("Exercises")
    Call<List<Post>> getExercisesJson();
    @GET("FoodToLoseWeight")
    Call<List<Post>> getLoseWeightFood();
    @GET("FoodToGainWeight")
    Call<List<Post>> getGainWeightFood();

    @POST("Exercises")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("Exercises")
    Call<Post> createPost(@FieldMap Map<String, String> fields);
}
