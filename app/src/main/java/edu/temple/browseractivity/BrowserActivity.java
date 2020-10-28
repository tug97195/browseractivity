package edu.temple.browseractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Resources;
import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity {
    FragmentManager frag_man;
    PageControlFragment pageControlFragment = new PageControlFragment();
    PageViewerFragment pageViewerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Browser App");

        frag_man = getSupportFragmentManager();
        frag_man.beginTransaction().add(R.id.page_viewer, PageViewerFragment.newInstance()).add(R.id.page_control, pageControlFragment).commit();

    }

//    public void urlPicked(String url) {
//        Resources res = getResources();
//        url = "https://" + url;
//        pageViewerFragment.displayURL(url);
//    }
}
