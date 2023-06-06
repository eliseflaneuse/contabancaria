package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {


		// Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "José da Silva", 0.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();

		// Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

		Scanner leia = new Scanner(System.in);

		int option;

		do {
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT);
			System.out.println("\t _________________________________________");
			System.out.println("\t|                                         |");
			System.out.println("\t|        " + Cores.TEXT_WHITE_BOLD_BRIGHT + "      Banco da Elise      "
					+ Cores.TEXT_RESET + Cores.TEXT_GREEN_BOLD_BRIGHT + "       |");
			System.out.println("\t|_________________________________________|");
			System.out.println("\t|                                         |");
			System.out.println("\t|   1 - Criar Conta                       |");
			System.out.println("\t|   2 - Listar todas as Contas            |");
			System.out.println("\t|   3 - Buscar Contas por Número          |");
			System.out.println("\t|   4 - Atualizar Dados da Conta          |");
			System.out.println("\t|   5 - Apagar Conta                      |");
			System.out.println("\t|   6 - Sacar                             |");
			System.out.println("\t|   7 - Depositar                         |");
			System.out.println("\t|   8 - Transferir Valores entre Contas   |");
			System.out.println("\t|   9 - Sair                              |");
			System.out.println("\t|_________________________________________|");
			System.out.println("\t|                                         |");
			System.out.println("\t|    " + Cores.TEXT_WHITE_BRIGHT + "   Entre com a opção desejada:   "
					+ Cores.TEXT_RESET + Cores.TEXT_GREEN_BOLD_BRIGHT + "    |");
			System.out.println("\t|_________________________________________|" + Cores.TEXT_RESET);
			
				option = leia.nextInt();
				leia.nextLine();
				

			switch (option) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\n\t\t\tCriar Conta \n\n" + Cores.TEXT_RESET);
				
				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tListar todas as Contas\n\n" + Cores.TEXT_RESET);
				
				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tConsultar dados da Conta - por número\n\n"
						+ Cores.TEXT_RESET);
				
				break;
			case 4:
				System.out
						.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tAtualizar dados da Conta\n\n" + Cores.TEXT_RESET);
				
				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tApagar a Conta\n\n" + Cores.TEXT_RESET);
				
				break;
			case 6:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tSaque\n\n" + Cores.TEXT_RESET);
				
				break;
			case 7:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tDepósito\n\n" + Cores.TEXT_RESET);
				
				break;
			case 8:
				System.out.println(
						Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tTransferência entre Contas\n\n" + Cores.TEXT_RESET);
				
				break;
			case 9:
				System.out.printf(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tPrograma finalizado." + Cores.TEXT_RESET);
				
				break;
			default:
				System.out.printf(
						Cores.TEXT_YELLOW_BOLD_BRIGHT + "\tOpção inválida. Tente novamente." + Cores.TEXT_RESET);
			}
		} while (option != 9);
		

	}

}
