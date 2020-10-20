package en01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Kadai01_2{
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("out11.txt"));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("out12.txt"))));

            String line;
            String namelist = "";
            int linenum = 0;
            int sum = 0;


            while((line = br.readLine())!= null){
            	linenum++;
            	if(linenum % 2 == 1) {
                namelist += line + "/";
            	}else {
            		sum += Integer.parseInt(line);
            	}
            }
            pw.println("商品リスト:" + namelist);
        	pw.println("合計:" + sum + "円");

            br.close();
            pw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}