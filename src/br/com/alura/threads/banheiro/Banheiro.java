package br.com.alura.threads.banheiro;

public class Banheiro {

	// private Lock lock = new ReentrantLock();
	private boolean estaSujo = true;

	public void fazNumero1() throws InterruptedException {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");
		// lock.tryLock(5, TimeUnit.SECONDS);
		synchronized (this) {

			// lock.lock();
			while (this.estaSujo) {
				System.out.println(nome + " entrando no banheiro");
				this.esperaLaFora(nome);
			}
			System.out.println(nome + " entrando no banheiro");
			
			System.out.println(nome + " vai ser rápido");

			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.estaSujo = true;
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
			// lock.unlock();
		}
	}

	public void fazNumero2() throws InterruptedException {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");
		// lock.tryLock(5, TimeUnit.SECONDS);
		synchronized (this) {
			// this.lock.lock();

			while (this.estaSujo) {
				System.out.println(nome + " entrando no banheiro");
				this.esperaLaFora(nome);
			}
			System.out.println(nome + " entrando no banheiro");

			System.out.println(nome + " vai demorar");

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.estaSujo = true;
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
			// this.lock.unlock();
		}
	}

	public void limpa() {
		
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this) {

			System.out.println(nome + " entrando no banheiro");

			if (!this.estaSujo) {
				System.out.println(nome + ", não está sujo, vou sair");
				return;
			}

			System.out.println(nome + " limpando o banheiro");
			this.estaSujo = false;

			try {
				Thread.sleep(13000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(nome + " saindo do banheiro");
			this.notifyAll();
		}
	}

	private void esperaLaFora(String nome) {

		System.out.println(nome + " eca, banheiro está sujo.");
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}