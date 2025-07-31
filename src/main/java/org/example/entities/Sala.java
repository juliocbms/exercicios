package main.java.org.example.entities;

public class Sala {
    private int idSala;
    private String sala;
    private boolean isDisponivel = true;

    public Sala(int idSala, String sala) {
        this.idSala = idSala;
        this.sala = sala;
    }

    public Sala( String sala) {
        this.sala = sala;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(boolean disponivel) {
        isDisponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "sala='" + sala + '\'' +
                ", isDisponivel=" + isDisponivel +
                '}';
    }
}
