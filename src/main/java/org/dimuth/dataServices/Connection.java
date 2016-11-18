package org.dimuth.dataServices;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by dimuth on 10/11/16.
 */
public class Connection {
    static java.sql.Connection con=null ;

    private static void setConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmd", "root", "9900");
        }
        catch (Exception e){
            e.printStackTrace();

        }
        System.out.println("Connection Object created");

    }
    private static java.sql.Connection getConnection(){
        if(con==null){
            setConnection();
        }
        return con;

    }
    public static double getMax(String axis) {
        try {
            String value=null;
            if(axis.equals("X"))value="(x1+x2+x3+x4)/4.0";
            else if(axis.equals(("Y")))value="(y1+y2+y3+y4)/4.0";
            java.sql.Connection connection = getConnection();

            Statement stmt = connection.createStatement();
            String query ="select max("+value+") from sensor_map";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            return rs.getDouble(1);

        } catch (SQLException e) {
            e.printStackTrace();

            return 0;
        }


    }


    public static double getMin(String axis) {
        try {
            String value=null;
            if(axis.equals("X"))value="(x1+x2+x3+x4)/4.0";
            else if(axis.equals(("Y")))value="(y1+y2+y3+y4)/4.0";
            java.sql.Connection connection = getConnection();

            Statement stmt = connection.createStatement();
            String query ="select min("+value+") from sensor_map";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            return rs.getDouble(1);

        } catch (SQLException e) {
            e.printStackTrace();

            return 0;
        }


    }



    public static ArrayList<String> DetailsList(String name){
        ArrayList<String> sensorList = new ArrayList<String>();
        String value ="*";
        if(name.equals("X"))value="(x1+x2+x3+x4)/4.0";
        else if(name.equals(("Y")))value="(y1+y2+y3+y4)/4.0";
        else if(name.equals("ID"))value="sensor_id";
        try {


            java.sql.Connection connection = getConnection();

            Statement stmt = connection.createStatement();
            String query ="SELECT "+value+" from sensor_map";

            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                String s = rs.getString(1);
                sensorList.add(s);


            }


            rs.next();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return sensorList;
    }



}
