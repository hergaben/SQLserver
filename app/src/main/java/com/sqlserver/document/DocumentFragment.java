package com.sqlserver.document;

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


public class DocumentFragment extends Fragment {

    Connection connect;
    String ConnectionResult = "";
    SimpleAdapter adapter;

    public void onStart() {
        super.onStart();
        ListView listView = (ListView) getActivity().findViewById(R.id.listViewDocument);

        List<Map<String,String>> MyDataList = null;
        ListItemDocument MyData = new ListItemDocument();
        MyDataList = MyData.getListDocument();

        String[] Fromw = {"idDocument","Name","Birth","Address", "Policy"};
        int[] Tow = {R.id.idDocument,R.id.NameDocument,R.id.BirthDocument,R.id.AddressDocument, R.id.PolicyDocument};
        adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_document, Fromw, Tow);
        listView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_document, container, false);

//        Button getData = (Button) view.findViewById(R.id.getDataDoc);
//        getData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ListView listView = (ListView) getActivity().findViewById(R.id.listViewDocument);
//
//                List<Map<String,String>> MyDataList = null;
//                ListItemDocument MyData = new ListItemDocument();
//                MyDataList = MyData.getListDocument();
//
//                String[] Fromw = {"idDocument","Name","Birth","Address", "Policy"};
//                int[] Tow = {R.id.idDocument,R.id.NameDocument,R.id.BirthDocument,R.id.AddressDocument, R.id.PolicyDocument};
//                adapter = new SimpleAdapter(getActivity(), MyDataList, R.layout.list_document, Fromw, Tow);
//                listView.setAdapter(adapter);
//            }
//        });

        Button btnEdit = (Button) view.findViewById(R.id.btnEditDoc);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CrudDocument.class);
                startActivity(intent);
            }
        });

        return view;
    }
}