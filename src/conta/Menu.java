package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int option;
		
		do {
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT);
			System.out.println("\t _________________________________________");
			System.out.println("\t|                                         |");
			System.out.println("\t|        " + Cores.TEXT_WHITE_BOLD_BRIGHT + "      Banco da Elise      " + Cores.TEXT_RESET + Cores.TEXT_GREEN_BOLD_BRIGHT + "       |");
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
			System.out.println("\t|    " + Cores.TEXT_WHITE_BRIGHT + "   Entre com a opção desejada:   " + Cores.TEXT_RESET + Cores.TEXT_GREEN_BOLD_BRIGHT + "    |");
			System.out.println("\t|_________________________________________|" + Cores.TEXT_RESET);
			
			option = leia.nextInt();
			leia.nextLine(); //   utilizada para limpar o buffer de entrada

			switch(option) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT  + "\n\t\t\tCriar Conta \n\n" + Cores.TEXT_RESET);
				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT  + "\t\tListar todas as Contas\n\n" + Cores.TEXT_RESET);
				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tConsultar dados da Conta - por número\n\n" + Cores.TEXT_RESET);
				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tAtualizar dados da Conta\n\n" + Cores.TEXT_RESET);
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
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tTransferência entre Contas\n\n" + Cores.TEXT_RESET);
				break;
			case 9:
				System.out.printf(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tPrograma finalizado." + Cores.TEXT_RESET);
				break;
			default:
				System.out.printf(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\tOpção inválida. Tente novamente." + Cores.TEXT_RESET);
			}			
		} while (option != 9);
		
		
		}

}
