package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;
import conta.util.Cores;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta numero : " + numero + " não foi encontrada!");

	}

	@Override
	public void listarTodas() {
		for (Conta conta : listaContas) { // aqui na documentação esta var ao invés de Conta
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta número: " + conta.getNumero() + " foi criada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		var buscarconta = buscarNaCollection(conta.getNumero());

		if (buscarconta != null) {
			listaContas.set(listaContas.indexOf(buscarconta), conta);
			System.out.println("\nA Conta Numero :" + conta.getNumero() + " Foi Atualizada Com Sucesso!!");
		} else
			System.out.println("\nA Conta Numero :" + conta.getNumero() + " Não Foi Encontrada!!");
	}

	@Override
	public void deletar(int numero) {
		var Conta = buscarNaCollection(numero);

		if (Conta != null) {
			if (listaContas.remove(Conta) == true)
				System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\n\tA Conta Numero :" + numero
						+ " Foi Deletada Com Sucesso!" + Cores.TEXT_RESET);
		} else
			System.out.println("\n\tA Conta Numero :" + numero + " Não Foi Encontrada!!");
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		if (conta != null) {
			if (conta.sacar(valor) == true) {
				System.out.println("\n0 Saque na Conta número: " + numero + " foi efetuado com sucesso!");
			} else {
				System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
			}
		}
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.depositar(valor);
			System.out.println("\n0 Depósito na Conta número: " + numero + " foi efetuado com sucesso!");
		} else {
			System.out.println(
					"\nA Conta numero: " + numero + " não foi encontrada ou a Conta Destino não é Conta Corrente!");
		}
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\nA transferência foi efetuado com sucesso!");
			} else {
				System.out.println("\nA Conta de Origem e/ou de Destino não foram encontradas!");
			}
		}
	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

	public int retornaTipo(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		return 0;
	}

}
