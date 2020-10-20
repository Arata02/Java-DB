//package kougi10;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class Ex103
// */
//@WebServlet("/kougi10/Ex103")
//public class Ex103 extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Ex103() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//        //コネクションとステートメントの宣言
//        Connection con = null;
//        Statement stmt = null;
//        PreparedStatement ps = null;
//
//		try {
//			PrintWriter out = response.getWriter();
//
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<title>Servlet Ex103</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<h3>Ex103.java</h3>");
//
//			//testdbデータベースへの接続
//			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\meibo;create=false";
//
//			//コネクションの確立
//			con = DriverManager.getConnection(driverUrl, "db", "db");
//
//			//ステートメントの作成
//			stmt = con.createStatement();
//
//			//======新しいレコードを追加========
//
//			//入力された値を取得
//			String sid = request.getParameter("sid");
//			String fullname = request.getParameter("fullname");
//			String gid = request.getParameter("gid");
//			String grade = request.getParameter("grade");
//			String point = request.getParameter("point");
//
//			String sql2 = "insert into T_STUDENT values (?,?,?,?,?)";
//
//			ps = con.prepareStatement(sql2);
//			ps.setInt(1, Integer.parseInt(sid));
//            ps.setString(2, fullname);
//            ps.setInt(3, Integer.parseInt(gid));
//            ps.setInt(4, Integer.parseInt(grade));
//            ps.setInt(5, Integer.parseInt(point));
//
//			int count = ps.executeUpdate();
//
//			//======現在のレコードを全て表示========
//
//			//実行するSQL文を記述
//			String sql = "select * from T_STUDENT order by student_id";
//
//			//SQLを実行してResultSetの形式で結果を取得
//			ResultSet rs = stmt.executeQuery(sql);
//
//			out.println("<ul>");
//			//取得したレコードを一つずつ処理
//			while (rs.next()) {
//			    String result = "";
//                result += rs.getInt("student_id") + ":";
//                result += rs.getString("fullname");
//			    out.println("<li>" + result + "</li>");
//			}
//			out.println("</ul>");
//
//			//メモリの開放
//			rs.close();
//
//			out.println("</body>");
//			out.println("</html>");
//
//		} catch (Exception e) {
//            //サーブレット内での例外をアプリケーションのエラーとして表示
//            throw new ServletException(e);
//        } finally {
//            //例外が発生する・しないにかかわらず確実にデータベースから切断
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    throw new ServletException(e);
//                }
//            }
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException e) {
//                    throw new ServletException(e);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    throw new ServletException(e);
//                }
//            }
//        }
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
