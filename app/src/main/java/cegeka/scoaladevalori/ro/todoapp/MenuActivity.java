package cegeka.scoaladevalori.ro.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle b = getIntent().getExtras();
        Toast.makeText(MenuActivity.this,
                b.getString("USER"), Toast.LENGTH_LONG).show();
    }
}
