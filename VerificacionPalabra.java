package VerificacionPalabras;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerificacionPalabra extends JFrame implements ActionListener{
	private JLabel mensaje;
	private JButton boton;
	private JTextField caja,caja2,caja3,caja4,caja5;
	
	public VerificacionPalabra() {
		super();
		configurarVentana();
		crearComponentes();
	}
	
	private void configurarVentana(){
		this.setTitle("Calculadora");
		this.setSize(350,300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearComponentes() {
		mensaje = new JLabel();
		mensaje.setText("Palabra");
		mensaje.setBounds(40, 20, 120, 30);
		this.add(mensaje);
		caja = new JTextField();
		caja.setBounds(130, 20, 150, 30);
		this.add(caja);
		mensaje = new JLabel();
		mensaje.setText("Polindromo");
		mensaje.setBounds(40, 100, 100, 30);
		this.add(mensaje);
		caja2 = new JTextField();
		caja2.setBounds(130, 100, 150, 30);
		this.add(caja2);
		mensaje = new JLabel();
		mensaje.setText("Longitud");
		mensaje.setBounds(40, 135, 100, 30);
		this.add(mensaje);
		caja3 = new JTextField();
		caja3.setBounds(130, 135, 150, 30);
		this.add(caja3);
		mensaje = new JLabel();
		mensaje.setText("Inversa");
		mensaje.setBounds(40, 170, 120, 30);
		this.add(mensaje);
		caja4 = new JTextField();
		caja4.setBounds(130, 170, 150, 30);
		this.add(caja4);
		mensaje = new JLabel();
		mensaje.setText("Repetidos");
		mensaje.setBounds(40, 205, 100, 30);
		this.add(mensaje);
		caja5 = new JTextField();
		caja5.setBounds(130, 205, 150, 30);
		this.add(caja5);
		boton = new JButton();
		boton.setText("Verificar");
		boton.setBounds(130, 60, 150, 30);
		boton.addActionListener(this);
		this.add(boton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		operaciones();
	}
	
	public void operaciones() {
		String palabra = caja.getText().toUpperCase();
		String auxiliar="";
		String cadena = "";
		for(int x=0; x<palabra.length();x++){
			if(palabra.charAt(x)!=' ')
				auxiliar = auxiliar + palabra.charAt(x); 
        }
		for(int x=palabra.length()-1; x>=0;x--){
			if(palabra.charAt(x)!=' ')
				cadena = cadena + palabra.charAt(x); 
        }
		if(auxiliar.compareTo(cadena)==0) 
			caja2.setText("Si");
		else
			caja2.setText("No");
		
		
		caja3.setText(String.valueOf(cadena.length()));
		caja4.setText(cadena);
		
		
        int maximo = 0;
        char repetido=' ';
        for (int x = 0; x < palabra.length(); x++) {
        	int contador = 0;
           for(int y =0; y<palabra.length(); y++) {
        	  if(palabra.charAt(y)==palabra.charAt(x)) {
        		  contador++;
        	  }
           }
           if(contador>maximo) {
        	   repetido=palabra.charAt(x);
        	   maximo=contador;
           }
        }
        if(maximo==1)
        	caja5.setText("No existe maximo repetido");
        else 
        	caja5.setText(Character.toString(repetido));
	}
	
	public static void main(String[] args) {
		VerificacionPalabra ventana = new VerificacionPalabra();
		ventana.setVisible(true);	
	}
}
