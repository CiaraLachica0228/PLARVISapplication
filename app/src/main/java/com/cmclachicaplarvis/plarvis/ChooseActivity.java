package com.cmclachicaplarvis.plarvis;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.cmclachicaplarvis.plarvis.Admin.VerificationActivity;
import com.cmclachicaplarvis.plarvis.User.IntroActivity;
import com.cmclachicaplarvis.plarvis.User.LoginActivity;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Choose();

    }

    @Override
    public void onBackPressed() {
        AlertDialog diaBox = AskOption();
        diaBox.show();
    }

    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                .setTitle("Close Application")
                .setMessage("Are you sure you want to exit?")
                .setIcon(R.drawable.ic_delete)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent MainActivityWindow = new Intent(ChooseActivity.this, LoginActivity.class);
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

    private void Choose() {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.activity_choose, null);
          dialogBuilder.setView(dialogView);

        final Button btnAdmin = (Button) dialogView.findViewById(R.id.btn_admin);
        final Button btnUser = (Button) dialogView.findViewById(R.id.btn_user);
        final ProgressBar progressBar = (ProgressBar) dialogView.findViewById(R.id.progressBar);

        //dialogBuilder.setTitle("Send Photos");
        final AlertDialog dialog = dialogBuilder.create();

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ChooseWindow = new Intent(ChooseActivity.this, VerificationActivity.class);
                startActivity(ChooseWindow);
            }
        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntroWindow = new Intent(ChooseActivity.this, IntroActivity.class);
                startActivity(IntroWindow);
            }
        });

        dialog.show();
    }
}
