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

		int option, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar contas: \n");

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
			System.out.println("\t|    " + Cores.TEXT_WHITE_BOLD_BRIGHT + "   Entre com a opção desejada:   "
					+ Cores.TEXT_RESET + Cores.TEXT_GREEN_BOLD_BRIGHT + "    |");
			System.out.println("\t|_________________________________________|" + Cores.TEXT_RESET);

			try {
				option = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				option = 0;
			}

			switch (option) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\n\t\t\tCriar Conta \n\n" + Cores.TEXT_RESET);

				System.out.printf(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tDigite o Número da Agência: ");
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

				switch (tipo) {
				case 1 -> {
					System.out.printf(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tDigite o Limite de Credito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				// Aniversario da conta ou do titular da conta????
				case 2 -> {
					System.out.printf(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tDigite o Dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tListar todas as Contas\n\n" + Cores.TEXT_RESET);
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tConsultar dados da Conta - por número\n");
				System.out.println("\tDigite Número da Conta: " + Cores.TEXT_RESET);
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tAtualizar dados da Conta\n");

				System.out.printf("\tDigite o Número da Conta: \n");

				numero = leia.nextInt();

				if (contas.buscarNaCollection(numero) != null) {

					System.out.printf(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tDigite o Número da Agência: ");
					agencia = leia.nextInt();
					System.out.printf("\tDigite o Titular da Conta: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					System.out.printf("\tDigite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();

					tipo = contas.retornaTipo(numero);

					switch (tipo) {
					case 1 -> {
						
						System.out.printf(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tDigite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();
						contas.cadastrar(
								new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}

					case 2 -> {
						
						System.out.printf(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\t\tDigite o Dia do Aniversario da Conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(
								new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("\nTipo de Conta Inválido! ");
					}
					}
				} else
					System.out.println("\nConta Não Encontrada! ");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tApagar a Conta\n");
				System.out.println("\tDigite o numero da Conta:\n " + Cores.TEXT_RESET);
				numero = leia.nextInt();

				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tSaque\n\n");

				System.out.println("Digite o número da Conta: " + Cores.TEXT_RESET);
				numero = leia.nextInt();

				do {
					System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "Digite o valor do Saque(R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tDepósito\n\n");
				System.out.println("Digite o número da Conta: " + Cores.TEXT_RESET);
				numero = leia.nextInt();

				do {
					System.out.println(
							Cores.TEXT_YELLOW_BOLD_BRIGHT + "Digite o valor do Depósito(R$): " + Cores.TEXT_RESET);
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tTransferência entre Contas\n\n");
				System.out.println("Digite o número da Conta de Origem: ");
				numero = leia.nextInt();

				System.out.println("Digite o número da Conta de Destino: " + Cores.TEXT_RESET);
				numeroDestino = leia.nextInt();

				do {
					System.out.println(
							Cores.TEXT_YELLOW_BOLD_BRIGHT + "Digite o valor da Transferência(R$): " + Cores.TEXT_RESET);
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);
				keyPress();
				break;
			case 9:
				System.out.printf(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\t\tPrograma finalizado." + Cores.TEXT_RESET);
				keyPress();
				break;
			default:
				System.out.printf(
						Cores.TEXT_YELLOW_BOLD_BRIGHT + "\tOpção inválida. Tente novamente." + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		} while (option != 9);

	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}
