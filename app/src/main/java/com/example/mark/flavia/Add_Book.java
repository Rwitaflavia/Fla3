package com.example.mark.flavia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Book extends AppCompatActivity {

    EditText book,Notes;
    Button add,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__book);

        book = (EditText) findViewById(R.id.book);
        Notes = (EditText) findViewById(R.id.Notes);
        add = (Button) findViewById(R.id.btn_add);
        view = (Button) findViewById(R.id.btn_View);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class );
                startActivity(intent);
            }
        });

        final String BOOK_TITLE = book.getText().toString();
        final String NOTES = Notes.getText().toString();

        final MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                broadcastIntent(view);
                Toast.makeText(getApplicationContext(),"Succefull", Toast.LENGTH_SHORT).show();

            }
        });
    }

    // broadcast a custom intent.

    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.munguriek.zeroapp.CUSTOM_INTENT"); sendBroadcast(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

}
