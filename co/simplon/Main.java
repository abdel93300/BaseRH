package co.simplon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class Main {

    static String databaseUrl = "jdbc:oracle:thin:system/root@localhost:1521:XE";

    static String requeteSql = "SELECT * FROM HR.COUNTRIES";

    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new OracleDriver());

        Connection connexion = DriverManager.getConnection(databaseUrl);
        Statement requete = connexion.createStatement();
        ResultSet resultat = requete.executeQuery(requeteSql);
        int noVille =0;
        while (resultat.next()) {
        	noVille=resultat.getRow();
            String nom = resultat.getString("COUNTRY_NAME");
            System.out.println("Nom pays n° : "+noVille+" ==> " +nom);
           }
        resultat.close();
        requete.close();
        connexion.close();
    }
}
