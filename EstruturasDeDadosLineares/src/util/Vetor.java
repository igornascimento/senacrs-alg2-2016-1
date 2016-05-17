package util;

public class Vetor {

	private int[] dados;
	private int numElementos;

	public Vetor(int tam) {
		this.dados = new int[tam];
		this.numElementos = 0;
	}

	public void insert(int index, int valor) {
		if (! (numElementos < dados.length))
			return;
		if (index >=0 && index < numElementos) {
			for (int i = numElementos; i > index; i--)
				dados[i] = dados[i-1];
			dados[index] = valor;
			numElementos++;
		} else
			throw new ArrayIndexOutOfBoundsException("Indice invalido");
	}
	
	public void append(int valor) {
		if (numElementos < dados.length) {
			dados[numElementos] = valor;
			numElementos++;
		}
	}

	public int length() {
		return numElementos;
	}

	public int get(int index) {
		if (index >=0 && index < numElementos) {
			return dados[index];
		}
		throw new ArrayIndexOutOfBoundsException("Indice invalido");
	}

	public void remove(int index) {
		if (index >=0 && index < numElementos) {
			numElementos--;
			dados[index] = dados[numElementos];
		} else
			throw new ArrayIndexOutOfBoundsException("Indice invalido");
	}

}
