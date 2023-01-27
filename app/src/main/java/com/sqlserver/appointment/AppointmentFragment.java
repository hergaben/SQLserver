package com.sqlserver.appointment;

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


public class AppointmentFragment extends Fragment {

    Connection connect;
    String ConnectionResult = "";
    SimpleAdapter adapter;

    public void onStart() {
        super.onStart();
        ListView listView = (ListView) getActivity().findViewById(R.id.listViewAppointment);

        List<Map<String,String>> MyDataList = null;
        ListItemAppointment MyData = new ListItemAppointment();
        MyDataList = MyData.getListAppointment();

        String[] Fromw = {"idAppointment","Date","S_appoint","E_appoint", "CabinetA"};
        int[] Tow = {R.id.idAppointment,R.id.DateA,R.id.S_appoint,R.id.E_appoint,R.id.CabinetA};
        adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_appointment, Fromw, Tow);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_appointment, container, false);

//        Button getData = (Button) view.findViewById(R.id.getDataA);
//        getData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ListView listView = (ListView) getActivity().findViewById(R.id.listViewAppointment);
//
//                List<Map<String,String>> MyDataList = null;
//                ListItemAppointment MyData = new ListItemAppointment();
//                MyDataList = MyData.getListAppointment();
//
//                String[] Fromw = {"idAppointment","Date","S_appoint","E_appoint"};
//                int[] Tow = {R.id.idAppointment,R.id.DateA,R.id.S_appoint,R.id.E_appoint};
//                adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_appointment, Fromw, Tow);
//                listView.setAdapter(adapter);
//            }
//        });

        Button btnEdit = (Button) view.findViewById(R.id.btnEditA);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CrudAppointment.class);
                startActivity(intent);
            }
        });

        return view;
    }
}