package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import play.data.validation.Constraints.Required;

import com.avaje.ebean.Model;

@Entity
@Table(name = "queryObjects", uniqueConstraints = @UniqueConstraint(columnNames = {
		"app_app_id", "chart_type", "query_title", "query_desc", "query_text" }))
public class BiQueryObjects extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "query_id")
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private BiApp app;

	@Required
	private String chartType;

	@Required
	private String queryTitle;

	private String queryDesc;

	@Required
	@javax.persistence.Column(length = 5000)
	private String queryText;

	@Required
	@OneToMany(mappedBy = "queryId", cascade = CascadeType.PERSIST)
	private List<BiQueryGroups> queryGroups = new ArrayList<>();

	public BiQueryObjects(BiApp app, String chartType, String queryTitle,
			String queryDesc, String queryText) {
		super();
		this.app = app;
		this.chartType = chartType;
		this.queryTitle = queryTitle;
		this.queryDesc = queryDesc;
		this.queryText = queryText;
	}

	public static Finder<Long, BiQueryObjects> find = new Finder<Long, BiQueryObjects>(
			Long.class, BiQueryObjects.class);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BiApp getApp() {
		return app;
	}

	public void setApp(BiApp app) {
		this.app = app;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

	public String getQueryTitle() {
		return queryTitle;
	}

	public void setQueryTitle(String queryTitle) {
		this.queryTitle = queryTitle;
	}

	public String getQueryDesc() {
		return queryDesc;
	}

	public void setQueryDesc(String queryDesc) {
		this.queryDesc = queryDesc;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public List<BiQueryGroups> getQueryGroups() {
		return queryGroups;
	}

	public void setQueryGroups(List<BiQueryGroups> queryGroups) {
		this.queryGroups = queryGroups;
	}

	/*
	 * public Promise<Void> asyncSave() { // TODO Auto-generated method stub
	 * 
	 * 
	 * return Promise.promise(new Function0<Void>() {
	 * 
	 * @Override public Void apply() throws Throwable {
	 * 
	 * 
	 * save(); return null; } }, DBExecutionContext.ctx);
	 * 
	 * 
	 * 
	 * }
	 */
}
