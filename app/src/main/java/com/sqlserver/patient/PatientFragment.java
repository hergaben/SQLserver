package com.sqlserver.patient;

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

import java.sql.Connection;
import java.util.List;
import java.util.Map;


public class PatientFragment extends Fragment {

    Connection connect;
    String ConnectionResult = "";
    SimpleAdapter adapter;

    public void onStart() {
        super.onStart();
        ListView listView = (ListView) getActivity().findViewById(R.id.listViewPatient);

        List<Map<String,String>> MyDataList = null;
        ListItemPatient MyData = new ListItemPatient();
        MyDataList = MyData.getListPatient();

        String[] Fromw = {"idPatient","NamePatient","Phone","Address"};
        int[] Tow = {R.id.idPatient,R.id.NamePatient,R.id.Phone_p,R.id.Address_p};

        adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_patient, Fromw, Tow);
        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Intent intent = new Intent(getContext(), PatientPage.class);
//                intent.putExtra("image", MyData.getListPatient().get(i).get("idPatient"));
//                startActivity(intent);
//
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_patient, container, false);

//        Button getData = (Button) view.findViewById(R.id.getDataPat);
//        getData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ListView listView = (ListView) getActivity().findViewById(R.id.listViewPatient);
//
//                List<Map<String,String>> MyDataList = null;
//                ListItemPatient MyData = new ListItemPatient();
//                MyDataList = MyData.getListPatient();
//
//                String[] Fromw = {"idPatient","NamePatient","Phone","Address"};
//                int[] Tow = {R.id.idPatient,R.id.NamePatient,R.id.Phone,R.id.Address};
//                adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_patient, Fromw, Tow);
//                listView.setAdapter(adapter);
//            }
//        });

        Button btnEdit = (Button) view.findViewById(R.id.btnEditPat);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CrudPatient.class);
                startActivity(intent);
            }
        });

        return view;
    }
}