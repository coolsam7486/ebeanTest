package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;

import com.avaje.ebean.Model;

@Entity
public class BiApp extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private Long appId;

	@Required
	private String appName;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private BiCompany company;

	@ManyToMany(mappedBy = "apps", cascade = CascadeType.PERSIST)
	private List<BiUsers> users = new ArrayList<>();

	public BiApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy = "app", cascade = CascadeType.PERSIST)
	private List<BiQueryObjects> queryObjects = new ArrayList<>();

	@OneToMany(mappedBy = "appId", cascade = CascadeType.PERSIST)
	private List<BiQueryGroups> queryGroups = new ArrayList<>();

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public BiCompany getCompany() {
		return company;
	}

	public void setCompany(BiCompany company) {
		this.company = company;
	}

	public List<BiUsers> getUsers() {
		return users;
	}

	public void setUsers(List<BiUsers> users) {
		this.users = users;
	}

	public List<BiQueryObjects> getQueryObjects() {
		return queryObjects;
	}

	public void setQueryObjects(List<BiQueryObjects> queryObjects) {
		this.queryObjects = queryObjects;
	}

	public List<BiQueryGroups> getQueryGroups() {
		return queryGroups;
	}

	public void setQueryGroups(List<BiQueryGroups> queryGroups) {
		this.queryGroups = queryGroups;
	}

	@SuppressWarnings("deprecation")
	public static Finder<Long, BiApp> find = new Finder<Long, BiApp>(
			Long.class, BiApp.class);

	public static List<String> getNames() {
		List<String> appNames = new ArrayList<>();
		for (BiApp app : find.all()) {
			appNames.add(app.appName);
		}
		return appNames;
	}

}
