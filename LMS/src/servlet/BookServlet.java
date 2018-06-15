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
		// ���ñ��뷽ʽ����ȡmethod
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
	
	//�޸�ͼ����Ϣ
	private void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ��JSPҳ���ȡͼ����Ϣ
		String bk_code = req.getParameter( "bk_code");
		String bk_name = req.getParameter("bk_name");
		String bk_number = req.getParameter("bk_number");
		int bk_type = Integer.parseInt( req.getParameter("bk_type"));
		String writer=req.getParameter( "writer");
		float price =Float.parseFloat(req.getParameter( "price")) ;
		String op_name ="��ƾ�";
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
	
	//��ȡͼ����Ϣ���޸Ľ�����ʾ
	private void correct(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		//���ñ��뷽ʽ����ȡͼ���ͼ����
		req.setCharacterEncoding("utf-8");
		String bk_code = req.getParameter("bk_code");
		
		BookDao bookDao = new BookDao();
		BookBean bookBean = new BookBean();
		bookBean = bookDao.find(bk_code);
		
		req.setAttribute("bookBean", bookBean);
		req.getRequestDispatcher("/book/correct.jsp").forward(req, resp);
	}
	
	//ɾ��ͼ��
	private void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		//���ñ��뷽ʽ����ȡͼ���ͼ����
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
	
	//��ѯͼ��
	private void find(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String bk_code = req.getParameter("bk_code");
		BookBean bookBean =new BookBean();
		
		BookDao bookDao = new BookDao();
		bookBean=bookDao.find(bk_code);
		req.setAttribute("bookBean", bookBean);
		req.getRequestDispatcher("/book/find.jsp").forward(req, resp);
	}
	
	
	// ���ͼ��

	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��JSPҳ���ȡͼ����Ϣ
		req.setCharacterEncoding("utf-8");
		String bk_name = req.getParameter("bk_name");
		String bk_number = req.getParameter("bk_number");
		int bk_type = Integer.parseInt( req.getParameter("bk_type"));
		String writer=req.getParameter( "writer");
		float price =Float.parseFloat(req.getParameter( "price")) ;
		String op_name = "��ƾ�";
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
