package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Font;

import controller.CancelarController;
import controller.ExecutarController;
import controller.ProcurarController;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;;


public class TelaExecutar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea taAbrir;
	private JButton btnProcurar, btnCancelar, btnOK;

	/**
	 * Launch the application.
	 */
	public void TelaExecutarMain () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExecutar frame = new TelaExecutar();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaExecutar() {
		setTitle("Executar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Abrir:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 95, 35, 23);
		contentPane.add(lblNewLabel);
		
		btnOK = new JButton("OK");
		btnOK.setBounds(48, 140, 89, 23);
		contentPane.add(btnOK);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(167, 140, 89, 23);
		contentPane.add(btnCancelar);
		
		btnProcurar = new JButton("Procurar...");
		btnProcurar.setBounds(286, 140, 89, 23);
		contentPane.add(btnProcurar);
		
		JLabel lblNewLabel_1 = new JLabel("Digite o nome de um programa, pasta, documento ou");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(58, 31, 297, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("recurso da Internet e o Windows o abrir\u00E1 para voc\u00EA.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(59, 51, 288, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(48, 95, 327, 22);
		contentPane.add(scrollPane);
		
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(TelaExecutar.class.getResource("/com/sun/java/swing/plaf/windows/icons/JavaCup32.png")));
		lblNewLabel_3.setBounds(10, 29, 35, 43);
		contentPane.add(lblNewLabel_3);
		
		taAbrir = new JTextArea();
		scrollPane.setViewportView(taAbrir);
		
		ProcurarController Procurar = new ProcurarController(taAbrir);
		btnProcurar.addActionListener(Procurar);

		ExecutarController exec = new ExecutarController(taAbrir);
		btnOK.addActionListener(exec);
		
		CancelarController cancel = new CancelarController();
		btnCancelar.addActionListener(cancel);
		
	}
}
