package cegeka.scoaladevalori.ro.todoapp;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddToDoActivity extends AppCompatActivity {
    EditText editTextTitle = null;
    EditText editTextDescription = null;
    SeekBar seekBar = null;
    EditText editTextDueDate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        seekBar = findViewById(R.id.seekBar);
        editTextDueDate = findViewById(R.id.editTextDueDate);

        Button buttonAddToCalendar = findViewById(R.id.button_calendar);
        buttonAddToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Validate()) {
                    ToDoItem item = new ToDoItem();
                    item.title = editTextTitle.getText().toString();
                    item.priority = seekBar.getProgress();
                    item.description = editTextDescription.getText().toString();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        item.dueDate = format.parse(editTextDueDate.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Intent intent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                    Calendar beginTime = Calendar.getInstance();
                    beginTime.setTime(item.dueDate);
                    intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                    intent.putExtra(CalendarContract.Events.TITLE, item.title);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean Validate() {
        if(editTextTitle.getText().toString().trim().equals("") ||
            editTextDescription.getText().toString().trim().equals("") ||
            editTextDueDate.getText().toString().trim().equals("")) {
            Toast.makeText(AddToDoActivity.this,
                    "All the fields are mandatory",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date =
              format.parse(editTextDueDate.getText().toString() + " 23:59");
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(AddToDoActivity.this,
                    "Invalid date format",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        Date currentDate = new Date();
        if(date != null && date.compareTo(currentDate) <= 0) {
            Toast.makeText(AddToDoActivity.this,
                    "Date should be at least today",
                    Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
}
