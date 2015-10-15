package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.avaje.ebean.Model;

@Entity
public class BiGroups extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private Long groupId;

	private String groupName;

	@ManyToMany(mappedBy = "groups", cascade = CascadeType.PERSIST)
	private List<BiUsers> users = new ArrayList<>();

	@OneToMany(mappedBy = "groupId", cascade = CascadeType.PERSIST)
	private List<BiQueryGroups> queryGroups = new ArrayList<>();

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<BiUsers> getUsers() {
		return users;
	}

	public void setUsers(List<BiUsers> users) {
		this.users = users;
	}

	public List<BiQueryGroups> getQueryGroups() {
		return queryGroups;
	}

	public void setQueryGroups(List<BiQueryGroups> queryGroups) {
		this.queryGroups = queryGroups;
	}

	@SuppressWarnings("deprecation")
	public static Finder<Long, BiGroups> find = new Finder<Long, BiGroups>(
			Long.class, BiGroups.class);
}
