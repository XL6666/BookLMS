package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.AdminBean;
import util.DBUtil;

public class AdminDao {
	
	//ע��
	public boolean register(AdminBean adminBean) {
		// TODO Auto-generated method stub
		// �����ݿ�����ӹ���Ա����Ϣ
		String sql = "insert into admin(user,password,user_name) values('"
				+ adminBean.getUser()
				+ "','"
				+ adminBean.getPassword()
				+ "','"
				+ adminBean.getUser_name()+ "')";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		boolean f= false;
		try {
			state = conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1)
				f=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(state, conn);
		}
		return f;
	}
	
	
	//��¼
	public AdminBean checkLogin(String user, String password) {
		//��ȡ����
		Connection conn = DBUtil.getConn();
		
		//��������Ա����
		AdminBean adminBean = null;
		try {
			//����״̬����
		Statement state = conn.createStatement();
		//��������������ҳ��û�������username����Ϣ
		ResultSet rs = state.executeQuery("select * from admin where user='" + user + "'");
		if (rs.next()) {
		// ����н��������Ϊ��ͨ����֤��
		if
		(rs.getString("password").equals(password)) {
			//��ȵĻ��ͰѴ����ݿ�����������Զ�AdminBean������и�ֵ
		adminBean = new AdminBean();
		adminBean.setUser(rs.getString("user"));
		adminBean.setPassword(rs.getString("password"));
		adminBean.setUser_name(rs.getString("user_name"));
		}
		}
		//�ر����ݿ������
		DBUtil.close(rs, state, conn);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return adminBean;
		}
}
