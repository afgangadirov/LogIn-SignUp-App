package com.example.loginsignupapp.ui;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginsignupapp.R;
import com.example.loginsignupapp.databinding.FragmentRegisterBinding;
import com.example.loginsignupapp.ui.viewmodel.HomeViewModel;
import com.example.loginsignupapp.ui.viewmodel.RegisterViewModel;
import com.google.android.material.snackbar.Snackbar;


public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding layout;
    private RegisterViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = FragmentRegisterBinding.inflate(inflater, container, false);

        layout.setRegisterFragment(this);


        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {

                Navigation.findNavController(requireView()).popBackStack(R.id.registerFragment,true);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        return layout.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
    }

    public void buttonRegister(View view){
        if (layout.editTextUsernameRegister.getText().toString().isEmpty()){
            Snackbar.make(view,"Please enter your "+layout.editTextUsernameRegister.getHint(),Snackbar.LENGTH_SHORT).show();
        }
        else if (layout.editTextEmailRegister.getText().toString().isEmpty()){
            Snackbar.make(view,"Please enter your "+layout.editTextEmailRegister.getHint(),Snackbar.LENGTH_SHORT).show();
        }
        else if (layout.editTextPasswordRegister.getText().toString().isEmpty()){
            Snackbar.make(view,"Please enter your "+layout.editTextPasswordRegister.getHint(),Snackbar.LENGTH_SHORT).show();
        }
        else if (layout.editTextConfirmRegister.getText().toString().isEmpty()){
            Snackbar.make(view,"Please confirm your "+layout.editTextPasswordRegister.getHint(),Snackbar.LENGTH_SHORT).show();
        }else {
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_homePageFragment);
        }
    }

    public void textViewLogin(View view){
        viewModel.textViewLoginRegister(view);
    }



}