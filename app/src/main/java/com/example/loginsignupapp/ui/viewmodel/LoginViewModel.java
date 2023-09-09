package com.example.loginsignupapp.ui.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.loginsignupapp.R;
import com.example.loginsignupapp.data.repo.Repository;

public class LoginViewModel extends ViewModel {
    private Repository repo = new Repository();

    public void textViewRegisterNow(View view){
        repo.textViewRegisterNow(view);
    }
}
