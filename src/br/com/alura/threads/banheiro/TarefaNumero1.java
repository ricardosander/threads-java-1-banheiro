package br.com.alura.threads.banheiro;

import java.util.concurrent.locks.Lock;

public class TarefaNumero1 implements Runnable {

	private Banheiro banheiro;

    public TarefaNumero1(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        try {
			this.banheiro.fazNumero1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
