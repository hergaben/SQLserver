package com.sqlserver.doctor;

import com.sqlserver.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItemDoctor {

    Connection connect;
    String ConnectionResult = "";
    Boolean isSuucess = false;

    public List<Map<String,String>>getListDoctor()
    {
        List<Map<String,String>> data = null;
        data = new ArrayList<Map<String,String>>();
        try{
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.CONN();
            if(connect!=null)
            {
                String query = "select * from врач";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next())
                {
                    Map<String,String> dtname = new HashMap<String,String>();
                    dtname.put("idDoctor", rs.getString("id_врача"));
                    dtname.put("NameDoctor", rs.getString("ФИО"));
                    dtname.put("Speciality", rs.getString("специальность"));
                    dtname.put("Phone", rs.getString("телефон"));
                    data.add(dtname);
                }
                ConnectionResult = "Success";
                isSuucess = true;
                //!!! Обрыв !!!
                connect.close();
            }
            else{
                ConnectionResult = "Failed";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }
}














