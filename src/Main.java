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
        var option =-1;
        while (true){
            System.out.println(" 1 - Cadastrar um novo emprestimo");
            System.out.println(" 2 - Listar emprestimos");
            System.out.println(" 3 - Selecionar um emprestimo existente");
            System.out.println(" 4 - Finalizar um emprestimo");
            System.out.println(" 5 - Deletar um emprestimo");
            System.out.println(" 6 - Sair");
            option = sc.nextInt();

            switch (option){
                case 1 -> service.realizarEmprestimo();
                case 2 -> service.listarEmprestimos();
                case 3 -> service.emprestimoPorCliente();
                case 4 -> service.finalizarEmprestimo();
                case 5 -> service.deletarEmprestimo();
                default -> System.out.println("Opção inválida, informe uma opção do menu");
            }
        }


//
//        for (Emprestimo emprestimo : service.listarEmprestimos()){
//
//            if (emprestimo.getSala().isDisponivel()){
//                System.out.println("Salas disponiveis:");
//                System.out.println("Proprietário: "+ emprestimo.getCliente().getNome() + ", Sala: "+ emprestimo.getSala().getSala() + ", Status: "+ emprestimo.getSala().isDisponivel());
//            }
//            else {
//                System.out.println("Salas indisponiveis:");
//                System.out.println("Proprietário: "+ emprestimo.getCliente().getNome() + ", Sala: "+ emprestimo.getSala().getSala() + ", Status: "+ emprestimo.getSala().isDisponivel());
//            }
//
//        }
//        System.out.println(" Digite o nome do Cliente: ");
//        String nomeCliente = sc.next();
//        service.emprestimoPorCliente(nomeCliente);




    }
}