package com.example.dbapp;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

@Component
public class DB_Conn {
    public Connection connection;

    public DB_Conn() throws SQLException {
        getConnection();
        createTable();
    }

    public Connection getConnection() throws SQLException {
        if(connection==null){
           connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","Shaik500@#");
        }
        return connection;
    }
    public void createTable() throws SQLException {
        String sql="create table if not exists student_info(id INT primary key auto_increment,age INT,name VARCHAR(30))";
        Statement st=connection.createStatement();
        st.execute(sql);
    }

    public void insert_info(Student s) throws SQLException {
        String sql="insert into student_info(age,name) values("+s.getAge()+",'"+s.getName()+"')";
        Statement st=connection.createStatement();
        st.executeUpdate(sql);
    }

    public void getAllStudents() throws SQLException {
        String sql="select * from student_info";
        Statement st = connection.createStatement();
        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){
            String name=rs.getString("name");
            String age=rs.getString("age");
            String id=rs.getString("id");

            System.out.println(name+" "+age+" "+id);
        }


    }
}
