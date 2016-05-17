package test;

import com.senac.SimpleJava.Console;

import util.Vetor;

public class TesteVetor {
	public void run() {
		Vetor vetor = new Vetor(10);
		
		vetor.append(1);
		vetor.append(2);
		vetor.append(3);
		vetor.append(4);
		vetor.append(5);
		
		for(int i = 0; i < vetor.length(); i++)
			Console.print(vetor.get(i)," ");
		Console.println();
		Console.println((new String(new char[6])).replace("\0","-"));
		
		vetor.remove(2);
		for(int i = 0; i < vetor.length(); i++)
			Console.print(vetor.get(i)," ");
		Console.println();
		Console.println((new String(new char[6])).replace("\0","-"));
		
		vetor.insert(2,3);
		for(int i = 0; i < vetor.length(); i++)
			Console.print(vetor.get(i)," ");
		Console.println();
	}
}
