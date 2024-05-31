import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        System.out.println(curso1);
        System.out.println(curso2);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de Java");
        mentoria.setDescricao("descrição mentoria");
        mentoria.setData(LocalDate.now());

        System.out.println(mentoria);

        Conteudo conteudo = new Curso();

        BootCamp bootcamp = new BootCamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devFelipe = new Dev();
        devFelipe.setNome("Felipe");
        devFelipe.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos Felipe: " + devFelipe.getConteudosInscritos());
        devFelipe.progredir();

        System.out.println("Conteudos Inscritos Felipe: " + devFelipe.getConteudosInscritos());
        System.out.println("Conteudos Concluidos Felipe: " + devFelipe.getConteudosConcluidos());

        System.out.println("--------");

        Dev devMatheus = new Dev();
        devMatheus.setNome("Matheus");
        devMatheus.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos João: " + devMatheus.getConteudosInscritos());
        devMatheus.progredir();
        System.out.println("Conteudos Inscritos João: " + devMatheus.getConteudosInscritos());
        System.out.println("Conteudos Concluidos João: " + devMatheus.getConteudosConcluidos());

    }
}