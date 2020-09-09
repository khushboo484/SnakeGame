package SnakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener , ActionListener{
	
	private int score = 0;
	private boolean play = false;
	private Timer timer;
	private int delay = 10;
	
	private int snakeposX = 200;
	private int snakeposY = 300;
	private int snakedirX = -3;
	private int snakedirY = -1;
	
	private int foodposX = 250;
	private int foodposY = 500;
	
	private int width = 100;
	private int height = 20;
	
	Random random = new Random();
	
	public Game()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	 
	public void paint(Graphics g)
	{
		//border 
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);
		
		//background
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		

		//snake
		g.setColor(Color.blue);
		g.fillRect(snakeposX, snakeposY, width ,height);
		
		
		//food
		g.setColor(Color.green);
		g.fillOval(foodposX, foodposY, 10, 10);
		
		//score
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,30));
		
		//heading
		g.setColor(Color.ORANGE);
		g.setFont(new Font("serif", Font.BOLD, 50));
		g.drawString(" SNAKE GAME ",100 , 60);
		
		//exit
		if(score >=30)
		{
			play = false;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString(" Your Scores: "+score, 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart", 230, 350);
		}
		
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play)
		{
			if(new Rectangle(snakeposX, snakeposY, 20 ,100).intersects(new Rectangle(foodposX, foodposY,10,10)))
			{
				score++;
				foodposX = random.nextInt(500);
				foodposY = random.nextInt(500);
			}
		}
		repaint();
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(snakeposX < 30)
				snakeposX = 780;
			moveleft();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(snakeposX > 750)
				snakeposX = 25;
			moveright();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(snakeposY < 80)
				snakeposY = 550;
			moveforward();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(snakeposY > 520)
				snakeposY = 70;
			movebackward();
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			if(!play)
			{
				play = true;
				score = 0;
				snakeposX = 200;
				snakeposY = 300;
				snakedirX = -3;
				snakedirY = -1;
				
				foodposX = 300;
				foodposY = 600;
				repaint();
			}
		}
		
	}

	private void moveright() {
		play = true;	
		snakeposX += 5;
		width = 100;
		height = 20;
	}

	private void moveforward() {
		play = true;
		snakeposY -= 5;
		width = 20;
		height = 100;
	}

	private void movebackward() {
		play = true;
		snakeposY += 5;
		width = 20;
		height = 100;
	}

	private void moveleft() {
		play = true;
		snakeposX -= 5;
		width = 100;
		height = 20;
	}

}
