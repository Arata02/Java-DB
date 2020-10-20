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
@WebServlet("/kougi09/Ex941")
public class Ex94 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex94() {
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
			out.println("<title>Servlet Ex94</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Ex94.java</h3>");

			String action = request.getParameter("action");

		if(action == null) {
			//セッション
			HttpSession session = request.getSession(false);

			//セッションがある場合は一旦破棄
			if(session != null) {
				session.invalidate();
			}

			//セッションを作成
			session = request.getSession(true);

			//取得したIDとパスワードを基にUser型のオブジェクトuser1を作成
			String uid = request.getParameter("id");
			String pass = request.getParameter("pass");
			User user1 = new User(uid, pass);

			//セッションにuser1を設定
			session.setAttribute("user1", user1);
			out.println("<p>登録ID: " + uid + "を登録します.</p>");

			out.println("<p><a href=\"Ex94?action=register\">登録</a></p>");
			out.println("<p><a href=\"Ex94.html\">戻る</a></p>");

			out.println("</body>");
			out.println("</html>");

		}else if(action.equals("register")) {
			HttpSession session = request.getSession(false);

			 //セッションが無い場合はタイムアウトで戻る
            if (session == null) {
				out.println("<p>タイムアウトしました<p>");
				out.println("<p><a href=\"Ex93.html\">戻る</a></p>");
			}
            //セッションがある場合は登録
            else {
				out.println("<p>登録しました！</p>");

				//セッションからIDを取得
				User user1 = (User)session.getAttribute("user1");
				out.println("登録したid:" + user1.getId());
            }
		}

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
