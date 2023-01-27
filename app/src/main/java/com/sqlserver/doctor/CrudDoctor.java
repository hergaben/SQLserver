package com.sqlserver.doctor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sqlserver.ConnectionHelper;
import com.sqlserver.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class CrudDoctor extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crud_doctor);

        TextView id = (TextView) findViewById(R.id.doctor_id);
        TextView name = (TextView) findViewById(R.id.doctor_name);
        TextView speciality = (TextView) findViewById(R.id.doctor_spec);
        TextView phone = (TextView) findViewById(R.id.doctor_phone);
        TextView table = (TextView) findViewById(R.id.id_table);
        TextView appointment = (TextView) findViewById(R.id.id_appointment);
        TextView poly = (TextView) findViewById(R.id.id_poly);
        TextView department = (TextView) findViewById(R.id.id_department);

        ImageButton btnGet = (ImageButton) findViewById(R.id.btnGet);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        ImageButton btnUpdate = (ImageButton) findViewById(R.id.btnUpdate);
        ImageButton btnDelete = (ImageButton) findViewById(R.id.btnDelete);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.CONN();
                    if (connect != null) {
                        String sqlGet = "Select * from врач where id_врача = '" + id.getText().toString() + "'";

                        Statement st = connect.createStatement();
                        ResultSet rs = st.executeQuery(sqlGet);
                        //st.executeUpdate(sqlGet);
                        Log.d("!!!", sqlGet);

                        while (rs.next())
                        {
                            name.setText(rs.getString(3));
                            speciality.setText(rs.getString(2));
                            phone.setText(rs.getString(4));
                            table.setText(rs.getString(5));
                            appointment.setText(rs.getString(8));
                            poly.setText(rs.getString(7));
                            department.setText(rs.getString(6));
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
                        String sqlInsert = "Insert into врач values ('" +
                                id.getText().toString() + "','" +
                                speciality.getText().toString() + "','" +
                                name.getText().toString() + "','" +
                                phone.getText().toString() + "','" +
                                table.getText().toString() + "','" +
                                department.getText().toString() + "','" +
                                poly.getText().toString() + "','" +
                                appointment.getText().toString() + "')";

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
                        String sqlUpdate = "Update врач set специальность = '" +
                                speciality.getText().toString() + "', ФИО = '" +
                                name.getText().toString() + "', телефон = '" +
                                phone.getText().toString() + "', расписание_id_расписания = '" +
                                table.getText().toString() + "', расписание_отделение_id_отделения = '" +
                                department.getText().toString() + "', расписание_отделение_поликлиника_id_поликлиники = '" +
                                poly.getText().toString() + "', прием_id_приема = '" +
                                appointment.getText().toString() + "' where id_врача = '" + id.getText().toString() + "'";

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
                        String sqlDelete = "Delete from врач where id_врача = '" + id.getText().toString() + "'";

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






















