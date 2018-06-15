package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBUtil;
import bean.BooktypeBean;

public class BooktypeDao {
	/*
	 *根据图书类型编号从数据库中获取图书类型的详细信息
	 */
	public BooktypeBean getBooktype(int bt_id){
		String sql = "select * from booktype where bt_id="+bt_id+"";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		BooktypeBean booktypeBean = null;
		try{
			state = conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				booktypeBean = new BooktypeBean();
				booktypeBean.setBt_id(rs.getInt( "bt_id"));
				booktypeBean.setBt_name(rs.getString( "bt_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return booktypeBean;
	}
}
