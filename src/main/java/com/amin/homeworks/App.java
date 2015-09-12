package com.amin.homeworks;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.*;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

public class App extends JFrame  implements GLEventListener, KeyListener {
	/**
	 * 
	 */
	static enum SHAPES {LINE, CIRCLE, SQUIRE};
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "OPENGL";
	private SHAPES currentShape = SHAPES.SQUIRE;
	// #########################
	{
		initComponents();
	}
	// #########################
	public App(){
		super(WINDOW_TITLE);
	}
	private void initComponents(){
		initGlProfile();
		initCap();
		initCanvas();
		initWindow();
		drawLine();
		setSize(getContentPane().getPreferredSize());
	}
	private void initWindow(){
//		window 	= new JFrame(WINDOW_TITLE);
		setVisible(true);
		addKeyListener(this);
	}
	// <><><><><><><><><><><><><><><><><><><><><><><><>
//	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		drawShape(gl, currentShape);
	}
//	@Override
	public void dispose(GLAutoDrawable arg0) {}
//	@Override
	public void init(GLAutoDrawable arg0) {}
//	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,int arg4) {}
	public void drawLine(){
		
	}
	private void drawShape(GL2 gl, SHAPES shape){
		switch(shape) {
		case LINE : {
			gl.glBegin (GL2.GL_LINES);//static field
			gl.glVertex3f(0.50f,-0.50f,0);
			gl.glVertex3f(-0.50f,0.50f,0);
			gl.glEnd();break;}
		case SQUIRE : {//edge1
			gl.glBegin( GL2.GL_LINES );
		gl.glVertex3f( 0.0f,0.75f,0 );
		gl.glVertex3f( -0.75f,0f,0 );
		gl.glEnd();
		//edge2
		gl.glBegin( GL2.GL_LINES );
		gl.glVertex3f( -0.75f,0f,0 );
		gl.glVertex3f( 0f,-0.75f, 0 );
		gl.glEnd();
		//edge3
		gl.glBegin( GL2.GL_LINES );
		gl.glVertex3f( 0f,-0.75f, 0 );
		gl.glVertex3f( 0.75f,0f, 0 );
		gl.glEnd();
		//edge4
		gl.glBegin( GL2.GL_LINES );
		gl.glVertex3f( 0.75f,0f, 0 );
		gl.glVertex3f( 0.0f,0.75f,0 );
		gl.glEnd();
		gl.glFlush();break;}
		case CIRCLE:{}
		}
	}
	private void initGlProfile(){
		 profile = GLProfile.get(GLProfile.GL2);
	}
	private void initCap(){
		capabilities = new GLCapabilities( profile );
	}
	private void initCanvas(){
		glcanvas = new GLCanvas( capabilities );
		glcanvas.addGLEventListener(this);
		glcanvas.setSize(400, 400);
		getContentPane().add(glcanvas);
	}
	public static void main(String[] args) {
		new App();
	}//end of main
	private GLProfile profile;
	private GLCanvas glcanvas;
	private GLCapabilities capabilities;
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		displayInfo(e, "KEY TYPED");
		char[] chars = {'i', 'I', 'o', 'O'};
		if(e.getKeyChar() == chars[0]||e.getKeyChar() == chars[1]){
			System.out.println("Welcome mr I <<.>><<.>>");
//			glcanvas.getGL()
			currentShape = SHAPES.LINE;
			display(glcanvas);
			glcanvas.repaint();
		}
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		displayInfo(e, "KEY PRESSED");
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
//		displayInfo(e, "KEY RELEASED");
	}
	 private void displayInfo(KeyEvent e, String keyStatus){
	        
	        //You should only rely on the key char if the event
	        //is a key typed event.
	        int id = e.getID();
	        String keyString;
	        if (id == KeyEvent.KEY_TYPED) {
	            char c = e.getKeyChar();
	            keyString = "key character = '" + c + "'";
	        } else {
	            int keyCode = e.getKeyCode();
	            keyString = "key code = " + keyCode
	                    + " ("
	                    + KeyEvent.getKeyText(keyCode)
	                    + ")";
	        }
	        System.out.println("######"+keyString);
	        int modifiersEx = e.getModifiersEx();
	        String modString = "extended modifiers = " + modifiersEx;
	        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
	        if (tmpString.length() > 0) {
	            modString += " (" + tmpString + ")";
	        } else {
	            modString += " (no extended modifiers)";
	        }
	        
	        String actionString = "action key? ";
	        if (e.isActionKey()) {
	            actionString += "YES";
	        } else {
	            actionString += "NO";
	        }
	        
	        String locationString = "key location: ";
	        int location = e.getKeyLocation();
	        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
	            locationString += "standard";
	        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
	            locationString += "left";
	        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
	            locationString += "right";
	        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
	            locationString += "numpad";
	        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
	            locationString += "unknown";
	        }
	        
	    }

}