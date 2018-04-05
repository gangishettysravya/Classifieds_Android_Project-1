package app.iiitb.com.classifieds;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static android.R.attr.tag;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        DisplaySelectedScreen(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            android.app.Fragment f = this.getFragmentManager().findFragmentById(R.id.content_main);
            if (f instanceof Home){
                super.onBackPressed();
            }
            else{
                DisplaySelectedScreen(R.id.nav_home);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }


    private void DisplaySelectedScreen(int id){
        android.app.FragmentManager fragmentManager = getFragmentManager();

        switch (id){
            case R.id.nav_home:
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main
                                , new Home())
                        .commit();
                break;
            case R.id.nav_profile:
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main
                                , new Profile())
                        .commit();
                break;
            case R.id.nav_settings:
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main
                                , new Settings())
                        .commit();
                break;
            case R.id.nav_drafts:
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main
                                , new Drafts())
                        .commit();
                break;
            case R.id.nav_wishList:
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main
                                , new WishList())
                        .commit();
                break;
            case R.id.nav_myPosts:
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main
                                , new MyPosts())
                        .commit();
                break;
            case R.id.nav_helpAndFeedback:
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main
                                , new HelpAndFeedback())
                        .commit();
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DisplaySelectedScreen(id);

        return true;
    }
}