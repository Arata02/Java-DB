package kougi01;

import java.io.File;

public class Ex11 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		File f1 = new File("text.txt");
		File dir1 = new File("C:\\Users\\Kaiki\\Documents");

		System.out.println("ファイル名: " + f1.getName());
		System.out.println("絶対パス: " + f1.getAbsolutePath());
		System.out.println("サイズ: " + f1.length() + "バイト");
		System.out.println("ファイルか？" + f1.isFile());
		System.out.println("ディレクトリか？" + f1.isDirectory());

		System.out.println("------------");

		System.out.println("ファイル名: " + dir1.getName());
		System.out.println("絶対パス: " + dir1.getAbsolutePath());
		System.out.println("サイズ: " + dir1.length() + "バイト");
		System.out.println("ファイルか？" + dir1.isFile());
		System.out.println("ディレクトリか？" + dir1.isDirectory());
	}

}
