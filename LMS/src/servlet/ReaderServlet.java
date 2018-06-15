package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AdminBean;
import bean.BookBean;
import bean.ReaderBean;
import dao.AdminDao;
import dao.ReaderDao;

/**
 * Servlet implementation class ReaderServlet
 */
@WebServlet("/servlet/readerServlet")
public class ReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReaderServlet() {
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
	
	//修改读者信息
	private void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 从JSP页面获取读者信息
		req.setCharacterEncoding("utf-8");
		String readerid = req.getParameter("readerid");
		String rd_name = req.getParameter("rd_name");
		int rd_type = Integer.parseInt(req.getParameter("rd_type"));
		String system = req.getParameter("system");
		String rclass = req.getParameter("rclass");
		String phone = req.getParameter("phone");

		ReaderBean readerBean = new ReaderBean(rd_name, rd_type, system,
				rclass, phone);
		readerBean.setReaderid(readerid);
		ReaderDao readerDao = new ReaderDao();
		boolean f = readerDao.update(readerBean);
		if (f == true) {
			resp.sendRedirect(req.getContextPath() + "/reader/correct.jsp?status=1");
		} else {
			resp.sendRedirect(req.getContextPath() + "/reader/correct.jsp?status=0");
		}
	}
	
	//获取读者信息在修改界面显示
	private void correct(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		//设置编码方式，获取读者的借书卡号
		req.setCharacterEncoding("utf-8");
		String readerid = req.getParameter("readerid");
		
		ReaderDao readerDao = new ReaderDao();
		ReaderBean readerBean = new ReaderBean();
		readerBean = readerDao.find(readerid);
		
		req.setAttribute("readerBean", readerBean);
		req.getRequestDispatcher("/reader/correct.jsp").forward(req, resp);
	}
	
	//删除读者
	private void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		//设置编码方式，获取读者的借书卡号
		req.setCharacterEncoding("utf-8");
		String readerid = req.getParameter("readerid");
		
		ReaderDao readerDao = new ReaderDao();
		boolean f = readerDao.delete(readerid);
		
		if(f==true){
			resp.sendRedirect(req.getContextPath()+"/reader/find.jsp?status=1");
		}
		else
			resp.sendRedirect(req.getContextPath()+"/reader/find.jsp?status=0");
	}
	
	//查询读者
	private void find(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String readerid = req.getParameter("readerid");
		
		ReaderBean readerBean =new ReaderBean();
		
		ReaderDao readerDao = new ReaderDao();
		readerBean=readerDao.find(readerid);
		req.setAttribute("readerBean", readerBean);
		req.getRequestDispatcher("/reader/find.jsp").forward(req, resp);
	}
	
	
	// 添加读者

	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//从JSP页面获取读者信息
		req.setCharacterEncoding("utf-8");
		String rd_name = req.getParameter("rd_name");
		int rd_type = Integer.parseInt( req.getParameter("rd_type"));
		String system=req.getParameter( "system");
		String rclass = req.getParameter( "rclass");
		String phone = req.getParameter( "phone");
		
		ReaderBean readerBean = new ReaderBean(rd_name,rd_type,system,rclass,phone);
		
		
		ReaderDao readerDao = new ReaderDao();
		boolean f = readerDao.add(readerBean);
		if (f==true) {
			resp.sendRedirect(req.getContextPath() + "/reader/add.jsp?status=1");
		} else {
			resp.sendRedirect(req.getContextPath()
					+ "/reader/add.jsp?status=0");
		}
	}
}
