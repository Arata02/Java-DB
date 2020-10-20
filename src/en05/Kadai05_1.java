package en05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Kadai05_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";

			Connection con
					= DriverManager.getConnection(driverUrl, "db", "db");

			Statement stmt = con.createStatement();

			String sql = "create table T_TWEET (number integer generated always as identity primary key, id varchar(15), text varchar(140) ,retweet integer )";

			int count = stmt.executeUpdate(sql);
			System.out.println(count + "件のレコードを追加しました");

			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}


