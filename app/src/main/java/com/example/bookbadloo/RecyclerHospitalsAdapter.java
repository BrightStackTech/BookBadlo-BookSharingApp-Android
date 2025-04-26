package com.example.bookbadloo;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerHospitalsAdapter extends RecyclerView.Adapter<RecyclerHospitalsAdapter.ViewHolder> {
    public Context context;
    public ArrayList<HospitalsModel> arrayList;

    public UserClickListener userClickListener;

    public interface UserClickListener{
        void selectedUser(HospitalsModel hospitalsModel);
    }

    public RecyclerHospitalsAdapter(ArrayList<HospitalsModel> hospitalsModels, Context context, UserClickListener userClickListener){

        this.context = context;
        this.arrayList = hospitalsModels;
        this.userClickListener = userClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context content = parent.getContext();
        View view = LayoutInflater.from(content).inflate(R.layout.hospitals_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HospitalsModel hospitalsModel = arrayList.get(position);
        int hname = hospitalsModel.getHname();
        String hlocation = hospitalsModel.getHlocation();
        String horgans = hospitalsModel.getHorgan();
        String haddress = hospitalsModel.getHaddress();
        String hstate = hospitalsModel.getHstate();
        holder.haddress.setText(haddress);
        holder.hname.setImageResource(hname);
        holder.hlocation.setText(hlocation);
        holder.hstate.setText(hstate);

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                userClickListener.selectedUser(hospitalsModel);
            }
        });
    }

    public int getItemCount() {
        return arrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView hlocation, haddress, hstate;
        ImageView hname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hname = itemView.findViewById(R.id.textViewU);
            hlocation = itemView.findViewById(R.id.minitextViewU);
            haddress = itemView.findViewById(R.id.minitextViewV);
            hstate = itemView.findViewById(R.id.minitextViewW);
        }
    }
}
