package edu.temple.browseractivity;

import android.content.res.Resources;
import android.os.Bundle;

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
    //urlPickedInterface mainActivity;
    public PageControlFragment() {
        // Required empty public constructor
    }

    public static PageControlFragment newInstance(String param1, String param2) {
        PageControlFragment fragment = new PageControlFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_page_control, container, false);
        ImageButton goButton = (ImageButton) v.findViewById(R.id.go);
        ImageButton nextButton = (ImageButton) v.findViewById(R.id.next);
        ImageButton backButton = (ImageButton) v.findViewById(R.id.back);

        goButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                EditText urlText = (EditText) v.findViewById(R.id.EditText);
                String url = urlText.getText().toString();
                Log.d("123 BUTTON PRESS:", "Go Button has been pressed: " + url);



                FragmentManager fm = getFragmentManager();
                FragmentTransaction updateURL = fm.beginTransaction();

                Fragment currentFragment = new PageViewerFragment();
                Bundle bundle = new Bundle();
                bundle.putString("message", url);
                currentFragment.setArguments(bundle);
                fm.beginTransaction().replace(R.id.page_viewer, currentFragment);
                fm.beginTransaction().commit();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                Log.d("123 BUTTON PRESS:", "Next Button has been pressed");
            }
        });
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                Log.d("123 BUTTON PRESS:", "Back Button has been pressed");
            }
        });

        return v;
    }

//    interface urlPickedInterface {
//        void urlPicked(String url);
//    }

}

//                Bundle bundle = new Bundle();
//                bundle.putString("message", url);
//                // set Fragmentclass Arguments
//                PageViewerFragment fragobj = new PageViewerFragment();
//                fragobj.setArguments(bundle);
//                Bundle bundle = new Bundle();
//                String myMessage = url;
//                bundle.putString("message", myMessage);
//                PageViewerFragment fragInfo = new PageViewerFragment();
//                fragInfo.setArguments(bundle);
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction updateURL = fm.beginTransaction();
//                updateURL.replace(R.id.page_viewer, fragInfo);
//                updateURL.commit();

//                FragmentManager fm = getFragmentManager();
//                PageViewerFragment fragm = (PageViewerFragment)fm.findFragmentById(R.id.page_viewer);
//                fragm.displayURL(urlText.getText().toString());
//
//                FragmentTransaction updateURL = fm.beginTransaction();
//                updateURL.replace(R.id.page_viewer, new PageViewerFragment());