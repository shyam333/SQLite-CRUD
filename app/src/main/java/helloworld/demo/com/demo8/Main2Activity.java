package helloworld.demo.com.demo8;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    //LIST INITIALIZATION
    ArrayList<Contact> contactlist;
 //   ListView listView;
    DatabaseHelper myDb;

//RECYCLER VIEW
    private Context context;
    RelativeLayout relativelayout;
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    private CustomAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.list_view);
        setContentView(R.layout.recycler_view);
        context = getApplicationContext();
        myDb = new DatabaseHelper(this);
        contactlist = myDb.getContacts();


     //   listView = (ListView) findViewById(R.id.lst);
      //  listView.setAdapter(new CustomAdapter (this, contactlist));
        relativelayout = (RelativeLayout) findViewById(R.id.rl);
        recyclerView = (RecyclerView) findViewById(R.id.rc);

        mAdapter = new CustomAdapter(this,contactlist);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);


    }


}



