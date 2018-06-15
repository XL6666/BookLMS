package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import bean.ReadertypeBean;

public class ReadertypeDao {
	/*
	 *根据读者类型编号从数据库中获取读者类型的详细信息
	 */
	public ReadertypeBean getReadertype(int rt_id){
		String sql = "select * from readertype where rt_id="+rt_id+"";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;
		ReadertypeBean readertypeBean = null;
		try{
			state = conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				readertypeBean = new ReadertypeBean();
				readertypeBean.setRt_id(rs.getInt( "rt_id"));
				readertypeBean.setRt_name(rs.getString( "rt_name"));
				readertypeBean.setRt_number(rs.getInt( "rt_number"));
				readertypeBean.setRt_time(rs.getInt( "rt_time"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return readertypeBean;
	}
}	
