
// Imports
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


// Class
public class AdvancedCalculatorFrame extends JFrame implements ActionListener{


	// Creating all necessary components
	JLabel answerLabel = new JLabel("0");
	
	JButton additionButton = new JButton("+");
	JButton subtractionButton = new JButton("-");
	JButton multiplicationButton = new JButton("*");
	JButton divisionButton = new JButton("/");
	JButton equalButton = new JButton("=");
	JButton clear = new JButton("C");
	
	JButton zero = new JButton("0");
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	JButton four = new JButton("4");
	JButton five = new JButton("5");
	JButton six = new JButton("6");
	JButton seven = new JButton("7");
	JButton eight = new JButton("8");
	JButton nine = new JButton("9");
	
	String answerString = "";
	String currString = "";
	
	String[] operations = {"*", "/", "+", "-"};
	
	// Initialization function
	public AdvancedCalculatorFrame() {
		
		// Main frame
		setSize(450,600);
		setTitle("Advanced Calculator");
		getContentPane().setBackground(Color.red);
		
		// Answer label
		answerLabel.setBounds(20,10,410,75);
		answerLabel.setFont(new Font("Serif", Font. BOLD, 28));
		answerLabel.setHorizontalAlignment(JTextField.RIGHT);
		answerLabel.setBackground(Color.white);
		answerLabel.setOpaque(true);
		add(answerLabel);
		
		
		// All the buttons
		
		additionButton.setBounds(350,360,80,80);
		add(additionButton);
		additionButton.addActionListener(this);
		
		subtractionButton.setBounds(350,270,80,80);
		add(subtractionButton);
		subtractionButton.addActionListener(this);
		
		multiplicationButton.setBounds(350,180,80,80);
		add(multiplicationButton);
		multiplicationButton.addActionListener(this);
		
		divisionButton.setBounds(350,90,80,80);
		add(divisionButton);
		divisionButton.addActionListener(this);
		
		equalButton.setBounds(350,450,80,80);
		add(equalButton);
		equalButton.addActionListener(this);
	
		zero.setBounds(150,450,80,80);
		add(zero);
		zero.addActionListener(this);
		
		one.setBounds(50,360,80,80);
		add(one);
		one.addActionListener(this);
		
		two.setBounds(150,360,80,80);
		add(two);
		two.addActionListener(this);
		
		three.setBounds(250,360,80,80);
		add(three);
		three.addActionListener(this);
		
		four.setBounds(50,270,80,80);
		add(four);
		four.addActionListener(this);
		
		five.setBounds(150,270,80,80);
		add(five);
		five.addActionListener(this);
		
		six.setBounds(250,270,80,80);
		add(six);
		six.addActionListener(this);
		
		seven.setBounds(50,180,80,80);
		add(seven);
		seven.addActionListener(this);
		
		eight.setBounds(150,180,80,80);
		add(eight);
		eight.addActionListener(this);
		
		nine.setBounds(250,180,80,80);
		add(nine);
		nine.addActionListener(this);
		
		clear.setBounds(150,90,80,80);
		add(clear);
		clear.addActionListener(this);
		
		
		setLayout(null);
		setVisible(true);
	}
	
	// Action Listener
	public void actionPerformed(ActionEvent event) {
		// Finding which button was pressed and doing the respective operation
		if(event.getSource() == zero) {
			answerString += "0";
			currString += "0";
			answerLabel.setText(currString);
		}else if(event.getSource() == one) {
			answerString += "1";
			currString += "1";
			answerLabel.setText(currString);
		}else if(event.getSource() == two) {
			answerString += "2";
			currString += "2";
			answerLabel.setText(currString);
		}else if(event.getSource() == three) {
			answerString += "3";
			currString += "3";
			answerLabel.setText(currString);
		}else if(event.getSource() == four) {
			answerString += "4";
			currString += "4";
			answerLabel.setText(currString);
		}else if(event.getSource() == five) {
			answerString += "5";
			currString += "5";
			answerLabel.setText(currString);
		}else if(event.getSource() == six) {
			answerString += "6";
			currString += "6";
			answerLabel.setText(currString);
		}else if(event.getSource() == seven) {
			answerString += "7";
			currString += "7";
			answerLabel.setText(currString);
		}else if(event.getSource() == eight) {
			answerString += "8";
			currString += "8";
			answerLabel.setText(currString);
		}else if(event.getSource() == nine) {
			answerString += "9";
			currString += "9";
			answerLabel.setText(currString);
		}else if(event.getSource() == divisionButton) {
			answerString += "/";
			currString = "";
		}else if(event.getSource() == multiplicationButton) {
			answerString += "*";
			currString = "";
		}else if(event.getSource() == additionButton) {
			answerString += "+";
			currString = "";
		}else if(event.getSource() == subtractionButton) {
			answerString += "-";
			currString = "";
		}else if(event.getSource() == clear) {
			// Clear button resets everything
			answerString = "";
			currString  = "";
			answerLabel.setText("0");
		}else {
			// Equals button runs a special function which calculates the answer
			calculate();
		}
	}
	
	public void calculate() {
		
		// This is the final output
		double val = 0;
		
		// The current number and the previous operator
		String currNum = "";
		String oper = "+";
		
		
		// Loop through the values they entered
		for(int i = 0; i < answerString.length();i++) {
			
			// If it is a operation, we have to get the old number and perform an operation to it
			if(Arrays.stream(operations).anyMatch(String.valueOf(answerString.charAt(i))::equals)) {
				double num = Double.parseDouble(currNum);
				
				if(oper.equals("+")) {
					val += num;
				}else if(oper.equals("-")) {
					val -= num;
				}else if(oper.equals("/")) {
					val /= num;
				}else if(oper.equals("*")) {
					val *= num;
				}
				
				currNum = "";
				oper = String.valueOf(answerString.charAt(i));
								
			}else {
				// If its a number we add it to the correct number
				currNum += answerString.charAt(i);
			}
		}
		
		
		// The last operation is not processed, so we process it
		double num = Double.parseDouble(currNum);

		
		if(oper.equals("+")) {
			val += num;
		}else if(oper.equals("-")) {
			val -= num;
		}else if(oper.equals("/")) {
			val /= num;
		}else if(oper.equals("*")) {
			val *= num;
		}

		// Change the answer label		
		answerLabel.setText(String.valueOf(val));
		currString = "";
		answerString = String.valueOf(val);
	}
}
