package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;

	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty())
			this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		if (sobrenome != null && !sobrenome.isEmpty())
			this.sobrenome = sobrenome;
	}

	public void setDataNascimento(String daterepr) {
		if (daterepr == null || daterepr.isEmpty())
			return;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(daterepr,format);
		if (date.isAfter(LocalDate.now()))
			return;
		this.dataNascimento = date;
	}

	public int getIdade() {
		return dataNascimento.until(LocalDate.now()).getYears();
	}

	public Object getNome() {
		return nome;
	}

	public String getDataNascimento(String formato) {
		if (formato == null || formato.isEmpty())
			formato = "dd/MM/yyyy";
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formato);
		return dataNascimento.format(format);
	}

	public String getNomeCompleto() {
		if (nome == null && sobrenome == null)
			return "John Doe";
		if (nome == null)
			return sobrenome;
		if (sobrenome == null)
			return nome;
		return nome + " " + sobrenome;
	}
}
