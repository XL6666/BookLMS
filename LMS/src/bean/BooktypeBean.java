package bean;

public class BooktypeBean {
	private int bt_id;
	private String bt_name;
	public BooktypeBean(int bt_id, String bt_name) {
		super();
		this.bt_id = bt_id;
		this.bt_name = bt_name;
	}
	public int getBt_id() {
		return bt_id;
	}
	public void setBt_id(int bt_id) {
		this.bt_id = bt_id;
	}
	public String getBt_name() {
		return bt_name;
	}
	public void setBt_name(String bt_name) {
		this.bt_name = bt_name;
	}
	
	public BooktypeBean() {
		// TODO Auto-generated constructor stub
	}
}
