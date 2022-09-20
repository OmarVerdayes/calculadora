package back;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoOperaciones {
    public boolean saveoperacion(String nombre,String num1,String num2, String resultado){

        boolean result = false;

        try
                (Connection con  = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement("insert into operaciones(nombre,num1,num2,resultado,fecha)values(?,?,?,?,time(NOW()));");
                )
        {
            pstm.setString(1, nombre);
            pstm.setString(2, num1);
            pstm.setString(3, num2);
            pstm.setString(4, resultado);
            result = pstm.executeUpdate() == 1;
            System.out.println("guardado");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("no guardado");
        }

        return result;
    }

    public List<BeanOperaciones> listOperaciones() {

        List<BeanOperaciones>  listoperaciones = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from operaciones");
            while (rs.next()){

                System.out.print("|"+rs.getString("nombre")+" |");
                System.out.print(rs.getString("num1")+" |");
                System.out.print(rs.getString("num2")+" |");
                System.out.print(rs.getString("resultado")+" |");
                System.out.print(rs.getString("fecha")+" |");
                System.out.println();

            };

            rs.close();
            connection.close();
            statement.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return listoperaciones;
    }
}
