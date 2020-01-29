import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClasePrincipal {
public static void main(String[] args) {
	ArrayList<Integer> casos=new ArrayList();
	Scanner sc=new Scanner(System.in);
	int n_casos=sc.nextInt();
	for (int i=0; i<n_casos; i++)
	{
		int n=sc.nextInt();
		casos.add(n);
	}
	tratarCasos(casos);
}

private static void tratarCasos(ArrayList<Integer> casos) {
	ArrayList<Resultados> lista=new ArrayList();
	for (int n: casos)
	{
		Resultados r=null;
		int n_iteraciones=0;
		if (n==6174)
		{
			r=new Resultados(n, 0);
		}else if(repdigit(n))
		{
			r=new Resultados(n, 8);
		}
		else
		{
			n_iteraciones=calcularIteraciones(n);
			r=new Resultados(n, n_iteraciones);
			
		}
		lista.add(r);
		
	}
	for (Resultados resultados: lista)
	{
		System.out.println(resultados);
	}
	
}
private static int calcularIteraciones(int n) {
int kaprekar=6174;
int menor=calcularMenor(n);
int mayor=calcularMayor(menor);
int it=1;//Cuento la iteracion que viene en la 52
int resta=mayor-menor;
while(resta!=kaprekar)
{
	
	//System.out.println("Mayor: "+mayor+" Menor: "+menor);
	menor=calcularMenor(resta);
	mayor=calcularMayor(menor);
	resta=mayor-menor;
	it++;
}
//System.out.println("Mayor: "+mayor+" Menor: "+menor);
return it;
}

private static int calcularMenor(int n) {
	// TODO Auto-generated method stub
	String numero=String.valueOf(n);
	
		char[] numeros=numero.toCharArray();
	
	List<Character> l=new ArrayList();
	for(char c: numeros)
	{
		l.add(c);
	}
	Collections.sort(l);//De menor a mayor
	String aux="";
	for (char c: l)
	{
		aux+=c;
	}
	
	//System.out.println("AUX:"+aux);
	return Integer.valueOf(aux);
}

private static int calcularMayor(int n) {

String texto=String.valueOf(n);
String aux="";

for (int i=texto.length()-1; i>=0; i--)
{
	char a=texto.charAt(i);
	aux+=a;
}
while (aux.length()<4)
{
	aux=aux+"0";
}
	return Integer.valueOf(aux);
}

private static boolean repdigit(int n) {
	//Si tiene los cuatro digitos iguales, al dividir entre 1111 me da un número entero y su resto es 0:
	int resto=n%1111;
	return (resto==0)?true:false;
}
public static class Resultados{
	private int caso, resultado;

	public Resultados(int caso, int resultado) {
		super();
		this.caso = caso;
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return ""+resultado;
	}
	
}
}

