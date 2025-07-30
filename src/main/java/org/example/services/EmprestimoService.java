package main.java.org.example.services;

import main.java.org.example.entities.Cliente;
import main.java.org.example.entities.Emprestimo;
import main.java.org.example.entities.Sala;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {

    private List<Emprestimo> emprestimos =new ArrayList<>();


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
