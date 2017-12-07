package com.cmclachicaplarvis.plarvis.User;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cmclachicaplarvis.plarvis.Admin.AddPlantActivity;
import com.cmclachicaplarvis.plarvis.Admin.CustomAdapter;
import com.cmclachicaplarvis.plarvis.Admin.Data;
import com.cmclachicaplarvis.plarvis.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TechniquesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Button btnsearch;
    private EditText txtsearch;
    LayoutInflater inflater1;
    ListView listView;
    ArrayList<Data> dataArrayList;
    CustomAdapter customAdapter;

    int count =0;
    String name;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Data data;
    String key;
    int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techniques);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("Uses");
        key = databaseReference.push().getKey();

        txtsearch = (EditText) findViewById(R.id.tsearch);
        btnsearch = (Button) findViewById(R.id.btn_tsearch);
        listView = (ListView) findViewById(R.id.readlist);

        dataArrayList = new ArrayList<>();
        customAdapter = new CustomAdapter(TechniquesActivity.this, dataArrayList);
        listView.setAdapter(customAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Data datam = dataSnapshot.getValue(Data.class);
                dataArrayList.add(datam);
                customAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final View v = inflater1.from(getApplicationContext()).inflate(R.layout.custom_techniques_list, null);
                temp = i;

                final TextView upname, upsname, uptech, pname, psname, ptech;

                upname = (TextView) v.findViewById(R.id.upname);
                upsname = (TextView) v.findViewById(R.id.upsname);
                uptech = (TextView) v.findViewById(R.id.uptech);
                //upuses = (TextView) v.findViewById(R.id.upuses);
                //upsteps = (TextView) v.findViewById(R.id.upsteps);
                pname = (TextView) v.findViewById(R.id.pname);
                psname = (TextView) v.findViewById(R.id.psname);
                //puses = (TextView) v.findViewById(R.id.puses);
                //psteps = (TextView) v.findViewById(R.id.psteps);
                ptech = (TextView) v.findViewById(R.id.ptech);

                //updttech = (EditText) v.findViewById(R.id.updttech);

                final AlertDialog.Builder builder  = new AlertDialog.Builder(TechniquesActivity.this).setView(v);
                final AlertDialog alert = builder.create();

                //v.findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
                //   @Override
                //   public void onClick(View view) {

                //        Data tempData = new Data(dataArrayList.get(temp).getKey(), updtname.getText().toString().trim(),  updtsname.getText().toString().trim(), updtuses.getText().toString().trim(),
                //                updtsteps.getText().toString().trim(), updttech.getText().toString().trim());

                //        databaseReference.child(dataArrayList.get(temp).getKey()).setValue(tempData);
                //        dataArrayList.remove(temp);
                //        dataArrayList.add(temp,tempData);
                //        customAdapter.notifyDataSetChanged();
                //     }
                // });

                // v.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                //   @Override
                //   public void onClick(View view) {
                //         if(temp == -1){

                //            Toast.makeText(getApplicationContext(), "There is no data to delete", Toast.LENGTH_SHORT).show();

                //      }else {

                //          databaseReference.child(dataArrayList.get(temp).getKey()).removeValue();
                //          dataArrayList.remove(temp);
                //          customAdapter.notifyDataSetChanged();
                //          alert.cancel();
                //         temp = -1;
                //     }
                //      }
                // });

                upname.setText(dataArrayList.get(temp).getName());
                upsname.setText("" + dataArrayList.get(temp).getSName());
                //upuses.setText("" + dataArrayList.get(temp).getUses());
                //upsteps.setText("" + dataArrayList.get(temp).getSteps());
                uptech.setText("" + dataArrayList.get(temp).getTech());

                try {


                    alert.show();
                } catch (Exception e) {
                    Log.d("show", "onItemClick: " + e);

                }

                return;



            }
        });

        //txtsearch = (EditText) findViewById(R.id.search);

        findViewById(R.id.btn_tsearch).setOnClickListener(new View.OnClickListener() {
                                                              @Override
                                                              public void onClick(View view) {

                  name = txtsearch.getText().toString().trim();

                  databaseReference.orderByChild("name").equalTo(name).addListenerForSingleValueEvent(new ValueEventListener() {
                  @Override
                  public void onDataChange(DataSnapshot dataSnapshot) {

                  ++count;

                  for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                        data = dataSnapshot1.getValue(Data.class);
                        dataArrayList.clear();
                        dataArrayList.add(data);
                        Log.d("log", "onDataChange: "+dataSnapshot1.child("name").getValue());
                    }
             func();
                   }

                   @Override
                   public void onCancelled(DatabaseError databaseError) {

                   }
               });
            }
                         }
        );
    }

    public void func(){

        if(count!=0){

            customAdapter = new CustomAdapter(getApplicationContext(),dataArrayList);
            listView.setAdapter(customAdapter);

        }else {

            Toast.makeText(getApplicationContext(), "There is no data to show", Toast.LENGTH_SHORT).show();
            listView.setVisibility(View.GONE);
        }
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
                        Intent MainActivityWindow = new Intent(TechniquesActivity.this, MainActivity.class);
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
        getMenuInflater().inflate(R.menu.techniques, menu);
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
                Intent b = new Intent(TechniquesActivity.this, MainActivity.class);
                startActivity(b);
                break;
            case R.id.nav_uses:
                Intent t = new Intent(TechniquesActivity.this, UsesActivity.class);
                startActivity(t);
                break;
            case R.id.nav_techniques:
                Intent i = new Intent(TechniquesActivity.this, TechniquesActivity.class);
                startActivity(i);
                break;
            case R.id.nav_logout:
                Intent l = new Intent(TechniquesActivity.this, LoginActivity.class);
                startActivity(l);
                break;
            //case R.id.nav_finder:
            //    Intent v = new Intent(MainActivity.this, FinderActivity.class);
            //   startActivity(v);
            //  break;
            case R.id.nav_about:
                Intent a = new Intent(TechniquesActivity.this, AboutActivity.class);
                startActivity(a);
                break;
            case R.id.nav_privacy:
                Intent p = new Intent(TechniquesActivity.this, TermsConditionActivity.class);
                startActivity(p);
                break;
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
