package com.bearsandflags.pocketcode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.io.File;
import java.util.Stack;

public class MainActivity extends Activity {

    final Stack<TableRow> tableRowStack=new Stack<>();
    TableLayout layout;
    int width;
    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context=getApplicationContext();

        File noteDir=context.getDir("mydir", Context.MODE_PRIVATE);

        layout=(TableLayout)findViewById(R.id.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        final TableRow tr=new TableRow(context);
        tableRowStack.push(tr);
        layout.addView(tableRowStack.peek());
        tr.setGravity(Gravity.CENTER_HORIZONTAL);

        ImageButton noteAdd=new ImageButton(context);
        noteAdd.setImageResource(R.drawable.note_add);
        noteAdd.setScaleType(ImageView.ScaleType.FIT_XY);
        noteAdd.setBackgroundColor(Color.TRANSPARENT);
        tableRowStack.peek().addView(noteAdd, width * 5 / 11, width * 5 / 11);
        noteAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNote();
            }
        });
    }

    public void createNote(){
        final Note note=new Note(getBaseContext());
        if(tableRowStack.peek().getChildCount()>1){
            final TableRow tableRow=new TableRow(getApplicationContext());
            tableRowStack.push(tableRow);
            layout.addView(tableRow);
            tableRow.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        tableRowStack.peek().addView(note.getBtn(), width * 5 / 11, width * 5 / 11);
        note.getBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),DisplayActivity.class);
                i.putExtra("fileName",note.getTitle());
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
