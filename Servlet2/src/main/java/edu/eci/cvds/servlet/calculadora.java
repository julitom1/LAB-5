package edu.eci.cvds.servlet;

import java.text.SimpleDateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.util.*;
import java.lang.*;


@ManagedBean(name="calculadoraBean")
@ApplicationScoped
public class calculadora{
	
	private ArrayList<Double> valores=new ArrayList<>();
		

	
	public calculadora(){

	}
	
	public void setValores(ArrayList<Double> lista){
		this.valores=valores;
	}
	
	public ArrayList<Double> getValores(){
		return valores;
	}
	
	public double calculateMean(ArrayList<Double> lista){
		
		double suma=0;
		
		for(int i=0;i<lista.size();i++){
			suma+=lista.get(i);
		}
		suma = suma/lista.size();
		
		return suma;
	}
	
	public double calculateStandardDeviation(ArrayList<Double> lista){
		
		double suma=calculateVariance(lista);
		suma=Math.sqrt(suma);
		
		
		return suma;
	}
	
	public double calculateVariance(ArrayList<Double> lista){
		
		double promedio=calculateMean(lista);
		double suma=0;
		for(int i=0;i<lista.size();i++){
			suma+=Math.pow((lista.get(i)-promedio),2);
		}
		suma=suma/lista.size();
		
		return suma;
	}
	
	public double calculateMode(ArrayList<Double> lista){
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
		return numero;
	}
	
	public void restart(){
		
		
	}
	
	
	
}