package com.androiddev.peopleswave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupStep3 extends AppCompatActivity {

    EditText inputEmail,inputPassword, inputConfirmPass;
    Button BtnSignUp;
    ProgressDialog progressDialog;
    String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_step3);

        inputEmail = findViewById(R.id.et_userName_s3);
        inputPassword = findViewById(R.id.et_pass_s3);
        inputConfirmPass = findViewById(R.id.et_RePass_s3);
        BtnSignUp = findViewById(R.id.btn_signup_s2);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        BtnSignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                PerforAuth();
            }
        });
    }

    private void PerforAuth() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmPass = inputConfirmPass.getText().toString();

        if(!email.matches(EMAIL_VERIFICATION)){
            inputEmail.setError("Enter Valid Email");
        }else if(password.isEmpty() || password.length() < 6){
            inputPassword.setError("Enter Proper Password");
        }else if(!password.equals(confirmPass)){
            inputConfirmPass.setError("Password Not Match");
        }else {
            progressDialog.setMessage("Please wait while Signing Up...");
            progressDialog.setTitle("Sign Up");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        navigateToLastStep();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(SignupStep3.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    //NavigateToLastStep
    public void navigateToLastStep(){
        Intent intentLastStep =  new Intent(this,SignupStep4.class);
        intentLastStep.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intentLastStep);
    }
}