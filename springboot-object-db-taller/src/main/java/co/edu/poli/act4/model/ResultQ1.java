package co.edu.poli.act4.model;

public class ResultQ1 {
	
	private String state;
	private String nickname;
	private int admission_number;
	
	public ResultQ1() {
		// TODO Auto-generated constructor stub
	}
	
	public ResultQ1(String state, String nickname, int admission_number) {
		super();
		this.state = state;
		this.nickname = nickname;
		this.admission_number = admission_number;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getAdmission_number() {
		return admission_number;
	}
	public void setAdmission_number(int admission_number) {
		this.admission_number = admission_number;
	}

}
