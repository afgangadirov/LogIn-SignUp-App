package com.example.loginsignupapp.data.repo;

import android.view.View;

import androidx.navigation.Navigation;

import com.example.loginsignupapp.R;
import com.google.android.material.snackbar.Snackbar;

public class Repository {

    public void textViewLogin(View view){
        Navigation.findNavController(view).navigate(R.id.action_emailEntranceFragment_to_loginFragment);
    }

    public void buttonLogin(View view){
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_loginFragment2);
    }

    public void buttonSignUp(View view){
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_registerFragment);
    }

    public void textViewGuest(View view){
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_homePageFragment);
    }

    public void textViewRegisterNow(View view){
        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment);
    }

    public void buttonBacktoLogin(View view){
        Navigation.findNavController(view).navigate(R.id.action_passwordChangedFragment_to_loginFragment);
    }

    public void textViewLoginRegister(View view){
        Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
    }

}
