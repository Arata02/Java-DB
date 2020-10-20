package kougi11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex11_1
 */
@WebServlet("/kougi11/Ex11_1")
public class Ex11_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex11_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Ex11_1</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Ex11_1.java</h3>");

            //テキストボックスに入力された値を取得
            String name = request.getParameter("name");
            int point = Integer.parseInt(request.getParameter("point"));

            //取得した値を用いて，Examクラスをインスタンス化
            Exam ex = new Exam(name, point);

            /*
            out.println(ex.getName() + "，点数=" + ex.getPoint()
            			+ "，評価=" + ex.getResult() + "<br>");
             */

			request.setAttribute("ex", ex);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Ex11_1.jsp");
			dispatcher.forward(request, response);

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
