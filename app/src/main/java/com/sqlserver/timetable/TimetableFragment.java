package com.sqlserver.timetable;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.sqlserver.R;
import com.sqlserver.polyclinic.CrudPolyclinic;
import com.sqlserver.polyclinic.ListItemPolyclinic;

import java.sql.Connection;
import java.util.List;
import java.util.Map;


public class TimetableFragment extends Fragment {

    Connection connect;
    String ConnectionResult = "";
    SimpleAdapter adapter;

    public void onStart() {
        super.onStart();
        ListView listView = (ListView) getActivity().findViewById(R.id.listViewTimetable);

        List<Map<String,String>> MyDataList = null;
        ListItemTimetable MyData = new ListItemTimetable();
        MyDataList = MyData.getListTimetable();

        String[] Fromw = {"idTimetable","Date","Start_work","End_work"};
        int[] Tow = {R.id.idTimetable,R.id.Date,R.id.S_work,R.id.E_work};
        adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_timetable, Fromw, Tow);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_timetable, container, false);

//        Button getData = (Button) view.findViewById(R.id.getDataT);
//        getData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ListView listView = (ListView) getActivity().findViewById(R.id.listViewTimetable);
//
//                List<Map<String,String>> MyDataList = null;
//                ListItemTimetable MyData = new ListItemTimetable();
//                MyDataList = MyData.getListTimetable();
//
//                String[] Fromw = {"idTimetable","Date","Start_work","End_work"};
//                int[] Tow = {R.id.idTimetable,R.id.Date,R.id.S_work,R.id.E_work};
//                adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_timetable, Fromw, Tow);
//                listView.setAdapter(adapter);
//            }
//        });

        Button btnEdit = (Button) view.findViewById(R.id.btnEditT);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CrudTimetable.class);
                startActivity(intent);
            }
        });

        return  view;
    }
}