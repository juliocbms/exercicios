package main.java.org.example.services;

import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Emprestimo;
import main.java.org.example.entities.Sala;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmprestimoService {

    private List<Emprestimo> emprestimos =new ArrayList<>();
    final Scanner sc = new Scanner(System.in);


    public void realizarEmprestimo(){
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
                salaDisponivel(sala);

                Emprestimo emp = new Emprestimo(gerarId(),cliente,sala, LocalDateTime.now(),null);
                sala.setDisponivel(false);
                System.out.println("Empréstimo realizado com sucesso.");
                emprestimos.add(emp);
            }
    }

    public void emprestimoPorCliente(){
        System.out.println("Digite o nome do cliente:");
        String nome = sc.next();

        emprestimos.stream()
                .filter(e -> e.getCliente().getNome().equalsIgnoreCase(nome))
                .forEach(e -> System.out.println("Cliente: " + e.getCliente().getNome() +
                        ", Sala: " + e.getSala().getSala()));

    }


    public void finalizarEmprestimo(){
        System.out.println("Digite o nome do cliente: ");
        String nome = sc.next();
        emprestimos.stream()
                .filter(e-> e.getCliente().getNome().equalsIgnoreCase(nome))
                .forEach(e -> {
                    e.setDataDevolucao(LocalDateTime.now());
                    e.getSala().setDisponivel(true);
                });
        System.out.println("Sala devolvida");

    }

    public void deletarEmprestimo(){
        System.out.println("Digite o nome do cliente que deseja cancelar:");
        String nome = sc.next();

        boolean removido = emprestimos.removeIf(e -> e.getCliente().getNome().equalsIgnoreCase(nome));

        if (removido) {
            System.out.println("Empréstimo(s) deletado(s)");
        } else {
            System.out.println("Nenhum empréstimo encontrado para esse cliente.");
        }
    }



    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo cadastrado.");
            return;
        }

        for (Emprestimo e : emprestimos) {
            System.out.println( "Cliente: " + e.getCliente().getNome() +
                    ", Sala: " + e.getSala().getSala() +
                    ", Início: " + e.getDataEmprestimo() +
                    ", Devolução: " + e.getDataDevolucao());
        }
    }

    private int gerarId() {
        return emprestimos.size() + 1;
    }

    private boolean salaDisponivel(Sala sala) {
        if (!sala.isDisponivel()) {
            System.out.println("Sala indisponível");
            return false;
        }
        System.out.println("Sala disponivel");
        return true;
    }
}
