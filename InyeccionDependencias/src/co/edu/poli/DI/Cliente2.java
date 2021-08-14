package co.edu.poli.DI;

import java.util.Calendar;

public class Cliente2 {

    private long id;
    private int diaPago;
    private double abono;

    private String celular;
    private String twitter;
    private String email;

    private MedioContacto medioContacto;

    private IMensaje mensaje;

	public void enviarRecordatorio() {
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);

        if (dia == diaPago && abono >= 300) {
            if(medioContacto == MedioContacto.EMAIL)
                mensaje.enviar(email, "Favor de pasar a pagar");
            else if (medioContacto == MedioContacto.SMS)
                mensaje.enviar(celular, "Favor de pasar a pagar");
            else if(medioContacto == MedioContacto.TWITTER)
                mensaje.enviar(twitter, "Favor de pasar a pagar");
        }
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MedioContacto getMedioContacto() {
		return medioContacto;
	}

	public void setMedioContacto(MedioContacto medioContacto) {
		this.medioContacto = medioContacto;
	}

	public IMensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(IMensaje mensaje) {
		this.mensaje = mensaje;
	}

}