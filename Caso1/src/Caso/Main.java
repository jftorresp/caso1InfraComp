package Caso;

public class Main {

	public static void main(String[] args) {
		
		Buffer buffer = new Buffer(25);
		for (int i = 0; i<1; i++)
		{
			Cliente cliente = new Cliente(i+1, buffer);
			System.out.println("Se crea cliente " + i);
			Servidor servidor = new Servidor(buffer);
			System.out.println("Se crea servidor " + i);

			
			cliente.start();
			System.out.println("Se inicia el cliente");
			servidor.start();
			System.out.println("Se inicia el servidor");
		}
		// TODO Auto-generated method stub

	}

}
