package com.example.loginsignupapp.ui.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.loginsignupapp.R;
import com.example.loginsignupapp.data.repo.Repository;

public class HomeViewModel extends ViewModel {

    private Repository repo = new Repository();

    public void buttonLogin(View view){
        repo.buttonLogin(view);
    }

    public void buttonSignUp(View view){
        repo.buttonSignUp(view);
    }

    public void textViewGuest(View view){
        repo.textViewGuest(view);
    }

}
