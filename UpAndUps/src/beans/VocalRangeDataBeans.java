package beans;

import java.io.Serializable;

public class VocalRangeDataBeans implements Serializable {

	private int id;
	private String name;
	private String category;

	// アクセサ
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
