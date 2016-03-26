package model;

/**
 * Esta classe reperesenta o modelo de dados para a criacao de 
 * objetos de Contato em uma agenda de contatos.
 */
public class Contato {

	private final int ANOATUAL = 2016;
	
	private String nome;
	private String sobrenome;
	private String telefone;
	private String email;
	private int dataNascimento;

	/**
	 * Inicializa um objeto contato, dados nome e sobrenome do contato.
	 * Ao menos um dos dois parametros deve ser nao-nulo. Caso os dois
	 * sejam nulos, o sobrenome sera "FULANO DE TAL"
	 * @param nome O nome do contato.
	 * @param sobrenome O sobrenome do contato.
	 */
	public Contato(String nome, String sobrenome) {
		if (nome == null && sobrenome == null)
			this.sobrenome = "FULANO DE TAL";
		else {
			this.nome = nome;
			this.sobrenome = sobrenome;
		}
	}

	/**
	 * Permite a configuracao do telefone do contato.
	 * @param telefone O telefone do contato.
	 */
	public void setTelefone(String telefone) {
		if (telefone.isEmpty())
			telefone = null;
		this.telefone = telefone;
	}

	/**
	 * Permite a configuracao do email do contato, com
	 * validacao simples.
	 * @param email O email do contato.
	 */
	public void setEmail(String email) {
		int arroba = email.indexOf('@');
		int ponto = email.indexOf('.', arroba);
		if (arroba > 0 && ponto > arroba)
			this.email = email;
	}

	/**
	 * Configura a data de nascimento do contato, nao permitindo anos
	 * futuros, ou idades maiores que 150 anos.
	 * @param dataNascimento O ano de nascimento do contato.
	 */
	public void setDataNascimento(int dataNascimento) {
		if (dataNascimento > (ANOATUAL-150) && dataNascimento <= ANOATUAL)
			this.dataNascimento = dataNascimento;
	}

	/**
	 * Retorna o nome completo do contato com o sobrenome antes,
	 * em maiusculas, e o nome apos, com capitalizacao normal.
	 * Caso nome ou sebrenome nao existam, ajusta o texto de acordo.
	 * @return O nome completo do contato.
	 */
	public String getNomeCompleto() {
		if (nome == null || nome.trim().isEmpty())
			return sobrenome.toUpperCase();
		if (sobrenome == null || sobrenome.trim().isEmpty())
			return nome;
		return sobrenome.toUpperCase()+", "+nome;
	}

	/**
	 * Retorna o telefone do contato, ou null caso este nao exista.
	 * @return O telefone do contato.
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Retorna o email do contato, ou null caso este nao exista.
	 * @return O email do contato.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Retorna a idade do contato de acordo com o ano atual.
	 * @return A idade do contato.
	 */
	public Object getIdade() {
		// TODO: ajustar calculo da idade.
		return ANOATUAL - dataNascimento;
	}

	/**
	 * Retorna o nome do contato.
	 * @return O nome do contato.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o sobrenome do contato.
	 * @return O sobrenome do contato.
	 */
	public String getSobrenome() {
		return sobrenome;
	}
}
