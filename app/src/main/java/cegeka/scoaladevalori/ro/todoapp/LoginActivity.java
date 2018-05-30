package cegeka.scoaladevalori.ro.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    EditText mUserEt;
    EditText mPassEt;
    Button mLoginBtn;
    public static User user = null;
    public static HashMap<String, ArrayList<ToDoItem>> mHashMap = new HashMap<>();

    private static final String USERNAME = "vianu_user";
    private static final String PASSWORD = "vianu_pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = null;
        try (FileInputStream fisier = openFileInput("data.bin")) {
            ObjectInputStream ois = new ObjectInputStream(fisier);
            mHashMap = (HashMap<String, ArrayList<ToDoItem>>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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
                    if(! mHashMap.containsKey(mUserEt.getText().toString())) {
                        mHashMap.put(mUserEt.getText().toString(), new ArrayList<ToDoItem>());
                    }

                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    intent.putExtra("user", user);
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
    protected void onDestroy() {
        super.onDestroy();
        try (FileOutputStream fisier = openFileOutput("data.bin", MODE_PRIVATE)) {
            ObjectOutputStream oos = new ObjectOutputStream(fisier);
            oos.writeObject(mHashMap);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
