package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDetailDataBeans implements Serializable {

	private int id;
	private int user_id;
	private String sex;
	private String photo_url;
	private String affiliation_form;
	private Date birth_date;
	private int vocal_range_id;
	private String special_skill;
	private String hobby;
	private String license;
	private String twitter_url;
	private String twitter_id;
	private String filmographies;

	private String name;

	// アクセサ
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	public String getAffiliation_form() {
		return affiliation_form;
	}
	public void setAffiliation_form(String affiliation_form) {
		this.affiliation_form = affiliation_form;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public int getVocal_range_id() {
		return vocal_range_id;
	}
	public void setVocal_range_id(int vocal_range_id) {
		this.vocal_range_id = vocal_range_id;
	}
	public String getSpecial_skill() {
		return special_skill;
	}
	public void setSpecial_skill(String special_skill) {
		this.special_skill = special_skill;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getTwitter_url() {
		return twitter_url;
	}
	public void setTwitter_url(String twitter_url) {
		this.twitter_url = twitter_url;
	}
	public String getTwitter_id() {
		return twitter_id;
	}
	public void setTwitter_id(String twitter_id) {
		this.twitter_id = twitter_id;
	}
	public String getFilmographies() {
		return filmographies;
	}
	public void setFilmographies(String filmographies) {
		this.filmographies = filmographies;
	}
	public String getFormatBirthDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(birth_date);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	}
