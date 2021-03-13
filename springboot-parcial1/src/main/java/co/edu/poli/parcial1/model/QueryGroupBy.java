package co.edu.poli.parcial1.model;

public class QueryGroupBy {

	private int documento;
	
	private String descripcion;
	
	private Long sum;

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}
	
	public QueryGroupBy() {
		
	}
	
	public QueryGroupBy(int documento, String descripcion, Long sum) {
		this.documento = documento;
		this.descripcion = descripcion;
		this.sum = sum;
	}

}
