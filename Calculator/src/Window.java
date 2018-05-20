import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Insets;
import java.awt.BorderLayout;



public class Window extends JFrame {
	
	private JTextArea screen;
	private JPanel panel;
	private JPanel screenpanel;
	private JButton button0 = new JButton("0");
	private JButton button1 = new JButton("1");
	private JButton button2 = new JButton("2");
	private JButton button3 = new JButton("3");
	private JButton button4 = new JButton("4");
	private JButton button5 = new JButton("5");
	private JButton button6 = new JButton("6");
	private JButton button7 = new JButton("7");
	private JButton button8 = new JButton("8");
	private JButton button9 = new JButton("9");
	private JButton dot = new JButton(".");
	private JButton del = new JButton("←");
	private JButton clear = new JButton("C");
	private JButton flipsign = new JButton("±");
	private JButton plus = new JButton("+");
	private JButton minus = new JButton("-");
	private JButton divide = new JButton("/");
	private JButton multiply = new JButton("*");
	private JButton equals = new JButton("=");
	private JButton mod = new JButton("%");
	private JButton squared = new JButton("x²");
	private JButton cubed = new JButton("x³");
	private JButton sqrt = new JButton("√");
	
	private Font numberfont = new Font("Serif",Font.BOLD,31);
	private Font outputfont = new Font("Serif", Font.BOLD,37);
	public Window(){
		
		super("Calculator");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(335, 400);
		setResizable(false);
		ImageIcon icon = new ImageIcon(getClass().getResource("/Calculator.png"));
		setIconImage(icon.getImage());
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		screenpanel = new JPanel();
		screenpanel.setBounds(5, 5, 320, 77);
		screenpanel.setBackground(Color.white);
		screenpanel.setLayout(new BorderLayout(0, 0));
		
		//adds screen
		screen = new JTextArea();
		screen.setFont(outputfont);
		screen.setEditable(false);
		screen.setRows(1);
		screen.setFocusable(false); //TODO Remove replace with KeyBinding
		screenpanel.add(screen, BorderLayout.WEST);
		getContentPane().add(screenpanel);
		
		panel = new JPanel();
		panel.setBounds(5, 45, 325, 362);
		//adds handlers
		
		TheHandler handler = new TheHandler();
		GridBagLayout gbl_panel = new GridBagLayout();		
		GridBagConstraints gbc = new GridBagConstraints();
		panel.setLayout(gbl_panel);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 5, 5);

		
		//adds del button
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		del.setFont(numberfont);
		del.addActionListener(handler);	
		panel.add(del, gbc);
		
		//adds clear button
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		clear.setFont(numberfont);
		clear.addActionListener(handler);
		panel.add(clear, gbc);
		
		//adds flip sign button
		gbc.gridx = 2;
		gbc.gridy = 0;
		flipsign.setFont(numberfont);
		flipsign.addActionListener(handler);
		panel.add(flipsign,gbc);
		
		//adds mod button
		gbc.gridx = 3;
		gbc.gridy = 0;
		mod.setFont(numberfont);
		mod.addActionListener(handler);
		panel.add(mod,gbc);
		
		//adds squared button
		gbc.gridx = 4;
		gbc.gridy = 0;
		squared.setFont(numberfont);
		squared.addActionListener(handler);
		panel.add(squared,gbc);
		
		//adds button 7
		gbc.gridx = 0;
		gbc.gridy = 1;
		button7.setFont(numberfont);
		button7.addActionListener(handler);
		panel.add(button7, gbc);
		
		//adds button 8
		gbc.gridx = 1;
		gbc.gridy = 1;
		button8.setFont(numberfont);
		button8.addActionListener(handler);
		panel.add(button8, gbc);
		
		//adds button 9
		gbc.gridx = 2;
		gbc.gridy = 1;
		button9.setFont(numberfont);
		button9.addActionListener(handler);
		panel.add(button9, gbc);
		
		//adds / button
		gbc.gridx = 3;
		gbc.gridy = 1;
		divide.setFont(numberfont);
		divide.addActionListener(handler);
		panel.add(divide, gbc);
		
		//adds Cubed button
		gbc.gridx = 4;
		gbc.gridy = 1;
		cubed.setFont(numberfont);
		cubed.addActionListener(handler);
		panel.add(cubed,gbc);
		//adds button 4
		gbc.gridx = 0;
		gbc.gridy = 2;
		button4.setFont(numberfont);
		button4.addActionListener(handler);
		panel.add(button4, gbc);
		
		//adds button 5
		gbc.gridx = 1;
		gbc.gridy = 2;
		button5.setFont(numberfont);
		button5.addActionListener(handler);
		panel.add(button5, gbc);
		
