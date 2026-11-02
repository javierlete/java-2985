package com.ipartek.formacion.asistentes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AsistenteSwing {

	private JFrame frame;
	private JTextField tfNombre;
	private JTable tabla;
	private JTextField tfAsistenteNombre;
	private JTextField tfAsistenteApellidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsistenteSwing window = new AsistenteSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public AsistenteSwing() throws SQLException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		initialize();

		String[] columnas = { "ID", "Nombre", "Apellidos" };

		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		tabla.setModel(modelo);
		
		JPanel pSuperior = new JPanel();
		frame.getContentPane().add(pSuperior, BorderLayout.NORTH);
		GridBagLayout gbl_pSuperior = new GridBagLayout();
		gbl_pSuperior.columnWidths = new int[]{0, 0, 0};
		gbl_pSuperior.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pSuperior.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pSuperior.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pSuperior.setLayout(gbl_pSuperior);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		pSuperior.add(lblNewLabel, gbc_lblNewLabel);
		
		tfAsistenteNombre = new JTextField();
		GridBagConstraints gbc_tfAsistenteNombre = new GridBagConstraints();
		gbc_tfAsistenteNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfAsistenteNombre.anchor = GridBagConstraints.BASELINE;
		gbc_tfAsistenteNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAsistenteNombre.gridx = 1;
		gbc_tfAsistenteNombre.gridy = 0;
		pSuperior.add(tfAsistenteNombre, gbc_tfAsistenteNombre);
		tfAsistenteNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		pSuperior.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfAsistenteApellidos = new JTextField();
		GridBagConstraints gbc_tfAsistenteApellidos = new GridBagConstraints();
		gbc_tfAsistenteApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_tfAsistenteApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAsistenteApellidos.gridx = 1;
		gbc_tfAsistenteApellidos.gridy = 1;
		pSuperior.add(tfAsistenteApellidos, gbc_tfAsistenteApellidos);
		tfAsistenteApellidos.setColumns(10);
		
		JButton btnInsertar = new JButton("Añadir asistente");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsistenteDto asistente = new AsistenteDto(null, tfAsistenteNombre.getText(), tfAsistenteApellidos.getText());
				
				try {
					AsistenteDao.insertar(asistente);
					
					listado((DefaultTableModel)tabla.getModel());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnInsertar = new GridBagConstraints();
		gbc_btnInsertar.gridwidth = 2;
		gbc_btnInsertar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertar.gridx = 0;
		gbc_btnInsertar.gridy = 2;
		pSuperior.add(btnInsertar, gbc_btnInsertar);

		listado((DefaultTableModel)modelo);
	}

	private void listado(DefaultTableModel modelo) throws SQLException {
		modelo.setRowCount(0);
		
		for (AsistenteDto asistente : AsistenteDao.obtenerTodos()) {
			modelo.addRow(new Object[] { asistente.id(), asistente.nombre(), asistente.apellidos()});
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 331, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel pInferior = new JPanel();
		frame.getContentPane().add(pInferior, BorderLayout.SOUTH);

		tfNombre = new JTextField();
		pInferior.add(tfNombre);
		tfNombre.setColumns(10);

		JButton btnSaludar = new JButton("Saludar");
		pInferior.add(btnSaludar);

		JLabel lblSaludo = new JLabel("Hola que tal");
		pInferior.add(lblSaludo);

		tabla = new JTable();
		frame.getContentPane().add(tabla, BorderLayout.CENTER);
		btnSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(frame, "Prueba");
				lblSaludo.setText("Hola " + tfNombre.getText());
			}
		});
	}
}
