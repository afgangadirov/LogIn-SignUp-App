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
import com.example.loginsignupapp.databinding.FragmentPasswordChangedBinding;
import com.example.loginsignupapp.ui.viewmodel.PasswordChangedViewModel;

public class PasswordChangedFragment extends Fragment {

    private FragmentPasswordChangedBinding layout;
    private PasswordChangedViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = FragmentPasswordChangedBinding.inflate(inflater, container, false);

        layout.setPasswordChangedFragment(this);


        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {

                Navigation.findNavController(requireView()).popBackStack(R.id.newPasswordFragment,true);
                Navigation.findNavController(requireView()).popBackStack(R.id.otpVerificationFragment,false);
                Navigation.findNavController(requireView()).popBackStack(R.id.emailEntranceFragment,true);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        return layout.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(PasswordChangedViewModel.class);
    }

    public void buttonBacktoLogin(View view){
        viewModel.buttonBacktoLogin(view);
    }



}