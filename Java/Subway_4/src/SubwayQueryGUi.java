import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

//GUI is used for subway query only
public class SubwayQueryGUi extends JFrame{
    private JPanel welcomePane;
    private JPanel queryPane;
    private JPanel resultPane;
    private JPanel backPane;
    public  Calculation returnObj;
    public String start;
    public String end;    
    public Result r;

    private JButton uploadButton;
    private JButton entryW;
    private JButton query;
    private JButton return_query;
    private JTextField startPoint;
    private JTextField endPoint;
    private JLabel welcomeLabel;
    private JLabel hintLabel;
    private JLabel resultLabel;
    private JLabel resultLabel2;
    private CardLayout card;
    public  JButton r1 = new JButton(); 
    //also need query result --strings and num of results
    //another panels also needed
    
    public String queryLine;

    public SubwayQueryGUi (){
         //CardLayout Management
         card = new CardLayout(5,5);
         backPane = new JPanel(card);
         backPane.setLayout(card);

         //initial JPanels
         welcomePane = new JPanel();
         queryPane = new JPanel();
         resultPane = new JPanel();
         

         //return query obj
         returnObj = new Calculation();
         //returnObj---initial in the query pane.
         
         //initial result 
         r = new Result();
        // resultLabel2 = new JLabel("");
        

         //initial welcomePane
         welcomeLabel = new JLabel ("Welcome To Subway Query System.");
         welcomePane.setLayout(new BorderLayout());
         welcomePane.add(welcomeLabel,BorderLayout.CENTER);
         entryW = new JButton("Start Query");
         welcomePane.add(entryW,BorderLayout.SOUTH);
         backPane.add(welcomePane,"welcomePane");
         this.getContentPane().add(backPane);

         //initial queryPane
         hintLabel = new JLabel("Please enter start point and end point.");
         queryPane.setLayout(new BorderLayout());
         queryPane.add(hintLabel,BorderLayout.NORTH);
         query = new JButton();
         query.setText("query");
         queryPane.add(query,BorderLayout.SOUTH);

         JPanel ioPane = new JPanel();//CENTER pane inside the queryPane
         ioPane.setLayout(new GridLayout(2,2));
         startPoint = new JTextField("",5);
         endPoint = new JTextField("",5);
         //add components into center panel
         ioPane.add(new JLabel("Start Point:"));
         ioPane.add(startPoint);
         ioPane.add(new JLabel("End Point:"));
         ioPane.add(endPoint);
         queryPane.add(ioPane,BorderLayout.CENTER);
         backPane.add(queryPane,"queryPane");
         
         //query button ActionListener
         query.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	start = startPoint.getText();
            	end = endPoint.getText();
            	
            	//r.setLine(returnObj.getLine());
            	returnObj.findShortPath();
            	//System.out.println(r.getLine());
            	//r.setLine("NIHAO");
            	//resultLabel2.setText(r.getLine());
            	//System.out.println(queryLine);
              card.show(backPane,"resultPane");
            }
         });


         //initial resultPane
         resultLabel = new JLabel();
         resultLabel.setText("Recommand Line is as following:");
         resultPane.setLayout(new BorderLayout());
         //System.out.println("Scuss");
        //System.out.println(r.getLine());
         return_query = new JButton("Query Again");
        //queryLine = r.getLine();
         //System.out.println(queryLine);
         //resultLabel2.setText();
         String s ="";
         try{
        	 File myFile = new File("..\\route.txt");
        	 FileReader fr = new  FileReader(myFile);
        	 BufferedReader br = new BufferedReader(fr);
        	 s = br.readLine();
        	 r1.setText(s);
        //	 resultLabel2.setText("11111");
        	// resultLabel2.setFont(new Font(s,Font.BOLD,30));
        	 br.close();
        	 
        	 
         }catch(IOException e){
        	 e.printStackTrace();
        	 
         }
       
         //System.out.print(r.getLine());
         //resultPane.add(resultLabel2,BorderLayout.CENTER);
         resultPane.add(r1,BorderLayout.CENTER);
         resultPane.add(resultLabel,BorderLayout.NORTH);
        
         resultPane.add(return_query,BorderLayout.SOUTH);
         backPane.add(resultPane,"resultPane");

        //get input info
        startPoint.addKeyListener(new KeyListener(){
        	public void keyReleased(KeyEvent e){
          	  if(e.getKeyCode()==e.VK_SPACE)
          	  start = startPoint.getText();
            }
            public void keyPressed(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        });
        endPoint.addKeyListener(new KeyListener(){
          public void keyReleased(KeyEvent e){
        	  if(e.getKeyCode()==e.VK_SPACE)
        	  end = endPoint.getText();
          }
          public void keyPressed(KeyEvent e){}
          public void keyTyped(KeyEvent e){}
        });


         //result_query pan
         return_query.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              //returnObj = new Calculation(start,end);
              //returnObj.setInfo(start,end);
            	
              card.show(backPane,"queryPane");
            }
         });

         //welcomePane ActionListener
         entryW.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              card.show(backPane,"queryPane");
            }
         });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Subway Query System");
        this.setSize(1000,500);
        this.setVisible(true);
       
     
    }


    public static void main (String[] args){
        new SubwayQueryGUi();
         

    }
}
