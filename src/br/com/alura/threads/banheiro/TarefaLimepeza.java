package br.com.alura.threads.banheiro;

public class TarefaLimepeza implements Runnable {

	private Banheiro banheiro;

	public TarefaLimepeza(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		while (true) {
			this.banheiro.limpa();
		}
	}

}
