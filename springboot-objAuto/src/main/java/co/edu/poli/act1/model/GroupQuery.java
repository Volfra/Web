package co.edu.poli.act1.model;

public class GroupQuery {

	private Integer model;
	private Long qmodels;
	
	public GroupQuery() {
		// TODO Auto-generated constructor stub
	}
	
	public GroupQuery(Integer model, Long qmodels) {
		super();
		this.model = model;
		this.qmodels = qmodels;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}
	
	public Long getQmodels() {
		return qmodels;
	}

	public void setQmodels(Long qmodels) {
		this.qmodels = qmodels;
	}

	
}
