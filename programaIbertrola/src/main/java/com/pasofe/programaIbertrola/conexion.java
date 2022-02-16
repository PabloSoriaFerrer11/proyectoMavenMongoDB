package com.pasofe.programaIbertrola;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCommandException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class conexion {

	//public DB bbddActual;
	private MongoDatabase bbdd;
	private MongoCollection coleccion;
	
	public conexion() {
		
	}
	
	public MongoClient conexion() {
		MongoClient mongo = null;
        mongo = new MongoClient("localhost", 27017);
        return mongo;
	}
	
	public void listarBBDD() {
		MongoClient cn = conexion();
		
		
		MongoIterable listas = cn.listDatabaseNames();
		System.out.println("_BASES_");
		for(Object s : listas) {
			System.out.println("--> " + s.toString());
		}
		System.out.println("");
	}

	public void listarColecciones() {
		MongoClient cn = conexion();
		
		
		
		MongoIterable listas = bbdd.listCollectionNames();
		System.out.println("_COLECCIONES_");
		for(Object s : listas) {
			System.out.println("--> " + s.toString());
		}
		System.out.println("");
	}	
	
	public void conectarBBDD() {
		MongoClient cn = conexion();
		
		MongoDatabase db = cn.getDatabase("ibertrola");
		bbdd =  db;
		coleccion = bbdd.getCollection("pruebaCliente");
		
	}

	public void crearColPrueba() {
		try {
			bbdd.createCollection("pruebaCliente");
			coleccion = bbdd.getCollection("pruebaCliente");	
		}catch(MongoCommandException e) {
			System.out.println("Ya existe");
		}
	}

	public void eliminarColPrueba() {
		System.out.println("DROPEANDO la coleccion");
		bbdd.getCollection("pruebaCliente").drop();
	}

	public void insertarDocumento() {
		//Dato random para saber que 2 inserrciones son diferentes
		double dato = Math.random()*100;
		Document doc = new Document();
		doc.append("nombre", "Pablo Soria Ferrer");
		doc.append("dni", "71230158D");
		doc.append("rand", String.valueOf(dato));
		
		coleccion.insertOne(doc);
		
		
	}

	public void eliminarDocumento() {
		// TODO Auto-generated method stub
		coleccion.deleteOne(Filters.eq("nombre", "Pablo Soria Ferrer"));
	}

	public void listarDocumentos() {
	      FindIterable<Document> iterDoc = coleccion.find();
	      int i = 1;
	      System.out.println("Remaining documents:");
	      Iterator it = iterDoc.iterator();
	      while (it.hasNext()) {
	         System.out.println(it.next());
	         i++;
	      }
		
	}

	public void actualizarDocumento() {
		// TODO Auto-generated method stub
		double rand = Math.random()*-50;
		coleccion.updateOne(Filters.eq("nombre", "Pablo Soria Ferrer"), Updates.set("rand", String.valueOf(rand)));
	}
	
}
