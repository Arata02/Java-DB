package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author iwashita
 */
public class TestDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {


            //meiboデータベースへの接続
            String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";

            //コネクションの確立
            Connection con
                    = DriverManager.getConnection(driverUrl, "db", "db");

            //ステートメントの作成
            Statement stmt = con.createStatement();

            //実行するSQL文を記述
            String sql = "select * from T_TEST";

            //SQLを実行してResultSetの形式で結果を取得
            ResultSet rs = stmt.executeQuery(sql);

            //取得したレコードを一つずつ処理
            while (rs.next()) {
                String result = "";
                result += rs.getInt("id");
                result += ":" + rs.getString("name");
                System.out.println(result);
            }
            //メモリの開放
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
