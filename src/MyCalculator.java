import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalculator extends JFrame{
    private JTextField textField; //Input text box
    private String input;//Result
    /**
     * Construction method: initialization
     */
    public MyCalculator() {
        input="";
        JPanel panel=new JPanel();//Define panels for storing component content
        textField=new JTextField(30);//Define a text box with a length of 30.
        textField.setEditable(false);//Text box prohibits editing.
        textField.setHorizontalAlignment(JTextField.LEFT);//The alignment of text boxes is left aligned.
        textField.setPreferredSize(new Dimension(200,30));//Set the initial size of the component.
 this.add(textField, BorderLayout.NORTH);

        //Character arrays are used to store numbers and symbols that appear on buttons on the interface.
        String[] name={"7","8","9","+","4","5","6","-","1","2","3","*","0","C","=","/"};

        //Set the layout of this panel as a grid layout, with four rows and four columns,
        //with row spacing and column spacing of 1.
        panel.setLayout(new GridLayout(4,4,1,1));

        for(int i=0;i<name.length;i++) {//The following is added to the loop:
            JButton button=new JButton(name[i]);//Button generation.
            button.addActionListener(new MyActionListener());//Set the time monitor for the button.
            panel.add(button);//Add the button to the panel
        }
        //Add the panel to this JFrame, layout as boundary layout, location as center.
        this.add(panel,BorderLayout.CENTER);
    }

    
    /**
     * Core algorithm: the hardest part.
     * Here, we need to use stack to complete the calculation of expressions. Firstly, we divide the string into string arrays. 
     * By the definition of infix, we know that the odd digits of the array are operators (starting from the 0th digit) and 
     * even digits are operands. Therefore, we can use even numbers as operands to stack. When we meet +(-) operators, 
     * we will enter the next number in the form of positive (negative) into the stack. When we meet * or / operators, 
     * we will get the top of the stack. Element out of the stack is calculated with the element after the array, and the 
     * result is re-entered into the stack until the last element of the array.
     * @param input 
     * @return 
     * @throws Exception
     */
    private String calculate(String input) throws Exception{
        String[] comput=input.split(" ");//Use spaces as separators.
        Stack<Double> stack=new Stack<>();//Initialization stack (Java comes with it).
        Double m=Double.parseDouble(comput[0]);//Use the delimiter to get each digit and store it in the array.
        stack.push(m); //The first operand enters the stack.

        for(int i=1; i<comput.length; i++) {
            if(i%2==1) {
                if(comput[i].equals("+"))
                    stack.push(Double.parseDouble(comput[i+1]));
                if(comput[i].equals("-"))
                    stack.push(-Double.parseDouble(comput[i+1]));
                if(comput[i].equals("*")) {
                    double d=stack.peek();//Take the top element of the stack.
                    stack.pop();//Multiply the previous number out of the stack before entering the stack.
                    stack.push(d*Double.parseDouble(comput[i+1]));
                }
                if(comput[i].equals("/")) {
                    double help=Double.parseDouble(comput[i+1]);
                    if(help==0) {
                        throw new Exception("The dividend cannot be 0.");
                    }
                    double d=stack.peek();
                    stack.pop();//Divide the previous number out of the stack and then put it on the stack.
                    stack.push(d/help);
                }
            }
        }

        double d=0d; //Initialize variable d to 0 of double type.

        while(!stack.isEmpty()) {        
            d+=stack.peek();//The sum of all the above.   
            stack.pop();//out of the stack.
        }

        String result = String.valueOf(d);//Use strings to get results.
        return result;
    }
    
    /**
     * Use internal classes to implement button responses.
     * @author zhuxiaojing
     *
     */
    class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {//Receive listening for operation events.
            boolean cnt=false;//Used to determine whether to press =.
            String action=e.getActionCommand();//Gets the string on the button.
           
            if(action.equals("+")||action.equals("-")||action.equals("*")||action.equals("/")) {
                input+=" "+action+" ";
            }
            else if(action.equals("C")) {//Clear the input.
                input="";
            }
            else if(action.equals("=")) {//Press the =.
                try {
                    input+="="+calculate(input);//Call the above calculation function.
                } 
                catch (Exception e1) {
                    input = e1.getMessage();
                }
                textField.setText(input);//Display the input in the text box.
                input="";
                cnt=true;//Press "=" to display the result.
            }
            else {
                input+=action; //Press the numbers.
            }

            //If you do not press the "=" button CNT will always be false, 
            //you can ensure that the input numbers and operation keys are displayed.
            if(cnt==false) {
                textField.setText(input);//The original string remains unchanged without pressing "=".
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new MyCalculator();//Initialization is called to generate the calculator window.
        f.setTitle("My calculator");//Set the title bar.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//End the process by clicking the Close button.
        f.setBounds(400, 200, 500, 300);//Window size.
        f.setVisible(true);//No hidden display.
    }
}
