package co.edu.poli.DI;

import java.util.Calendar;

public class Cliente1 {

	private int diaPago;
    private double abono;
    private String phoneNumber;

    public void enviarRecordatorio(){
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);

        if(dia == diaPago && abono >= 300){
            new SMS().sendMessage(phoneNumber,"Favor de pasar a pagar");
        }
    }

	public int getDiaPago() {
		return diaPago;
	}

	public void setDiaPago(int diaPago) {
		this.diaPago = diaPago;
	}

	public double getAbono() {
		return abono;
	}

	public void setAbono(double abono) {
		this.abono = abono;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}