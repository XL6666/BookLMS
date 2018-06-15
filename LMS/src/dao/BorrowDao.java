package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import bean.BorrowBean;

import util.DBUtil;

public class BorrowDao {
	
	
	//�ı������Ϣ�е�״̬
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
	
	//���ݽ��鿨�ź�ͼ���Ų�ѯ���߽�����Ϣ
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
	
	// ��ӽ�����Ϣ�����ݿ�
	public boolean add(BorrowBean borrowBean) {
		// TODO Auto-generated method stub
		
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		
		boolean f = false;
		// �����ݿ�����ӽ�����Ϣ
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
