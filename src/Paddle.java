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
public class Paddle extends GameObject {
	final static int HEIGHT = 30;
	private static int WIDTH = 100;
    private ImageIcon platform;
    private int a;
	public Paddle(int courtwidth, int courtheight) {
		super((courtwidth - getWIDTH()) / 2, courtheight - HEIGHT - 20, 0, 0, getWIDTH(), HEIGHT);
	    a = (int)(Math.random() * 10 + 1);
      if(a==7){
         platform = new ImageIcon(getClass().getResource("blue.jpg.png"));
      }
      else{
         platform = new ImageIcon(getClass().getResource("cheese.jpg"));
      }
   }  
	public void accelerate() {
		if(x<0){
			velocityX=2;
		}
		if(x> rightBound){
			velocityX=-2;
		}
	}
	public void draw(Graphics g) {
		g.drawImage(platform.getImage(), x, y, getWIDTH(), 30, null);
	}
	public int getA(){
      return a;
      }
	public void setWidth(int x){
		Paddle.setWIDTH(x);
	}
	public void move(){
		super.move();	
	}
	public static int getWIDTH() {
		return WIDTH;
	}
	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}
}
