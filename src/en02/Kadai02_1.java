package en02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kadai02_1 {

	public static void main(String[] args) {

		List<Cat> clist = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("en02_data.csv")));
			String line;
			while((line = br.readLine()) != null) {
				Cat cat = new Cat();
				String[] word = line.split(",");
				cat.setName(word[1]);
				cat.setKind(word[2]);
				cat.setSex(word[5]);
				cat.setWeight(Double.parseDouble(word[7]));
				clist.add(cat);
			}
			br.close();

			for(Cat cat : clist) {
				cat.printCat();
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
