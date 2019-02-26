package Caso;

import java.util.ArrayList;

public class Buffer {

	public ArrayList<Mensaje> buff;

	//Capacidad del buffer
	private int n;

	Object lleno;

	Object vacio;

	public Buffer(int n) {
		this.n = n;
		buff = new ArrayList<Mensaje>();
		lleno = new Object();
		vacio = new Object();
	}

	public void almacenar(Mensaje i) {
		synchronized (lleno) {
			while (buff.size() == n) {
				try {
					System.out.println("Buffer lleno");
					lleno.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("El buffer no está lleno");
		
		synchronized (i){
			buff.add(i);
			System.out.println("Se añadió el mensaje " + i.darMensaje());
			System.out.println("El cliente se va a dormir");
			i.dormir();
		}


		synchronized (vacio) {
			vacio.notify();
		}
	}

	public Mensaje retirar() {

		synchronized(this){
			if(buff.size() >0)
			{
				Mensaje i;
				i = buff.remove(0);

				synchronized (lleno) {
					lleno.notify();
				}
				return i;
			}
			else{
				return null;
			}

		}
	}


}
