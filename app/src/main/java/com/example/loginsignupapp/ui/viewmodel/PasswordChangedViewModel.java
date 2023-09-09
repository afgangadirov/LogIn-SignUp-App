package com.example.loginsignupapp.ui.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.loginsignupapp.R;
import com.example.loginsignupapp.data.repo.Repository;

public class PasswordChangedViewModel extends ViewModel {

    private Repository repo = new Repository();
    public void buttonBacktoLogin(View view){
        repo.buttonBacktoLogin(view);
    }
}
