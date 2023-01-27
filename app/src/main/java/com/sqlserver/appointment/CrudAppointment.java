package com.sqlserver.appointment;

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

public class CrudAppointment extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crud_appointment);

        TextView id = (TextView) findViewById(R.id.appointment_id);
        TextView date = (TextView) findViewById(R.id.appointment_date);
        TextView s_appoint = (TextView) findViewById(R.id.appointment_s_appoint);
        TextView e_appoint = (TextView) findViewById(R.id.appointment_e_appoint);
        TextView cabinet_a = (TextView) findViewById(R.id.appointment_cabinet);

        ImageButton btnGet = (ImageButton) findViewById(R.id.btnGetA);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAddA);
        ImageButton btnUpdate = (ImageButton) findViewById(R.id.btnUpdateA);
        ImageButton btnDelete = (ImageButton) findViewById(R.id.btnDeleteA);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.CONN();
                    if (connect != null) {
                        String sqlGet = "Select * from прием where id_приема = '" + id.getText().toString() + "'";

                        Statement st = connect.createStatement();
                        ResultSet rs = st.executeQuery(sqlGet);
                        //st.executeUpdate(sqlGet);
                        Log.d("!!!", sqlGet);

                        while (rs.next())
                        {
                            date.setText(rs.getString(2));
                            s_appoint.setText(rs.getString(3));
                            e_appoint.setText(rs.getString(4));
                            cabinet_a.setText(rs.getString(5));
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
                        String sqlInsert = "Insert into прием values ('" +
                                id.getText().toString() + "','" +
                                date.getText().toString() + "','" +
                                s_appoint.getText().toString() + "','" +
                                e_appoint.getText().toString() + "','" +
                                cabinet_a.getText().toString() + "')";

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
                        String sqlUpdate = "Update прием set дата_приема = '" +
                                date.getText().toString() + "', начало_приема = '" +
                                s_appoint.getText().toString() + "', конец_приема = '" +
                                e_appoint.getText().toString() + "', кабинет = '" +
                                cabinet_a.getText().toString() + "' where id_приема = '" + id.getText().toString() + "'";

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
                            exception.getMessage(), Toast.LENGTH_SHORT);
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
                        String sqlDelete = "Delete from прием where id_приема = '" + id.getText().toString() + "'";

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
                            exception.getMessage(), Toast.LENGTH_SHORT);
                    toa.show();
                }

            }
        });
    }
}
