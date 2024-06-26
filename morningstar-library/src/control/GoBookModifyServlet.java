package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import service.InventoryService;

/**
 * Servlet implementation class BookModifyServlet
 */
@WebServlet("/GoBookModify")
public class GoBookModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoBookModifyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		
		BookService bookService = new BookService();
		InventoryService inventoryService = new InventoryService();
		inventoryService.getPrice(isbn);
		
		request.setAttribute("book", bookService.loadBook(isbn));
		request.setAttribute("price", inventoryService.getPrice());
		request.getRequestDispatcher("/book_modify.jsp").forward(request, response);
	}
}
