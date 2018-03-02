package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDataBeans implements Serializable {

	private int id;
	private String login_id;
	private String password;
	private String name;
	private Date create_date;
	private Date update_date;



	// アクセサ
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getFormatCreateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(create_date);
	}
	public String getFormatUpdateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(update_date);
	}

}
