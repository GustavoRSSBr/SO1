package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ExecutarController implements ActionListener{

	private JTextArea taAbrir;
	
	public ExecutarController(JTextArea taAbrir) {
		this.taAbrir = taAbrir;
	}
	
	public boolean validaTela() {
		if(taAbrir.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo vazio", "ERRO", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean Executa() {
		String command = taAbrir.getText();
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) { 
			if(e.getMessage().contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(command);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					System.err.println(e1.getMessage());
					return false;
				}
			}else {
				System.err.println("Commando invalido");
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(validaTela()) { 
			if (Executa()) { 
				System.exit(0);
			}
		}
	}

}
