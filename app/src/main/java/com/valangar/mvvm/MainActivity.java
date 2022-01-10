package com.valangar.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.valangar.mvvm.Model.UserModel;
import com.valangar.mvvm.ViewModel.ViewModelUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewModelUser viewModelUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModelUser = ViewModelProviders.of(this).get(ViewModelUser.class);
        viewModelUser.getMoviesListObserver().observe(this, new Observer<ArrayList<UserModel>>() {
            @Override
            public void onChanged(ArrayList<UserModel> userModelArrayList) {
                if(userModelArrayList != null) {

                    Log.i("test_api", "movieModels != null");
                    Log.i("test_api", "Response Size : "+userModelArrayList.size());

                } else {
                    Log.i("test_api", "movieModels == null");
                    Log.i("test_api", "Response Size : "+userModelArrayList.size());

                }
            }
        });
        viewModelUser.makeApiCall();
    }
}