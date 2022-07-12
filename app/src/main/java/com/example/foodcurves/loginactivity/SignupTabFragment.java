package com.example.foodcurves.loginactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.foodcurves.MainActivity;
import com.example.foodcurves.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupTabFragment extends Fragment {

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ProgressDialog progressDialog;
    EditText emailText, passwordText, confirmPasswordText;
    Button signup, skip;
    String emailPattern;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signup_tab_fragment, container, false);

        skip = view.findViewById(R.id.skip_button);
        emailText = view.findViewById(R.id.email);
        passwordText = view.findViewById(R.id.password);
        confirmPasswordText = view.findViewById(R.id.confirm_password);
        signup = view.findViewById(R.id.signup_btn);
        skip = view.findViewById(R.id.skip_button);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressDialog = new ProgressDialog(getContext());


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignupClick(v);
            }
        });
        return view;
    }

    public void onSignupClick(View view){
        String userName = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();
        String confirmPassword = confirmPasswordText.getText().toString().trim();
        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";   //"^(.+)@(.+)$";
        if(!userName.matches(emailPattern)){
            emailText.setError("Invalid email Id");
            emailText.requestFocus();
        }else if(password.length()<6){
            passwordText.setError("Must contain at least 6 characters");
            passwordText.requestFocus();
        }else if(!password.equals(confirmPassword)){
            confirmPasswordText.setError("Password not matches");
        }else{
            progressDialog.setMessage("Please wait while Login");
            progressDialog.setTitle("Log In");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if(task.isSuccessful()){
                        Toast.makeText(getContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                        sendUserToNextActivity();
                    }else{
                        Toast.makeText(getContext(), task.getException().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void sendUserToNextActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
