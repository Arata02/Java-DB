package en05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class Kadai05_5 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";

			Connection con
					= DriverManager.getConnection(driverUrl, "db", "db");

			Statement stmt = con.createStatement();

			String sql = "select * from T_TWEET where tweetdate > 2019/10/28";

			ResultSet rs = stmt.executeQuery(sql);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -10);
			Timestamp tm = new Timestamp(cal.getTimeInMillis());

			while(rs.next()) {
				String result = "";
				result += rs.getString("number") + ":";
				result += rs.getString("id") + ":";
				result += rs.getString("tweet") + ":";
				result += tm;
				System.out.println(result);
			}

			rs.close();
			stmt.close();
			con.close();
		} catch (NumberFormatException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
