

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.SystemException;

import dao.Account;
import main.AccountsManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String banneduser= request.getParameter("banned");
		Date date = new Date();
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String strDate = dateFormat.format(date);
		
		AccountsManager manage= new AccountsManager();
		if(!(manage.CheckAccount(username, password)))
			this.getServletContext().getRequestDispatcher("/").forward(request, response);
		else if(username.equals(banneduser)) {
			this.getServletContext().getRequestDispatcher("/").forward(request, response);
		}
		else {
		Account ac = manage.FoundAccount(username,password);
		request.setAttribute("username", username);
		ac.setlast_connect(strDate);
		request.setAttribute("last_connect", ac.getlast_connect());
		request.setAttribute("name", ac.getName());
		request.setAttribute("username", username);
		request.setAttribute("email", ac.getEmail());
		request.setAttribute("idaccount", ac.getIdAccount());
		request.setAttribute("password", password);
		this.getServletContext().getRequestDispatcher("/chat.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
