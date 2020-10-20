package kougi02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tweet2 {
	//フィールド
	private int tweetNo; //ツイートの番号
	private String twitterID; //twitterID
	private String name; //氏名
	private Date tweetTime; //投稿日時
	private String text; //投稿内容

	//コンストラクタ
	public Tweet2() {
		//とりあえず何もしない
	}

	//各フィールドのGet・Setメソッド（自動生成）
	public int getTweetNo() {
		return tweetNo;
	}

	public void setTweetNo(int tweetNo) {
		this.tweetNo = tweetNo;
	}

	public String getTwitterID() {
		return twitterID;
	}

	public void setTwitterID(String twitterID) {
		this.twitterID = twitterID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTweetTime() {
		return tweetTime;
	}

	public void setTweetTime(String tm) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
			Date date = sdf.parse(tm);
			this.tweetTime = date;
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	//ツイート情報を出力するメソッド
	public void printTweet() {
		System.out.println(tweetNo + ":"
				+ twitterID + "(" + name + ")\n"
				+ tweetTime + "\n" + text);
	}

}
