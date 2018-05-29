package cegeka.scoaladevalori.ro.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText nameText = null;
    EditText usernameText = null;
    EditText passwordText = null;
    EditText repeatedPasswordText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameText = findViewById(R.id.editTextName);
        usernameText = findViewById(R.id.editTextUsername);
        passwordText = findViewById(R.id.editTextPassword);
        repeatedPasswordText = findViewById(R.id.editTextRepeatPassword);
    }

    public void CreateUser(View view) {
        if(nameText.getText().toString().trim().equals("") ||
            usernameText.getText().toString().trim().equals("") ||
            passwordText.getText().toString().trim().equals("") ||
            repeatedPasswordText.getText().toString().trim().equals("")) {
            Toast.makeText(RegisterActivity.this, "All the fields are mandatory",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if(passwordText.getText().toString().length() < 3) {
            Toast.makeText(RegisterActivity.this,
                    "Password should be at least 3 characters long",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if(! passwordText.getText().toString().equals(repeatedPasswordText.getText().toString())) {
            Toast.makeText(RegisterActivity.this, "Passwords are not the same",
                    Toast.LENGTH_LONG).show();
            return;
        }

        User user = new User();
        user.name = nameText.getText().toString();
        user.username = usernameText.getText().toString();
        user.password = passwordText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("user", user);
        setResult(RESULT_OK, intent);
        finish();
    }
}
