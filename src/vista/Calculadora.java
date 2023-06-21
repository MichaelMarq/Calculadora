
package vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//Vamos a trabajar con el double nomas para evitarnos problemas



public class Calculadora extends JFrame{
    
    //Atributos
    private JPanel jPanel;
    private JMenuBar jBarraMenu;
    private JMenu jMenu;
    private JMenuItem jItemCalEstandar,jItemCalDivisa,jItemSalir;
    private GridBagLayout design;
    private GridBagConstraints c;
    private JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    private JButton btnC,btnRaiz,btnDivision,btnEliminar,btnMultiplicacion,btnResta,btnSuma;
    private JButton btnIgual,btnPunto,btnSigno;
    private JLabel jlResultado,jlOperacion;
    private String mensaje="0",signo="",aux1="0",aux2="0",signoPunto="";
    private double numero1=0,numero2=0,resultado=0;
    private boolean pulsadoIgual = false, pulsadoMas = false, pulsadoPunto1 = false, pulsadoPunto2 = false;
    
    
    //Constructor
    
    public Calculadora(){
        //Metodo que inicializa los componentes del JFrame
        inicializarComponentes();
        
        //La barrra de menu
        this.setJMenuBar(jBarraMenu);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Inicialzar componentes
    private void inicializarComponentes(){
        agregarVentana();
        agregarBarraMenu();
        agregarMenu();
        agregarMenuItem();
        agregarPanel();
        agregarDesign();
        agregarBoton();
        agregarEtiquetaResultado();
        agregarEtiquetaOperacion();
    }
    
    //Inicializar ventana
    private void agregarVentana(){
        this.setTitle("Calculadora");
        this.setSize(330, 440);
        
        this.setLocationRelativeTo(null);    
    }
    
    //Agregar la barra de menu a la ventana
    private void agregarBarraMenu(){
        jBarraMenu = new JMenuBar();
    }
    
    //Agregar el menu a la barra de menu
    private void agregarMenu(){
        jMenu = new JMenu("Usos");
        jMenu.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        jBarraMenu.add(jMenu);
    }
    
    //Agregar Items al menu
    private void agregarMenuItem(){
        jItemCalEstandar = new JMenuItem("Calculadora Estándar");
        jItemCalEstandar.setFont(new Font("Arial Rounded MT Bold", 0, 15));
        jMenu.add(jItemCalEstandar);
        
        jItemCalDivisa = new JMenuItem("Conversor de Divisas");
        jItemCalDivisa.setFont(new Font("Arial Rounded MT Bold", 0, 15));
        jMenu.add(jItemCalDivisa);
        
        jItemSalir = new JMenuItem("Salir");
        jItemSalir.setFont(new Font("Arial Rounded MT Bold", 0, 15));
        jMenu.add(jItemSalir);
        eventoItemSalir();
         
    }
    
    //Crear panel
    private void agregarPanel(){
        jPanel = new JPanel();
        this.add(jPanel);
    }
    
    //Crear el diseño
    private void agregarDesign(){
        design = new GridBagLayout();
        jPanel.setLayout(design);
        c = new GridBagConstraints();
    }
    
    
    //Agregar botones
    private void agregarBoton(){
        
        btnC = new JButton("C");
        btnC.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnC, c);
        
        btnRaiz = new JButton("√");
        btnRaiz.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnRaiz, c);
        
