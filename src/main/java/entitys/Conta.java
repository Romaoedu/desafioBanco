package entitys;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public abstract class Conta {

    protected static final int AGENCIA_PADRAO = 1;
    private static  int SEQUENCIAL = 1;

    protected int agencia;
    protected int numeroConta;
    @Getter
    protected  double saldo = 0;
    protected  double divida = 0;
    protected Cliente cliente;
    protected Banco banco;


    public Conta( Cliente cliente) {

        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;

    }

    public void sacar(double valor){

        if (saldo >= valor){
            this.saldo-= valor;
        }else
            System.out.println("Saldo insuficiente");
    }

    public void depositar(double valor){
            this.saldo += valor;
        }

    public void tranferir(Conta contaDestino,double valor){
        if (this.saldo > 0){
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    public void emprestimo(double valor){

        depositar(valor);
        this.divida = valor + (valor * 0.3);

    }

    public void imprimirInformacoesComuns(){
        System.out.println(String.format("Nome do cliente: %s", this.cliente.getNome()));
        System.out.println(String.format("CPF do cliente: %s", this.cliente.getCpf()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero da conta: %d", this.numeroConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Divida: %.2f", this.divida));
        System.out.println();
    }
}
