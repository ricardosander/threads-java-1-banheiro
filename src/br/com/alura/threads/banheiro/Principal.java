package br.com.alura.threads.banheiro;

import java.util.ArrayList;
import java.util.Collections;

public class Principal {

    public static void main(String[] args) {

    	Banheiro banheiro = new Banheiro();

        //Passando a tarefa e o nome do Thread
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
        Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
        Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");
        Thread limpeza = new Thread(new TarefaLimepeza(banheiro), "Faxineira");
        
        limpeza.setDaemon(true);
        
        convidado1.start();
        convidado2.start();
        convidado3.start();
        convidado4.start();
        limpeza.start();
        
        System.out.println("Acabou");
    }
}