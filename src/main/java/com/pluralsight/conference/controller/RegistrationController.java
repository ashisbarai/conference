/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Registration;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ashis Barai
 */
@Controller
public class RegistrationController {
    @Autowired
    private Environment env;
    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration") Registration registration){
        return "registration";
    }
    @PostMapping("registration")
    public String addRegistration(@ModelAttribute("registration") Registration registration) throws SQLException {
        System.out.println("Registration: " + registration.getName());

        OracleDataSource ods = new OracleDataSource();
        ods.setURL(env.getProperty("spring.datasource.url")); // jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
        ods.setUser(env.getProperty("spring.datasource.username"));
        ods.setPassword(env.getProperty("spring.datasource.password"));
        Connection conn = ods.getConnection();

        PreparedStatement stmt = conn.prepareStatement("select * from persons");
        ResultSet rslt = stmt.executeQuery();
        while (rslt.next()) {
            System.out.println(rslt.getString(1));
        }
        return "registration";
    }
}
