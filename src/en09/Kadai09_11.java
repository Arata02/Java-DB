package en09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Kadai09_11
 */
@WebServlet("/en09/Kadai09_11")
public class Kadai09_11 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai09_11() {
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
			out.println("<title>Kadai09_11</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Kadai09_11.java</h3>");

			String id = request.getParameter("id");

            HttpSession session = request.getSession(false);
            if (session == null) {
                out.println("<p>初めてのアクセスですね．セッション開始！<p>");
                session = request.getSession(true);
                session.setAttribute("id", id);
                out.println("id: " + id);

            } else {
                out.println("<p>既にセッションは開始しています．</p>");
                out.println("id: " + session.getAttribute("id"));
            }



            out.println("<p><a href=\"Kadai09_12\">登録内容の確認</a></p>");
            out.println("<p><a href=\"Kadai09_13\">セッションの破棄</a></p>");

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
