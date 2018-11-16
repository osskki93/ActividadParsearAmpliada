package parser;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Parser {
	
	private Document dom = null;
	private ArrayList <Libro> libros = null;
	
	public Parser () {
		libros = new ArrayList<Libro>();
	}
	
	
	public void parseFicheroXML (String fichero) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
	
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(fichero);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void parseDocument() {
		
		Element docEle = dom.getDocumentElement();
		NodeList n1 = docEle.getElementsByTagName("libro");
		
		if (n1 != null && n1.getLength() > 0) {
			for (int i = 0; i < n1.getLength() ; i++) {
				
				Element el = (Element) n1.item(i);
				Libro l = getLibro(el);
				libros.add(l);
				
				
			}
		}
	
	}
	
	public Libro getLibro(Element libroEle) {
		
		String titulo = getTextValue(libroEle, "titulo");
		int anyo = getIntAtribute (libroEle, "titulo");
		ArrayList <Autor> autores= getArray (libroEle, "autor");
		String editor = getTextValue(libroEle, "editor");
		int paginas = getIntValue(libroEle, "paginas");
		
		Libro l = new Libro (titulo, anyo, autores, editor, paginas);
		return l;
			
		
	}
	

	private String getTextValue (Element ele, String tagName) {
		
		String textValue = null;
		NodeList n1 = ele.getElementsByTagName(tagName);
		
		if (n1 != null && n1.getLength() > 0) {
			
			Element el = (Element) n1.item(0);
			textValue = el.getFirstChild().getTextContent();
		}
		
		return textValue;
	}
	
	private int getIntAtribute (Element ele, String tagName) {
		
		int anyo = 0;
		NodeList n1 = ele.getElementsByTagName(tagName);
		if (n1 != null && n1.getLength() > 0) {
			Element el = (Element) n1.item(0);
			anyo = Integer.parseInt(el.getAttribute("anyo"));
		}
		return anyo;
	}	
	
	
	private ArrayList<Autor> getArray (Element ele, String tagName) {
		
		ArrayList <Autor> autores = new ArrayList<Autor>();
		NodeList n1 = ele.getElementsByTagName(tagName);
		
		if (n1 != null && n1.getLength() > 0) {
			
			Element el = (Element) n1.item(0);
			NodeList nlNombres = el.getElementsByTagName("nombre");
			
			if (nlNombres != null && nlNombres.getLength() > 0) {
				for (int i = 0; i < nlNombres.getLength() ; i++) {
					Element e1 = (Element) nlNombres.item(i);
					String nombre = getTextValue(e1, "nom");
					String apellido = e1.getAttribute("apellido");
					String calle = getTextValue(e1, "calle");
					int numero_vivienda = getIntValue(e1, "numero_vivienda");
					String ciudad_residente = getTextValue(e1, "ciudad_residente");
					Autor a = new Autor(nombre, apellido, calle, numero_vivienda, ciudad_residente);
					autores.add(a);
					}
			}
			
		}
	
		return autores;

	}
	
	private int getIntValue (Element ele, String tagName) {
		
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	

	
	public void print () {
		
		Iterator it = libros.iterator();
		while (it.hasNext()) {
			Libro l = (Libro) it.next();
			System.out.println(l);
		}
			
		}
	}
	
