package com.example.foodcurves.loginactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.foodcurves.R;

public class LogInTabFragment extends Fragment {

    EditText email, password;
    Button login;
    TextView forget;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        forget = view.findViewById(R.id.forget_password);
        login = view.findViewById(R.id.login_button);

        int xT = 300;
        float sAl = 0.0f;

        email.setTranslationX(xT);
        password.setTranslationX(xT);
        forget.setTranslationX(xT);
        login.setTranslationX(xT);

        email.setAlpha(sAl);
        password.setAlpha(sAl);
        forget.setAlpha(sAl);
        login.setAlpha(sAl);

        email.animate().translationX(0).alpha(1).setStartDelay(300).setDuration(500).start();
        password.animate().translationX(0).alpha(1).setStartDelay(500).setDuration(500).start();
        forget.animate().translationX(0).alpha(1).setStartDelay(600).setDuration(500).start();
        login.animate().translationX(0).alpha(1).setStartDelay(700).setDuration(500).start();

        return view;
    }
}
