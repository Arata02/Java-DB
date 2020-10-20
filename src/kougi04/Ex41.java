package kougi04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex41 {

	public static void main(String[] args) {


		try {
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\meibo;create=false";

			Connection con
					= DriverManager.getConnection(driverUrl, "db", "db");

			Statement stmt = con.createStatement();

			String sql = "select * from T_STUDENT";

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				String result = "";
				result += rs.getInt("student_id") + ":";
				result += rs.getString("fullname");
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
