<h1>Projeto 01 - Conta Bancária - Iniciando o Projeto Java</h1>

<h2>1. O Projeto Conta Bancária</h2>

```mermaid
classDiagram
class Conta {
<<Abstract>>
  - numero : int
  - agencia : int
  - tipo : int
  - titular : String
  - saldo : float
  + int getNumero()
  + int getAgencia()
  + int getTipo()
  + String getTitular()
  + float getSaldo()
  + void setNumero(int numero)
  + void setAgencia(int agencia)
  + void setTipo(int tipo)
  + void setTitular(String titular)
  + void setSaldo(float saldo)
  + boolean sacar(float valor)
  + void depositar(float valor)
  + void visualizar()
}
class ContaCorrente {
  - limite : float
  + float getLimite()
  + void setLimite(float limite)
  + boolean sacar(float valor)
  + void visualizar()
}
class ContaPoupanca {
  - aniversario : int
  + int getAniversario()
  + void setAniversario(int aniversario)
  + void visualizar()
}
class ContaRepository{
<< Interface >>
+ void procurarPorNumero(int numero)
+ void listarTodas()
+ void cadastrar(Conta conta)
+ void atualizar(Conta conta)
+ void deletar(int numero)
+ void sacar(int numero, float valor)
+ void depositar(int numero, float valor)
+ void transferir(int numeroOrigem, int numeroDestino, float valor)
}
class ContaController{
+ void procurarPorNumero(int numero)
+ void listarTodas()
+ void cadastrar(Conta conta)
+ void atualizar(Conta conta)
+ void deletar(int numero)
+ void sacar(int numero, float valor)
+ void depositar(int numero, float valor)
+ void transferir(int numeroOrigem, int numeroDestino, float valor)
+ int gerarNumero()
+ Conta buscarNaCollection(int numero)
+ int retornaTipo(int numero)
}
Conta <|-- ContaCorrente
Conta <|-- ContaPoupanca
Conta <.. ContaRepository
ContaRepository <|.. ContaController
```

<br />

O Projeto será composto pelas seguintes Classes e Interfaces:

| Classe/Interface    | Descrição                                                    |
| ------------------- | ------------------------------------------------------------ |
| **Menu**            | Classe principal, que conterá o Método main, responsável por criar o Menu inicial da aplicação com todas as funcionalidades do sistema. |
| **Cores**           | Classe utilitária, que possui a função de aplicar cores ao Menu. |
| **Conta**           | Classe responsável por definir o Objeto Conta genérico.      |
| **ContaCorrente**   | Classe responsável por definir o Objeto Conta Corrente.      |
| **ContaPoupanca**   | Classe responsável por definir o Objeto Conta Poupanca.      |
| **ContaRepository** | Interface responsável por encapsular os Métodos que serão utilizados no Menu da aplicação |
| **ContaController** | Classe responsável por implementar a Interface ContaRepository. |
