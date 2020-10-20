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
 * Servlet implementation class Register
 */
@WebServlet("/final_Ex/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
			out.println("<h3>以下のデータを追加しました</h3>");

			//testdbデータベースへの接続
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";

			//コネクションの確立
			con = DriverManager.getConnection(driverUrl, "db", "db");

			//ステートメントの作成
			stmt = con.createStatement();

			//======新しいレコードを追加========

			//入力された値を取得
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String b_year = request.getParameter("b_year");
			String genre = request.getParameter("genre");

			String sql = "insert into T_BOOK (title, author, b_year, genre) values (?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, Integer.parseInt(b_year));
            ps.setString(4, genre);

            ps.executeUpdate();

            //追加したレコードを出力

            out.println("<table border='1'>");
            out.println("<tr>");
		    out.print("<td>" + title + "</td>");
            out.print("<td>" + author + "</td>");
            out.print("<td>" + b_year + "</td>");
            out.print("<td>" + genre + "</td>");
            out.println("</tr>");
            out.println("</table>");

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
