package com.valangar.mvvm.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.valangar.mvvm.Model.UserModel;
import com.valangar.mvvm.Network.APIService;
import com.valangar.mvvm.Network.RetroInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelUser extends ViewModel {

    private MutableLiveData<ArrayList<UserModel>> userList;

    public ViewModelUser(){
        userList = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<UserModel>> getMoviesListObserver() {
        return userList;

    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<ArrayList<UserModel>> call = apiService.getUsersDetails();
        call.enqueue(new Callback<ArrayList<UserModel>>() {
            @Override
            public void onResponse(Call<ArrayList<UserModel>> call, Response<ArrayList<UserModel>> response) {
                userList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<UserModel>> call, Throwable t) {
                userList.postValue(null);

                Log.i("test_api", "ERROR :- "+t.getMessage().toString());

            }
        });
    }
}
