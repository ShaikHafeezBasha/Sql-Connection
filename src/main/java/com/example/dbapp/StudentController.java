package com.example.dbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class StudentController {

    @Autowired
    DB_Conn db_conn;

    @PostMapping("/insert_info")
    public void insertinfo(@RequestBody Student s) throws SQLException {
        db_conn.insert_info(s);
        return;
    }

    @GetMapping("/info")
    public void getinfo() throws SQLException {
        db_conn.getAllStudents();
    }



}
