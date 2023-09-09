package com.example.loginsignupapp.ui;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginsignupapp.R;
import com.example.loginsignupapp.databinding.FragmentHomePageBinding;
import com.example.loginsignupapp.ui.viewmodel.HomePageViewModel;
import com.example.loginsignupapp.ui.viewmodel.HomeViewModel;


public class HomePageFragment extends Fragment {

    private FragmentHomePageBinding layout;
    private HomePageViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = FragmentHomePageBinding.inflate(inflater, container, false);


        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {

                Navigation.findNavController(requireView()).popBackStack(R.id.homePageFragment,true);

            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);



        return layout.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(HomePageViewModel.class);
    }
}