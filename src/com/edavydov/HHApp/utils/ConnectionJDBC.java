package com.edavydov.HHApp.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static Connection getConnection(){
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("jdbc/hr");
            return ds.getConnection();
        } catch (SQLException | NamingException e){
            e.printStackTrace();
        }
        return null;
    }
}
