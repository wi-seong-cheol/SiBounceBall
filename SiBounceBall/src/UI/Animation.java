package UI;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Objects.*;
import Scenes.*;
import OptimizedSBB.SBBMain;

import java.awt.Color;
import java.awt.Font;


public class Animation extends SBBMain{
//	private static Canvas c;
//	private static GraphicsEnvironment ge;
//	private static GraphicsDevice gd;
//	private static GraphicsConfiguration gc;
//	private static BufferedImage buffer;
//	private static Graphics graphics;
//	private static Graphics2D g2d;
//	private static AffineTransform at = new AffineTransform();

	public Animation() {}
	public void runAnimation() {
		// Set up some variables.
		int fps = 0;
		int frames = 0;
		long totalTime = 0;
		long curTime = System.currentTimeMillis();
		long lastTime = curTime;
		// Start the loop.
		while (isRunning) {
			try {
				// Calculations for FPS.
				lastTime = curTime;
				curTime = System.currentTimeMillis();
				totalTime += curTime - lastTime;
				if (totalTime > 1000) {
					totalTime -= 1000;
					fps = frames;
					frames = 0;
				}
				++frames;
				// clear back buffer...
				g2d = buffer.createGraphics();
				//g2d.fillRect(0, 0, X, Y);
				if(sceneNum==1 || sceneNum==4 || sceneNum==7) g2d.drawImage(background.get(0), 0,0, null);
				else if(sceneNum==2 || sceneNum==5 || sceneNum==6) g2d.drawImage(background.get(1), 0,0, null);
				else if(sceneNum==3 || sceneNum==8) g2d.drawImage(background.get(2), 0,0, null);
				else g2d.drawImage(background.get(0), 0,0, null);

				// Draw entities
				for (int i = 0; i < MakeGameComponents.living.size(); i++) {
					try {
						at.translate(MakeGameComponents.living.get(i).getX(), MakeGameComponents.living.get(i).getY());
						Spawn s = MakeGameComponents.living.get(i);
						if(s instanceof SpawnBall) { 
							//g2d.drawImage(sibaball,(int) (s.getX() ),(int) (s.getY() ), c);
							g2d.drawImage(sibaball2,(int) (s.getX() )+4,(int) (s.getY() ), c);
						}
						else if(s instanceof SpawnWall){
							g2d.drawImage(wallImage.get(s.num-1),(int) (s.getX() ),(int) (s.getY() ), c);

						}
						else if(s instanceof SpawnThorn) {
							g2d.drawImage(thorn.get(s.num-1),(int) (s.getX() ),(int) (s.getY() ), c);
						}
						else if(s instanceof SpawnJump) {
							g2d.drawImage(jump,(int) (s.getX() ),(int) (s.getY() ), c);
						}
						else if(s instanceof SpawnElectricity) {
							g2d.drawImage(electricity,(int) (s.getX() ),(int) (s.getY() ), c);
						}
						else if(s instanceof SpawnItem1) {
							g2d.drawImage(item1,(int) (s.getX() ),(int) (s.getY() ), c);
						}
						else if(s instanceof SpawnItem2) {
							g2d.drawImage(item2,(int) (s.getX() ),(int) (s.getY() ), c);
						}
						else if(s instanceof SpawnStar) {
							g2d.drawImage(star,(int) (s.getX() ),(int) (s.getY() ), c);
						}
						else if(s instanceof SpawnBreakable) {
							g2d.drawImage(breakable,(int) (s.getX() ),(int) (s.getY() ), c);
						}
						else if(s instanceof SpawnMoveL) {
							g2d.drawImage(moveL,(int) (s.getX() ),(int) (s.getY() ), c);
						}
						else if(s instanceof SpawnMoveR) {
							g2d.drawImage(moveR,(int) (s.getX() ),(int) (s.getY() ), c);
						}
					}catch (Exception e) {
						continue;
					}
					/* <type>
					 * Ball
					 * Wall
					 * Jump
					 * Thorn
					 * Item1 : 대쉬
					 * Item2 : 점프
					 * Star
					 * Breakable
					 * MoveL
					 * MoveR
					 */    
				}
				
				// display frames per second...
				g2d.setFont(new Font("Courier New", Font.PLAIN, 12));
				g2d.setColor(Color.GREEN);
				g2d.drawString(String.format("FPS: %s", fps), 20, 20);
				
				// Blit image and flip...
				graphics = b.getDrawGraphics();
				graphics.drawImage(buffer, 0, 0, null);
				if (!b.contentsLost()) b.show();
				
				// Let the OS have a little time...
				Thread.sleep(15);
			} catch (InterruptedException e) {
			} finally {
				// release resources
				if (graphics != null) graphics.dispose();
				if (g2d != null) g2d.dispose();
			}
		}
	}
}
