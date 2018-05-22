package gui;

import java.awt.EventQueue;

import test.Test;

public class GUIKontroler {
	
	/**
	 * Launch the application.
	 */
	private static ThreadsGUI prozor;
	private static Test t;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t = new Test();
					prozor = new ThreadsGUI();
					prozor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void startAll() {
		prozor.btnFirst.setEnabled(false);
		prozor.btnSecond.setEnabled(false);
		prozor.btnThird.setEnabled(false);
		prozor.btnStart.setEnabled(false);
		t.start(true,true,true);
	}
	
	public static void start(boolean first, boolean second, boolean back) {
		t.start(first,second,back);
	}
	
	public static void stop() {
		t.stop();
		prozor.btnFirst.setEnabled(true);
		prozor.btnSecond.setEnabled(true);
		prozor.btnThird.setEnabled(true);
		prozor.btnStart.setEnabled(true);
		prozor.lblThread.setText("");
	}
	
	public static void ispis(String lyrics, String name) {
		prozor.textArea.append(lyrics+"\n");
		prozor.lblThread.setText(name);
	}

}
