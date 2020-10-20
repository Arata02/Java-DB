package final_Ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show
 */
@WebServlet("/final_Ex/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//コネクションとステートメントの宣言
		Connection con = null;
		Statement stmt = null;

		try {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Show Books</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>書籍一覧</h3>");

			//testdbデータベースへの接続
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";

			//コネクションの確立
			con = DriverManager.getConnection(driverUrl, "db", "db");

			//ステートメントの作成
			stmt = con.createStatement();

			//実行するSQL文を記述
			String sql = "select * from T_BOOK order by id";

			//SQLを実行してResultSetの形式で結果を取得
			ResultSet rs = stmt.executeQuery(sql);

			out.println("<table border='1'>");
			out.println("<tr><td>ID</td><td>タイトル</td><td>著者</td><td>出版年度</td><td>ジャンル</td></tr>");
			//取得したレコードを一つずつ処理
			while (rs.next()) {
				out.println("<tr>");
				out.print("<td>" + rs.getInt("id") + "</td>");
				out.print("<td>" + rs.getString("title") + "</td>");
				out.print("<td>" + rs.getString("author") + "</td>");
				out.print("<td>" + rs.getInt("b_year") + "</td>");
				out.print("<td>" + rs.getString("genre") + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");

			//メモリの開放
			rs.close();

			out.println("<a href=\"index.html\">トップページに戻る</a>");

			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			//サーブレット内での例外をアプリケーションのエラーとして表示
			throw new ServletException(e);
		} finally {
			//例外が発生する・しないにかかわらず確実にデータベースから切断
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new ServletException(e);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new ServletException(e);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
