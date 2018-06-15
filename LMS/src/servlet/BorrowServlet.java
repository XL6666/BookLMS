package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bean.BorrowBean;
import bean.ReaderBean;
import bean.ReturnBean;
import dao.BookDao;
import dao.BorrowDao;
import dao.ReaderDao;
import dao.ReturnDao;

/**
 * Servlet implementation class BorrowServlet
 */
@WebServlet("/servlet/borrowServlet")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowServlet() {
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
		if ("borrowfind".equals(method)) {
			borrowfind(req, resp);
		}
		else if("borrow".equals( method)){
			borrow(req,resp);
		}
		else if("returnfind".equals( method)){
			returnfind(req,resp);
		}
		else if("return".equals(method)){
			returnbook(req,resp);
		}
	}
	
	//归还图书
	private void returnbook(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//设置编码方式
		req.setCharacterEncoding("utf-8");
		
		String bk_code = req.getParameter("bk_code");
		String readerid = req.getParameter("readerid");
		String op_name = "徐浩军";
		
		ReturnBean returnBean = new ReturnBean(readerid,bk_code,op_name);
		
		ReturnDao returnDao = new ReturnDao();
		boolean f1 = returnDao.add(returnBean);
		
		BookDao bookDao = new BookDao();
		String state = "0";
		boolean f2 = bookDao.changestate(bk_code,state);
		
		String operator = "-";
		ReaderDao readerDao = new ReaderDao();
		boolean f3 = readerDao.Borrowed_num(readerid,operator);
		
		BorrowDao borrowDao = new BorrowDao();
		boolean f4 = borrowDao.changestate(readerid, bk_code);
		
		
		if(f1==true&&f2==true&&f3==true&&f4==true)
			req.getRequestDispatcher("/borrow/return.jsp?status=1").forward(req, resp);
		else
			req.getRequestDispatcher("/borrow/return.jsp?status=0").forward(req, resp);
	}
	
	
	//查询还书的基本信息
	private void returnfind(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		
		//得到图书的基本信息
		String bk_code = req.getParameter("bk_code");
		BookBean bookBean =new BookBean();
		BookDao bookDao = new BookDao();
		bookBean=bookDao.find(bk_code);
		//得到读者的基本信息
		String readerid = req.getParameter("readerid");
		ReaderBean readerBean =new ReaderBean();
		ReaderDao readerDao = new ReaderDao();
		readerBean=readerDao.find(readerid);
		//得到借书信息
		BorrowDao borrowDao = new BorrowDao();
		BorrowBean borrowBean = new BorrowBean();
		borrowBean = borrowDao.find(readerid, bk_code);
		borrowBean.setReaderBean(readerBean);
		borrowBean.setBookBean(bookBean);
		req.setAttribute( "borrowBean", borrowBean);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		String date =format.format(date1); 
		req.getRequestDispatcher("/borrow/return.jsp?date="+date).forward(req, resp);
	}
	
	//借阅
	private void borrow(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		
		//根据图书编号查询得到图书信息
		String bk_code = req.getParameter("bk_code");
		BookBean bookBean =new BookBean();
		BookDao bookDao = new BookDao();
		bookBean=bookDao.find(bk_code);
		
		//根据读者编号查询得到读者信息
		String readerid = req.getParameter("readerid");
		ReaderBean readerBean =new ReaderBean();
		ReaderDao readerDao = new ReaderDao();
		readerBean=readerDao.find(readerid);
		
		Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。    
		cal.add(Calendar.DAY_OF_MONTH, +readerBean.getReadertypeBean().getRt_time());//取得还书日期.
		
		BorrowBean borrowBean = new BorrowBean(readerBean.getReaderid(),bookBean.getBk_code(),Calendar.getInstance().getTime(),cal.getTime(),"徐浩军");
		BorrowDao borrowDao = new BorrowDao();
		
		String state = "1";
		boolean f2 = bookDao.changestate(bk_code,state);
		String operator = "+";
		boolean f3 = readerDao.Borrowed_num(readerid,operator);
		
		boolean f1 = borrowDao.add(borrowBean);
		
		if(f1==true&&f2==true&&f3==true)
			req.getRequestDispatcher("/borrow/borrow.jsp?status=1").forward(req, resp);
		else
			req.getRequestDispatcher("/borrow/borrow.jsp?status=0").forward(req, resp);
	}
	
	
	//查询能否借阅
	private void borrowfind(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		
		String bk_code = req.getParameter("bk_code");
		BookBean bookBean =new BookBean();
		BookDao bookDao = new BookDao();
		bookBean=bookDao.find(bk_code);
		req.setAttribute("bookBean", bookBean);
		
		String readerid = req.getParameter("readerid");
		
		ReaderBean readerBean =new ReaderBean();
		
		ReaderDao readerDao = new ReaderDao();
		readerBean=readerDao.find(readerid);
		req.setAttribute("readerBean", readerBean);
		
		req.getRequestDispatcher("/borrow/borrow.jsp").forward(req, resp);
	}
}
