package cegeka.scoaladevalori.ro.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText mUserEt;
    EditText mPassEt;
    Button mLoginBtn;

    private static final String USERNAME = "vianu_user";
    private static final String PASSWORD = "vianu_pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserEt = (EditText) findViewById(R.id.userEt);
        mPassEt = (EditText) findViewById(R.id.passEt);
        mLoginBtn = (Button) findViewById(R.id.loginBtn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(mUserEt.getText().toString().equals(USERNAME) &&
                        mPassEt.getText().toString().equals(PASSWORD)){

                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    Bundle b = new Bundle();
                    b.putString("USER", mUserEt.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Invalid Credentials",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
