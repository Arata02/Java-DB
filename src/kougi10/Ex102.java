package kougi10;

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
 * Servlet implementation class Ex102
 */
@WebServlet("/kougi10/Ex102")
public class Ex102 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex102() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        //コネクションとステートメントの宣言
        Connection con = null;
        Statement stmt = null;
        PreparedStatement ps = null;

		try {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Ex102</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Ex102.java</h3>");

			//testdbデータベースへの接続
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\meibo;create=false";

			//コネクションの確立
			con = DriverManager.getConnection(driverUrl, "db", "db");

			//ステートメントの作成
			stmt = con.createStatement();

			/*
			String sql2 = "insert into T_STUDENT values "
					+ "(8, '松田聖子', 1, 4, 50)";
			int count = stmt.executeUpdate(sql2);
*/

			//入力されたstudent_idを取得
			String sid = request.getParameter("sid");

			//実行するSQL文を記述
			String sql = "select * from T_STUDENT where student_id=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(sid));

			//SQLを実行してResultSetの形式で結果を取得
			//ResultSet rs = stmt.executeQuery(sql);
			ResultSet rs = ps.executeQuery();

			out.println("<ul>");
			//取得したレコードを一つずつ処理
			while (rs.next()) {
			    String result = "";
                result += rs.getInt("student_id") + ":";
                result += rs.getString("fullname");
			    out.println("<li>" + result + "</li>");
			}
			out.println("</ul>");

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
