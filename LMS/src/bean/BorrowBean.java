package bean;

import java.util.Date;

public class BorrowBean {
	private String readerid;
	private String bk_code;
	private Date borrowtime;
	private Date duedate;
	private String op_name;
	private int borrowstate;
	private ReaderBean readerBean;
	private BookBean bookBean;
	
	
	
	public BorrowBean(String readerid, String bk_code, Date borrowtime,
			Date duedate, String op_name) {
		super();
		this.readerid = readerid;
		this.bk_code = bk_code;
		this.borrowtime = borrowtime;
		this.duedate = duedate;
		this.op_name = op_name;
	}
	public ReaderBean getReaderBean() {
		return readerBean;
	}
	public void setReaderBean(ReaderBean readerBean) {
		this.readerBean = readerBean;
	}
	public BookBean getBookBean() {
		return bookBean;
	}
	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}
	public String getReaderid() {
		return readerid;
	}
	public void setReaderid(String readerid) {
		this.readerid = readerid;
	}
	public String getBk_code() {
		return bk_code;
	}
	public void setBk_code(String bk_code) {
		this.bk_code = bk_code;
	}
	
	public Date getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(Date borrowtime) {
		this.borrowtime = borrowtime;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public String getOp_name() {
		return op_name;
	}
	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}
	public int getBorrowstate() {
		return borrowstate;
	}
	public void setBorrowstate(int borrowstate) {
		this.borrowstate = borrowstate;
	}
	
	public BorrowBean() {
		// TODO Auto-generated constructor stub
	}
}
