package helloworld.demo.com.demo8;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by shyamramesh on 01/12/17.
 */

    public class Contact  {
    public String ID;
    public String RollNo;
    public String Name;
    public String Address;
    public String Section;


    public Contact(String RollNo) {
     this.RollNo = RollNo;
    }

    public Contact() {

    }

    public Contact(String ID, String RollNo, String Name, String Address, String Section) {
        this.ID = ID;
        this.RollNo = RollNo;
        this.Name = Name;
        this.Address = Address;
        this.Section = Section;
    }


    //SETTER METHODS
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setRollNo(String rollNo) {
        this.RollNo = rollNo;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public void setSection(String section) {
        this.Section = section;
    }


    //GETTER METHODS
    public String getID() {
        return ID;
    }

    public String getRollNo() {
        return RollNo;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getSection() {
        return Section;
    }


    }