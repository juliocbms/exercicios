import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Emprestimo;
import main.java.org.example.entities.Sala;
import main.java.org.example.services.EmprestimoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EmprestimoService service = new EmprestimoService();
        final Scanner sc = new Scanner(System.in);



        System.out.println("Bem-vindo ao sistema de aluguel de salas");
        System.out.println();
        System.out.println("Quantas salas serão alugadas?");
        int n = sc.nextInt();

        for (int i = 1; i <= n;i++){
            System.out.println("Digite as informações do CLiente");

            System.out.println("Digite o nome do cliente "+ i+" :");
            String nome = sc.next();

            System.out.println("Digite a idade do cliente "+ i+" :");
            int idade = sc.nextInt();

            System.out.println("Digite o cpf do cliente "+ i+" :");
            Long cpf = sc.nextLong();
            Cliente cliente = new Cliente(nome,idade,cpf);

            System.out.println("Digite as informações da Sala");
            System.out.println("Digite a sala que o cliente irá alugar "+ i+" :");
            String nomeSala = sc.next();

            Sala sala = new Sala(nomeSala);

            service.realizarEmprestimo(cliente,sala);
        }
        for (Emprestimo emprestimo : service.listarEmprestimos()){
            
            if (emprestimo.getSala().isDisponivel()){
                System.out.println("Salas disponiveis:");
                System.out.println("Proprietário: "+ emprestimo.getCliente().getNome() + ", Sala: "+ emprestimo.getSala().getSala() + ", Status: "+ emprestimo.getSala().isDisponivel());
            }
            else {
                System.out.println("Salas indisponiveis:");
                System.out.println("Proprietário: "+ emprestimo.getCliente().getNome() + ", Sala: "+ emprestimo.getSala().getSala() + ", Status: "+ emprestimo.getSala().isDisponivel());
            }

        }
        System.out.println(" Digite o nome do Cliente: ");
        String nomeCliente = sc.next();
        service.emprestimoPorCliente(nomeCliente);




    }
}