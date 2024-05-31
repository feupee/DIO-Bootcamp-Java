import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Pessoa {
    private Date dataCadastro;
    private int numeroCompras;
    private boolean clienteVIP;
    private double descontoVIP;
    private String email;
    private Date dataVip;

    private List<Pesquisa> pesquisas; // Lista de pesquisas feitas pelo cliente
    private List<Compras> compras;

    // Construtor
    public Cliente(String nome, String cpf, String enderecoCompleto, Date dataNascimento, String email, Date dataCadastro) {
        super(nome, cpf, enderecoCompleto, dataNascimento);
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.numeroCompras = 0;
        this.clienteVIP = false;
        this.descontoVIP = 0.0;
        this.dataVip = null;
        this.compras = new ArrayList<>();
        this.pesquisas = new ArrayList<>();
    }
    //Construtor Default
    public Cliente() {
        super("", "", "", new Date()); // Chamada ao construtor da superclasse Pessoa com valores padrão
        this.email = "";
        this.dataCadastro = new Date();
        this.numeroCompras = 0;
        this.clienteVIP = false;
        this.descontoVIP = 0.0;
        this.dataVip = null;
        this.compras = new ArrayList<>();
        this.pesquisas = new ArrayList<>();
    }

    // Método para adicionar uma pesquisa feita pelo cliente
    public void adicionarPesquisa(Pesquisa pesquisa) {
        if (pesquisas == null) {
            pesquisas = new ArrayList<>();
        }
        pesquisas.add(pesquisa);
    }

    // Métodos getters e setters específicos para a classe Cliente
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public int getNumeroCompras() {
        return numeroCompras;
    }
    public void setNumeroCompras(int numeroCompras) {
        this.numeroCompras = numeroCompras;
    }
    public boolean isClienteVIP() {
        return clienteVIP;
    }
    public void setClienteVIP(boolean clienteVIP) {
        this.clienteVIP = clienteVIP;
    }
    public double getDescontoVIP() {
        return descontoVIP;
    }
    public void setDescontoVIP(double descontoVIP) {
        this.descontoVIP = descontoVIP;
    }
    public Date getDataVip() {
        return dataVip;
    }
    public void setDataVip(Date dataVip) {
        this.dataVip = dataVip;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Pesquisa> getPesquisas() {
        return pesquisas;
    }
    public void setPesquisas(List<Pesquisa> pesquisas) {
        this.pesquisas = pesquisas;
    }
    public List<Compras> getCompras() {
        return compras;
    }
    public void setCompras(List<Compras> compras) {
        this.compras = compras;
    }
}