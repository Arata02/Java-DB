package kougi02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex21 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("tweet.csv")));

			String line;
			while((line = br.readLine()) != null) {
				String[] word = line.split(",");
				System.out.println("tweetId: " + word[0]);
				System.out.println("氏名: " + word[1]);
			}
			br.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
