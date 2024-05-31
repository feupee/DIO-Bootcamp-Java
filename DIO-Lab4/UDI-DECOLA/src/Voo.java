class Voo {
    private String entrada, saida;
    private Aeroporto origem, destino;
    private String data;
    private String quantidadeDeVagas;
    private String valorDoVoo;
    private String codigo_voo;

    //Construtor
    public Voo(String horario_entrada, String horario_saida, Aeroporto origem, Aeroporto destino, String data, String vagas, String valor, String codigo_voo) {
        this.entrada = horario_entrada;
        this.saida = horario_saida;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.quantidadeDeVagas = vagas;
        this.valorDoVoo = valor;
        if(identificador(codigo_voo)){
            this.codigo_voo = codigo_voo;
        }else{
            this.codigo_voo = "0";
        }
    }

    public boolean identificador(String codigo) {
        // Verificar se o código tem o comprimento correto
        if (codigo.length() != 8) {
            System.out.println("1");
            return false;
        }

        int cont_digito = 0, cont_letra = 0;

        // Verificar se existe 3 Letras
        for (int i = 0; i < 8; i++) {
            if (Character.isLetter(codigo.charAt(i))) {
                cont_letra++;
            }
            // Verificar se existe 5 numeros
            if (Character.isDigit(codigo.charAt(i))) {
                cont_digito++;
            }
        }
        if(cont_letra == 3 && cont_digito == 5){
            return true;
        }else {
            throw new IllegalArgumentException("Codigo Invalido");
        }
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getQuantidadeDeVagas() {
        return quantidadeDeVagas;
    }

    public void setQuantidadeDeVagas(String quantidadeDeVagas) {
        this.quantidadeDeVagas = quantidadeDeVagas;
    }

    public String getValorDoVoo() {
        return valorDoVoo;
    }

    public void setValorDoVoo(String valorDoVoo) {
        this.valorDoVoo = valorDoVoo;
    }

    public String getCodigo_voo() {
        return codigo_voo;
    }

    public void setCodigo_voo(String codigo_voo) {
        this.codigo_voo = codigo_voo;
    }

    public int calcularTempoEstimado() {
        String[] horaDecolagem = entrada.split(":");
        String[] horaPouso = saida.split(":");

        int horaInicio = Integer.parseInt(horaDecolagem[0]);
        int minutoInicio = Integer.parseInt(horaDecolagem[1]);

        int horaFim = Integer.parseInt(horaPouso[0]);
        int minutoFim = Integer.parseInt(horaPouso[1]);

        int horaTotal = horaFim - horaInicio;
        int minutoTotal = minutoFim - minutoInicio;

        if (minutoTotal < 0) {
            horaTotal--;
            minutoTotal += 60;
        }

        return horaTotal * 60 + minutoTotal; // Retornando o tempo total em minutos
    }
}