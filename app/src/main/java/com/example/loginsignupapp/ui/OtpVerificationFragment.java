package com.example.loginsignupapp.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginsignupapp.R;
import com.example.loginsignupapp.databinding.FragmentOtpVerificationBinding;
import com.example.loginsignupapp.ui.viewmodel.HomeViewModel;
import com.example.loginsignupapp.ui.viewmodel.OtpVerificationViewModel;
import com.google.android.material.snackbar.Snackbar;

public class OtpVerificationFragment extends Fragment {

    private FragmentOtpVerificationBinding layout;
    private OtpVerificationViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = FragmentOtpVerificationBinding.inflate(inflater, container, false);

        layout.setOtpVerificationFragment(this);

        layout.inputCode1.requestFocus();

        setupOTPInputs();

        layout.textViewResendOtp.setOnClickListener(view -> {
            Snackbar.make(view,"We just sent an OTP verification code to your email. Please check it.",Snackbar.LENGTH_SHORT).show();
        });

        return layout.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(OtpVerificationViewModel.class);
    }

    public void buttonVerify(View view){
        if (layout.inputCode1.getText().toString().isEmpty()){
            Snackbar.make(view,"Please enter the OTP verification code we just sent you",Snackbar.LENGTH_SHORT).show();
        }
        else if (layout.inputCode2.getText().toString().isEmpty()){
            Snackbar.make(view,"Please enter the OTP verification code we just sent you",Snackbar.LENGTH_SHORT).show();
        }
        else if (layout.inputCode3.getText().toString().isEmpty()){
            Snackbar.make(view,"Please enter the OTP verification code we just sent you",Snackbar.LENGTH_SHORT).show();
        }
        else if (layout.inputCode4.getText().toString().isEmpty()){
            Snackbar.make(view,"Please enter the OTP verification code we just sent you",Snackbar.LENGTH_SHORT).show();
        }else {
            Navigation.findNavController(view).navigate(R.id.action_otpVerificationFragment_to_newPasswordFragment);
        }
    }


    public void setupOTPInputs(){
        layout.inputCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    layout.inputCode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        layout.inputCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    layout.inputCode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        layout.inputCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    layout.inputCode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        layout.inputCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    layout.buttonVerifyOtp.performClick();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}