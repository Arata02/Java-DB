package en05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Kadai05_2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";

			Connection con = DriverManager.getConnection(driverUrl, "db", "db");

			String sql = "insert into T_TWEET (id, text, retweet) values (?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "abc");
			ps.setString(2, "できた！");
			ps.setInt(3, 5);

			int count = ps.executeUpdate();
			System.out.println(count + "件のレコードを追加しました");

			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
