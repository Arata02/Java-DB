package en10;

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
 * Servlet implementation class Kadai10_1
 */
@WebServlet("/en10/Kadai10_1")
public class Kadai10_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai10_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//コネクションとステートメントの宣言
        Connection con = null;
        Statement stmt = null;

		try {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Kadai10_1</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Kadai10_1</h3>");

			//testdbデータベースへの接続
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\testdb;create=false";

			//コネクションの確立
			con = DriverManager.getConnection(driverUrl, "db", "db");

			//ステートメントの作成
			stmt = con.createStatement();

			//実行するSQL文を記述
			String sql = "select * from T_TWEET order by number";

			//SQLを実行してResultSetの形式で結果を取得
			ResultSet rs = stmt.executeQuery(sql);

			out.println("<table border='1'>");
			//取得したレコードを一つずつ処理
			while (rs.next()) {
			    out.println("<tr>");
                out.print("<td>" + rs.getInt("number") + "</td>");
                out.print("<td>" + rs.getString("id") + "</td>");
                out.print("<td>" + rs.getString("text") + "</td>");
                out.print("<td>" + rs.getInt("retweet") + "</td>");
                out.println("</tr>");
			}
			out.println("</table>");

			//メモリの開放
			rs.close();

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
