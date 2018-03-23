package helloworld.demo.com.demo8;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shyamramesh on 07/12/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    //LIST CREATION
    ArrayList<Contact> contactlist;
    Context context;
    //  LayoutInflater inflater;

    //CLASS CONSTRUCTOR
    public CustomAdapter(Context context, ArrayList<Contact> contactlist) {
        this.context = context;
        this.contactlist = contactlist;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.text_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //  Contact m;
        //  m = contactlist.get(position);
        //  holder.mrollno.setText((String).get(position));
        Contact m;
        m = contactlist.get(position);
        holder.mrollno.setText(" ROLLNO : " + m.getRollNo());
        holder.mname.setText(" NAME : " + m.getName());
        holder.maddress.setText(" ADDRESS : " + m.getAddress());
        holder.msection.setText(" SECTION : " + m.getSection());
    }

    @Override
    public int getItemCount() {
        return contactlist.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mrollno;
        public TextView mname;
        public TextView maddress;
        public TextView msection;
        public RelativeLayout mRelativeLayout;

        public ViewHolder(View v) {
            super(v);
            mrollno = (TextView) v.findViewById(R.id.listitem1);
            mname = (TextView) v.findViewById(R.id.listitem2);
            maddress = (TextView) v.findViewById(R.id.listitem3);
            msection = (TextView) v.findViewById(R.id.listitem4);
            mRelativeLayout = (RelativeLayout) v.findViewById(R.id.rl);
        }

    }
}
 /*   @Override
    public int getCount() {
        return contactlist.size();
    }

    @Override
    public Object getItem(int position) {
        return contactlist.get(position);
    }*/



  /*  @Override
    public long getItemId(int position) {
        return position;
    }*/




 /*   @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            //CALLING LAYOUT INFLATOR SERVICE WITH CONTEXT OBJECT AS REFERENCE
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //INFLATING TEXT_VIEW LAYOUT
            convertView = inflater.inflate(R.layout.text_view, null);
            //VIEWHOLDER OBJECT CREATION
            viewHolder = new ViewHolder();
            //CALLING TEXTVIEWS USING VIEWHOLDER OBJECT
            viewHolder.rollno = (TextView) convertView.findViewById(R.id.listitem1);
            viewHolder.name = (TextView) convertView.findViewById(R.id.listitem2);
            viewHolder.address = (TextView) convertView.findViewById(R.id.listitem3);
            viewHolder.section = (TextView) convertView.findViewById(R.id.listitem4);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact m;
        m = contactlist.get(position);
        //SETTING TEXT USING VIEWHOLDER OBJECT
        viewHolder.rollno.setText(" ROLLNO : " + m.getRollNo());
        viewHolder.name.setText(" NAME : " + m.getName());
        viewHolder.address.setText(" ADDRESS : " + m.getAddress());
        viewHolder.section.setText(" SECTION : " + m.getSection());


        return convertView;
    }
}*/
