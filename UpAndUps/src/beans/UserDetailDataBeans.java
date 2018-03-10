package beans;

import java.io.Serializable;

public class UserDetailDataBeans implements Serializable {

	private int id;
	private int user_id;
	private String sex;
	private String photo_url;
	private String affiliation_form;
	private String birth_date;
	private int birth_place_id;
	private String blood_type;
	private int vocal_range_id;
	private String special_skill;
	private String hobby;
	private String license;
	private String twitter_url;
	private String twitter_id;
	private String filmographies_anime;
	private String filmographies_film;
	private String filmographies_narration;
	private String filmographies_other;

	private String birth_date_format;

	private String login_id;
	private String name;

	private String prefectures_name;
	private String vocal_range;

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
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirth_place_id() {
		return birth_place_id;
	}
	public void setBirth_place_id(int birth_place_id) {
		this.birth_place_id = birth_place_id;
	}
	public String getBlood_type() {
		return blood_type;
	}
	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}
	public String getFilmographies_anime() {
		return filmographies_anime;
	}
	public void setFilmographies_anime(String filmographies_anime) {
		this.filmographies_anime = filmographies_anime;
	}
	public String getFilmographies_film() {
		return filmographies_film;
	}
	public void setFilmographies_film(String filmographies_film) {
		this.filmographies_film = filmographies_film;
	}
	public String getFilmographies_narration() {
		return filmographies_narration;
	}
	public void setFilmographies_narration(String filmographies_narration) {
		this.filmographies_narration = filmographies_narration;
	}
	public String getFilmographies_other() {
		return filmographies_other;
	}
	public void setFilmographies_other(String filmographies_other) {
		this.filmographies_other = filmographies_other;
	}
	public String getPrefectures_name() {
		return prefectures_name;
	}
	public void setPrefectures_name(String prefectures_name) {
		this.prefectures_name = prefectures_name;
	}
	public String getVocal_range() {
		return vocal_range;
	}
	public void setVocal_range(String vocal_range) {
		this.vocal_range = vocal_range;
	}
	public void setBirth_date_format(String birth_date_format) {
		this.birth_date_format = birth_date_format;
	}
	public String getBirth_date_format() {
		return birth_date_format;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}


}
