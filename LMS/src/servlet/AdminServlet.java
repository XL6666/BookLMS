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
		// ���ñ��뷽ʽ����ȡmethod
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if ("login".equals(method)) {
			// �����login�͵�loginҳ��
			login(req, resp);
		}
		else if("loginout".equals(method)){
			loginout(req,resp);
		}
		else if("register".equals(method)){
			register(req,resp);
		}
	}
	
	// ��ӹ���Ա

	private void register(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		AdminDao adminDao = new AdminDao();

		String user = req.getParameter("user");
		String user_name = req.getParameter("user_name");
		String password = req.getParameter("password");

		// ��������
		AdminBean adminBean = new AdminBean(user,password,user_name);

			boolean flag = adminDao.register(adminBean);
			if(flag)
				resp.sendRedirect(req.getContextPath()+"/login/login.jsp?status=2");
			else 
				// ע��ʧ�ܣ�����
				resp.sendRedirect(req.getContextPath()+"login/register.jsp?status=0");
		}
	
	// �˳���¼

	private void loginout(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ���ñ��뷽ʽ����ȡstatus
		req.setCharacterEncoding("utf-8");
			req.getSession().invalidate();
			req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
	}
	// ��¼

	private void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ���ñ��뷽ʽ����ȡ�û����ͽ���MD5���ܺ������
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("user");
		String password = req.getParameter("password");
		
		// ����adminDao��������ݿ�������ѽ������һ��adminDao����
		AdminDao adminDao = new AdminDao();
		
		AdminBean adminBean = adminDao.checkLogin(username, password);
		if (adminBean != null) {
			// ��Ϊ�վ��ǵ�¼�ɹ���������û��浽session��Ȼ���ת����̨��ҳ��
			req.getSession().setAttribute("adminBean",
					adminBean);
			resp.sendRedirect(req.getContextPath() + "/main/main.jsp");
		} else {
			// ��¼ʧ�������µ�¼
			resp.sendRedirect(req.getContextPath()
					+ "/login/login.jsp?status=1");
		}
	}
}
