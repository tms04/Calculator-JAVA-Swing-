import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.datatransfer.FlavorTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener{
    JFrame calci;
    JPanel Grid;
    JTextField Answer;
    JButton Numbers[]=new JButton[16];
    JButton J0;
    JButton J1;
    JButton J2;
    JButton J3;
    JButton J4;
    JButton J6;
    JButton J5;
    JButton J7;
    JButton J8;
    JButton J9;
    JButton plus;
    JButton minus;
    JButton div;
    JButton mul;
    JButton dot;
    JButton clear;
    JButton ans;
    float firstNum,secondNum;
    char OP;
    Calculator() {
        calci= new JFrame();
        Grid=new JPanel();
        Grid.setBounds(0, 60, 225, 350);
        calci.setSize(250, 450);
        Answer=new JTextField();
        // Answer.setSize(50, 100);
        Answer.setBounds(5, 10, 225, 50);
        Answer.setEditable(false);
        Grid.setLayout(new GridLayout(5,4));
        J0=new JButton("0");
        J1=new JButton("1");
        J2=new JButton("2");
        J3=new JButton("3");
        J4=new JButton("4");
        J5=new JButton("5");
        J6=new JButton("6");
        J7=new JButton("7");
        J8=new JButton("8");
        J9=new JButton("9");
        plus= new JButton("+");
        minus= new JButton("-");
        div= new JButton("/");
        mul= new JButton("x");
        dot= new JButton(".");
        clear= new JButton("C");
        ans= new JButton("=");
        Numbers[0]=J0;
        Numbers[1]=J1;
        Numbers[2]=J2;
        Numbers[3]=J3;
        Numbers[4]=J4;
        Numbers[5]=J5;
        Numbers[6]=J6;
        Numbers[7]=J7;
        Numbers[8]=J8;
        Numbers[9]=J9;
        Numbers[10]=clear;
        Numbers[11]=plus;
        Numbers[12]=minus;
        Numbers[13]=div;
        Numbers[14]=mul;
        Numbers[15]=ans;
        Grid.add(clear);
        Grid.add(mul);
        Grid.add(dot);
        Grid.add(ans);
        Grid.add(J9);
        Grid.add(J8);
        Grid.add(J7);
        Grid.add(div);
        Grid.add(J6);
        Grid.add(J5);
        Grid.add(J4);
        Grid.add(plus);
        Grid.add(J3);
        Grid.add(J2);
        Grid.add(J1);
        Grid.add(minus);
        Grid.add(J0);
        J0.setBounds(10, 370, 60, 75);
        calci.setLayout(null);
        calci.add(Answer);
        calci.add(Grid);
        for(int i=0;i<16;i++){
            Numbers[i].addActionListener(this);
            Numbers[i].setFocusable(false);
        }
        dot.addActionListener(this);
        // calci.add(J0);
        // calci.add(Answer,BorderLayout.NORTH);
        // calci.add(Grid,BorderLayout.CENTER);
        calci.setVisible(true);

    }
    public static void main(String[] args) {
        Calculator c1=new Calculator();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        char operator=e.getActionCommand().charAt(0);
        for(int i=0;i<10;i++){
            if(e.getSource()==Numbers[i]){
                Answer.setText(Answer.getText().concat(String.valueOf(i)));
            }
        }
        if(operator=='.'){
            Answer.setText(Answer.getText().concat("."));
        }
        switch(operator){
            case '+':
            case '-':
            case '/':
            case 'x':
            getFirstNumber();
            OP=operator;
            break;
            case '=':
            getSecondNumber();
            showTotal();
            break;
            case 'C':
            clear();
            break;
        }


    }
    private void clear() {
        firstNum=0;
        secondNum=0;
        Answer.setText(null);

    }
    private void showTotal() {
        switch(OP){
            case '+':
            Answer.setText(String.valueOf(firstNum+secondNum));
            break;
            case '-':
            Answer.setText(String.valueOf(firstNum-secondNum));
            break;
            case '/':
            Answer.setText(String.valueOf(firstNum/secondNum));
            break;
            case 'x':
            Answer.setText(String.valueOf(firstNum*secondNum));
            break;
        }
    }
    private void getSecondNumber() {
        secondNum=Float.valueOf(Answer.getText());
        Answer.setText(null);
    }
    private void getFirstNumber() {
        firstNum=Float.valueOf(Answer.getText());
        Answer.setText(null);
    }
}   