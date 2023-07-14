


/**
 *
 *Write a Java GUI program using Swing. As shown in the screen capture below, a circle
and a cross is drawn in a panel. The fill color of the circle is controlled by the radio
buttons on the right side. When you click on the panel with the mouse, the figure will
move to the new location centered at the mouse pointer. The drawing object can also be
moved by the direction buttons on the right. Show your name in the title of the frame.
*
* 
* @author Ikaia Melton
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Assignment  extends JFrame implements ActionListener, MouseListener {

	 
	private static final long serialVersionUID = 1L;
	
	//Declaration of "Rectangular" Control Buttons
	private JButton right;
	private JButton left;
	private JButton up;
	private JButton down;
	private ButtonGroup group; 
	//Declaration of "Circle" Control Buttons
	private JRadioButton red;   
	private JRadioButton green; 
	private JRadioButton blue;  
	 
	//Declaration of Instance Variables to Track X and Y coordinates
	private int xPosition;
	private int yPosition;
	
	//Create Constructor
	public Assignment () {
		super("Ikaia Melton"); //Title the Frame
		
		//Setting Default Value for X and Y Coordinates
		xPosition = yPosition = 250;
		
		//Set Size of the Frame To Your Preferences
		setSize(600, 600); 
		
		//Set Layout as (Null) so Layout is by default
		setLayout(null);
		
		//Have Exit Button After Clicking on "X" button
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		//Initialize All Control Buttons With "Text"
		right = new JButton(" > ");
		left = new JButton(" < ");
		up = new JButton(" ^ ");
		down = new JButton(" v ");
		//Initialize All Control Buttons With "Text"----Group
		group = new ButtonGroup();
		red = new JRadioButton("Red",true);
		green = new JRadioButton("Green",true);
		blue = new JRadioButton("Blue",true);
		
		//Add RadioButtons into a Button Group thats "Unselected" In the Beginning 
		group.add(red);
		group.add(green);
		group.add(blue);
		
		//Set Bounds (Approximate Location) to the RadioButton Controls 
		red.setBounds(500,80,100,30);
		green.setBounds(500,120,100,30);
		blue.setBounds(500,160,100,30);
		//Set Bounds (Approximate Location) to the Button Controls 
		left.setBounds(480,220,100,30);
		right.setBounds(480,250,100,30);
		up.setBounds(480,280,100,30);
		down.setBounds(480,310,100,30);
		
		//Add RadioButton Controls to the Frame
		add(red);
		add(green);
		add(blue);
		//Add Button Controls to the Frame
		add(left);
		add(right);
		add(up);
		add(down);
				
		//Add ActionListener to RadioButton Controls
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		//Add ActionListener to Button Controls
		left.addActionListener(this);
		right.addActionListener(this);
		up.addActionListener(this);
		down.addActionListener(this);
		
		//Add MouseListener to the Frame
		addMouseListener(this);
		
		//Make the Frame Visible
		setVisible(true);
		
	}
	@Override
	public void paint(Graphics paint) {
		//Create super.paint() Method
		super.paint(paint); 
		
		//If "Red Button" is Selected
		if(red.isSelected()) {
			//Change Color Red
			paint.setColor(Color.RED);
		}else
			//If "Green Button" is Selected
			if(green.isSelected()){
				//Change Color Green
				paint.setColor(Color.GREEN);
			}else
				//If "Blue Button" is Selected
				if(blue.isSelected()) {
					//Change Color Blue
					paint.setColor(Color.BLUE);
				}
		
		//Draw Oval
		paint.fillOval(xPosition-30, yPosition-30, 60, 60);
		
		//Draw Lines To Make Sure Circle Position
		paint.drawLine(xPosition, yPosition-60, xPosition, yPosition+60);
		paint.drawLine(xPosition-60, yPosition, xPosition+60, yPosition);
		//Color Lines Black
		paint.setColor(Color.BLACK);
			
	}
	@Override
	public void actionPerformed(ActionEvent action) {
		//If "Right" Button is Clicked
		if(action.getSource()==right) {
			xPosition+=5;
		}else
			//If "Left" Button is Clicked
			if(action.getSource()==left) {
				xPosition-=5;
			}else
				//If "Up" Button is Clicked
				if(action.getSource()==up) {
					yPosition-=5;
				}else
					//If "Down" Button is Clicked
					if(action.getSource()==down) {
						yPosition+=5;
					}
		 //Call The paint() method
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Mouse Clicked Then Get X and Y Coordinates
		xPosition=e.getX();
		yPosition=e.getY();
	}
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) { }
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	public static void main(String[] args) {
		new Assignment(); // Object of Project1 class
	}
}