package Caso;

public class Cliente extends Thread{

	private Buffer buffer;
	
	private static int num;
	
	public Cliente(int mensajes, Buffer pBuf)
	
	{
		num = mensajes;
		buffer = pBuf;
	}
	
	public void run() {
		Boolean finalT = false;
		Boolean terminado = true;
		
		for (int i = 0; i < num && terminado; i++)
		{
			terminado = false;
			
			Mensaje mensaje = new Mensaje(i);
			System.out.println("Se crea el mensaje " + i);
			System.out.println("Se va a almacenar el mensaje " + i);
			buffer.almacenar(mensaje);
			System.out.println("Se almacenó y se va a cambiar el estado de terminado");
			terminado = true;
			
		}
		
		System.out.println("Se acaban por completo los mensajes del cliente " + this);
		finalT = true;
	}

}
