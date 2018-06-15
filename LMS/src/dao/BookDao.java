package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.BookBean;
import bean.ReaderBean;

import util.DBUtil;

public class BookDao {
	// 修改图书信息
	public boolean update(BookBean bookBean) {
		// TODO Auto-generated method stub
		
		boolean f = false;
		//修改数据库里的图书信息
		String sql = "update book set bk_name='"+bookBean.getBk_name()+"',bk_number='"+bookBean.getBk_number()+"',bk_type='"+bookBean.getBk_type()+"',writer='"+bookBean.getWriter()+"',price='"+bookBean.getPrice()+"',bs_number='"+bookBean.getBs_number()+"' where bk_code = "+bookBean.getBk_code();
		
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
	
	//根据图书编号删除图书信息
	public boolean delete(String bk_code){
		boolean f = false ;
		String sql = "delete from book where bk_code = '"+bk_code+"'";
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
	//根据图书编号和状态改变图书的状态
	public boolean changestate(String bk_code,String state1){
		String sql = "update book set bk_state = "+state1+" where bk_code='"+bk_code+"'";
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
	
	//根据图书编号查询图书信息
	public BookBean find(String bk_code){
		BookBean bookBean = new BookBean();
		String sql = "select * from book where bk_code='"+bk_code+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		try{
			state = conn.createStatement();
			rs= state.executeQuery(sql);
			while(rs.next()){
				bookBean.setBk_code( rs.getString( "bk_code"));
				bookBean.setBk_name( rs.getString( "bk_name"));
				bookBean.setBk_number( rs.getString( "bk_number"));
				bookBean.setBk_type( rs.getInt( "bk_type"));
				bookBean.setWriter( rs.getString( "writer"));
				bookBean.setPrice( rs.getFloat( "price"));
				bookBean.setAddtime( rs.getDate( "addtime"));
				bookBean.setOp_name( rs.getString( "op_name"));
				bookBean.setBs_number( rs.getString( "bs_number"));
				bookBean.setBk_state( rs.getInt( "bk_state"));
				bookBean.setBooktypeBean( new BooktypeDao().getBooktype(bookBean.getBk_type()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return bookBean;
	}
	
	// 添加图书
	public boolean add(BookBean bookBean) {
		// TODO Auto-generated method stub
		
		boolean f = false;
		// 向数据库里添加图书的信息
		String sql = "insert into book(bk_name,bk_number,bk_type,writer,price,addtime,op_name,bs_number) values('"
				+ bookBean.getBk_name()
				+ "','"
				+ bookBean.getBk_number()
				+ "','"
				+ bookBean.getBk_type()
				+ "','"
				+ bookBean.getWriter() 
				+ "','"
				+bookBean.getPrice()
				+ "',now(),'"+bookBean.getOp_name()
				+"','"+bookBean.getBs_number()+"')";
		
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
