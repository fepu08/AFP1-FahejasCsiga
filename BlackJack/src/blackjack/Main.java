package blackjack;

import java.io.IOException;

import blackjack.GUI;

public class Main implements Runnable {

	long xTime = System.nanoTime();
	public static boolean terminator = false;

	//screen refresh rate
	public int Hz = 100;

	GUI gui = new GUI();

	public Main() throws IOException {
	}

	public static void main(String[] args) throws IOException {
		new Thread(new Main()).start();
	}

	@Override
	public void run() {
		while(terminator == false) {
			if (System.nanoTime() - xTime >= 1000000000/Hz) {
				gui.refresher();
				gui.repaint();
				xTime = System.nanoTime();
			}
		}
	}

}

