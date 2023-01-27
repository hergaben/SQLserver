package com.sqlserver.polyclinic;

import android.os.Bundle;

import com.sqlserver.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItemPolyclinic {

    Connection connect;
    String ConnectionResult = "";
    Boolean isSuucess = false;

    public List<Map<String,String>>getListPolyclinic()
    {
        List<Map<String,String>> data = null;
        data = new ArrayList<Map<String,String>>();
        try{
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.CONN();
            if(connect!=null)
            {
                String query = "select * from поликлиника";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next())
                {
                    Map<String,String> dtname = new HashMap<String,String>();
                    dtname.put("idPolyclinic", rs.getString("id_поликлиники"));
                    dtname.put("NamePolyclinic", rs.getString("название_поликлиники"));
                    dtname.put("Address", rs.getString("адрес"));
                    dtname.put("Details", rs.getString("детали"));
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
