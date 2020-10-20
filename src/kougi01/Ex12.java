package kougi01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Ex12 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		 try {
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("out.txt"))));
			    String line;
			    while((line = br.readLine())!= null){
			        pw.println(line);
			    }
			    br.close();
			    pw.close();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
