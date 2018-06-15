package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import bean.BorrowBean;

import util.DBUtil;

public class BorrowDao {
	
	
	//改变借书信息中的状态
	public boolean changestate(String readerid,String bk_code){
		String sql = "delete from borrow  where readerid = '"+readerid+"' and bk_code='"+bk_code+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		boolean f = false;
		try{
			state = conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1){
				f=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(state, conn);
		}
		return f;
	}
	
	//根据借书卡号和图书编号查询读者借书信息
	public BorrowBean find(String readerid,String bk_code){
		BorrowBean borrowBean = new BorrowBean();
		String sql = "select * from borrow where readerid='"+readerid+"' and bk_code='"+bk_code+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		try{
			state = conn.createStatement();
			rs= state.executeQuery(sql);
			while(rs.next()){
				borrowBean.setDuedate( rs.getDate( "duedate"));
				borrowBean.setBorrowstate( rs.getInt( "borrowstate"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return borrowBean;
	}
	
	// 添加借书信息到数据库
	public boolean add(BorrowBean borrowBean) {
		// TODO Auto-generated method stub
		
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		
		boolean f = false;
		// 向数据库里添加借书信息
		String sql = "insert into borrow(readerid,bk_code,borrowtime,duedate,op_name) values('"
				+ borrowBean.getReaderid()
				+ "','"
				+ borrowBean.getBk_code()
				+ "','"
				+ format.format(borrowBean.getBorrowtime())
				+ "','"
				+ format.format(borrowBean.getDuedate()) 
				+ "','"
				+borrowBean.getOp_name()+"')";
		
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
