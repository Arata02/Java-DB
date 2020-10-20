package kougi04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex42 {

	public static void main(String[] args) {


		try {
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\meibo;create=false";

			Connection con
					= DriverManager.getConnection(driverUrl, "db", "db");

			Statement stmt = con.createStatement();

			String sql = "select * from T_GAKUBU";

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				String result = "";
				result += rs.getInt("gakubu_id") + ":";
				result += rs.getString("gakubu_name");
				System.out.println(result);
			}

			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
