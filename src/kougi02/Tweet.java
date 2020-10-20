package kougi02;

public class Tweet {
	//フィールド
	private int tweetNo; //ツイートの番号
	private String twitterID; //twitterID
	private String name; //氏名
	private String tweetTime; //投稿日時
	private String text; //投稿内容

	//コンストラクタ
	public Tweet() {
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

	public String getTweetTime() {
		return tweetTime;
	}

	public void setTweetTime(String tweetTime) {
		this.tweetTime = tweetTime;
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
