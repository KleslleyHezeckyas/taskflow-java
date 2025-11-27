package app;

import java.sql.Connection;
import dao.ConnectionFactory;


public class TestConnection {
    public static void main(String[] args) {

        try {
            Connection conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Falha ao conectar:");
            e.printStackTrace();
        }
    }
}

