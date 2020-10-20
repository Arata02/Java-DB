package kougi09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex93
 */
@WebServlet("/kougi09/Ex93")
public class Ex93 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex93() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Ex93</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Ex93.java</h3>");

			//セッション
			HttpSession session = request.getSession(false);

			//セッションがある場合は一旦破棄
			if(session != null) {
				session.invalidate();
			}

			//セッションを作成
			session = request.getSession(true);

			//取得したIDとパスワードを基にUser型のオブジェクトuser1を作成
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			User user1 = new User(id, pass);

			//セッションにuser1を設定
			session.setAttribute("user1", user1);
			out.println("<p>登録ID: " + id + "でよろしいでしょうか？</p>");

			out.println("<p><a href=\"Ex93.html\">戻る</a></p>");
			out.println("<p><a href=\"Ex93_2\">登録</a></p>");

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
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
