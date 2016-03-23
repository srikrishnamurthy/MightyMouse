/*
 * Copyright 2015 Srinidhi Krishnamurthy
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class PongCourt extends JComponent {
	//it the compiler again
	private static final long serialVersionUID = 1L;
	//
	static Ball ball;
	//
	
	private List<Paddle> paddleList;
	private List<PowerUp> pUpList;
	private Random rand= new Random();
	private int interval = 20; 
	private Timer timer;       
	final int COURTWIDTH  = 600;
	final int COURTHEIGHT = 800;
	private boolean ticker=false; 
   private ImageIcon background, cat, cheese;
	public int score;

	final int BALL_VEL  = 6;  


	public PongCourt() {
		setFocusable(true);
      background = new ImageIcon(getClass().getResource("kitchen.jpg"));
      cat = new ImageIcon(getClass().getResource("Picture1.png"));
      cheese = new ImageIcon(getClass().getResource("Cheese2.jpg"));

		timer = new Timer(interval, new ActionListener() {
			public void actionPerformed(ActionEvent e) {tick(); }});
		timer.start(); 

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT){
					ball.left();
               ball.setVelocity(-BALL_VEL, ball.velocityY);
               }
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					ball.setVelocity(BALL_VEL, ball.velocityY);
               ball.right();
               }
				else if (e.getKeyCode() == KeyEvent.VK_R)
					reset();
			}

			public void keyReleased(KeyEvent e) {
				ball.setVelocity(0, ball.velocityY);
			}
		});
	}

	public void reset() {
		paddleList= new CopyOnWriteArrayList<Paddle>();
		pUpList=new CopyOnWriteArrayList<PowerUp>();
		ball = new Ball(200, 400, 0, -5);
		int y=600;
		for(int x=0;x<8;x++){
			paddleList.add(new Paddle(COURTWIDTH+525 - rand.nextInt(1000), y));			
         y-=90;
		}
		requestFocusInWindow();
		score=0;
		Paddle.setWIDTH(75);

	}
	public void stopTimer(){
		timer.stop();
	}
	public void startTimer(){
		timer.start();
	}
	public void restartTimer(){
		timer.restart();
	}
	
	void tick() {
		if((score%8000==0 && score>0) || score==2000){
			pUpList.add(new PowerUp(rand.nextInt(600),0, 0, 2));
		}
		
		ball.setBounds(getWidth(), getHeight());
		ball.move();

		for(Paddle p:paddleList){
			ball.bounce(p.intersects(ball));
			p.setBounds(getWidth(), getHeight());
			p.move();
		}
		repaint(); 
		
		if(ticker==false)
			ball.gravity+=0.3;	
		
		GamePanel.scores.setText("Score " + score);

	}


	@SuppressWarnings("static-access")
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(),0,0,600,600, null);
      g.drawImage(cheese.getImage(),0,600,800,200, null);
		ball.draw(g);
		
		for(PowerUp pU:pUpList){
			pU.draw(g);
			pU.y+=4;
			if(ball.intersects(pU)==Intersection.UP ||ball.intersects(pU)==Intersection.DOWN
					|| ball.intersects(pU)==Intersection.RIGHT || ball.intersects(pU)==Intersection.LEFT){
				ticker=true;
				ball.gravity=6;
				pUpList.remove(pU);
			}
		}

		if(ball.y<10){
			ticker=false;
			ball.gravity=10;
		}

		if(ball.y> COURTHEIGHT){
			for(Paddle p: paddleList)
				paddleList.remove(p);
			g.setFont(new Font("Verdana", Font.PLAIN, 20));
			g.drawString("Your Final Score: " + score, COURTWIDTH/2-110, 15);
			timer.stop();
		}

		if(ball.getPostMove()<ball.getHolder() ){
			for(Paddle p: paddleList){
				p.y+=11;
				score+=1;
				if(score>5000){
					p.setWidth(75);
				}

				if(score>15000){
					p.setWidth(50);
				}

				if(score>25000){
					p.setWidth(35);
				}
				
				if(score>40000){
					p.setWidth(20);
				}

				if(p.y>COURTHEIGHT-210){
					paddleList.remove(p);
					paddleList.add(new Paddle(rand.nextInt(1150), -10));
					if(rand.nextInt(8)==0){
						if(rand.nextInt(2)==0)
							paddleList.get(paddleList.size()-1).setVelocity(2, 0);
						else
							paddleList.get(paddleList.size()-1).setVelocity(-2, 0);
					}
				}
			}				
		}	

		for(Paddle p: paddleList){
			p.draw(g);
		}
         g.drawImage(cat.getImage(),-38,550,700,275,null);
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(COURTWIDTH, COURTHEIGHT);
	}
}
