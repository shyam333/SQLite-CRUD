package helloworld.demo.com.demo8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //OBJECTS CREATION
    EditText editRollno, editName, editAddress, editSection;
    Button btnAddData;
    DatabaseHelper myDb;
    Button btnViewAll;
    Button btnDelete;
    Button btnViewUpdate;
    Button btnClearAll;
  //  Button btnListView;
    Button btnRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);


        //REFERENCE ID
        editRollno = (EditText) findViewById(R.id.txt1);
        editName = (EditText) findViewById(R.id.txt2);
        editAddress = (EditText) findViewById(R.id.txt3);
        editSection = (EditText) findViewById(R.id.txt4);
        btnAddData = (Button) findViewById(R.id.submit);
        btnViewAll = (Button) findViewById(R.id.view);
        btnViewUpdate = (Button) findViewById(R.id.update);
        btnDelete = (Button) findViewById(R.id.delete);
        btnClearAll = (Button) findViewById(R.id.clear);
     //   btnListView = (Button) findViewById(R.id.list);
        btnRecyclerview = (Button) findViewById(R.id.list);


        //CALLING METHOD SETONCLICKLISTENER
        btnClearAll.setOnClickListener(this);
        btnAddData.setOnClickListener(this);
        btnViewAll.setOnClickListener(this);
        btnViewUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);


        btnRecyclerview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                android.content.Intent intent = new android.content.Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    //ONCLICK METHOD DECLARATION
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                addData();
                break;
            case R.id.view:
                viewAll();
                break;
            case R.id.update:
                updateData();
                break;
            case R.id.delete:
                deleteData();
                break;
            case R.id.clear:
                clearAll();
                break;

        }

    }

    //TO CLEAR EDIT TEXT FIELD
    public void clearAll() {
        editRollno.setText("");
        editName.setText("");
        editAddress.setText("");
        editSection.setText("");
        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show();
    }

    public void addData() {
        //TOAST OPERATIONS
        if (editRollno.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter roll no", Toast.LENGTH_SHORT).show();
        } else if (editName.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
        } else if (editAddress.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter address", Toast.LENGTH_SHORT).show();
        } else if (editSection.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter section", Toast.LENGTH_SHORT).show();
        } else {
            //CALLING METHOD OF DATABASE HELPER CLASS
            String rollNo = myDb.checkRollNo(editRollno.getText().toString());
            if (rollNo == null) {
                boolean isInserted = myDb.insertData(new Contact(null,
                        editRollno.getText().toString(),
                        editName.getText().toString(),
                        editAddress.getText().toString(),
                        editSection.getText().toString()));
                //TOAST OPERATIONS
                if (isInserted)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "RollNo already Inserted", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void updateData() {
        //TOAST OPERATIONS
        if (editRollno.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter roll no", Toast.LENGTH_SHORT).show();
        } else if (editName.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
        } else if (editAddress.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter address", Toast.LENGTH_SHORT).show();
        } else if (editSection.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter section", Toast.LENGTH_SHORT).show();
        } else {
            //CALLING METHOD OF DATABASE HELPER CLASS
            boolean isUpdate = myDb.updateData(new Contact(null,
                    editRollno.getText().toString(),
                    editName.getText().toString(),
                    editAddress.getText().toString(),
                    editSection.getText().toString()));
            //TOAST OPERATIONS
            if (isUpdate)
                Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteData() {
        //TOAST OPERATIONS
        if (editRollno.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter roll no", Toast.LENGTH_SHORT).show();
        } else {
            //CALLING METHOD OF DATABASE HELPER CLASS
            Integer deletedRows = myDb.deleteData(editRollno.getText().toString());
            //TOAST OPERATIONS
            if (deletedRows > 0)
                Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
        }
    }

    public void viewAll() {
        //TOAST OPERATIONS
        if (editRollno.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter roll no", Toast.LENGTH_SHORT).show();
        } else {
            //CALLING METHOD OF DATABASE HELPER CLASS

            Contact contact = myDb.getContact(editRollno.getText().toString());
            //TOAST OPERATIONS
            if (contact.getRollNo() != null) {
                editName.setText(contact.getName());
                editAddress.setText(contact.getAddress());
                editSection.setText(contact.getSection());
                Toast.makeText(this, "Data retrieved successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}




















