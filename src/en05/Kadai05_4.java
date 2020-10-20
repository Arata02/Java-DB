package en05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Kadai05_4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";

			Connection con
					= DriverManager.getConnection(driverUrl, "db", "db");

			String sql = "insert into T_TWEET (id, text, retweet, tweetdate) values (?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			BufferedReader br = new BufferedReader(new FileReader(new File("tweet54.csv")));

			String line;
			int count = 0;
			while((line = br.readLine()) != null) {
				String[] word = line.split(",");
				ps.setString(1, word[0]);
				ps.setString(2, (word[1]));
				ps.setInt(3, Integer.parseInt(word[2]));
				Timestamp tm = Timestamp.valueOf(word[3]);
				ps.setTimestamp(4, tm);
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
