package kougi09;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex92
 */
@WebServlet("/Ex92")
public class Ex92 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex92() {
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
			out.println("<title>Servlet Ex92</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Ex92.java</h3>");

            HttpSession session = request.getSession(false);
            if (session == null) {
                out.println("<p>初めてのアクセスですね．セッション開始！<p>");
                session = request.getSession(true);

                session.setAttribute("group", 1234);

                Item item1 = new Item("リンゴ", 300);
                session.setAttribute("item", item1);

            } else {
                out.println("<p>既にセッションは開始しています．</p>");
            }

            out.println("<hr>");

            out.println("セッションID: " + session.getId());
            out.println("group: " + session.getAttribute("group"));

            out.println("<hr>");

            long createTime = session.getCreationTime();
            Date createDate = new Date(createTime);
            out.println("作成日時： " + createDate.toString() + "<br>");

            out.println("<p><a href=\"Ex92_2\">Ex92_2へ</a></p>");
            out.println("<p><a href=\"Ex92_3\">セッションの破棄</a></p>");


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
