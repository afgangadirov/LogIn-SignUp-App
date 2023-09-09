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
import com.example.loginsignupapp.databinding.FragmentNewPasswordBinding;
import com.example.loginsignupapp.ui.viewmodel.HomeViewModel;
import com.example.loginsignupapp.ui.viewmodel.NewPasswordViewModel;
import com.google.android.material.snackbar.Snackbar;

public class NewPasswordFragment extends Fragment {

    private FragmentNewPasswordBinding layout;
    private NewPasswordViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = FragmentNewPasswordBinding.inflate(inflater, container, false);

        layout.setNewPasswordFragment(this);

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {

                Navigation.findNavController(requireView()).popBackStack(R.id.otpVerificationFragment,true);

            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        return layout.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(NewPasswordViewModel.class);
    }

    public void buttonReset(View view){

        if (layout.editTextPasswordNewPassword.getText().toString().isEmpty()){
            Snackbar.make(view,"Please enter your "+layout.editTextPasswordNewPassword.getHint(),Snackbar.LENGTH_SHORT).show();
        }
        else if (layout.editTextConfirmPasswordNewPassword.getText().toString().isEmpty()){
            Snackbar.make(view,"Please cofirm your new pasword",Snackbar.LENGTH_SHORT).show();
        }else {
            Navigation.findNavController(view).navigate(R.id.action_newPasswordFragment_to_passwordChangedFragment);
        }
    }


}