package com.sqlserver.department;

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

public class CrudDepartment extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crud_department);

        TextView id = (TextView) findViewById(R.id.department_id);
        TextView name = (TextView) findViewById(R.id.department_name);
        TextView poly = (TextView) findViewById(R.id.department_pol);

        ImageButton btnGet = (ImageButton) findViewById(R.id.btnGetDep);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAddDep);
        ImageButton btnUpdate = (ImageButton) findViewById(R.id.btnUpdateDep);
        ImageButton btnDelete = (ImageButton) findViewById(R.id.btnDeleteDep);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.CONN();
                    if (connect != null) {
                        String sqlGet = "Select * from отделение where id_отделения = '" + id.getText().toString() + "'";

                        Statement st = connect.createStatement();
                        ResultSet rs = st.executeQuery(sqlGet);
                        //st.executeUpdate(sqlGet);
                        Log.d("!!!", sqlGet);

                        while (rs.next())
                        {
                            name.setText(rs.getString(2));
                            poly.setText(rs.getString(3));
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
                        String sqlInsert = "Insert into отделение values ('" +
                                id.getText().toString() + "','" +
                                name.getText().toString() + "','" +
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
                        String sqlUpdate = "Update отделение set название_отделения = '" +
                                name.getText().toString() + "', поликлиника_id_поликлиники = '" +
                                poly.getText().toString() + "' where id_отделения = '" + id.getText().toString() + "'";

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
                        String sqlDelete = "Delete from отделение where id_отделения = '" + id.getText().toString() + "'";

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
