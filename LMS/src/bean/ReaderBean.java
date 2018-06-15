package bean;

import java.util.Date;

public class ReaderBean {
	private String readerid;
	private String rd_name;
	private int rd_type;
	private String system;
	private String rclass;
	private String phone;
	private Date reg_time;
	private int borrowed_num;
	private ReadertypeBean readertypeBean;
	
	
	public ReaderBean(String rd_name, int rd_type, String system,
			String rclass, String phone) {
		super();
		this.rd_name = rd_name;
		this.rd_type = rd_type;
		this.system = system;
		this.rclass = rclass;
		this.phone = phone;
	}
	public ReadertypeBean getReadertypeBean() {
		return readertypeBean;
	}
	public void setReadertypeBean(ReadertypeBean readertypeBean) {
		this.readertypeBean = readertypeBean;
	}
	public String getReaderid() {
		return readerid;
	}
	public void setReaderid(String readerid) {
		this.readerid = readerid;
	}
	public String getRd_name() {
		return rd_name;
	}
	public void setRd_name(String rd_name) {
		this.rd_name = rd_name;
	}
	public int getRd_type() {
		return rd_type;
	}
	public void setRd_type(int rd_type) {
		this.rd_type = rd_type;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getRclass() {
		return rclass;
	}
	public void setRclass(String rclass) {
		this.rclass = rclass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getReg_time() {
		return reg_time;
	}
	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}
	public int getBorrowed_num() {
		return borrowed_num;
	}
	public void setBorrowed_num(int borrowed_num) {
		this.borrowed_num = borrowed_num;
	}
	
	public ReaderBean() {
		// TODO Auto-generated constructor stub
	}
}
