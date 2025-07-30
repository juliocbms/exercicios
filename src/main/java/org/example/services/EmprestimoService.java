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


    public boolean salaDisponivel(Sala sala) {
        if (!sala.isDisponivel()) {
            System.out.println("Sala indisponível");
            return false;
        }
        System.out.println("Sala disponivel");
        return true;
    }

    public void realizarEmprestimo(Cliente cliente, Sala sala){
        if (!salaDisponivel(sala)){
            return;
        }
        else {
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

            Emprestimo emp = new Emprestimo(gerarId(),cliente,sala, LocalDateTime.now(),null);
            sala.setDisponivel(false);
            System.out.println("Empréstimo realizado com sucesso.");
            emprestimos.add(emp);
        }
    }

    public void emprestimoPorCliente(String nomeCliente){
        emprestimos.stream().filter(e -> e.getCliente().getNome().equalsIgnoreCase(nomeCliente))
                .forEach(e -> System.out.println(e.getCliente().getNome()+", " + e.getSala().getSala()));

    }


    public void finalizarEmprestimo(Emprestimo emprestimo){
        emprestimo.setDataDevolucao(LocalDateTime.now());
        emprestimo.getSala().setDisponivel(true);
        System.out.println("Sala devolvida");

    }



    private int gerarId() {
        return emprestimos.size() + 1;
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }
}
