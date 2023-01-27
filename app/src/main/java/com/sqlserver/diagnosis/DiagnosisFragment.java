package com.sqlserver.diagnosis;

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
import com.sqlserver.department.ListItemDepartment;
import com.sqlserver.document.CrudDocument;
import com.sqlserver.document.ListItemDocument;

import java.sql.Connection;
import java.util.List;
import java.util.Map;


public class DiagnosisFragment extends Fragment {

    Connection connect;
    String ConnectionResult = "";
    SimpleAdapter adapter;

    public void onStart() {
        super.onStart();
        ListView listView = (ListView) getActivity().findViewById(R.id.listViewDiagnosis);

        List<Map<String,String>> MyDataList = null;
        ListItemDiagnosis MyData = new ListItemDiagnosis();
        MyDataList = MyData.getListDiagnosis();

        String[] Fromw = {"idDiagnosis","Detail"};
        int[] Tow = {R.id.idDiagnosis,R.id.DetailDiagnosis};
        adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_diagnosis, Fromw, Tow);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_diagnosis, container, false);

//        Button getData = (Button) view.findViewById(R.id.getDataDia);
//        getData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ListView listView = (ListView) getActivity().findViewById(R.id.listViewDiagnosis);
//
//                List<Map<String,String>> MyDataList = null;
//                ListItemDiagnosis MyData = new ListItemDiagnosis();
//                MyDataList = MyData.getListDiagnosis();
//
//                String[] Fromw = {"idDiagnosis","Detail"};
//                int[] Tow = {R.id.idDiagnosis,R.id.DetailDiagnosis};
//                adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_diagnosis, Fromw, Tow);
//                listView.setAdapter(adapter);
//            }
//        });

        Button btnEdit = (Button) view.findViewById(R.id.btnEditDia);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CrudDiagnosis.class);
                startActivity(intent);
            }
        });

        return view;
    }
}