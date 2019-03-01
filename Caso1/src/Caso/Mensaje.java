package Caso;

public class Mensaje {

	private int n;
	public Mensaje (int pn)
	{
		n = pn;
	}

	public void responder()
	{
		System.out.println("Respondí el mensaje");
		n++;
		System.out.println(n);
	}

	public void dormir ()
	{
		try {
			System.out.println("Se duerme el cliente en el mensaje");
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void despertar ()
	{
		synchronized (this) {
			this.notify();
			System.out.println("Se despertó el cliente");
		}
	}

	public int darMensaje()
	{
		return n;
	}

}
