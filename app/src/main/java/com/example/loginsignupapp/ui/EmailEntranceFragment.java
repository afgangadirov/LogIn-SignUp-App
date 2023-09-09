package com.example.loginsignupapp.ui;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginsignupapp.R;
import com.example.loginsignupapp.databinding.FragmentEmailEntranceBinding;
import com.example.loginsignupapp.ui.viewmodel.EmailEntranceViewModel;
import com.google.android.material.snackbar.Snackbar;

public class EmailEntranceFragment extends Fragment {

    private FragmentEmailEntranceBinding layout;
    private EmailEntranceViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = FragmentEmailEntranceBinding.inflate(inflater, container, false);

        layout.setEmailEntranceFragment(this);

        return layout.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(EmailEntranceViewModel.class);
    }

    public void buttonSendCode(View view){
        if (layout.editTextEmailEmailEntrance.getText().toString().isEmpty()){
            Snackbar.make(view,"Please "+layout.editTextEmailEmailEntrance.getHint(),Snackbar.LENGTH_SHORT).show();
        }else {
            Navigation.findNavController(view).navigate(R.id.action_emailEntranceFragment_to_otpVerificationFragment);
        }
    }

    public void textViewLogin(View view){
        viewModel.textViewLogin(view);
    }


}