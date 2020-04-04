package untitled;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Class2 {

    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {

            String url = "jdbc:mysql://195.19.44.146:3306/user5?useUnicode=true&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "user5", "user5");
            System.out.println("Connected...!");

            statement = conn.createStatement();
            resultSet = statement.executeQuery("select * from Artisty JOIN Seans ON Seans_nomer = Seans.nomer WHERE Seans.nomer=1");
            int Seans_nomer = 0;
            int Artisty_nomer = 0;
            while (resultSet.next()) {
                Seans_nomer = resultSet.getInt("Seans_nomer");
                Artisty_nomer = resultSet.getInt("kod");
                System.out.println("Номер сеанса " + resultSet.getInt("Seans_nomer") + "; Артисты " + resultSet.getInt("kod"));
            }
           // statement = conn.createStatement();
            resultSet = statement.executeQuery("select * from dannye WHERE seans_nomer=1");
            String dannye_nomer = "";
            while (resultSet.next()) {
                dannye_nomer = resultSet.getString("data_pokaza");
                System.out.println("Дата " + resultSet.getString("data_pokaza"));
            }
            resultSet = statement.executeQuery("select * from Seans WHERE nomer=1");
            int vremya1 = 0;
            int dlina = 0;
            while (resultSet.next()) {
                vremya1 = resultSet.getInt("vremya_nachala");
                dlina = resultSet.getInt("dlina");
                System.out.println("Время начала " + resultSet.getInt("vremya_nachala") + "; Продолжительность " + resultSet.getInt("dlina"));
            }
            resultSet = statement.executeQuery("select * from Spektakl WHERE nomer=1");
            String janr = "";
            String kolichestvomest = "";
            while (resultSet.next()) {
                janr = resultSet.getString("janr");
                kolichestvomest = resultSet.getString("kolichestvomest");
                System.out.println("Жанр " + resultSet.getString("janr") + "; Количество мест " + resultSet.getString("kolichestvomest"));
            }
            resultSet = statement.executeQuery("select * from Organizator WHERE kod=1");
            String nazvanie = "";
            while (resultSet.next()) {
                nazvanie = resultSet.getString("nazvanie");
                System.out.println("Организатор концерта " + resultSet.getString("nazvanie"));
            }
            resultSet = statement.executeQuery("select * from mesto WHERE kod=1");
            String adress = "";
            String gorod = "";
            while (resultSet.next()) {
                adress = resultSet.getString("adress");
                gorod = resultSet.getString("gorod");
                System.out.println("Место проведения " + resultSet.getString("gorod") + " " + resultSet.getString("adress"));
            }
            
        } catch (Exception e) {

        }

    }
}