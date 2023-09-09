package com.example.loginsignupapp.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginsignupapp.R;
import com.example.loginsignupapp.databinding.FragmentHomeBinding;
import com.example.loginsignupapp.ui.viewmodel.EmailEntranceViewModel;
import com.example.loginsignupapp.ui.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding layout;
    private HomeViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        layout.setHomeFragment(this);
        layout.setHomeTitle("Samsung Pay");

        return layout.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }
    public void buttonLogin(View view){
        viewModel.buttonLogin(view);
    }

    public void buttonSignUp(View view){
        viewModel.buttonSignUp(view);
    }

    public void textViewGuest(View view){
        viewModel.textViewGuest(view);
    }

}