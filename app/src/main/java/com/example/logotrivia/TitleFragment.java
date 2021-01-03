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
import android.widget.Toast;

import com.example.logotrivia.databinding.FragmentTitleBinding;


public class TitleFragment extends Fragment {
    private FragmentTitleBinding mBinding;

    public TitleFragment() {
        // Required empty public constructor
    }


    public static TitleFragment newInstance() {
        TitleFragment fragment = new TitleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentTitleBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.btComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= mBinding.etNombre.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(getContext(),"Debes indicar tu nombre"
                            , Toast.LENGTH_SHORT).show();

                }
                else addTrivia(name);
            }
        });


    }
            private void addTrivia(String name){
                TriviaFragment triviaFragment = TriviaFragment.newInstance(name);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment, triviaFragment, TriviaFragment.class.getSimpleName())
                .addToBackStack(null);
                transaction.commit();

    }
}