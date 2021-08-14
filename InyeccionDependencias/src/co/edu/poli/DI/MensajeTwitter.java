package co.edu.poli.DI;

public class MensajeTwitter implements IMensaje {

    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.printf("Enviando mensaje via Twitter a %s \n Mensaje: %s", destinatario, mensaje);
    }

}