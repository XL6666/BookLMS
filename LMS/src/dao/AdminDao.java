package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.AdminBean;
import util.DBUtil;

public class AdminDao {
	
	//注册
	public boolean register(AdminBean adminBean) {
		// TODO Auto-generated method stub
		// 向数据库里添加管理员的信息
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
	
	
	//登录
	public AdminBean checkLogin(String user, String password) {
		//获取连接
		Connection conn = DBUtil.getConn();
		
		//建立管理员对象
		AdminBean adminBean = null;
		try {
			//创建状态对象
		Statement state = conn.createStatement();
		//创建结果集对象，找出用户名等于username的信息
		ResultSet rs = state.executeQuery("select * from admin where user='" + user + "'");
		if (rs.next()) {
		// 如果有结果，是认为是通过验证了
		if
		(rs.getString("password").equals(password)) {
			//相等的话就把从数据库里读出的属性对AdminBean对象进行赋值
		adminBean = new AdminBean();
		adminBean.setUser(rs.getString("user"));
		adminBean.setPassword(rs.getString("password"));
		adminBean.setUser_name(rs.getString("user_name"));
		}
		}
		//关闭数据库的连接
		DBUtil.close(rs, state, conn);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return adminBean;
		}
}
