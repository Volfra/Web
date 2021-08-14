package co.edu.poli.DI;

public class MensajeSMS implements IMensaje{

	@Override
	public void enviar(String destinatario, String mensaje) {
        System.out.printf("Enviando mensaje via SMS a %s \n Mensaje: %s", destinatario, mensaje);		
	}

}
