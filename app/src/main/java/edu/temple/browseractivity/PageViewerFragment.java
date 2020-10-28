package edu.temple.browseractivity;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.zip.Inflater;


public class PageViewerFragment extends Fragment {
    View bg;
    WebView webView;

    public PageViewerFragment() {
        // Required empty public constructor
    }

    public static PageViewerFragment newInstance(String param1, String param2) {
        PageViewerFragment fragment = new PageViewerFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment newInstance() {
        PageViewerFragment fragment = new PageViewerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //WebView myWebView = new WebView(activityContext);
        //setContentView(myWebView);

    }

    private void setContentView(WebView myWebView) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page_viewer, container, false);
        Bundle bundle;
        if(savedInstanceState != null){
            bundle = savedInstanceState;
            Log.d ("123 myApplication", "HELLO? 1" + bundle.getString("message"));
        }
        else if(getArguments() != null){
            bundle = getArguments();
            Log.d ("123 myApplication", "HELLO? 2" + bundle.getString("message"));
        }
        else{
            bundle = getActivity().getIntent().getExtras();
            Log.d ("123 myApplication", "HELLO? 3");
        }

        String url = "https://www.msn.com/";
        webView = (WebView) view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        return view;
    }

    public void displayURL(String url) {
        //webView = (WebView) view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}

//        if(this.getArguments().getString("message") == null){
//            Log.d("123 Message:", "Sticking with home URL ");
//        }else{
//            try {
//                url = this.getArguments().getString("message");
//                Log.d("123 URL BUNDLE:", url);
//            }
//            catch(Exception e) {
//                Log.d("123 ERROR:", "ERROR: " + e);
//            }
//        }
