package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bean.ReaderBean;
import dao.BookDao;
import dao.ReaderDao;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/servlet/bookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码方式并获取method
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if ("add".equals(method)) {
			add(req, resp);
		}
		else if("find".equals( method)){
			find(req,resp);
		}
		else if("delete".equals(method)){
			delete(req,resp);
		}
		else if("correct".equals(method)){
			correct(req,resp);
		}
		else if("update".equals(method)){
			update(req,resp);
		}
	}
	
	//修改图书信息
	private void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 从JSP页面获取图书信息
		String bk_code = req.getParameter( "bk_code");
		String bk_name = req.getParameter("bk_name");
		String bk_number = req.getParameter("bk_number");
		int bk_type = Integer.parseInt( req.getParameter("bk_type"));
		String writer=req.getParameter( "writer");
		float price =Float.parseFloat(req.getParameter( "price")) ;
		String op_name ="徐浩军";
		String bs_number=req.getParameter( "bs_number");
		
		BookBean bookBean = new BookBean(bk_name,bk_number,bk_type,writer,price,op_name,bs_number);
		bookBean.setBk_code(bk_code);
		
		BookDao bookDao = new BookDao();
		boolean f = bookDao.update(bookBean);
		if (f == true) {
			resp.sendRedirect(req.getContextPath() + "/book/correct.jsp?status=1");
		} else {
			resp.sendRedirect(req.getContextPath() + "/book/correct.jsp?status=0");
		}
	}
	
	//获取图书信息在修改界面显示
	private void correct(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		//设置编码方式，获取图书的图书编号
		req.setCharacterEncoding("utf-8");
		String bk_code = req.getParameter("bk_code");
		
		BookDao bookDao = new BookDao();
		BookBean bookBean = new BookBean();
		bookBean = bookDao.find(bk_code);
		
		req.setAttribute("bookBean", bookBean);
		req.getRequestDispatcher("/book/correct.jsp").forward(req, resp);
	}
	
	//删除图书
	private void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		//设置编码方式，获取图书的图书编号
		req.setCharacterEncoding("utf-8");
		String bk_code = req.getParameter("bk_code");
		
		BookDao bookDao = new BookDao();
		boolean f = bookDao.delete(bk_code);
		
		if(f==true){
			resp.sendRedirect(req.getContextPath()+"/book/find.jsp?status=1");
		}
		else
			resp.sendRedirect(req.getContextPath()+"/book/find.jsp?status=0");
	}
	
	//查询图书
	private void find(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String bk_code = req.getParameter("bk_code");
		BookBean bookBean =new BookBean();
		
		BookDao bookDao = new BookDao();
		bookBean=bookDao.find(bk_code);
		req.setAttribute("bookBean", bookBean);
		req.getRequestDispatcher("/book/find.jsp").forward(req, resp);
	}
	
	
	// 添加图书

	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//从JSP页面获取图书信息
		req.setCharacterEncoding("utf-8");
		String bk_name = req.getParameter("bk_name");
		String bk_number = req.getParameter("bk_number");
		int bk_type = Integer.parseInt( req.getParameter("bk_type"));
		String writer=req.getParameter( "writer");
		float price =Float.parseFloat(req.getParameter( "price")) ;
		String op_name = "徐浩军";
		String bs_number=req.getParameter( "bs_number");
		
		BookBean bookBean = new BookBean(bk_name,bk_number,bk_type,writer,price,op_name,bs_number);
		BookDao bookDao = new BookDao();
		boolean f = bookDao.add(bookBean);
		if (f==true) {
			resp.sendRedirect(req.getContextPath() + "/book/add.jsp?status=1");
		} else {
			resp.sendRedirect(req.getContextPath()
					+ "/book/add.jsp?status=0");
		}
	}
}
