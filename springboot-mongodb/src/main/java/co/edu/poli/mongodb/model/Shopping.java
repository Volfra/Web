
package co.edu.poli.mongodb.model;

import java.util.Date;

public class Shopping {

	private Long id;
	
	private Date date;
	
	private Long total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
}
