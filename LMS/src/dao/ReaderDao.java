package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBUtil;

import bean.ReaderBean;



public class ReaderDao {
	
	// 修改读者信息
	public boolean update(ReaderBean readerBean) {
		// TODO Auto-generated method stub
		
		boolean f = false;
		//修改数据库里的读者信息
		String sql = "update reader set rd_name='"+readerBean.getRd_name()+"',rd_type='"+readerBean.getRd_type()+"',system='"+readerBean.getSystem()+"',rclass='"+readerBean.getRclass()+"',phone='"+readerBean.getPhone()+"' where readerid = "+readerBean.getReaderid();
		
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
	
	//根据借书卡号删除读者信息
	public boolean delete(String readerid){
		boolean f = false ;
		String sql = "delete from reader where readerid = '"+readerid+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		try{
			state = conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1){
				f = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(state, conn);
		}
		return f;
	}
	
	//根据借书卡号改变读者的已借阅数量
	public boolean Borrowed_num(String readerid,String operator){
		boolean f=false;
		String sql= "";
		if(operator.equals("+"))
			sql = "update reader set borrowed_num =borrowed_num+1 where readerid='"+readerid+"'";
		else if(operator.equals( "-"))
			sql = "update reader set borrowed_num =borrowed_num-1 where readerid='"+readerid+"'";
			
		Connection conn = DBUtil.getConn();
		Statement state = null;
		try{
			state = conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1)
				f=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(state, conn);
		}
		return f;
	}
	
	//根据借书卡号查询读者信息
	public ReaderBean find(String readerid){
		ReaderBean readerBean = new ReaderBean();
		String sql = "select * from reader where readerid='"+readerid+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		try{
			state = conn.createStatement();
			rs= state.executeQuery(sql);
			while(rs.next()){
				readerBean.setReaderid( rs.getString( "readerid"));
				readerBean.setRd_name( rs.getString( "rd_name"));
				readerBean.setRd_type( rs.getInt( "rd_type"));
				readerBean.setSystem( rs.getString( "system"));
				readerBean.setRclass( rs.getString( "rclass"));
				readerBean.setPhone( rs.getString( "phone"));
				readerBean.setReg_time( rs.getDate( "reg_time"));
				readerBean.setBorrowed_num( rs.getInt( "borrowed_num"));
				readerBean.setReadertypeBean( new ReadertypeDao().getReadertype(readerBean.getRd_type()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return readerBean;
	}
	
	// 添加读者
	public boolean add(ReaderBean readerBean) {
		// TODO Auto-generated method stub
		
		boolean f = false;
		// 向数据库里添加读者的信息
		String sql = "insert into reader(rd_name,rd_type,system,rclass,phone,reg_time) values('"
				+ readerBean.getRd_name()
				+ "','"
				+ readerBean.getRd_type()
				+ "','"
				+ readerBean.getSystem()
				+ "','"
				+ readerBean.getRclass() 
				+ "','"
				+readerBean.getPhone()
				+ "',now())";
		
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
