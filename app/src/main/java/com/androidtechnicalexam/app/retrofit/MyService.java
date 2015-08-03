package com.androidtechnicalexam.app.retrofit;

import com.androidtechnicalexam.app.models.MyModel;
import com.androidtechnicalexam.app.models.ResponseModel;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ihortelano on 7/30/15.
 */
public interface MyService {

    @GET("/users")
    void getUsers(Callback<ArrayList<MyModel>> cb);
}
