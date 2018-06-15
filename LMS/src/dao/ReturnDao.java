package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import util.DBUtil;
import bean.BorrowBean;
import bean.ReturnBean;


public class ReturnDao {
	// 添加还书信息到数据库
	public boolean add(ReturnBean returnBean) {
		// TODO Auto-generated method stub
		
		boolean f = false;
		
		// 向数据库里添加还书信息
		String sql = "insert into return1(readerid,bk_code,returntime,op_name) values('"
				+ returnBean.getReaderid()
				+ "','"
				+ returnBean.getBk_code()
				+ "',now(),'"
				+ returnBean.getOp_name()
				+ "')";
		
		Connection conn = DBUtil.getConn();
		Statement state = null;
		try {
			state = conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1){
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(state, conn);
		}
		return f;
	}
}
