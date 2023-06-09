package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int option, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		System.out.println("\ncriar contas \n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana do Santos", 4000f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

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
			
			try {
				option = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				option=0;
			}
			
			switch (option) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\n\t\t\tCriar Conta \n\n" + Cores.TEXT_RESET);
				
				System.out.printf(Cores.TEXT_GREEN_BOLD_BRIGHT + "\t\tDigite o Número da Agência: ");
				agencia = leia.nextInt();
				System.out.printf("\tDigite o Nome do Titular ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.printf("\tDigite o tipo de conta (1 - Conta Corrente  ou 2 - Conta Poupança): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);
				
				System.out.printf("\tDigite o Saldo da Conta (R$): " + Cores.TEXT_RESET);
				saldo = leia.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.printf("Digite o Limite de Credito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				// Aniversario da conta ou do titular da conta????
				case 2 -> {
					System.out.printf("Digite o Dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				
				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tListar todas as Contas\n\n" + Cores.TEXT_RESET);
				contas.listarTodas();
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
