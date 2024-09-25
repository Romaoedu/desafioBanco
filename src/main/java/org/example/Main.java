package org.example;

import entitys.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("Joao", "6895468459");
        ContaCorrente cc = new ContaCorrente(cliente1);
        banco.adicionarClientes(cliente1);
        cc.depositar(450);
        cc.emprestimo(100);


        System.out.println();

        Cliente cliente2 = new Cliente("Maria", "9549385930");
        ContaPoupanca cp = new ContaPoupanca(cliente2);
        banco.adicionarClientes(cliente2);
        cp.depositar(1500);


        cc.tranferir(cp, 50);

        cc.imprimirExtrato();
        cp.imprimirExtrato();


        banco.imprimirListaDeContas();

    }

}