package com.valangar.mvvm.Network;

import com.valangar.mvvm.Model.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;


//-----------------------------------------------------------------------------------------
// Test Response API
// https://jsonplaceholder.typicode.com/posts
//-----------------------------------------------------------------------------------------

public interface APIService {

    @GET("posts")
    Call<ArrayList<UserModel>> getUsersDetails();
}

