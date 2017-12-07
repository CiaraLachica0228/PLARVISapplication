package com.cmclachicaplarvis.plarvis.Admin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cmclachicaplarvis.plarvis.ChooseActivity;
import com.cmclachicaplarvis.plarvis.R;
import com.cmclachicaplarvis.plarvis.User.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class VerificationActivity extends AppCompatActivity {

    private EditText expertId;
    private Button btnConfirm, btnBack;
    private ProgressBar progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_verification);

        expertId = (EditText) findViewById(R.id.expert_id);
        btnConfirm = (Button) findViewById(R.id.btn_confirm);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar);
        btnBack = (Button) findViewById(R.id.btn_back);

        // Back Button
        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(),
                        ChooseActivity.class);
                startActivity(c);
                finish();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String expertid = expertId.getText().toString();

                if (TextUtils.isEmpty(expertid)) {
                    Toast.makeText(getApplication(), "Enter your registered Identification Number", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar1.setVisibility(View.VISIBLE);

                if (expertid.equals("01020304")) {
                    //--FOR DETERMINING WHICH ACCOUNT IS LOGGED IN
                    Intent HomeWindow = new Intent(VerificationActivity.this, AddPlantActivity.class);
                    startActivity(HomeWindow);
                } else
                    Toast.makeText(VerificationActivity.this, "Identification Number don't match!", Toast.LENGTH_LONG).show();

            }
        });

    }


    @Override
    public void onBackPressed() {
        AlertDialog diaBox = AskOption();
        diaBox.show();
    }

    private AlertDialog AskOption() {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                .setTitle("Close Application")
                .setMessage("Are you sure you want to exit?")
                .setIcon(R.drawable.ic_delete)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent MainActivityWindow = new Intent(VerificationActivity.this, LoginActivity.class);
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

}
