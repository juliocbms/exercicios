package main.java.org.example.services;

import main.java.org.example.entities.Emprestimo;
import main.java.org.example.entities.Sala;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalaService {

    private List<Sala> salas = new ArrayList<>();
    final Scanner sc = new Scanner(System.in);


    public void rodarMenuSala(){
        System.out.println("Qual opção você deseja? ");
        var option =-1;
        while (true){
            System.out.println(" 1 - Cadastrar uma Sala");
            System.out.println(" 2 - Listar salas");
            System.out.println(" 3 - Deletar uma sala");
            System.out.println(" 4 - Sair");
            option = sc.nextInt();

            switch (option){
                case 1 -> cadastrarSala();
                case 2 -> listarSalas();
                case 3 -> deletarSala();
                case 4 -> {
                    System.out.println("Retornando ao menu principal...");
                    return;
                }
                default -> System.out.println("Opção inválida, informe uma opção do menu");
            }
        }
    }


    private void cadastrarSala(){
        System.out.println("Digite o nome sala que quer cadastrar:");
        String nome = sc.next();
        Sala sala = new Sala(gerarId(),nome);
        salas.add(sala);
    }


    private void deletarSala(){
        System.out.println("Digite o nome do cliente que deseja cancelar:");
        String nome = sc.next();

        boolean removido = salas.removeIf(s -> s.getSala().equalsIgnoreCase(nome));

        if (removido) {
            System.out.println("Empréstimo(s) deletado(s)");
        } else {
            System.out.println("Nenhum empréstimo encontrado para esse cliente.");
        }
    }



    private void listarSalas() {
        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala cadastrado.");
            return;
        }

        for (Sala s : salas) {
            System.out.println( "ID: " + s.getIdSala() +
                    ", Sala: " + s.getSala() );
        }
    }



    private int gerarId() {
        return salas.size() + 1;
    }
}
