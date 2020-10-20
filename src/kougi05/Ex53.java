package kougi05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex53 {

	public static void main(String[] args) {

			try {
				String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\meibo;create=false";

				Connection con
						= DriverManager.getConnection(driverUrl, "db", "db");

				String sql = "insert into T_STUDENT_A" + "(fullname, gakubu_id, grade)" +"values (?, ?, ?)";

				PreparedStatement ps = con.prepareStatement(sql);

				BufferedReader br = new BufferedReader(new FileReader(new File("student.csv")));

				String line;
				int count = 0;
				while((line = br.readLine()) != null) {
					String[] word = line.split(",");
					ps.setString(1, word[0]);
					ps.setInt(2, Integer.parseInt(word[1]));
					ps.setInt(3, Integer.parseInt(word[2]));
					count += ps.executeUpdate();
				}

				System.out.println(count + "件のレコードを追加しました");

				Statement stmt = con.createStatement();

				sql = "select * from T_STUDENT_A order by student_id";

				ResultSet rs = stmt.executeQuery(sql);

				while(rs.next()) {
					String result = "";
					result += rs.getInt("student_id") + ":";
					result += rs.getString("fullname") + ":";
					result += rs.getString("gakubu_id") + ":";
					result += rs.getString("grade");
					System.out.println(result);
				}

				br.close();
				ps.close();
				stmt.close();
				con.close();
			} catch (NumberFormatException | SQLException | IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}

}
