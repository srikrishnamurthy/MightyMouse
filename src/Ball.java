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
import javax.swing.*;


public class Ball extends GameObject {
	final static int DIAMETER = 55;
	public double gravity =0.8;
	private static double holder;//score before
	private static double postMove=0;//score after
    private ImageIcon mouse, mouser, mousel;
	public Ball(int x, int y, int velocityX, int velocityY) {
		super(x, y, 0, velocityY, DIAMETER, DIAMETER);
      mousel = new ImageIcon(getClass().getResource("mouse.png"));
      mouser = new ImageIcon(getClass().getResource("mouse1.png"));
      mouse = mousel;
	}
	public void accelerate() {
		if (x < 0)
			x=rightBound;
		else if (x > rightBound)
			x=0;
	}

	// Bounce the ball, if necessary
	public boolean bounce(Intersection i) {
		switch (i) {
		case NONE: break;
		case UP: velocityY = -4; gravity=0.8; return true;
		
		//added for jar file
		default:
			break; 
		}
		return false;
	}
	public void move(){
		setHolder(this.y);
		super.move();	
		this.y+=this.velocityY+gravity;
		setPostMove(this.y);
	}
   public void right(){
      mouse = mouser;
      }
   public void left(){
      mouse = mousel;
      }
	public void draw(Graphics g){
		g.drawImage(mouse.getImage(), x, y, 60, 60, null);;
	}
	public static double getPostMove() {
		return postMove;
	}
	public static void setPostMove(double postMove) {
		Ball.postMove = postMove;
	}
	static double getHolder() {
		return holder;
	}
	public static void setHolder(double holder) {
		Ball.holder = holder;
	}
}
