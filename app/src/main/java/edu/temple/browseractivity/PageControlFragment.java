package edu.temple.browseractivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PageControlFragment extends Fragment {
    urlPickedInterface mainActivity;
    public PageControlFragment() {
        // Required empty public constructor
    }
    public String prev = "DEBUG_prev";
    public String next = "DEBUG_next";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof urlPickedInterface) {
            mainActivity = (urlPickedInterface) context;
        }
        else {
            throw new RuntimeException("Implement GetURLInterface interface to attach this fragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page_control, container, false);
        ImageButton goButton = (ImageButton) v.findViewById(R.id.go);
        ImageButton nextButton = (ImageButton) v.findViewById(R.id.next);
        ImageButton backButton = (ImageButton) v.findViewById(R.id.back);

        final EditText urlText = v.findViewById(R.id.EditText);

        goButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("123 BUTTON PRESS:", "Next Button has been pressed " + urlText.getText().toString());
                mainActivity.urlPicked( urlText.getText().toString() );
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("123 BUTTON PRESS:", "Next Button has been pressed " + urlText.getText().toString());

            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("123 BUTTON PRESS:", "Back Button has been pressed " + urlText.getText().toString());

            }
        });

        return v;
    }

    interface urlPickedInterface {
        void urlPicked(String url);

    }


}
