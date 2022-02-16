package com.pasofe.programaIbertrola;

import java.util.Scanner;

import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App {
	static conexion cn = new conexion();
	static Scanner sc = new Scanner(System.in);
	
    public static void main( String[] args ){
        

    	
    	int op=0;
    	
    	do {
    		System.out.println("");
    		System.out.println("Introduce");
    		System.out.println("______________________");
    		System.out.println("1.- Para listar las bbdd");
    		System.out.println("2.- Para conectarse a IBERTROLA");
    		System.out.println("3.- Listar colecciones");
    		System.out.println("4.- Crear colección PRUEBA");
    		System.out.println("5.- Eliminar colección PRUEBA");
    		System.out.println("6.- Insertar un Documento en PRUEBA");
    		System.out.println("7.- Mostrar documentos en PRUEBA");
    		System.out.println("8.- Eliminar ese Documento");
    		System.out.println("9.- Update del documento");
    		System.out.println("10.- Salir");
    		System.out.println("______________________");
    		op = sc.nextInt();
    		sc.nextLine();
    		
    		switch(op) {
    		case 1: cn.listarBBDD(); break;
    		case 2: cn.conectarBBDD(); break;
    		case 3: cn.listarColecciones(); break;
    		case 4: cn.crearColPrueba(); break;
    		case 5: cn.eliminarColPrueba(); break;
    		case 6: cn.insertarDocumento(); break;
    		case 7: cn.listarDocumentos(); break;
    		case 8: cn.eliminarDocumento(); break;
    		case 9: cn.actualizarDocumento(); break;
    		case 10: break;
    		default: break;
    		}
    	}while(op!=10);
    	

    }


	


}
