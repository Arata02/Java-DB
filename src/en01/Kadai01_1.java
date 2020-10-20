package en01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Kadai01_1 {
	    public static void main(String[] args) {
	        String food[] = {"いちご", "バナナ", "すいか"};
	        int price[] = {500, 200, 700};


			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("out11.txt"))));

	        for(int i = 0; i < 3; i++){
	            pw.println(food[i]);
	            pw.println(price[i]);

	        }
	        pw.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	    }
	}