import java.util.Date; // Importe a classe Date para usar na data de nascimento
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Pessoa
public class Pessoa {
    private String nome;
    private String cpf;
    private Date dataNascimento;

    // Construtor
    public Pessoa(String nome, String cpf, String enderecoCompleto, Date dataNascimento) {
        this.nome = nome;
        if (ValidaCPF.isCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.dataNascimento = dataNascimento;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}


