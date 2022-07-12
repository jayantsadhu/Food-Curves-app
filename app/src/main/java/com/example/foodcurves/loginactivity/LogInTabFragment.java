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

public class LogInTabFragment extends Fragment {

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ProgressDialog progressDialog;
    EditText emailText, passwordText;
    Button login, skip;
    TextView forget;
    String emailPattern;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_tab_fragment, container, false);

        emailText = view.findViewById(R.id.email);
        passwordText = view.findViewById(R.id.password);
        forget = view.findViewById(R.id.forget_password);
        login = view.findViewById(R.id.login_button);
        skip = view.findViewById(R.id.skip_button);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressDialog = new ProgressDialog(getContext());

        int xT = 300;
        float sAl = 0.0f;

        emailText.setTranslationX(xT);
        passwordText.setTranslationX(xT);
        forget.setTranslationX(xT);
        login.setTranslationX(xT);
        skip.setTranslationX(xT);

        emailText.setAlpha(sAl);
        passwordText.setAlpha(sAl);
        forget.setAlpha(sAl);
        login.setAlpha(sAl);
        skip.setAlpha(sAl);

        emailText.animate().translationX(0).alpha(1).setStartDelay(300).setDuration(500).start();
        passwordText.animate().translationX(0).alpha(1).setStartDelay(500).setDuration(500).start();
        forget.animate().translationX(0).alpha(1).setStartDelay(600).setDuration(500).start();
        login.animate().translationX(0).alpha(1).setStartDelay(700).setDuration(500).start();
        skip.animate().translationX(0).alpha(1).setStartDelay(800).setDuration(500).start();

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginClick(v);
            }
        });

        return view;
    }

    public void onLoginClick(View view){
        String userName = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();
        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";   //"^(.+)@(.+)$";
        if(!userName.matches(emailPattern)){
            emailText.setError("Invalid email Id");
            emailText.requestFocus();
        }else if(password.length()<6){
            passwordText.setError("Must contain at least 6 characters");
            passwordText.requestFocus();
        }else{
            progressDialog.setMessage("Please wait while Login");
            progressDialog.setTitle("Log In");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if(task.isSuccessful()){
                        Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        sendUserToNextActivity();
                    }else{
                        String errorMsg = task.getException().toString();
                        if(errorMsg.contains("There is no user record corresponding to this identifier")){
                            Toast.makeText(getContext(), "Wrong email Id", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                        }
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
