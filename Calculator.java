// package Calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.border.Border;

public class Calculator implements ActionListener{
	JTextField screen;
	JFrame frame;
	JButton[] numButtons = new JButton[10];
	JButton[] funcKeys = new JButton[9];
	JButton addB, subB, mulB, divB;
	JButton decB, clrB, eqnB, delB, negB;
	JPanel panel;
	Font font = new Font("Ink Free", Font.BOLD, 34);
	Font font1 = new Font("monospace", Font.BOLD, 40);
	double val1=0, val2=0, result=0;
	char operator;

	
Calculator(){
	frame = new JFrame("Calculator App");
	frame.setBounds(0, 0, 400, 520);
	frame.setIconImage(null);
	frame.getContentPane().setBackground(new Color(109, 132, 161));
	frame.setLayout(null);
	frame.setResizable(false);
	
	screen = new JTextField();
	screen.setBounds(10, 10, 370, 90);
	screen.setEditable(false);
	screen.setBackground(new Color(177, 199, 227));
	
	addB = new JButton("+");
	subB = new JButton("-");
	divB = new JButton("/");
	mulB = new JButton("x");
	clrB = new JButton("Clr");
	decB = new JButton(".");
	eqnB = new JButton("=");
	delB = new JButton("Del");
	negB = new JButton("(-)");
	
	JButton[] funcKeys= {addB,subB,divB,mulB,clrB,decB,eqnB,delB,negB};
	
	for(int i=0;i<9;i++){
		funcKeys[i].addActionListener(this);
		funcKeys[i].setFont(font);
		funcKeys[i].setFocusable(false);
	}
	for(int i =0; i<10; i++){
		numButtons[i] = new JButton(String.valueOf(i));
		numButtons[i].setFocusable(false);
		numButtons[i].setFont(font);
		numButtons[i].addActionListener(this);
	}
	
	delB.setBounds(10, 110, 130, 57);
	clrB.setBounds(248, 110, 130, 57);
	negB.setBounds(144, 110, 100, 57);
	panel = new JPanel();
	panel.setBounds(10, 170, 370, 300);
	panel.setLayout(new GridLayout(4,4,5,5));
	panel.setBackground(new Color(109, 132, 161));
	
	panel.add(numButtons[1]);
	panel.add(numButtons[2]);
	panel.add(numButtons[3]);
	panel.add(addB);
	panel.add(numButtons[4]);
	panel.add(numButtons[5]);
	panel.add(numButtons[6]);
	panel.add(subB);
	panel.add(numButtons[7]);
	panel.add(numButtons[8]);
	panel.add(numButtons[9]);
	panel.add(mulB);
	panel.add(decB);
	panel.add(numButtons[0]);
	panel.add(eqnB);
	panel.add(divB);
	
	screen.setFont(font1);
	frame.add(screen);
	frame.setVisible(true);
	frame.add(panel);
	frame.add(delB);
	frame.add(clrB);
	frame.add(negB);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	try {
	for(int i=0; i<10; i++) {
		if(e.getSource()==numButtons[i]) {
			screen.setText(screen.getText().concat(String.valueOf(i)));
		}
	}
	if(e.getSource()==decB) {
		screen.setText(screen.getText().concat("."));
	}
	if(e.getSource()== addB) {
		val1 = Double.parseDouble(screen.getText());
		operator = '+';
		screen.setText("");
	}
	if(e.getSource()== subB) {
		val1 = Double.parseDouble(screen.getText());
		operator = '-';
		screen.setText("");
	}
	if(e.getSource()== mulB) {
		val1 = Double.parseDouble(screen.getText());
		operator = 'x';
		screen.setText("");
	}
	if(e.getSource()== divB) {
		val1 = Double.parseDouble(screen.getText());
		operator = '/';
		screen.setText("");
	}
	if(e.getSource()== eqnB) {
		val2 = Double.parseDouble(screen.getText());
		screen.setText("");
		switch(operator) {
		case '+': result = val1 + val2;
		break;
		case '-': result = val1 - val2;
		break;
		case 'x': result = val1 * val2;
		break;
		case '/': result = val1 / val2;
		break;
		default: result = val1;
		break;
		}
	screen.setText(String.valueOf(result));
	val1 = result;
}
	if(e.getSource()== clrB) {
		screen.setText("");
	}
	if(e.getSource()== delB) {
		val1 = Double.parseDouble(screen.getText());
		String m = screen.getText();
		screen.setText("");
		for(int i=0; i<m.length()-1; i++) {
			screen.setText(screen.getText()+m.charAt(i));	
		}
	if(e.getSource()== negB) {
		double val = Double.parseDouble(screen.getText());
		val *= -1;
		screen.setText(String.valueOf(val));
		}
	}
	}
	catch(Exception wHY) {
		System.out.println(wHY);
		screen.setText("Syntax Error");
	}
}

public static void main(String[] args) {
	Calculator calculator = new Calculator();
}
}
	
	

