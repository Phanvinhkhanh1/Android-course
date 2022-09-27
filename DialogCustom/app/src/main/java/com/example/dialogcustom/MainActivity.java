package com.example.dialogcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtViewLogin;
    EditText edtUsername, edtPassword;
    Button btnConfirm, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtViewLogin = (TextView) findViewById(R.id.textViewLogin);
        txtViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCustom();
            }
        });
    }

    private void dialogCustom() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCanceledOnTouchOutside(false);

        edtUsername = (EditText) dialog.findViewById(R.id.editTextUsername);
        edtPassword = (EditText) dialog.findViewById(R.id.editTextPassword);
        btnConfirm = (Button) dialog.findViewById(R.id.buttonConfirm);
        btnCancel = (Button) dialog.findViewById(R.id.buttonCancel);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textUserName = edtUsername.getText().toString().trim();
                String textPassword = edtPassword.getText().toString().trim();
                if (textUserName.equals("PhanVinhKhanh") && textPassword.equals("123456789")) {
                    Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}