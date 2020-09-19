package edu.eci.cvds.servlet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import java.util.*;
import java.lang.*;


@ManagedBean(name="calculadoraBean")
@SessionScoped
public class calculadora{
	private String valores = "";
	private ArrayList<Double> lista=new ArrayList<>();
	private ArrayList<String> valoresIngresados = new ArrayList<>();
	private double promedio = 0;
	private double varianza = 0;
	private double desviacion = 0;
	private double moda = 0;

	
	public calculadora(){

	}

	public void formarLista(String entrada) {
			valoresIngresados.add(entrada);
			String[] separado = entrada.split(";");
			for( String val: separado) {
				lista.add( Double.parseDouble(val) );
			}
	}
	public void calcularTodo(String value){
		formarLista(value);
		calculateMean();
		calculateVariance();
		calculateStandardDeviation();
		calculateMode();
	}
	public void calculateMean(){

		double suma=0;
		
		for(int i=0;i<lista.size();i++){
			suma+=lista.get(i);
		}
		promedio = suma/lista.size();
	}
	
	public void calculateStandardDeviation(){

		desviacion = Math.sqrt(varianza);

	}
	
	public Double calculateVariance(){

		double suma=0;
		for(int i=0;i<lista.size();i++){
			suma+=Math.pow((lista.get(i)-promedio),2);
		}
		varianza = suma/lista.size();
		return suma/lista.size();
	}
	/*ArrayList<Double> lista*/
	public void calculateMode(){
		Collections.sort(lista);
		int max=0;
		int contador=1;
		double numero=lista.get(0);
		for(int i=1;i<lista.size();i++){
			if(lista.get(i)!=lista.get(i-1)){
				if(max<contador){
					max=contador;
					numero=lista.get(i-1);
				}
				contador=0;
			}
			contador+=1;
		}
		moda = numero;

	}
	
	public void restart(){
		lista = new ArrayList<>();
		promedio = 0;
		desviacion = 0;
		varianza = 0;
		moda = 0;
	}
	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public double getVarianza() {
		return varianza;
	}

	public void setVarianza(double varianza) {
		this.varianza = varianza;
	}

	public double getDesviacion() {
		return desviacion;
	}

	public void setDesviacion(double desviacion) {
		this.desviacion = desviacion;
	}

	public double getModa() {
		return moda;
	}

	public void setModa(double moda) {
		this.moda = moda;
	}

	public void setValores(ArrayList<Double> lista){
		this.valores=valores;
	}

	public String getValores(){
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	public ArrayList<Double> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Double> lista) {
		this.lista = lista;
	}

	public ArrayList<String> getValoresIngresados() {
		return valoresIngresados;
	}

	public void setValoresIngresados(ArrayList<String> valoresIngresados) {
		this.valoresIngresados = valoresIngresados;
	}
}