		//adds button 6
		gbc.gridx = 2;
		gbc.gridy = 2;
		button6.setFont(numberfont);
		button6.addActionListener(handler);
		panel.add(button6, gbc);
		
		//adds button *
		gbc.gridx = 3;
		gbc.gridy = 2;
		multiply.setFont(numberfont);
		multiply.addActionListener(handler);
		panel.add(multiply, gbc);
		
		//adds button sqrt
		gbc.gridx = 4;
		gbc.gridy = 2;
		sqrt.setFont(numberfont);
		sqrt.addActionListener(handler);
		panel.add(sqrt, gbc);
		
		//adds button 1
		gbc.gridx = 0;
		gbc.gridy = 3;
		button1.setFont(numberfont);
		button1.addActionListener(handler);
		panel.add(button1, gbc);
		
		//adds button 2
		gbc.gridx = 1;
		gbc.gridy = 3;
		button2.setFont(numberfont);
		button2.addActionListener(handler);
		panel.add(button2,gbc);
		
		//adds button 3
		gbc.gridx = 2;
		gbc.gridy = 3;
		button3.setFont(numberfont);
		button3.addActionListener(handler);
		panel.add(button3, gbc);
		
		//adds button -
		gbc.gridx = 3;
		gbc.gridy = 3;
		minus.setFont(numberfont);
		minus.addActionListener(handler);
		panel.add(minus, gbc);
		
		//adds = button
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridheight = 2;
		equals.setFont(numberfont);
		equals.addActionListener(handler);		
		panel.add(equals, gbc);
		
		//adds button 0
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		button0.setFont(numberfont);
		button0.addActionListener(handler);
		panel.add(button0, gbc);
		
		//adds button .
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		dot.setFont(numberfont);
		dot.addActionListener(handler);
		panel.add(dot, gbc);
		
		//adds button +
		gbc.gridx = 3;
		gbc.gridy = 4;
		plus.setFont(numberfont);
		plus.addActionListener(handler);		
		panel.add(plus, gbc);
		
		
		KeyHandler key = new KeyHandler();  //TODO Remove and replace with keyBinding
		getContentPane().addKeyListener(key);
		getContentPane().setFocusable(true);
		getContentPane().setFocusTraversalKeysEnabled(false);

		
		getContentPane().add(panel);
		
		
		setVisible(true);

	}
	
	
	public void setDisplay(String str){ //sets Display
		screen.setText(str);
	}
	public void setDisplayFont(int size){ //sets Display Font Size
		screen.setFont(new Font("Serif",Font.BOLD,size));
	}
	
	public class TheHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			getContentPane().requestFocusInWindow(); //TODO replace with KeyBinding
			if(event.getActionCommand().equals("C")){ //Clear
				Calculator.clear();
			}else if(event.getActionCommand().equals("←")){ //Delete
				Calculator.delete();
			}else if(Calculator.getDisplayLength() < 32){ // Checks if display is full
				
				if(event.getActionCommand().equals("+") || event.getActionCommand().equals("-") ||event.getActionCommand().equals("/") || event.getActionCommand().equals("*") || event.getActionCommand().equals("%")){
					Calculator.addOperator(event.getActionCommand());
				}else if(event.getActionCommand().equals("±") ||event.getActionCommand().equals("√")|| event.getActionCommand().contains("x")){
					Calculator.instant(event.getActionCommand());
				}else if(event.getActionCommand().contains("=")){
					Calculator.calculate();			
				}else{
					Calculator.buildString(event.getActionCommand());
				
				}
			}
			
		}
		
	}
	
	public class KeyHandler extends KeyAdapter{ //TODO replace with keybinding 
		public void keyPressed(KeyEvent event){
			char input = event.getKeyChar();
			System.out.println(event.getExtendedKeyCode());
			if(event.getExtendedKeyCode()== 10){
			  equals.doClick();
			}
			
			switch(input){
				case '0': button0.doClick();
				break;
				case '1': button1.doClick();
				break;
				case '2': button2.doClick();
				break;
				case '3': button3.doClick();
				break;
				case '4': button4.doClick();
				break;
				case '5': button5.doClick();
				break;
				case '6': button6.doClick();
				break;
				case '7': button7.doClick();
				break;
				case '8': button8.doClick();
				break;
				case '9': button9.doClick();
				break;
				case '.': dot.doClick();
				break;
				case '+': plus.doClick();
				break;
				case '-': minus.doClick();
				break;
				case '/': divide.doClick();
				break;
				case '*': multiply.doClick();
				break;
				case '=': equals.doClick();
				break;
				case '': del.doClick();
				break;
				case '': clear.doClick();
				break;
				case 'c': clear.doClick();
				break;
				
				default: break;
			}
			
				
			
		}
	}

}
