package com.example.recyclerviewexample;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder>{

    @NonNull
private int lastposition=-1;
    Context context;
    ArrayList<contact_model> arrayList;
    recyclerAdapter(Context context,ArrayList<contact_model> arrayList){
        this.arrayList=arrayList;
        this.context=context;
    }
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.contact_column,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        contact_model model=(contact_model) arrayList.get(position);
     holder.imgView.setImageResource(model.img);
    holder.txtname.setText(model.name);
    holder.txtnumber.setText(model.number);
    holder.llrow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Dialog dialog=new Dialog(context);
            dialog.setContentView(R.layout.add_update);
            EditText editname=dialog. findViewById(R.id.edittext1);
            EditText editnumber=dialog. findViewById(R.id.edittext2);
            Button btnaction=dialog. findViewById(R.id.btnaction);
            TextView texttitle=dialog.findViewById(R.id.textview);
            btnaction.setText("Update");
            texttitle.setText("Update data");
            editname.setText(arrayList.get(position).name);
            editnumber.setText(arrayList.get(position).number);
            btnaction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name="",number="";
                    if(!editname.getText().toString().equals("")) {
                        name=editname.getText().toString();

                    }else
                    {
                        Toast.makeText(context,"please enter name",Toast.LENGTH_SHORT).show();
                    }
                    if(!editnumber.getText().toString().equals("")){
                        number = editnumber.getText().toString();
                    }else{
                        Toast.makeText(context,"Please enter number",Toast.LENGTH_SHORT).show();
                    }
                    arrayList.set(position,new contact_model(R.drawable.middy,name,number));
                    notifyItemChanged(position);
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    });
    holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            AlertDialog.Builder builder=new AlertDialog.Builder(context).setTitle("Delete contact").setMessage("Are you sure want to delete")
                    .setIcon(R.drawable.ic_baseline_delete_24).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            arrayList.remove(position);
                            notifyItemRemoved(position);
                        }
                    }
                    ).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            builder.show();


            return true;
        }
    });
    setAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname,txtnumber;
        ImageView imgView;
        LinearLayout llrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           txtname= itemView.findViewById(R.id.contact_textview);
            txtnumber= itemView.findViewById(R.id.contact_number);
            imgView= itemView.findViewById(R.id.imageview);
            llrow=itemView.findViewById(R.id.llrow);
        }
    }
    private void setAnimation(View viewtoanimate,int position){
        if(position>lastposition){
            Animation slidein= AnimationUtils.loadAnimation(context, R.anim.rcy_anim);
            viewtoanimate.setAnimation(slidein);
             lastposition=position;
        }

    }
}