        btnDivision = new JButton("÷");
        btnDivision.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnDivision, c);
        
        btnEliminar = new JButton("X");
        btnEliminar.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnEliminar, c);
        
        btnMultiplicacion = new JButton("X");
        btnMultiplicacion.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnMultiplicacion, c);
        
        btnResta = new JButton("-");
        btnResta.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 3;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnResta, c);
        
        btnSuma = new JButton("+");
        btnSuma.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 3;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnSuma, c);
        
        btnIgual = new JButton("=");
        btnIgual.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 3;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnIgual, c);
        
        btnPunto = new JButton(".");
        btnPunto.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 2;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnPunto, c);
        
        btnSigno = new JButton("±");
        btnSigno.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnSigno, c);
        

        
        btn9 = new JButton("9");
        btn9.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn9, c);
        
        btn8 = new JButton("8");
        btn8.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn8, c);
        
        btn7 = new JButton("7");
        btn7.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn7, c);
        
        btn6 = new JButton("6");
        btn6.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 2;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn6, c);
        
        btn5 = new JButton("5");
        btn5.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn5, c);
        
        btn4 = new JButton("4");
        btn4.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn4, c);
        
        btn3 = new JButton("3");
        btn3.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 2;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn3, c);
        
        btn2 = new JButton("2");
        btn2.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn2, c);
        
        btn1 = new JButton("1");
        btn1.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn1, c);
        
        btn0 = new JButton("0");
        btn0.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        c.gridx = 1;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn0, c);
        
        
        //Eventos click de los botones
        eventoClickNumero();
        eventoClickSigno();
    }
    
    //Agregar etiqueta del resultado de las operaciones
    private void agregarEtiquetaResultado(){
        jlResultado = new JLabel(aux1);
        jlResultado.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        jlResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        jlResultado.setVerticalAlignment(SwingConstants.BOTTOM);
        
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.gridheight = 2;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 30, 10);
        c.weightx = 0.5;
        c.weighty = 0.5;
        
        jPanel.add(jlResultado, c);
        
    }
    
    //Agregar etiqueta de las operaciones que se realizar 5 + 2 =
    private void agregarEtiquetaOperacion(){
        jlOperacion = new JLabel();
        jlOperacion.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        jlOperacion.setHorizontalAlignment(SwingConstants.RIGHT);
        jlOperacion.setVerticalAlignment(SwingConstants.BOTTOM);
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 30, 10);
        c.weightx = 0.5;
        c.weighty = 0.5;
        
        jPanel.add(jlOperacion, c);
    }
    

    

    //Eventos click de los botones numericos
    private void eventoClickNumero(){
        eventoBtn0();
        eventoBtn1();
        eventoBtn2();
        eventoBtn3();
        eventoBtn4();
        eventoBtn5();
        eventoBtn6();
        eventoBtn7();
        eventoBtn8();
        eventoBtn9();
    }
    
    //Evento click de los signos para operar los numeros
    private void eventoClickSigno(){
        eventoBtnC();
        eventoSuma();
        eventoIgual();
        eventoPunto();
    }
    
    
    //Eventos click botones numericos
    private void eventoBtn0(){
        //Boton 0
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //  Si el signo es + significa que ya digito el primer numero
                if(pulsadoIgual == true){
                    
                    aux1 = "0";
                    aux2 = "0";
                    pulsadoPunto1 = false;
                    pulsadoPunto2 = false;
                    signoPunto = "";
                    
                    if(pulsadoMas == true){
                        aux1 = ""+resultado;
                        aux2 += "0";
                        mensaje = aux2;          
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");                 
                        pulsadoIgual = false;
                        
                    }
                    else{
                        aux1 = "0";
                        pulsadoIgual = false;
                        signo = "";
                        mensaje =aux1;
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                        
                    }
                    
                }
                else if(signo.equals("+")){
                    aux2 += "0";
                    mensaje = aux2;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");           
                }
                else{ 
                    
                    aux1 += "0";
                    mensaje =aux1;
                    jlResultado.setText(Double.parseDouble(mensaje)+""); 
                }
                
            }
        };
        
        btn0.addActionListener(oyente);
    }
    
    private void eventoBtn1(){
        //boton 1
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //  Si el signo es + significa que ya digito el primer numero
                if(pulsadoIgual == true){
                    
                    aux1 = "0";
                    aux2 = "0";
                    pulsadoPunto1 = false;
                    pulsadoPunto2 = false;
                    signoPunto = "";
                    
                    if(pulsadoMas == true){
                        aux1 = ""+resultado;
                        aux2 += "1";
                        mensaje = aux2;          
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");                 
                        pulsadoIgual = false;
                        
                    }
                    else{
                        aux1 = "1";
                        pulsadoIgual = false;
                        signo = "";
                        mensaje =aux1;
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                        
                    }
                    
                }
                else if(signo.equals("+")){
                    aux2 += "1";
                    mensaje = aux2;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");           
                }
                else{ 
                    
                    aux1 += "1";
                    mensaje =aux1;
                    jlResultado.setText(Double.parseDouble(mensaje)+""); 
                }    
            }
        };
        
        btn1.addActionListener(oyente);
        
    }
    
    private void eventoBtn2(){
        //boton 2
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){ 
                //  Si el signo es + significa que ya digito el primer numero
                if(pulsadoIgual == true){
                    
                    aux1 = "0";
                    aux2 = "0";
                    pulsadoPunto1 = false;
                    pulsadoPunto2 = false;
                    signoPunto = "";
                    
                    if(pulsadoMas == true){
                        aux1 = ""+resultado;
                        aux2 += "2";
                        mensaje = aux2;          
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");                 
                        pulsadoIgual = false;
                        
                    }
                    else{
                        aux1 = "2";
                        pulsadoIgual = false;
                        signo = "";
                        mensaje =aux1;
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                        
                    }
                    
                }
                else if(signo.equals("+")){
                    aux2 += "2";
                    mensaje = aux2;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");           
                }
                else{ 
                    
                    aux1 += "2";
                    mensaje =aux1;
                    jlResultado.setText(Double.parseDouble(mensaje)+""); 
                }
             
            }
        };
        
        btn2.addActionListener(oyente);
    }
    
    private void eventoBtn3(){
        //boton 3
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //  Si el signo es + significa que ya digito el primer numero
                if(pulsadoIgual == true){
                    
                    aux1 = "0";
                    aux2 = "0";
                    pulsadoPunto1 = false;
                    pulsadoPunto2 = false;
                    signoPunto = "";
                    
                    if(pulsadoMas == true){
                        aux1 = ""+resultado;
                        aux2 += "3";
                        mensaje = aux2;          
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");                 
                        pulsadoIgual = false;
                        
                    }
                    else{
                        aux1 = "3";
                        pulsadoIgual = false;
                        signo = "";
                        mensaje =aux1;
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                        
                    }
                    
                }
                else if(signo.equals("+")){
                    aux2 += "3";
                    mensaje = aux2;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");           
                }
                else{ 
                    
                    aux1 += "3";
                    mensaje =aux1;
                    jlResultado.setText(Double.parseDouble(mensaje)+""); 
                }

            }
        };
        
        btn3.addActionListener(oyente);
    }
    
    private void eventoBtn4(){
        //boton 4
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //  Si el signo es + significa que ya digito el primer numero
                if(pulsadoIgual == true){
                    
                    aux1 = "0";
                    aux2 = "0";
                    
                    if(pulsadoMas == true){
                        aux1 = ""+resultado;
                        aux2 += "4";
                        mensaje = aux2;
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                        pulsadoIgual = false;
                        
                    }
                    else{
                        aux1 = "4";
                        pulsadoIgual = false;
                        signo = "";
                        mensaje =aux1;
                        jlOperacion.setText("");
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                    }
                    
                }
                else if(signo.equals("+")){
                    aux2 += "4";
                    mensaje = aux2;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");
                    
                }
                else{
                    aux1 += "4";
                    mensaje =aux1;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");
                }
                
            }
        };
        
        btn4.addActionListener(oyente);
    }
    
    private void eventoBtn5(){
        //boton 5
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //  Si el signo es + significa que ya digito el primer numero
                if(pulsadoIgual == true){
                    
                    aux1 = "0";
                    aux2 = "0";
                    pulsadoPunto1 = false;
                    pulsadoPunto2 = false;
                    signoPunto = "";
                    
                    if(pulsadoMas == true){
                        aux1 = ""+resultado;
                        aux2 += "5";
                        mensaje = aux2;          
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");                 
                        pulsadoIgual = false;
                        
                    }
                    else{
                        aux1 = "5";
                        pulsadoIgual = false;
                        signo = "";
                        mensaje =aux1;
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                        
                    }
                    
                }
                else if(signo.equals("+")){
                    aux2 += "5";
                    mensaje = aux2;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");           
                }
                else{ 
                    
                    aux1 += "5";
                    mensaje =aux1;
                    jlResultado.setText(Double.parseDouble(mensaje)+""); 
                }
                
            }
        };
        
        btn5.addActionListener(oyente);
    }
    
    private void eventoBtn6(){
        //boton 6
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //  Si el signo es + significa que ya digito el primer numero
                if(pulsadoIgual == true){
                    
                    aux1 = "0";
                    aux2 = "0";
                    pulsadoPunto1 = false;
                    pulsadoPunto2 = false;
                    signoPunto = "";
                    
                    if(pulsadoMas == true){
                        aux1 = ""+resultado;
                        aux2 += "6";
                        mensaje = aux2;          
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");                 
                        pulsadoIgual = false;
                        
                    }
                    else{
                        aux1 = "6";
                        pulsadoIgual = false;
                        signo = "";
                        mensaje =aux1;
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                        
                    }
                    
                }
                else if(signo.equals("+")){
                    aux2 += "6";
                    mensaje = aux2;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");           
                }
                else{ 
                    
                    aux1 += "6";
                    mensaje =aux1;
                    jlResultado.setText(Double.parseDouble(mensaje)+""); 
                }

            }
        };
        
        btn6.addActionListener(oyente);
    }
    
    private void eventoBtn7(){
        //boton 7
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //  Si el signo es + significa que ya digito el primer numero
                if(pulsadoIgual == true){
                    
                    aux1 = "0";
                    aux2 = "0";
                    pulsadoPunto1 = false;
                    pulsadoPunto2 = false;
                    signoPunto = "";
                    
                    if(pulsadoMas == true){
                        aux1 = ""+resultado;
                        aux2 += "7";
                        mensaje = aux2;          
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");                 
                        pulsadoIgual = false;
                        
                    }
                    else{
                        aux1 = "7";
                        pulsadoIgual = false;
                        signo = "";
                        mensaje =aux1;
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                        
                    }
                    
                }
                else if(signo.equals("+")){
                    aux2 += "7";
                    mensaje = aux2;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");           
                }
                else{ 
                    
                    aux1 += "7";
                    mensaje =aux1;
                    jlResultado.setText(Double.parseDouble(mensaje)+""); 
                }
                
            }
        };
        
        btn7.addActionListener(oyente);
    }
    
    private void eventoBtn8(){
        //boton 8
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //  Si el signo es + significa que ya digito el primer numero
                if(pulsadoIgual == true){
                    
                    aux1 = "0";
                    aux2 = "0";
                    pulsadoPunto1 = false;
                    pulsadoPunto2 = false;
                    signoPunto = "";
                    
                    if(pulsadoMas == true){
                        aux1 = ""+resultado;
                        aux2 += "8";
                        mensaje = aux2;          
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");                 
                        pulsadoIgual = false;
                        
                    }
                    else{
                        aux1 = "8";
                        pulsadoIgual = false;
                        signo = "";
                        mensaje =aux1;
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                        
                    }
                    
                }
                else if(signo.equals("+")){
                    aux2 += "8";
                    mensaje = aux2;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");           
                }
                else{ 
                    
                    aux1 += "8";
                    mensaje =aux1;
                    jlResultado.setText(Double.parseDouble(mensaje)+""); 
                }
            }
        };
        
        btn8.addActionListener(oyente);
    }
    
    private void eventoBtn9(){
        //boton 9
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //  Si el signo es + significa que ya digito el primer numero

                if(pulsadoIgual == true){
                    
                    aux1 = "0";
                    aux2 = "0";
                    pulsadoPunto1 = false;
                    pulsadoPunto2 = false;
                    signoPunto = "";
                    
                    //pulsadoMas = el boton + ah sido presionado
                    if(pulsadoMas == true){
                        aux1 = ""+resultado;
                        aux2 += "9";
                        mensaje = aux2;          
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");               
                        pulsadoIgual = false;
                        
                    }
                    else{
                        aux1 = "9";
                        pulsadoIgual = false;
                        signo = "";
                        mensaje =aux1;
                        
                        jlResultado.setText(Double.parseDouble(mensaje)+"");
                        
                    }
                    
                }
                else if(signo.equals("+")){
                    aux2 += "9";
                    mensaje = aux2;
                    jlResultado.setText(Double.parseDouble(mensaje)+"");
                }
                else{ 
                    aux1 += "9";
                    mensaje =aux1;
                    jlResultado.setText(Double.parseDouble(mensaje)+""); 
                }  
                    
            }
                        
        };
        
        btn9.addActionListener(oyente);
    }
    
    //****************
    
    //evento boton C
    private void eventoBtnC(){
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                //Reiniciar todo a su estado inicial

                aux1 = "0";
                aux2 = "0";
                signo = "";
                signoPunto = "";
                numero1=0;
                numero2=0;
                resultado=0;
                mensaje = "0";
                pulsadoIgual = false;
                pulsadoMas = false;
                pulsadoPunto1 = false;
                pulsadoPunto2 = false;
                jlResultado.setText(aux1);
                jlOperacion.setText("");
     
            }
        };
        
        btnC.addActionListener(oyente);
    }
    


    //Operaciones
    private void eventoSuma(){
        
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){ 
                pulsadoMas = true;
                signo = "+";
                
                numero1 = Double.parseDouble(aux1);
                numero2 = Double.parseDouble(aux2);
                resultado = numero1 + numero2;
                if(aux2.equals("0")){
                    jlOperacion.setText(Double.parseDouble(mensaje)+"  "+signo);
                }
                else{
                    jlOperacion.setText(resultado+"  "+signo);
                    jlResultado.setText(resultado+"");
                    aux1 = resultado+"";
                    aux2 = "0";
                }
                //jlOperacion.setText(Double.parseDouble(mensaje)+"  "+signo);
                
                //mensaje para la suma consecutiva
                //jlResultado.setText(Double.parseDouble(signo));
            }
        };
        btnSuma.addActionListener(oyente);  
        
    }
    
    private void eventoIgual(){
                
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                            
                if(signo.equals("+")){
                    
                    if(aux2.equals("0")){
                        aux2 = aux1;
                        numero1 = Double.parseDouble(aux1);
                        numero2 = Double.parseDouble(aux2);
                        
                        resultado = numero1 + numero2;
                        
                        jlOperacion.setText(Double.parseDouble(aux1)+" "+signo+" "+Double.parseDouble(aux2)+ " = ");
                        jlResultado.setText(resultado+"");
                        
                        aux1 = resultado+"";
                        mensaje = aux1;
                        
                        pulsadoIgual = true;
                        pulsadoMas = false;
                        
                    }
                    else{
                        numero1 = Double.parseDouble(aux1);
                        numero2 = Double.parseDouble(aux2);
                        resultado = numero1 + numero2;
                        
                        jlOperacion.setText(Double.parseDouble(aux1)+" "+signo+" "+Double.parseDouble(aux2)+" = ");
                        jlResultado.setText(resultado+"");
                        
                        aux1 = resultado+"";
                        mensaje = aux1;
                        
                        pulsadoIgual = true;
                        pulsadoMas = false;
                    }
                }
                else{
                    
                    numero1 = Double.parseDouble(aux1);
                    numero2 = Double.parseDouble(aux2);
                    resultado = numero1 + numero2;
                    

                    if(aux1.contains(".")){
                        jlOperacion.setText(Double.parseDouble(aux1)+" = ");
                        jlResultado.setText(resultado+"");
                    }
                    else{
                        jlOperacion.setText(Integer.parseInt(aux1)+" = ");
                        jlResultado.setText((int)(resultado)+"");
                    }
                    
                    
                    /*
                    jlOperacion.setText(Double.parseDouble(aux1)+" = ");
                    jlResultado.setText(resultado+"");
                    
                    */
                    aux1 = resultado+"";
                    mensaje = aux1;
                    
                    pulsadoIgual = true;
                    pulsadoMas = false;
                }
                           
                
            }
   
        };
        btnIgual.addActionListener(oyente);  
    
    }
    
    private void eventoPunto(){
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(signo.equals("+")){
                    if(pulsadoPunto2 == false){
                        signoPunto = ".";
                        jlResultado.setText(Integer.parseInt(aux2)+signoPunto);
                        aux2 += signoPunto;
                        pulsadoPunto2 = true;
                    }
                    else{
                        signoPunto = ".";
                        jlResultado.setText(Integer.parseInt(aux2)+signoPunto);
                        aux2 += signoPunto;
                        pulsadoPunto2 = true;
                    }
                
                }
                else{
                    if(pulsadoPunto1 == false){
                        signoPunto = ".";
                        if(pulsadoIgual == true){
                            aux1 = "0";
                            pulsadoIgual = false;
                            jlResultado.setText(Integer.parseInt(aux1)+signoPunto);
                        }
                        else{
                            jlResultado.setText(Integer.parseInt(aux1)+signoPunto);
                        }
                        
                        aux1 += signoPunto;
                        pulsadoPunto1 = true;
                    }
                    
                }
            }
        };
        
        btnPunto.addActionListener(oyente);
    }


    //Evento salir del item de la barra de menu
    private void eventoItemSalir(){
        
        MouseListener evento = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
            
        };
         
        jItemSalir.addMouseListener(evento);
        
    }
    
    
}
