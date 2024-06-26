 // Book 배열을 응답으로 보내는 sublet

package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.WebConfig;
import model.Book;
import service.BookService;

/**
 * Servlet implementation class ViewBookSublet
 */
@WebServlet("/ViewBook")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookService bookService = (BookService) session.getAttribute("bookService");

		if (bookService == null) {
		    bookService = new BookService();
		    session.setAttribute("bookService", bookService);
		}		
		Vector<Book> books = bookService.getBooks();
		
		if(books.size() == 0) {
			bookService.loadBooks(WebConfig.MAIN_PAGE_BOOK_COUNT);	
		}
		
		Object isManager = session.getAttribute("isManager");
		
		if((isManager != null) && ((int)isManager == 1)) {
			request.setAttribute("showmore", true);
			request.setAttribute("books", books);
			request.getRequestDispatcher("/bookpage.jsp").forward(request, response);
			
		} else {
			request.setAttribute("showmore", true);
			request.setAttribute("books", books);
			request.getRequestDispatcher("/mainpage.jsp").forward(request, response);	
		}
	}

}
