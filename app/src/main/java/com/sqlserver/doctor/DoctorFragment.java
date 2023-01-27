package com.sqlserver.doctor;

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
import com.sqlserver.diagnosis.ListItemDiagnosis;

import java.sql.Connection;
import java.util.List;
import java.util.Map;


public class DoctorFragment extends Fragment {

    Connection connect;
    String ConnectionResult = "";
    SimpleAdapter adapter;

    public void onStart() {
        super.onStart();
        ListView listView = (ListView) getActivity().findViewById(R.id.listViewDoctor);

        List<Map<String,String>> MyDataList = null;
        ListItemDoctor MyData = new ListItemDoctor();
        MyDataList = MyData.getListDoctor();

        String[] Fromw = {"idDoctor","NameDoctor","Speciality","Phone"};
        int[] Tow = {R.id.idDoctor,R.id.NameDoctor,R.id.Speciality,R.id.Phone};
        adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_doctor, Fromw, Tow);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_doctor, container, false);

//        Button getData = (Button) view.findViewById(R.id.getDataD);
//        getData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ListView listView = (ListView) getActivity().findViewById(R.id.listViewDoctor);
//
//                List<Map<String,String>> MyDataList = null;
//                ListItemDoctor MyData = new ListItemDoctor();
//                MyDataList = MyData.getListDoctor();
//
//                String[] Fromw = {"idDoctor","NameDoctor","Speciality","Phone"};
//                int[] Tow = {R.id.idDoctor,R.id.NameDoctor,R.id.Speciality,R.id.Phone};
//                adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_doctor, Fromw, Tow);
//                listView.setAdapter(adapter);
//            }
//        });

        Button btnEdit = (Button) view.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CrudDoctor.class);
                startActivity(intent);
            }
        });

        return view;
    }
}