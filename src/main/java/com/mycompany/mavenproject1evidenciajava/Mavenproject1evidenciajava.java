package com.mycompany.mavenproject1evidenciajava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

 public class Mavenproject1evidenciajava {
    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/jdbctest";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement =conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            //Insercion de datos//
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'yuly');");
            System.out.println("");
            
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //Actualizacion de datos//
             statement.execute("UPDATE `usuarios` SET `nombre` = 'harold' WHERE `usuarios`.`id` = 1;");
            System.out.println("");
            
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //Eliminacion de datos//
             statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 2");
            System.out.println("");
            
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Mavenproject1evidenciajava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
