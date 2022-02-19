package co.edu.poli.DI;

public class Main {
    public static void main(String[] args) {
    	
    	/*
    	Cliente1 cliente = new Cliente1();
    	cliente.setAbono(320);
    	cliente.setDiaPago(7); //1 Domingo, 2 Lunes, 3 Martes, etc.
    	cliente.setPhoneNumber("0123456789");
    	cliente.enviarRecordatorio();
    	*/
    	
        Cliente2 cliente = new Cliente2();
        cliente.setAbono(320);
        cliente.setDiaPago(7); //1 Domingo, 2 Lunes, 3 Martes, etc.
        cliente.setMedioContacto(MedioContacto.TWITTER);
        cliente.setEmail("molder.itp@gmail.com");
        cliente.setTwitter("@windoctor");
        cliente.setCelular("0123456789");

        //inyectamos el objeto especifico
        MensajeTwitter mt = new MensajeTwitter();
        mt.enviar("xx", "y");
        cliente.setMensaje(mt);
        //cliente.setMensaje(new MensajeSMS());
        
        cliente.enviarRecordatorio();
        
        
    }
}
