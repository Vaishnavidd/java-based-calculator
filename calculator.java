
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class calculator extends JFrame implements ActionListener
{
  JTextField result;
  boolean cleardisplay=false;
  String operator= "=";
  double argument=0;
  public static void main(String[] args)
  {
	  calculator c=new calculator();
	  c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }//end main
  public calculator()
  {
	  this.setTitle("Calculator");

     setLayout(new BorderLayout());
     result=new JTextField("0");
     add(result,BorderLayout.NORTH);
     JPanel p=new JPanel();
     p.setLayout(new GridLayout(5,4));
     String s="789/456*123-0.=+";
     int i;
     for(i=0;i<s.length();i++)
     {
        String item=s.substring(i,i+1);
        createbuttons(p,item);
     }
       createbuttons(p,"sin");
       createbuttons(p,"cos");
       createbuttons(p,"tan");
       createbuttons(p,"sqrt");
     add(p,BorderLayout.CENTER);
	 this.pack();
	 this.setVisible(true);
  }//end init
  public void createbuttons(JPanel c,String t)
  {
    JButton b=new JButton(t);
    c.add(b);
    b.addActionListener(this);
  } //end createbuttons
  public void actionPerformed(ActionEvent e)
  {
   char ch;
   String s=e.getActionCommand();
   ch=s.charAt(0);
   if(ch>='0' &&  ch<='9' || ch=='.')
   {
      if(cleardisplay==true)
      {
        result.setText(s);
      }
     else
     {
        String temp=result.getText();
        result.setText(temp+s);
     } //end inner if
     cleardisplay=false;
  }
  else
  {
         calculate(Double.parseDouble(result.getText()));
         operator=s;
         cleardisplay=true;
  } //end if
} //end actionPerformed
 public void calculate(double n)
 {
   if(operator.equals("+"))
   {
     argument=argument+n;
     //showStatus(""+argument);
   }
   else if(operator.equals("-"))
   {
     argument=argument-n;
   }
   else if(operator.equals("*"))
   {
     argument=argument*n;
   }
   else if(operator.equals("/"))
   {
     argument=argument/n;
   }
   else if(operator.equals("sin"))
   {
     argument=Math.sin(argument*3.14/180);
   }
   else if(operator.equals("cos"))
   {
     argument=Math.cos(argument*3.14/180);
   }
   else if(operator.equals("tan"))
   {
     argument=Math.tan(argument*3.14/180);
   }
   else if(operator.equals("sqrt"))
   {
     argument=Math.sqrt(argument);
   }
   else if(operator.equals("="))
   {
     argument=n;
   }
     result.setText(""+argument);
 } //end calculate

 }//end class




