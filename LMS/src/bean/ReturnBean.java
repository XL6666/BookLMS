package bean;

import java.util.Date;

public class ReturnBean {
	private String readerid;
	private String bk_code;
	private Date returntime;
	private String op_name;
	private ReaderBean readerBean;
	private BookBean bookBean;
	
	
	public ReturnBean(String readerid, String bk_code, String op_name) {
		super();
		this.readerid = readerid;
		this.bk_code = bk_code;
		this.op_name = op_name;
	}

	public ReturnBean(ReaderBean readerBean, BookBean bookBean) {
		super();
		this.readerBean = readerBean;
		this.bookBean = bookBean;
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

	public ReturnBean() {
		// TODO Auto-generated constructor stub
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


	public Date getReturntime() {
		return returntime;
	}

	public void setReturntime(Date returntime) {
		this.returntime = returntime;
	}

	public String getOp_name() {
		return op_name;
	}

	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}
}
