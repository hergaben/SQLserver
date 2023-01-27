package com.sqlserver.polyclinic;

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
import com.sqlserver.patient.ListItemPatient;

import java.sql.Connection;
import java.util.List;
import java.util.Map;


public class PolyclinicFragment extends Fragment {

    Connection connect;
    String ConnectionResult = "";
    SimpleAdapter adapter;

    public void onStart() {
        super.onStart();
        ListView listView = (ListView) getActivity().findViewById(R.id.listViewPolyclinic);

        List<Map<String,String>> MyDataList = null;
        ListItemPolyclinic MyData = new ListItemPolyclinic();
        MyDataList = MyData.getListPolyclinic();

        String[] Fromw = {"idPolyclinic","NamePolyclinic","Address","Details"};
        int[] Tow = {R.id.idPolyclinic,R.id.NamePolyclinic,R.id.Address_pol,R.id.Details_pol};
        adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_polyclinic, Fromw, Tow);
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_polyclinic, container, false);

//        Button getData = (Button) view.findViewById(R.id.getData);
//        getData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ListView listView = (ListView) getActivity().findViewById(R.id.listViewPolyclinic);
//
//                List<Map<String,String>> MyDataList = null;
//                ListItemPolyclinic MyData = new ListItemPolyclinic();
//                MyDataList = MyData.getListPolyclinic();
//
//                String[] Fromw = {"idPolyclinic","NamePolyclinic","Address","Details"};
//                int[] Tow = {R.id.idPolyclinic,R.id.NamePolyclinic,R.id.Address,R.id.Details};
//                adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_polyclinic, Fromw, Tow);
//                listView.setAdapter(adapter);
//            }
//        });

        Button btnEdit = (Button) view.findViewById(R.id.btnEditP);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CrudPolyclinic.class);
                startActivity(intent);
            }
        });

        return view;
    }
}