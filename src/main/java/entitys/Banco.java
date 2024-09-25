package entitys;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    List<Cliente> clienteList = new ArrayList<>();

public void adicionarClientes(Cliente cliente){
    clienteList.add(cliente);
}

    public void imprimirListaDeContas(){
        System.out.println(clienteList);
    }
}
