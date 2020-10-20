package en05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Kadai05_3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";

			Connection con
					= DriverManager.getConnection(driverUrl, "db", "db");

			String sql = "insert into T_TWEET (id, text, retweet) values (?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			BufferedReader br = new BufferedReader(new FileReader(new File("tweet53.csv")));

			String line;
			int count = 0;
			while((line = br.readLine()) != null) {
				String[] word = line.split(",");
				ps.setString(1, word[0]);
				ps.setString(2, (word[1]));
				ps.setInt(3, Integer.parseInt(word[2]));
				count += ps.executeUpdate();
			}

			System.out.println(count + "件のレコードを追加しました");

			br.close();
			ps.close();
			con.close();
		} catch (NumberFormatException | SQLException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
