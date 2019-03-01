package Caso;

public class Servidor extends Thread {

	private Buffer buffer;

	private Mensaje mensaje;

	public Servidor(Buffer pBuf)
	{
		buffer = pBuf;
	}

	public void run()
	{
		int i = 0;
		while(true && i<1000000)
		{
//			System.out.println("Voy a retirar un mensaje plis");
			mensaje = buffer.retirar();
			if(mensaje!=null){
				System.out.println("Retiré el mensaje " + mensaje.darMensaje() + " y lo voy a responder");
				mensaje.responder();
				mensaje.despertar();
				i=0;
			}
			i++;
			Thread.yield();
		}
		System.out.println("Los servidores ya esperaron mucho tiempo por mensajes, se cierra la aplicación.");
		System.exit(-1);
	}
}
