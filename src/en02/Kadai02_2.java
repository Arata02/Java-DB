package en02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kadai02_2 {

	public static void main(String[] args) {

		List<Cat> clist = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("en02_data.csv")));
			String line;
			int maleSum = 0;
			int femaleSum = 0;
			double maleAve = 0.0;
			double femaleAve = 0.0;
			double a =0.0;
			double b = 0.0;
			while((line = br.readLine()) != null) {
				Cat cat = new Cat();
				String[] word = line.split(",");
				cat.setSex(word[5]);
				cat.setWeight(Double.parseDouble(word[7]));
				clist.add(cat);
			}
			br.close();

			for(Cat cat :clist) {
				if(cat.getSex().equals("オス")) {
					maleSum++;
					a += cat.getWeight();
				}else {
					femaleSum++;
					b += cat.getWeight();
				}
			}

			maleAve = a / maleSum;
			femaleAve = b / femaleSum;

			System.out.println("登録されているネコのうち、オスは" + maleSum + "匹でメスは" + femaleSum + "匹です。");
			System.out.printf("オスの平均体重は%.2fkgです。\n", maleAve);
			System.out.printf("メスの平均体重は%.2fkgです。\n", femaleAve);

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
