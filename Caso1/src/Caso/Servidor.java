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
		while(true)
		{
//			System.out.println("Voy a retirar un mensaje plis");
			mensaje = buffer.retirar();
			if(mensaje!=null){
				System.out.println("Retir�Ec el mensaje " + mensaje.darMensaje() + " y lo voy a responder");
				mensaje.responder();
				mensaje.despertar();
			}
			
			Thread.yield();
		}
	}
}
