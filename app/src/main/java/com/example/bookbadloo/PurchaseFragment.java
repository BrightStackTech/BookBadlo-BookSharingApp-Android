package com.example.bookbadloo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PurchaseFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerHospitalsAdapter adapter;
    ArrayList<HospitalsModel> arrayList = new ArrayList<>();

    public PurchaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_purchase, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = requireView().findViewById(R.id.HospitalsRecycler);
        setData();
        prepareRecyclerView();
        // Inflate the layout for this fragment
    }

    public void setData(){
        arrayList.add(new HospitalsModel(R.drawable.angels_demons, "Angels Demons", "Yash Agrawal", "199", "1111111111", ""));
        arrayList.add(new HospitalsModel(R.drawable.breaking_dawn, "Breaking Dawn","Bhuvanesh Angane", "299", "1222222222", ""));
        arrayList.add(new HospitalsModel(R.drawable.diary_of_wimpy_kid_double_down, "Diary of Wimpy kid double down","Preeth Kothari", "399", "1333333333", ""));
        arrayList.add(new HospitalsModel(R.drawable.diary_of_wimpy_kid_the_getaway, "Diary of Wimpy kid the getaway","Sachin Kumar", "499", "1444444444", ""));
        arrayList.add(new HospitalsModel(R.drawable.eclipse, "Eclipse","Yash Agrawal", "199", "1555555555", ""));
        arrayList.add(new HospitalsModel(R.drawable.harry_potter_and_the_chamber_of_secrets, "Harry Potter and the chamber of secrets","Bhuvanesh Angane", "299", "1666666666", ""));
        arrayList.add(new HospitalsModel(R.drawable.harry_potter_and_the_cursed_child, "Harry Potter the cursed child","Preeth Kothari", "399", "1777777777", ""));
        arrayList.add(new HospitalsModel(R.drawable.harry_potter_and_the_deathly_hallows, "Harry Potter and the deathly hallows","Sachin Kumar", "499", "1888888888", ""));
        arrayList.add(new HospitalsModel(R.drawable.harry_potter_and_the_goblet_fire, "Harry Potter and the goblet fire","Yash Agrawal", "199", "1999999999", ""));
        arrayList.add(new HospitalsModel(R.drawable.harry_potter_and_the_half_blood_prince, "Harry Potter and Half blood prince","Bhuvanesh Angane", "299", "2111111111", ""));
        arrayList.add(new HospitalsModel(R.drawable.harry_potter_and_the_order_of_the_phoenix, "Harry Potter and the order of the Phoenix","Preeth Kothari", "399", "2222222222", ""));
        arrayList.add(new HospitalsModel(R.drawable.lotr, "Lotr","Sachin Kumar", "499", "2333333333", ""));
        arrayList.add(new HospitalsModel(R.drawable.midnightsun, "Midnightsun","Yash Agrawal", "199", "2444444444", ""));
        arrayList.add(new HospitalsModel(R.drawable.new_moon, "New Moon","Bhuvanesh Angane", "299", "2555555555", ""));
        arrayList.add(new HospitalsModel(R.drawable.philosophers_stone, "Philosopers Stone","Preeth Kothari", "399", "2666666666", ""));
        arrayList.add(new HospitalsModel(R.drawable.the_book_of_lost_tails, "The Book of lost tails","Sachin Kumar", "499", "2777777777", ""));
        arrayList.add(new HospitalsModel(R.drawable.the_children_of_hurin, "The Children of Hurin","Yash Agrawal", "199", "2888888888", ""));
        arrayList.add(new HospitalsModel(R.drawable.the_da_vinci_code,"The Davinci code","Bhuvanesh Angane", "299", "2999999999", ""));
        arrayList.add(new HospitalsModel(R.drawable.the_two_towers, "The Two towers","Preeth Kothari", "399", "3111111111", ""));
        arrayList.add(new HospitalsModel(R.drawable.twilight, "Twilight","Yash Agrawal", "499", "3222222222", ""));
    }


    public void prepareRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        preAdapter();
    }

    public void preAdapter(){
        adapter = new RecyclerHospitalsAdapter(arrayList, getContext(), this::selectedUser);
        recyclerView.setAdapter(adapter);
    }

    public void selectedUser(HospitalsModel hospitalsModel) {
//        Toast.makeText(this, hospitalsModel.getHname(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getContext(), SelectedHospitalActivity.class).putExtra("data", hospitalsModel));
    }
}