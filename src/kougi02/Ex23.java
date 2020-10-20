package kougi02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex23 {
	public static void main(String[] args) {

		List<Tweet> tlist = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("tweet2.csv")));
			String line = "";
			while((line = br.readLine()) != null) {

				Tweet tweet = new Tweet();

				String[] word = line.split(",");
				tweet.setTweetNo(Integer.parseInt(word[0]));
				tweet.setTwitterID(word[1]);
				tweet.setName(word[2]);
				tweet.setTweetTime(word[3]);
				tweet.setText(word[4]);

				tlist.add(tweet);
			}
			br.close();

			for(Tweet tweet : tlist) {
				tweet.printTweet();
			}

		} catch (NumberFormatException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
