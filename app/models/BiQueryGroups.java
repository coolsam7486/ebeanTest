package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;

@Entity
public class BiQueryGroups extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private BiQueryObjects queryId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private BiApp appId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private BiGroups groupId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BiQueryObjects getQueryId() {
		return queryId;
	}

	public void setQueryId(BiQueryObjects queryId) {
		this.queryId = queryId;
	}

	public BiApp getAppId() {
		return appId;
	}

	public void setAppId(BiApp appId) {
		this.appId = appId;
	}

	public BiGroups getGroupId() {
		return groupId;
	}

	public void setGroupId(BiGroups groupId) {
		this.groupId = groupId;
	}

	private BiQueryGroups(BiQueryObjects queryId, BiApp appId, BiGroups groupId) {

		this.queryId = queryId;
		this.appId = appId;
		this.groupId = groupId;
	}

	public static BiQueryGroups Big(BiQueryObjects queryId, BiApp appId,
			BiGroups groupId) {

		return new BiQueryGroups(queryId, appId, groupId);
	}

	@SuppressWarnings("deprecation")
	public static Finder<Long, BiQueryGroups> find = new Finder<Long, BiQueryGroups>(
			Long.class, BiQueryGroups.class);

}
