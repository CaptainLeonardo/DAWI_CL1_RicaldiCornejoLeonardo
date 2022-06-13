package com.ricaldi.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import com.ricaldi.examenCL1.dao.LibroDao;
import com.ricaldi.examenCL1.dao.TemaDao;
import com.ricaldi.examenCL1.model.Libro;
import com.ricaldi.examenCL1.model.Tema;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMantenimientoLibros extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTituloPrincipal;
	private JLabel lblTitulo;
	private JTextField txtTitulo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JLabel lblOrigen;
	private JLabel lblTema;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JTextField txtOrigen;
	private JComboBox cboTema;
	private JButton btnRegistrar;
	private JScrollPane scrollPane;
	private JTable tbLibro;

	
	LibroDao libroDao = new LibroDao();
	List<Tema> listaTemas = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoLibros frame = new FrmMantenimientoLibros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMantenimientoLibros() {
		setTitle("Sistema de Mantenimiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTituloPrincipal = new JLabel("MANTENIMIENTO DE LIBROS");
		lblTituloPrincipal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTituloPrincipal.setBounds(83, 27, 307, 13);
		contentPane.add(lblTituloPrincipal);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(40, 77, 45, 13);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(120, 75, 189, 19);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(40, 107, 45, 13);
		contentPane.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(40, 137, 62, 13);
		contentPane.add(lblCantidad);
		
		lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrigen.setBounds(40, 167, 45, 13);
		contentPane.add(lblOrigen);
		
		lblTema = new JLabel("Tema");
		lblTema.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTema.setBounds(40, 197, 45, 13);
		contentPane.add(lblTema);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(120, 105, 189, 19);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(120, 135, 189, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtOrigen = new JTextField();
		txtOrigen.setBounds(120, 165, 189, 19);
		contentPane.add(txtOrigen);
		txtOrigen.setColumns(10);
		
		cboTema = new JComboBox();
		cboTema.setBounds(120, 195, 189, 19);
		contentPane.add(cboTema);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(40, 249, 107, 21);
		contentPane.add(btnRegistrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 287, 416, 154);
		contentPane.add(scrollPane);
		
		tbLibro = new JTable();
		scrollPane.setViewportView(tbLibro);
		tbLibro.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String [] {
						"ID","Titulo","Precio","Cantidad","Origen","Tema"
				}
			));
		
		//cargar combo Tema
		cargarComboTemas();
		//listar libros
		listarLibros();
	}
	
	//Cargar Temas en combo
	public void cargarComboTemas() {		
		TemaDao temaDao = new TemaDao();
		Tema tem1 = new Tema("Magia");
		Tema tem2 = new Tema("Viajes Espaciales");
		Tema tem3 = new Tema("Historia");
		temaDao.registrarTema(tem1);
		temaDao.registrarTema(tem2);
		temaDao.registrarTema(tem3);
		listaTemas = temaDao.obtenerTodosTemas();
		for (Tema t : listaTemas) {
			cboTema.addItem(t);
		}
	}
	
	//Listar los libros en Tabla
	private void listarLibros() {
		List<Libro> listaLibros = libroDao.obtenerTodosLibros();
		DefaultTableModel dtm = (DefaultTableModel) tbLibro.getModel();
		dtm.setRowCount(0);
		for (Libro l : listaLibros) {
			Object[] fila = {
					l.getIdlibro(),
					l.getTitulo(),
					l.getPrecio(),
					l.getCantEjemplares(),
					l.getOrigen(),
					l.getTema().getNombre()
			};
			dtm.addRow(fila);
		}
		dtm.fireTableDataChanged();
	}
	
	
	private void limpiarControles() {
		txtTitulo.setText("");
		txtCantidad.setText("");
		txtOrigen.setText("");
		txtPrecio.setText("");
		cboTema.setSelectedIndex(0);
	}
	
	
	private boolean esTexto(String valor) {
		return valor.matches("[a-zA-Z]{1,60}");
	}
	
	private boolean esNumero(String valor) {
		return valor.matches("^[1-9]+[.]*[0-9]{0,2}");
	}
	
	private String validaTitulo() {
		String mensaje="";
		if (txtTitulo.getText().trim().length() == 0) {
			mensaje = "Debe ingresar un valor en titulo";
		}
		else if(!esTexto(txtTitulo.getText().trim())){
			mensaje = "Ingresar solo letras. Máximo 60 caracteres.";
		}
		
		return mensaje;
	}
	
	private String validaOrigen() {
		String mensaje="";
		if (txtOrigen.getText().trim().length() == 0) {
			mensaje = "Debe ingresar un valor en Origen";
		}
		else if(!esTexto(txtOrigen.getText().trim())){
			mensaje = "Ingresar solo letras. Máximo 60 caracteres.";
		}
		
		return mensaje;
	}
	
	private String validarCantidad() {
		String mensaje="";
		if (txtCantidad.getText().trim().length() == 0) {
			mensaje = "Debe ingresar un numero en Cantidad";
		}
		else if(!esNumero(txtCantidad.getText().trim())){
			mensaje = "Ingrese solo numeros.";
		}
		
		return mensaje;
	}
	
	private String validarPrecio() {
		String mensaje="";
		if (txtPrecio.getText().trim().length() == 0) {
			mensaje = "Debe ingresar un precio";
		}
		else if(!esNumero(txtPrecio.getText().trim())){
			mensaje = "Ingrese solo numeros hasta dos decimales.";
		}
		
		return mensaje;
	}
	
	private Tema obtenerTemaDeCombo(String s) {
		Tema tema = null;
		for (Tema tem : listaTemas) {
			if (tem.getNombre().equals(s)) {
				tema = tem;
			}
		}
		return tema;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		
		String mensaje="";
		String tit = "";
		int cant = 0;
		double pre = 0;
		String ori = "";
		Tema tem = (Tema) cboTema.getSelectedItem();
		
		
		mensaje = validaTitulo();
		if (!mensaje.equals("")) {
			JOptionPane.showMessageDialog(this, mensaje, "Formato Incorrecto", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else {
			tit = txtTitulo.getText().trim();
		}
		
		mensaje = validarPrecio();
		if (!mensaje.equals("")) {
			JOptionPane.showMessageDialog(this, mensaje, "Formato Incorrecto", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else {
			pre = Double.parseDouble(txtPrecio.getText().trim());
		}
		
		mensaje = validarCantidad();
		if (!mensaje.equals("")) {
			JOptionPane.showMessageDialog(this, mensaje, "Formato Incorrecto", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else {
			cant = Integer.parseInt(txtCantidad.getText().trim());
		}

		
		mensaje = validaOrigen();
		if (!mensaje.equals("")) {
			JOptionPane.showMessageDialog(this, mensaje, "Formato Incorrecto", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else {
			ori = txtOrigen.getText().trim();
		}
			
			
		Libro oLibro = new Libro(tit,pre,cant,ori,tem);
		libroDao.registrarLibro(oLibro);
		
		listarLibros();
		limpiarControles();
		JOptionPane.showMessageDialog(this, "Registro ingresado", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
}
