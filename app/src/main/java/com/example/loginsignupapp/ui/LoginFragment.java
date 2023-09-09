package com.example.loginsignupapp.ui;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginsignupapp.R;
import com.example.loginsignupapp.databinding.FragmentLoginBinding;
import com.example.loginsignupapp.ui.viewmodel.HomeViewModel;
import com.example.loginsignupapp.ui.viewmodel.LoginViewModel;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding layout;
    private LoginViewModel viewModel;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = FragmentLoginBinding.inflate(inflater, container, false);

        layout.setLoginFragment(this);

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {

                Navigation.findNavController(requireView()).popBackStack(R.id.passwordChangedFragment,true);
                Navigation.findNavController(requireView()).popBackStack(R.id.homePageFragment,true);
                Navigation.findNavController(requireView()).popBackStack(R.id.loginFragment,true);

            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        return layout.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    public void textViewForgotPassword(View view){
        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_emailEntranceFragment);
    }

    public void buttonLogin(View view){
        if (layout.editTextEmailLogin.getText().toString().isEmpty()){
            Snackbar.make(view,"Please "+layout.editTextEmailLogin.getHint(),Snackbar.LENGTH_SHORT).show();
        }
        else if (layout.editTextPasswordLogin.getText().toString().isEmpty()){
            Snackbar.make(view,"Please "+layout.editTextPasswordLogin.getHint(),Snackbar.LENGTH_SHORT).show();
        } else {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homePageFragment);
        }
    }

    public void textViewRegisterNow(View view){
        viewModel.textViewRegisterNow(view);
    }





}