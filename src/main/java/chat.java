

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Message;
import main.MessageManager;

/**
 * Servlet implementation class chat
 */
@WebServlet("/chat")
public class chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Date date = new Date();
	    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	    String strDate = dateFormat.format(date);
		HttpSession session = request.getSession();
		MessageManager manager= new MessageManager();
		Message msg=new Message(request.getParameter("username"),request.getParameter("msg"),(long)Integer.valueOf(request.getParameter("idaccount")));
		
		msg.setTimetamp(strDate);
		manager.addMessage(msg);
		
		request.setAttribute("message", request.getParameter("msg"));
		request.setAttribute("timetamp", request.getParameter("timetamp"));
		request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("idaccount", request.getParameter("idaccount"));
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("last_connect", request.getParameter("last_connect"));
		
		this.getServletContext().getRequestDispatcher("/chat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
