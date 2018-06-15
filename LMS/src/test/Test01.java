package test;


import bean.ReturnBean;
import dao.ReturnDao;

public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
ReturnBean returnBean = new ReturnBean("1","1","ÐìºÆ¾ü");
		
		ReturnDao returnDao = new ReturnDao();
		boolean f1 = returnDao.add(returnBean);  
		System.out.println(f1);
	}

}
