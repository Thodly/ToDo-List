package com.kettydugue.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import static com.kettydugue.simpletodo.R.id.editText2;

public class EditItemActivity extends AppCompatActivity {
    EditText tv;
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    String value;
    Button savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        savebtn = (Button) findViewById(R.id.button);

       tv = (EditText)findViewById(editText2);
        Intent intent = getIntent();
        value = intent.getStringExtra("value");
        tv.setText(value);
         savebtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String newname = tv.getText().toString();
                 Intent intent = new Intent();
                 intent.putExtra("New_name",newname);
                 setResult(RESULT_OK,intent);
                 finish();


                 Toast.makeText(EditItemActivity.this,"Modification Reussite" ,Toast.LENGTH_LONG).show();

             }
         });

    }
   /*public void onSaveItem(View v){
        EditText editText2 =(EditText)findViewById(R.id.editText2);
        String itemText = editText2.getText().toString();
        itemsAdapter.add(itemText);
       // itemsAdapter.notifyDataSetChanged();
        Intent intent = new Intent(EditItemActivity.this, MainActivity.class);
        editText2.getInputExtras(value.contains(itemText));
        intent.putExtra("lan",itemText);
        startActivity(intent);
        //writeItems();
    }


 /*  private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    */
};
