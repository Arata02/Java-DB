package final_Ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Result
 */
@WebServlet("/final_Ex/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		// コネクションとステートメントの宣言
		Connection con = null;
		Statement stmt = null;
		PreparedStatement ps = null;

		try {
			final PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>検索結果</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>検索結果</h3>");

			// testdbデータベースへの接続
			final String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";
			// コネクションの確立
			con = DriverManager.getConnection(driverUrl, "db", "db");

			// ステートメントの作成
			stmt = con.createStatement();

			if (request.getParameterValues("btn1") != null) {
				final String id = request.getParameter("input_text");
				final String sql1 = "select * from T_BOOK where id=?";
				ps = con.prepareStatement(sql1);
				ps.setInt(1, Integer.parseInt(id));
			} else if (request.getParameterValues("btn2") != null) {
				final String title = request.getParameter("input_text");
				final String sql2 = "select * from T_BOOK where title=?";
				ps = con.prepareStatement(sql2);
				ps.setString(1, title);
			} else if (request.getParameterValues("btn3") != null) {
				final String author = request.getParameter("input_text");
				final String sql3 = "select * from T_BOOK where author=?";
				ps = con.prepareStatement(sql3);
				ps.setString(1, author);
			}

			// SQLを実行してResultSetの形式で結果を取得
			final ResultSet rs = ps.executeQuery();

			out.println("<table border=\"1\">");
			// 取得したレコードを一つずつ処理
			while (rs.next()) {
				out.println("<table border='1'>");
				out.println("<tr>");
				out.print("<td>" + rs.getString("title") + "</td>");
				out.print("<td>" + rs.getString("author") + "</td>");
				out.print("<td>" + rs.getInt("b_year") + "</td>");
				out.print("<td>" + rs.getString("genre") + "</td>");
				out.println("</tr>");
				out.println("</table>");
			}
			out.println("</table>");

			// メモリの開放
			rs.close();

			out.println("<a href=\"search.html\">書籍検索に戻る</a>");
			out.println("<a href=\"index.html\">トップページに戻る</a>");

			out.println("</body>");
			out.println("</html>");

		} catch (final Exception e) {
			// サーブレット内での例外をアプリケーションのエラーとして表示
			throw new ServletException(e);
		} finally {
			// 例外が発生する・しないにかかわらず確実にデータベースから切断
			if (stmt != null) {
				try {
					stmt.close();
				} catch (final SQLException e) {
					throw new ServletException(e);
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (final SQLException e) {
					throw new ServletException(e);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					throw new ServletException(e);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
