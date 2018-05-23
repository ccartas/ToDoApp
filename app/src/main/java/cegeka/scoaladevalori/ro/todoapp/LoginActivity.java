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
    User user = null;

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
                if((mUserEt.getText().toString().equals(USERNAME) &&
                        mPassEt.getText().toString().equals(PASSWORD)) ||
                (user != null && mUserEt.getText().toString().equals(user.username) &&
                        mPassEt.getText().toString().equals(user.password))){

                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("user", user);
                    intent.putExtras(b);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this,
                            "Invalid Credentials",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == RESULT_OK) {
            user = (User)data.getSerializableExtra("user");
        }
    }

    public void OpenRegisterActivity(View view) {
        Intent intent = new Intent(LoginActivity.this,
                RegisterActivity.class);
        startActivityForResult(intent, 1);
    }
}
