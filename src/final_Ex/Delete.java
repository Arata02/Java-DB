package final_Ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/final_Ex/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement ps = null;

		try {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Register</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>レコードを削除しました</h3>");

			//testdbデータベースへの接続
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";

			//コネクションの確立
			con = DriverManager.getConnection(driverUrl, "db", "db");

			//ステートメントの作成
			stmt = con.createStatement();

			//レコードの削除

			//入力された値を取得
			String id = request.getParameter("id");

			String sql = "delete from T_BOOK where id=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));

			ps.executeUpdate();

			out.println("<a href=\"Show\">全レコード表示</a>");
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
			if (ps != null) {
				try {
					ps.close();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
