package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.db.ebean.Model;


@Entity


public class BiCompany  extends Model{
	
	
	private static final long serialVersionUID = 1L;
	

	@Id
	private Long companyId;
	
	private String companyName;
	
	 
	 @OneToMany(mappedBy="company" ,cascade=CascadeType.PERSIST)
	  private List<BiApp> apps = new ArrayList<>();
	  
	 /* @OneToMany(mappedBy="company" ,cascade=CascadeType.PERSIST)
	  public List<QueryObjects> queryObjects = new ArrayList<>();*/
	
	 @ManyToMany(mappedBy="companies", cascade=CascadeType.ALL)
	  private List<BiUsers> users = new ArrayList<>();
	
	  
	
	 public Long getCompanyId() {
		return companyId;
	}



	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public List<BiApp> getApps() {
		return apps;
	}



	public void setApps(List<BiApp> apps) {
		this.apps = apps;
	}



	public List<BiUsers> getUsers() {
		return users;
	}



	public void setUsers(List<BiUsers> users) {
		this.users = users;
	}



	public static Finder<Long,BiCompany> find = new Finder<Long, BiCompany>(Long.class, BiCompany.class);
	
	public static List<String> getNames() {
		List<String> companyNames = new ArrayList<>();
		for (BiCompany c : find.all()) {
			companyNames.add(c.companyName);
		}
		return companyNames;
	}

}
