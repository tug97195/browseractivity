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
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.Inflater;


public class PageViewerFragment extends Fragment {
    //View bg;
    String homepage = "https://www.msn.com";
    String url = homepage;
    WebView webView;


    private static final String URL_KEY = "url";

    public PageViewerFragment() {
        // Required empty public constructor
    }

    public static PageViewerFragment newInstance(String url) {
        PageViewerFragment fragment = new PageViewerFragment();
        Bundle args = new Bundle();
        args.putString(URL_KEY, url);
        Log.d("123 URLKEY:", url + " ADDED !!!");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Log.d("123 URLKEY:", getArguments().getString(URL_KEY));
            url = getArguments().getString(URL_KEY);
        } else{
            url = homepage;
        }
    }

    private void setContentView(WebView myWebView) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page_viewer, container, false);
        EditText urlText = view.findViewById(R.id.EditText);
        webView = (WebView) view.findViewById(R.id.webView);
        displayURL(url);
        return view;
    }

    public void displayURL(String url) {
        if(url.contains("DEBUG_prev")){
            webView.goBack();
            Log.d("123 :", "ASDF P");
        }else if(url.contains("DEBUG_next")){
            webView.goForward();
            Log.d("123 :", "ASDF N");
        } else {
            if(url.contains("https://") == false && url.contains("www.") == false){
                url = "https://www." + url;
            } else if(url.contains("https://") == true && url.contains("www.") == false){
                url = "www." + url;
            } else if(url.contains("https://") == false && url.contains("www.") == true){
                url = "https://" + url;
            }
            if(url.contains(".com") == false){
                url = url + ".com";
            }
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);

            try {
                Log.d("123 URL Proper:", url + " Attempted");
                URL url_proper = new URL(url);
                Log.d("123 URL Proper accepted:", String.valueOf(url_proper) + " Attempted");
                webView.loadUrl(String.valueOf(url_proper));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }


}
