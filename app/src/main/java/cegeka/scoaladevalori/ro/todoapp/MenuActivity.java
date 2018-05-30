package cegeka.scoaladevalori.ro.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        user = (User)getIntent().getSerializableExtra("user");
    }

    public void OpenNewToDoActivity(View view) {
        Intent intent = new Intent(MenuActivity.this, AddToDoActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            switch (resultCode){
                case Activity.RESULT_OK:
                    Toast.makeText(MenuActivity.this, LoginActivity.mHashMap.size() + "", Toast.LENGTH_LONG).show();
                    break;
                    default:
                        Toast.makeText(MenuActivity.this, "Nu s-a intamplat nimic", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void OpenTodoListActivity(View view) {
        Intent intent =
                new Intent(MenuActivity.this, ToDoListActivity.class);
        startActivity(intent);
    }

    public void OpenProfileActivity(View view) {
        Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}
