package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword())) {
            System.out.println("Conectado con suceso!");


            //Creamos la sentencia sql que es para ordenar los empleados por su salario de forma descendente
            String sql = "SELECT NOMBRE, SALARIO FROM EMPLEADO" +
                    " ORDER BY SALARIO DESC ";
            //La ejecutamos
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = (rs.getString("nombre"));
                double salario = (rs.getInt("salario"));
                System.out.println(nombre+"  "+salario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}