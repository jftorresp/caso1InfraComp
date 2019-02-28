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

	public static void main(String[] args) throws IOException {

		//		File fichero = new File("./datos/archivo.txt");
		//		Scanner s = null;
		//		
		//		try {
		//			// Leemos el contenido del fichero
		//			s = new Scanner(fichero);
		//
		//			ArrayList<String> datos = new ArrayList<String>();
		//			
		//			// Leemos linea a linea el fichero
		//			while (s.hasNextLine()) {
		//				String linea = s.nextLine(); 	// Guardamos la linea en un String
		//								
		//				int dato = Integer.parseInt(linea);
		//				
		//				datos.add(linea);
		//				
		//				System.out.println(datos.size());
		//			}
		//
		//		} catch (Exception ex) {
		//			ex.getMessage();
		//		} 

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("./datos/archivo.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while((linea=br.readLine()) != null)
			{
				System.out.println(linea);
			}

			
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
