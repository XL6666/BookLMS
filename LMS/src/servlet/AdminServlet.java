package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.AdminDao;

import bean.AdminBean;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/servlet/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		if ("login".equals(method)) {
			// 如果是login就到login页面
			login(req, resp);
		}
		else if("loginout".equals(method)){
			loginout(req,resp);
		}
		else if("register".equals(method)){
			register(req,resp);
		}
	}
	
	// 添加管理员

	private void register(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		AdminDao adminDao = new AdminDao();

		String user = req.getParameter("user");
		String user_name = req.getParameter("user_name");
		String password = req.getParameter("password");

		// 建立对象
		AdminBean adminBean = new AdminBean(user,password,user_name);

			boolean flag = adminDao.register(adminBean);
			if(flag)
				resp.sendRedirect(req.getContextPath()+"/login/login.jsp?status=2");
			else 
				// 注册失败，跳回
				resp.sendRedirect(req.getContextPath()+"login/register.jsp?status=0");
		}
	
	// 退出登录

	private void loginout(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码方式并获取status
		req.setCharacterEncoding("utf-8");
			req.getSession().invalidate();
			req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
	}
	// 登录

	private void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 设置编码方式并获取用户名和进过MD5加密后的密码
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("user");
		String password = req.getParameter("password");
		
		// 建立adminDao对象对数据库操作并把结果赋给一个adminDao对象
		AdminDao adminDao = new AdminDao();
		
		AdminBean adminBean = adminDao.checkLogin(username, password);
		if (adminBean != null) {
			// 不为空就是登录成功并把这个用户存到session中然后调转到后台主页面
			req.getSession().setAttribute("adminBean",
					adminBean);
			resp.sendRedirect(req.getContextPath() + "/main/main.jsp");
		} else {
			// 登录失败则重新登录
			resp.sendRedirect(req.getContextPath()
					+ "/login/login.jsp?status=1");
		}
	}
}
