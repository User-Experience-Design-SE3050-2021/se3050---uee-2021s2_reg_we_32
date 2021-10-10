package com.androiddev.peopleswave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText inputEmail,inputPassword;
    Button BtnLogin;
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEmail = findViewById(R.id.loginUsername);
        inputPassword = findViewById(R.id.loginPassword);
        BtnLogin = findViewById(R.id.btnLogin);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforLogin();
            }
        });
    }

    private void perforLogin(){
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if(!email.matches(EMAIL_VERIFICATION)){
            inputEmail.setError("Enter Valid Email");
        }else if(password.isEmpty() || password.length() < 6){
            inputPassword.setError("Enter Proper Password");
        }else {
            progressDialog.setMessage("Please wait while Login...");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        navigateToMenu();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }


    /*
     Navigate to menu page
    * */

    public void navigateToMenu(){
        Intent intent =  new Intent(this,Menu.class);

        startActivity(intent);

    }

    //navigate to forget password
    public void navigateToForgetPass(View v){
        Intent intentFP =  new Intent(this,ForgotPassStep1.class);
        startActivity(intentFP);

    }

    //navigate to signup
    public void navigateToSignup(View v){
        Intent intentSignup =  new Intent(this,SignupStep2.class);
        startActivity(intentSignup);
    }
}