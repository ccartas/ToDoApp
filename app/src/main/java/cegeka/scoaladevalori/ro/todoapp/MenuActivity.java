package cegeka.scoaladevalori.ro.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void OpenNewToDoActivity(View view) {
        Intent intent = new Intent(MenuActivity.this, AddToDoActivity.class);
        startActivity(intent);
    }
}
