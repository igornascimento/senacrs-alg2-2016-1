package view;

import com.senac.SimpleJava.Console;

import model.Contato;

/**
 * A classe ContatoView implementa a interacao do usuario
 * com o sistema.
 */
public class ContatoView {

	/**
	 * Pergunta ao usuario as informacoes de um contato e
	 * retorna um novo objeto Contato. A criacao do objeto
	 * deveria ser feita em um "Controller", mas, devido a
	 * limitacoes atuais na utilizacao do Console, a criacao
	 * esta sendo realizada na "view".
	 * @return O objeto Contato criado.
	 */
	public Contato leContato() {
		Contato contato;
		
		String nome = Console.readLine("Nome:");
		String sobrenome = Console.readLine("Sobrenome:");

		contato = new Contato(nome, sobrenome);
		contato.setTelefone(Console.readLine("Telefone:"));
		contato.setEmail(Console.readLine("Email:"));
		// TODO: Alterar data para tipo de data.
		int dataNascimento = Console.readInt("Data de Nascimento:");
		contato.setDataNascimento(dataNascimento);
		return contato;
	}

	/**
	 * Exibe as imformacoes completas de um contato.
	 * @param contato O contato que tera as informacoes exibidas.
	 */
	public void exibeContato(Contato contato) {
		Console.println(contato.getNomeCompleto());
		if (contato.getTelefone() != null) {
			Console.println("Telefone: ", contato.getTelefone());
		}
		if (contato.getEmail() != null) {
			Console.println("Email: ", contato.getEmail());
		}
		Console.println("Idade: ", contato.getIdade(), " anos");
	}

	/**
	 * Faz uma pergunta ao usuario e retorna a resposta com uma String.
	 * @param O texto da pergunta.
	 * @return Uma String contendo a resposta.
	 */
	public String questionaUsuario(String texto) {
		return Console.readLine(texto + "? ");
	}

	/**
	 * Exibe as informacoes resumidas de um contato.
	 * @param contato O contato que tera as informacoes exibidas.
	 */
	public void exibeResumoContato(Contato contato) {
		String nome = contato.getNome();
		if (nome == null) {
			nome = contato.getSobrenome();
		}
		Console.println("Contato: ",contato.getNome()," <",contato.getEmail(),">");
	}

	/**
	 * Pede uma confirmacao para o usuario aceitando "s" ou "n" como
	 * respostas e retorna verdadeiro se o usuario confirmar.
	 * @param texto O texto da pergunta a ser exibida.
	 * @return True caso o usuario confirme, False caso contrario.
	 */
	public boolean confirma(String texto) {
		String resposta = questionaUsuario(texto + "([s]im ou [n]ao)").toLowerCase();
		while (!(resposta.startsWith("s") || resposta.startsWith("n"))) {
			exibeErro("Resposta invalida.");
			resposta = questionaUsuario(texto + "([s]im ou [n]ao)").toLowerCase();
		} 
		Console.print("Resposta ",resposta.startsWith("s"));
		return resposta.startsWith("s");
	}

	/**
	 * Exibe uma mensagem de erro para o usuario.
	 * @param mensagem A mensagem a ser exibida.
	 */
	public void exibeErro(String mensagem) {
		Console.println("ERRO: " + mensagem);
	}

	public void mensagem(String mensagem) {
		Console.println("INFO: " + mensagem);
	}
	
}
