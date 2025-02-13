package com.example.earthquake;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class ApiClient {

    public interface Service {
        @GET("all_hour.geojson")
        Call<String> getEarthquakes();
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    private static final ApiClient apiCLient = new ApiClient();

    private Service service;

    public static ApiClient getInstance(){
        return apiCLient;
    }

    private ApiClient(){

    }

    public Service getService(){
        if (service == null){
            service = retrofit.create(Service.class);
        }
        return service;
    }
}
