package com.androidtechnicalexam.app.retrofit;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.inject.Singleton;

import java.util.Date;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by ihortelano on 8/3/15.
 */
@Singleton
public class Retrofit {

    public static <K> K getService(Class<K> claz) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://jsonplaceholder.typicode.com")
                .setConverter(new GsonConverter(gson))
                .build();

        return restAdapter.create(claz);
    }

}
