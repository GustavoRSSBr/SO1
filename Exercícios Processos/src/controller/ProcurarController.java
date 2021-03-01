package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;



public class ProcurarController implements ActionListener {

	private JTextArea taAbrir;
	
	public ProcurarController(JTextArea taAbrir) {
		this.taAbrir = taAbrir;
	}
	
	public void validaTela() {
		if(!taAbrir.getText().trim().equals("")) {
			taAbrir.setText("");
		}
	}
	
	public void ProcuraArquivo() {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos Executáveis (.exe)", "exe");
		
		String diretorioBase = System.getProperty("user.home") + "/Desktop";
		File dir = new File (diretorioBase);
		
		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		choose.addChoosableFileFilter(filtro);
		String caminhoArquivo = "";
		
		int retorno = choose.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = choose.getSelectedFile().getAbsolutePath();
			taAbrir.setText(caminhoArquivo);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		validaTela();
		ProcuraArquivo();
	}
	
}
