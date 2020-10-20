package kougi11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex11_2
 */
@WebServlet("/kougi11/Ex11_2")
public class Ex11_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex11_2() {
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

		try {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Ex11_2</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Ex11_2.java</h3>");

			//testdbデータベースへの接続
			String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\meibo;create=false";

			//コネクションの確立
			con = DriverManager.getConnection(driverUrl, "db", "db");

			//ステートメントの作成
			stmt = con.createStatement();

			String sql = "select * from T_STUDENT_A";
            ResultSet rs = stmt.executeQuery(sql);

            //Student型のArrayListを作成
            List<Student> slist = new ArrayList<>();

            //データベースから値を取得して出力
            while (rs.next()) {
                //1つのレコードの情報を格納するインスタンスstdを作成
                Student std = new Student();

                //stdにレコードの値をセット
                std.setStudent_id(rs.getInt("student_id"));
                std.setFullname(rs.getString("fullname"));
                std.setGakubu_id(rs.getInt("gakubu_id"));
                std.setGrade(rs.getInt("grade"));

                //リストにstdを追加
                slist.add(std);
            }

			//メモリの開放
			rs.close();

			//リストの内容を順番に出力
			//※次回はこのオブジェクトをJSPに送信し，JSPで表示する


			out.println("<table border=\"1\"");
			for(Student std : slist) {
				out.println("<tr>");
				out.println("<td>" + std.getStudent_id() + "</td>");
				out.println("<td>" + std.getFullname() + "</td>");
				out.println("<td>" + std.getGakubu_id() + "</td>");
				out.println("<td>" + std.getGrade() + "</td>");
				out.println("</tr>");
			}
			out.println("<table>");


//			request.setAttribute("slist", slist);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("Ex11_2.jsp");
//			dispatcher.forward(request, response);
//
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
        }}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
