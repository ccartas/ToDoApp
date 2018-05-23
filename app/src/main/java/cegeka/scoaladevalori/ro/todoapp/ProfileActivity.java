package cegeka.scoaladevalori.ro.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        User user =
                (User)getIntent().getSerializableExtra("user");
        if(user != null) {
            TextView textView = findViewById(R.id.textViewName);
            textView.setText(user.name);
        }
    }
}
