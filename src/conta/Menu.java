package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int option;
		
		do {
			System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT);
			System.out.println("\t _________________________________________");
			System.out.println("\t|                                         |");
			System.out.println("\t|              Banco da Elise             |");
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
			System.out.println("\t|       Entre com a opção desejada:       |");
			System.out.println("\t|_________________________________________|" + Cores.TEXT_RESET);
			
			option = leia.nextInt();
			leia.nextLine(); //   utilizada para limpar o buffer de entrada

			switch(option) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT  + "\n\t\t\tCriar Conta \n\n" + Cores.TEXT_RESET);
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");
				break;
			case 6:
				System.out.println("Saque\n\n");
				break;
			case 7:
				System.out.println("Depósito\n\n");
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");
				break;
			case 9:
				System.out.printf("\n\tPrograma finalizado.");
				break;
			default:
				System.out.printf("\tOpção inválida. Tente novamente.");
			}			
		} while (option != 9);
		
		
		}

}
