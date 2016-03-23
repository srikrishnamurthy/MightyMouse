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
import java.awt.Graphics;

public class PowerUp extends GameObject {
	
	final static int DIAMETER = 30;

	public PowerUp(int x, int y, int velocityX, int velocityY) {
		super(x, y, 0, velocityY, DIAMETER, DIAMETER);
	}

	public void accelerate() {

	}

   public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, DIAMETER, DIAMETER);
		g.setColor(Color.MAGENTA);
      g.setFont(new Font("Serif", Font.BOLD, 20));
		g.drawString("P", x+11, y+18);
		
	}
	
	public void move(){
		super.move();
	}

}
