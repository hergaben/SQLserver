package com.sqlserver.department;

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
import com.sqlserver.appointment.ListItemAppointment;
import com.sqlserver.doctor.ListItemDoctor;
import com.sqlserver.polyclinic.CrudPolyclinic;

import java.sql.Connection;
import java.util.List;
import java.util.Map;


public class DepartmentFragment extends Fragment {

    Connection connect;
    String ConnectionResult = "";
    SimpleAdapter adapter;

    public void onStart() {
        super.onStart();
        ListView listView = (ListView) getActivity().findViewById(R.id.listViewDepartment);

        List<Map<String,String>> MyDataList = null;
        ListItemDepartment MyData = new ListItemDepartment();
        MyDataList = MyData.getListDepartment();

        String[] Fromw = {"idDepartment","NameDepartment"};
        int[] Tow = {R.id.idDepartment,R.id.NameDepartment};
        adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_department, Fromw, Tow);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_department, container, false);

//        Button getData = (Button) view.findViewById(R.id.getDataDep);
//        getData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ListView listView = (ListView) getActivity().findViewById(R.id.listViewDepartment);
//
//                List<Map<String,String>> MyDataList = null;
//                ListItemDepartment MyData = new ListItemDepartment();
//                MyDataList = MyData.getListDepartment();
//
//                String[] Fromw = {"idDepartment","NameDepartment"};
//                int[] Tow = {R.id.idDepartment,R.id.NameDepartment};
//                adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_department, Fromw, Tow);
//                listView.setAdapter(adapter);
//            }
//        });

        Button btnEdit = (Button) view.findViewById(R.id.btnEditDep);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CrudDepartment.class);
                startActivity(intent);
            }
        });

        return view;
    }
}