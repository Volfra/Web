package co.edu.poli.act1.model;

public class GroupQueryByAuto {
	
	private Auto auto;
	private Long qautos;
	
	public GroupQueryByAuto(Auto auto, Long qautos) {
		super();
		this.auto = auto;
		this.qautos = qautos;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Long getQautos() {
		return qautos;
	}

	public void setQautos(Long qautos) {
		this.qautos = qautos;
	}
	
}
