package view;

import com.senac.SimpleJava.Console;

/**
 * Cria uma abstracao de um Menu.
 */
public class Menu {
	
	/**
	 * Exibe um menu com opcoes para o usuario.
	 */
	public void exibir() {
		Console.println();
		Console.println("Agenda de Contatos");
		Console.println("==================");
		Console.println("[1] Inserir contato");
		Console.println("[2] Exibir contato");
		Console.println("[3] Excluir contato");
		Console.println("[4] Sair do programa");
		Console.println();
	}

	/**
	 * Pede ao usuario que escolha uma opcao e so encerra quando
	 * uma opcao valida for inserida.
	 * @return A opcao escolhida.
	 */
	public int getOpcao() {
		int opcao = 0;
		while (true) {
			opcao = Console.readInt("Opcao: ");
			if (opcao > 0 && opcao <= 3)
				return opcao;
			Console.println("Opcao invalida.");
		}
	}
}
