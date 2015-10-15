package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;

import com.avaje.ebean.Model;

@Entity
public class BiUsers extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private Long userId;

	private String userName;

	@Email
	@Required
	@Column(unique = true)
	private String email;

	private String passWord;

	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<BiGroups> groups = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<BiCompany> companies = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<BiApp> apps = new ArrayList<>();

	public static Finder<Long, BiUsers> find = new Finder<Long, BiUsers>(
			Long.class, BiUsers.class);

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public List<BiGroups> getGroups() {
		return groups;
	}

	public void setGroups(List<BiGroups> groups) {
		this.groups = groups;
	}

	public List<BiCompany> getCompanies() {
		return companies;
	}

	public void setCompanies(List<BiCompany> companies) {
		this.companies = companies;
	}

	public List<BiApp> getApps() {
		return apps;
	}

	public void setApps(List<BiApp> apps) {
		this.apps = apps;
	}

	public static List<String> getNames() {
		List<String> userNames = new ArrayList<>();
		for (BiUsers user : find.all()) {
			userNames.add(user.userName);
		}
		return userNames;
	}

}
