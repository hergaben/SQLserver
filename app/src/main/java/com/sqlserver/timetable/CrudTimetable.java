package com.sqlserver.timetable;

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

public class CrudTimetable extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crud_timetable);

        TextView id = (TextView) findViewById(R.id.timetable_id);
        TextView date = (TextView) findViewById(R.id.timetable_date);
        TextView s_work = (TextView) findViewById(R.id.timetable_s_work);
        TextView e_work = (TextView) findViewById(R.id.timetable_e_work);
        TextView poly = (TextView) findViewById(R.id.timetable_poly);
        TextView department = (TextView) findViewById(R.id.timetable_dep);

        ImageButton btnGet = (ImageButton) findViewById(R.id.btnGetT);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAddT);
        ImageButton btnUpdate = (ImageButton) findViewById(R.id.btnUpdateT);
        ImageButton btnDelete = (ImageButton) findViewById(R.id.btnDeleteT);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.CONN();
                    if (connect != null) {
                        String sqlGet = "Select * from расписание where id_расписания = '" + id.getText().toString() + "'";

                        Statement st = connect.createStatement();
                        ResultSet rs = st.executeQuery(sqlGet);
                        //st.executeUpdate(sqlGet);
                        Log.d("!!!", sqlGet);

                        while (rs.next())
                        {
                            date.setText(rs.getString(2));
                            s_work.setText(rs.getString(3));
                            e_work.setText(rs.getString(4));
                            poly.setText(rs.getString(5));
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
                        String sqlInsert = "Insert into расписание values ('" +
                                id.getText().toString() + "','" +
                                date.getText().toString() + "','" +
                                s_work.getText().toString() + "','" +
                                e_work.getText().toString() + "','" +
                                department.getText().toString() + "','" +
                                poly.getText().toString() + "')";

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
                        String sqlUpdate = "Update расписание set дата = '" +
                                date.getText().toString() + "', начало_работы = '" +
                                s_work.getText().toString() + "', конец_работы = '" +
                                e_work.getText().toString() + "', отделение_id_отделения = '" +
                                department.getText().toString() + "', отделение_поликлиника_id_поликлиники = '" +
                                poly.getText().toString() + "' where id_расписания = '" + id.getText().toString() + "'";

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
                        String sqlDelete = "Delete from расписание where id_расписания = '" + id.getText().toString() + "'";

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
