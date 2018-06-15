package bean;

import java.util.Date;

public class BookBean {
	private String bk_code;
	private String bk_name;
	private String bk_number;
	private int bk_type;
	private String writer;
	private float price;
	private Date addtime;
	private String op_name;
	private String bs_number;
	private int bk_state;
	private BooktypeBean booktypeBean;
	
	
	
	public int getBk_state() {
		return bk_state;
	}
	public void setBk_state(int bk_state) {
		this.bk_state = bk_state;
	}
	public BookBean(String bk_name, String bk_number, int bk_type,
			String writer, float price, String op_name, String bs_number) {
		super();
		this.bk_name = bk_name;
		this.bk_number = bk_number;
		this.bk_type = bk_type;
		this.writer = writer;
		this.price = price;
		this.op_name = op_name;
		this.bs_number = bs_number;
	}
	public BooktypeBean getBooktypeBean() {
		return booktypeBean;
	}
	public void setBooktypeBean(BooktypeBean booktypeBean) {
		this.booktypeBean = booktypeBean;
	}
	public String getBk_code() {
		return bk_code;
	}
	public void setBk_code(String bk_code) {
		this.bk_code = bk_code;
	}
	public String getBk_name() {
		return bk_name;
	}
	public void setBk_name(String bk_name) {
		this.bk_name = bk_name;
	}
	public String getBk_number() {
		return bk_number;
	}
	public void setBk_number(String bk_number) {
		this.bk_number = bk_number;
	}
	public int getBk_type() {
		return bk_type;
	}
	public void setBk_type(int bk_type) {
		this.bk_type = bk_type;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public String getOp_name() {
		return op_name;
	}
	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}
	public String getBs_number() {
		return bs_number;
	}
	public void setBs_number(String bs_number) {
		this.bs_number = bs_number;
	}
	
	public BookBean() {
		// TODO Auto-generated constructor stub
	}
}
