package Caso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("./datos/archivo.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			
			int numClientes = Integer.parseInt(br.readLine());
			int capacidadBuffer = Integer.parseInt(br.readLine());
			int numServidores = Integer.parseInt(br.readLine());
			int numMensajes = Integer.parseInt(br.readLine());
			
			Buffer buffer = new Buffer(capacidadBuffer);
			for (int i = 0; i<numClientes; i++)
			{
				Cliente cliente = new Cliente(numMensajes, buffer);
				System.out.println("Se crea cliente " + i);

				cliente.start();
				System.out.println("Se inicia el cliente");

			}
			
			for (int i=0; i<numServidores; i++){
				Servidor servidor = new Servidor(buffer);
				System.out.println("Se crea servidor " + i);
				servidor.start();
				System.out.println("Se inicia el servidor");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta 
			// una excepcion.
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		} 

		
		// TODO Auto-generated method stub

	}

}
