package edu.temple.browseractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Resources;
import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity implements PageControlFragment.urlPickedInterface {
    FragmentManager frag_man;
    PageViewerFragment view_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Browser App");
        view_frag = new PageViewerFragment();
        frag_man = getSupportFragmentManager();
        frag_man.beginTransaction().add(R.id.page_control, new PageControlFragment()).add(R.id.page_viewer, view_frag).commit();

    }

    @Override
    public void urlPicked(String url) {
        PageViewerFragment v = PageViewerFragment.newInstance(url);
        frag_man.beginTransaction().add(R.id.page_viewer, v).commit();
    }

}
