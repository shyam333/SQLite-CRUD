package helloworld.demo.com.demo8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by shyamramesh on 01/12/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student";
    public static final String TABLE_NAME = "student_details";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "ROLLNO";
    public static final String COL_3 = "NAME";
    public static final String COL_4 = "ADDRESS";
    public static final String COL_5 = "SECTION";
    private static final int DATABASE_VERSION = 1;

    //TABLE CREATION
    private static final String CREATE_QUERY = " CREATE TABLE " + TABLE_NAME + " ( " +
            COL_1 + " INTEGER PRIMARY KEY ," +
            COL_2 + " TEXT ," +
            COL_3 + " TEXT ," +
            COL_4 + " TEXT ," +
            COL_5 + " TEXT )";

    //CREATING SELECT_QUERY METHOD
    private String SELECT_QUERY = " SELECT " +
            COL_1 + " , " +
            COL_2 + " , " +
            COL_3 + " , " +
            COL_4 + " , " +
            COL_5 +
            " FROM " + TABLE_NAME + " WHERE " + COL_2 + " = ? ";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //CREATING DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    //UPGRADING DATABASE
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //INSERT RECORD
    public boolean insertData(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        //CONTENTVALUES OBJECT CREATION FOR CONTENTVALUES CLASS
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, contact.getRollNo());
        contentValues.put(COL_3, contact.getName());
        contentValues.put(COL_4, contact.getAddress());
        contentValues.put(COL_5, contact.getSection());
        long result = db.insert(TABLE_NAME, null, contentValues);
        //CONDITONS TO PERFORM BOOLEAN OPERATION
        if (result == -1)
            return false;
        else
            return true;
    }


    //UPDATE RECORD
    public boolean updateData(Contact contact) {
        //TO PERFORM WRITE OPERATION IN DATABASE
        SQLiteDatabase db = this.getWritableDatabase();
        //CONTENTVALUES OBJECT CREATION FOR CONTENTVALUES CLASS
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, contact.getName());
        contentValues.put(COL_4, contact.getAddress());
        contentValues.put(COL_5, contact.getSection());
        //UPDATING DATA WITH REFERENCE TO COLOUMN2(ROLLNO)
        db.update(TABLE_NAME, contentValues, COL_2 + " = ?", new String[]{contact.getRollNo()});
        //RETURN STATEMENT FOR BOOLEAN OPERATION
        return true;
    }


    //DELETE RECORD
    public Integer deleteData(String RollNo) {
        //TO PERFORM WRITE OPERATION IN DATABASE
        SQLiteDatabase db = this.getWritableDatabase();
        //DELETING DATA WITH REFERENCE TO COLOUMN2(ROLLNO)
        return db.delete(TABLE_NAME, COL_2 + " = ?", new String[]{RollNo});
    }

    //CHECKING ROLLNO
    public String checkRollNo(String RollNo) {
        //TO PERFORM WRITE OPERATION IN DATABASE
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        //FOR EXCEPTION HANDLING
        try {
            //CALLING SELECT_QUERY METHOD
            cursor = db.rawQuery(SELECT_QUERY, new String[]{RollNo});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                return cursor.getString(cursor.getColumnIndex(COL_2));
            }
        }
        //CATCHES ALL TYPES OF EXCEPTION(NULL,IO,ARRAYOVERINDEX)
        catch (Exception e) {
            e.printStackTrace();
        }
        //FINALLY STATEMENT EXECUTES AFTER THE TRY BLOCK

        return null;
    }

    //SELECTING PARTICULAR RECORD USING ROLLNO
    public Contact getContact(String RollNo) {

        SQLiteDatabase db = this.getWritableDatabase();
        Contact contact = new Contact(RollNo);
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(SELECT_QUERY, new String[]{RollNo});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                contact.setID(cursor.getString(cursor.getColumnIndex(COL_1)));
                contact.setRollNo(cursor.getString(cursor.getColumnIndex(COL_2)));
                contact.setName(cursor.getString(cursor.getColumnIndex(COL_3)));
                contact.setAddress(cursor.getString(cursor.getColumnIndex(COL_4)));
                contact.setSection(cursor.getString(cursor.getColumnIndex(COL_5)));
            }
            return contact;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //GETTING CONTACT LISTS
    public ArrayList<Contact> getContacts() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Contact> contactlist = new ArrayList<Contact>();

        //   Cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME, null);
        Cursor c1 = null;
        c1 = db.rawQuery(" SELECT * FROM student_details ", null);
        c1.moveToFirst();
        do {
                Contact contact = new Contact();
                contact.setID(c1.getString(c1.getColumnIndex(COL_1)));


                contact.setRollNo(c1.getString(c1.getColumnIndex(COL_2)));


                contact.setName(c1.getString(c1.getColumnIndex(COL_3)));


                contact.setAddress(c1.getString(c1.getColumnIndex(COL_4)));


                contact.setSection(c1.getString(c1.getColumnIndex(COL_5)));
               contactlist.add(contact);



        } while (c1.moveToNext());

        return contactlist;
    }
}


//try {


//cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME, null);


//if (cursor.getCount() > 0) {


//cursor.moveToFirst();


//contact.setID(cursor.getString(cursor.getColumnIndex(COL_1)));


//contact.setRollNo(cursor.getString(cursor.getColumnIndex(COL_2)));


//contact.setName(cursor.getString(cursor.getColumnIndex(COL_3)));


//contact.setAddress(cursor.getString(cursor.getColumnIndex(COL_4)));


//contact.setSection(cursor.getString(cursor.getColumnIndex(COL_5)));


//contactlist.add(contact);


//}


//


//return contactlist;


//} catch (Exception e) {


//e.printStackTrace();


//}


//return null;


//}



