package com.sqlserver.appointment;

import com.sqlserver.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItemAppointment {

    Connection connect;
    String ConnectionResult = "";
    Boolean isSuucess = false;

    public List<Map<String,String>> getListAppointment()
    {
        List<Map<String,String>> data = null;
        data = new ArrayList<Map<String,String>>();
        try{
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.CONN();
            if(connect!=null)
            {
                String query = "select * from прием";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next())
                {
                    Map<String,String> dtname = new HashMap<String,String>();
                    dtname.put("idAppointment", rs.getString("id_приема"));
                    dtname.put("Date", rs.getString("дата_приема"));
                    dtname.put("S_appoint", rs.getString("начало_приема"));
                    dtname.put("E_appoint", rs.getString("конец_приема"));
                    dtname.put("CabinetA", rs.getString("кабинет"));
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
