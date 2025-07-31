
import main.java.org.example.services.EmprestimoService;
import main.java.org.example.services.SalaService;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EmprestimoService service = new EmprestimoService();
        SalaService salaService = new SalaService();
        final Scanner sc = new Scanner(System.in);



        System.out.println("Bem-vindo ao sistema de aluguel de salas");
        System.out.println();
        System.out.println("Qual opção você deseja? ");
        var option =-1;
        while (true){
            System.out.println(" 1 - Serviços de Sala");
            System.out.println(" 2 - Serviços de Usuário");
            System.out.println(" 3 - Serviços de Emprestimo");
            System.out.println(" 4 - Sair");
            option = sc.nextInt();

            switch (option){
                case 1 -> salaService.rodarMenuSala();
//                case 2 -> service.rodarMenuEmprestimo();
                case 3 -> service.rodarMenuEmprestimo();
//                case 4 -> service.finalizarEmprestimo();
                default -> System.out.println("Opção inválida, informe uma opção do menu");
            }
        }
    }
}