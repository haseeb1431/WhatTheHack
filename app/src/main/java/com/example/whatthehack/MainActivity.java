package com.example.whatthehack;

import android.content.Intent;
import android.os.health.SystemHealthManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter adapter;
    ArrayList<String> names;
    Button btnFilter;
    public static String filters[] = { "Depression", "Pneumonia", "Asthma" };
    // sorry for this
    public static boolean current_filters[] = { false, false, true };

    TextView filter0, filter1, filter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.theList);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);
        btnFilter = findViewById(R.id.filter);

        filter0 = findViewById(R.id.filter0);
        filter1 = findViewById(R.id.filter1);
        filter2 = findViewById(R.id.filter2);

        names = new ArrayList<>();
        names.add("Mitch");
        names.add("Blake");
        names.add("Shelly");
        names.add("Jess");
        names.add("Steve");
        names.add("Mohammed");

        adapter = new ArrayAdapter(this, R.layout.list_item_layout, names);
        list.setAdapter(adapter);

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                Intent intent = new Intent(MainActivity.this, Haseeb.class);
                startActivity(intent);
            }
        });

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Filter.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView filterViews[] = {filter0, filter1, filter2};
        for (int i = 0; i < filterViews.length; i++) {
            if (current_filters[i]) filterViews[i].setVisibility(View.VISIBLE);
            else filterViews[i].setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("Item selected");
        if (item.getTitle().toString().equals("Saved")) {
            item.setTitle("Back to feed");
            names.clear();
            names.add("Saved drug");
            names.add("Saved drug2");
        } else {
            item.setTitle("Saved");
            names.clear();
            names.add("New drug 1");
            names.add("New drug 2");
        }

        adapter.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }

}
