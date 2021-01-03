package com.example.logotrivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.logotrivia.databinding.FragmentWinnerBinding;


public class WinnerFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private String name;
    private FragmentWinnerBinding mBinding;
    public WinnerFragment() {
        // Required empty public constructor
    }

    public static WinnerFragment newInstance(String param1) {
        WinnerFragment fragment = new WinnerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentWinnerBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String message = getString(R.string.felicitaciones, name);
        mBinding.tvWinner.setText(message);

        mBinding.btIntentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTitle();
            }
        });
    }

    private void addTitle(){
        TitleFragment titleFragment = TitleFragment.newInstance();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment, titleFragment, TitleFragment.class.getSimpleName())
                .addToBackStack(null);
        transaction.commit();
    }
}