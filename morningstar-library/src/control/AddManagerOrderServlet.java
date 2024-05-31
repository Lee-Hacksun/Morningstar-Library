package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ManagerOrderService;

/**
 * Servlet implementation class AddManagerOrderServlet
 */
@WebServlet("/AddManagerOrder")
public class AddManagerOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddManagerOrderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	        
		 HttpSession session = request.getSession();
		 String userID = (String) session.getAttribute("userID");
		 
	     String isbn = request.getParameter("isbn");
	     String author = request.getParameter("author");
	     int amount = Integer.parseInt(request.getParameter("amount"));
	     String date = request.getParameter("date");
	        
	     ManagerOrderService managerOrderService = new ManagerOrderService();
	     System.out.println(userID + author + date + isbn + amount);
	     managerOrderService.addManagerOrder(userID, author, date, isbn, amount);
	     
	     response.sendRedirect("admin_index.jsp");
	}

}
