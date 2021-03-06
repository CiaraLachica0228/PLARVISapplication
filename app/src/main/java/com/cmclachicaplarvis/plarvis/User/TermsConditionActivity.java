package com.cmclachicaplarvis.plarvis.User;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cmclachicaplarvis.plarvis.Admin.AddPlantActivity;
import com.cmclachicaplarvis.plarvis.R;

import static com.cmclachicaplarvis.plarvis.R.menu.view;

public class TermsConditionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_condition);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog diaBox = AskOption();
            diaBox.show();
        }
    }

    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                .setTitle("Close Application")
                .setMessage("Are you sure you want to exit?")
                .setIcon(R.drawable.ic_delete)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent MainActivityWindow = new Intent(TermsConditionActivity.this, MainActivity.class);
                        startActivity(MainActivityWindow);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.terms_condition, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {

            case R.id.nav_profile:
                Intent b = new Intent(TermsConditionActivity.this, MainActivity.class);
                startActivity(b);
                break;
            case R.id.nav_uses:
                Intent t = new Intent(TermsConditionActivity.this, UsesActivity.class);
                startActivity(t);
                break;
            case R.id.nav_techniques:
                Intent e = new Intent(TermsConditionActivity.this, TechniquesActivity.class);
               startActivity(e);
               break;
           // case R.id.nav_logout:
           //     Intent l = new Intent(TermsConditionActivity.this, LoginActivity.class);
           //     startActivity(l);
            //    break;
            //case R.id.nav_finder:
            //    Intent v = new Intent(MainActivity.this, FinderActivity.class);
            //   startActivity(v);
            //  break;
            case R.id.nav_about:
                Intent a = new Intent(TermsConditionActivity.this, AboutActivity.class);
                startActivity(a);
                break;
            case R.id.nav_privacy:
                Intent p = new Intent(TermsConditionActivity.this, TermsConditionActivity.class);
                startActivity(p);
                break;

        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
