package com.sqlserver.patient;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sqlserver.ConnectionHelper;
import com.sqlserver.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CrudPatient extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crud_patient);

        TextView id = (TextView) findViewById(R.id.patient_id);
        TextView name = (TextView) findViewById(R.id.patient_name);
        TextView phone = (TextView) findViewById(R.id.patient_phone);
        TextView address = (TextView) findViewById(R.id.patient_address);
        TextView appointment = (TextView) findViewById(R.id.patient_appoint);
        TextView document = (TextView) findViewById(R.id.patient_document);

        ImageButton btnGet = (ImageButton) findViewById(R.id.btnGetPat);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAddPat);
        ImageButton btnUpdate = (ImageButton) findViewById(R.id.btnUpdatePat);
        ImageButton btnDelete = (ImageButton) findViewById(R.id.btnDeletePat);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.CONN();
                    if (connect != null) {
                        String sqlGet = "Select * from пациент where id_пациента = '" + id.getText().toString() + "'";

                        Statement st = connect.createStatement();
                        ResultSet rs = st.executeQuery(sqlGet);
                        //st.executeUpdate(sqlGet);
                        Log.d("!!!", sqlGet);

                        while (rs.next())
                        {
                            name.setText(rs.getString(2));
                            phone.setText(rs.getString(3));
                            address.setText(rs.getString(4));
                            appointment.setText(rs.getString(5));
                            document.setText(rs.getString(6));
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Данные успешно получены!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                }
                catch (Exception exception) {
                    Log.e("Error", exception.getMessage());
                    Toast toa = Toast.makeText(getApplicationContext(),
                            exception.getMessage(), Toast.LENGTH_LONG);
                    toa.show();
                }

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.CONN();
                    if (connect != null) {
                        String sqlInsert = "Insert into пациент values ('" +
                                id.getText().toString() + "','" +
                                name.getText().toString() + "','" +
                                phone.getText().toString() + "','" +
                                address.getText().toString() + "','" +
                                appointment.getText().toString() + "','" +
                                document.getText().toString() + "')";

                        Statement st = connect.createStatement();
                        //ResultSet rs = st.executeQuery(sqlInsert);
                        st.executeUpdate(sqlInsert);
                        Log.d("!!!", sqlInsert);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Данные успешно добавлены!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                catch (Exception exception) {
                    Log.e("Error", exception.getMessage());
                    Toast toa = Toast.makeText(getApplicationContext(),
                            exception.getMessage(), Toast.LENGTH_LONG);
                    toa.show();
                }

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.CONN();
                    if (connect != null) {
                        String sqlUpdate = "Update пациент set ФИО = '" +
                                name.getText().toString() + "', телефон = '" +
                                phone.getText().toString() + "', адрес = '" +
                                address.getText().toString() + "', прием_id_приема = '" +
                                appointment.getText().toString() + "', документ_id_документа = '" +
                                document.getText().toString() + "' where id_пациента = '" + id.getText().toString() + "'";

                        Statement st = connect.createStatement();
                        //ResultSet rs = st.executeQuery(sqlUpdate);
                        st.executeUpdate(sqlUpdate);
                        Log.d("!!!", sqlUpdate);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Данные успешно обновлены!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                catch (Exception exception) {
                    Log.e("Error", exception.getMessage());
                    Toast toa = Toast.makeText(getApplicationContext(),
                            exception.getMessage(), Toast.LENGTH_LONG);
                    toa.show();
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.CONN();
                    if (connect != null) {
                        String sqlDelete = "Delete from пациент where id_пациента = '" + id.getText().toString() + "'";

                        Statement st = connect.createStatement();
                        //ResultSet rs = st.executeQuery(sqlDelete);
                        st.executeUpdate(sqlDelete);
                        Log.d("!!!", sqlDelete);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Данные удалены!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                catch (Exception exception) {
                    Log.e("Error", exception.getMessage());
                    Toast toa = Toast.makeText(getApplicationContext(),
                            exception.getMessage(), Toast.LENGTH_LONG);
                    toa.show();
                }

            }
        });
    }
}
