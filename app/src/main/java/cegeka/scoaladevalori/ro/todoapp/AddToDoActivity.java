package cegeka.scoaladevalori.ro.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class AddToDoActivity extends AppCompatActivity {
    EditText editTextTitle = null;
    EditText editTextDescription = null;
    SeekBar seekBar = null;
    EditText editTextDueDate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        Button buttonAdd = findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDoItem item = new ToDoItem();
                EditText editTextTitle = findViewById(R.id.editTextTitle);
                item.title = editTextTitle.getText().toString();
                SeekBar seekBar = findViewById(R.id.seekBar);
                item.priority = seekBar.getProgress();

                Toast.makeText(AddToDoActivity.this, item.title,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean Validate() {
        return false;
    }
}
