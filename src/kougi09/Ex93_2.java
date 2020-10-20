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
 * Servlet implementation class Ex93_2
 */
@WebServlet("/kougi09/Ex93_2")
public class Ex93_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex93_2() {
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
			out.println("<title>Servlet Ex93_2</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Ex93_2.java</h3>");

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
