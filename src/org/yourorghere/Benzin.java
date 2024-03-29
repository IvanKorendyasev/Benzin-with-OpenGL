package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;



/**
 * Benzin.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Benzin implements GLEventListener {

    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Benzin());
        frame.add(canvas);
        frame.setSize(640, 640);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        /*if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();*/
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        //gl.glLoadIdentity();
        // Reset the current matrix to the "identity"
        gl.glRotatef(0.2f,1,1,1);
        GLU glu = new GLU();
        
        GLUquadric q;
        q = glu.gluNewQuadric();
        
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK,GL.GL_FILL);
        
        gl.glPushMatrix();        
        gl.glTranslatef(0.0f,0.5f,0.0f);
        gl.glColor3f(0,1,0);
        glu.gluSphere(q, 0.1, 24, 24); //������� �����
            gl.glPushMatrix();
            gl.glRotatef(90, 1, 0, 0);
            gl.glRotatef(-60, 0, 1, 0);
            gl.glColor3f(0.8f,0.8f,0.8f);
            glu.gluCylinder(q, 0.01, 0.01, 0.5, 24, 1); //����� �������� �������
            gl.glPopMatrix();
            gl.glPushMatrix();
            gl.glRotatef(90, 1, 0, 0);
            gl.glRotatef(60, 0, 1, 0);
            glu.gluCylinder(q, 0.01, 0.01, 0.5, 24, 1);
            gl.glPopMatrix();
        gl.glTranslatef(0.0f,0.3f,0.0f);
        gl.glColor3f(1,0,0);
        glu.gluSphere(q, 0.03, 24, 24); //��������� �����
        gl.glRotatef(90, 1, 0, 0);
        gl.glColor3f(0.8f,0.8f,0.8f);
        glu.gluCylinder(q, 0.01, 0.01, 0.3, 24, 1); //� ��������� �����
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.0f,-0.5f,0.0f);
        gl.glColor3f(0,1,0);
        glu.gluSphere(q, 0.1, 24, 24);
            gl.glPushMatrix();
            gl.glRotatef(-90, 1, 0, 0);
            gl.glRotatef(60, 0, 1, 0);
            gl.glColor3f(0.8f,0.8f,0.8f);
            glu.gluCylinder(q, 0.01, 0.01, 0.5, 24, 1);
            gl.glPopMatrix();
        gl.glTranslatef(0.0f,-0.3f,0.0f);
        gl.glColor3f(1,0,0);
        glu.gluSphere(q, 0.03, 24, 24);
        gl.glRotatef(-90, 1, 0, 0);
        gl.glColor3f(0.8f,0.8f,0.8f);
        glu.gluCylinder(q, 0.01, 0.01, 0.3, 24, 1);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, 0.25f,0.0f);
        gl.glColor3f(0,1,0);
        glu.gluSphere(q, 0.1, 24, 24);
            gl.glPushMatrix();
            gl.glRotatef(-90, 1, 0, 0);
            gl.glRotatef(-60, 0, 1, 0);
            gl.glColor3f(0.8f,0.8f,0.8f);
            glu.gluCylinder(q, 0.01, 0.01, 0.5, 24, 1);
            gl.glPopMatrix();
        gl.glTranslatef(0.2f,0.2f,0.0f);
        gl.glColor3f(1,0,0);
        glu.gluSphere(q, 0.03, 24, 24);
        gl.glRotatef(90, 1, 0, 0);
        gl.glRotatef(-45, 0, 1, 0);
        gl.glColor3f(0.8f,0.8f,0.8f);
        glu.gluCylinder(q, 0.01, 0.01, 0.3, 24, 1);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, 0.25f,0.0f);
        gl.glColor3f(0,1,0);
        glu.gluSphere(q, 0.1, 24, 24);
            gl.glPushMatrix();
            gl.glRotatef(90, 1, 0, 0);
            gl.glColor3f(0.8f,0.8f,0.8f);
            glu.gluCylinder(q, 0.01, 0.01, 0.5, 24, 1);
            gl.glPopMatrix();
        gl.glTranslatef(-0.2f,0.2f,0.0f);
        gl.glColor3f(1,0,0);
        glu.gluSphere(q, 0.03, 24, 24);
        gl.glRotatef(90, 1, 0, 0);
        gl.glRotatef(45, 0, 1, 0);
        gl.glColor3f(0.8f,0.8f,0.8f);
        glu.gluCylinder(q, 0.01, 0.01, 0.3, 24, 1);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, -0.25f,0.0f);
        gl.glColor3f(0,1,0);
        glu.gluSphere(q, 0.1, 24, 24);
            gl.glPushMatrix();
            gl.glRotatef(-90, 1, 0, 0);
            gl.glColor3f(0.8f,0.8f,0.8f);
            glu.gluCylinder(q, 0.01, 0.01, 0.5, 24, 1);
            gl.glPopMatrix();
            gl.glPushMatrix();
            gl.glRotatef(90, 1, 0, 0);
            gl.glRotatef(-60, 0, 1, 0);
            glu.gluCylinder(q, 0.01, 0.01, 0.5, 24, 1);
            gl.glPopMatrix();
        gl.glTranslatef(0.2f,-0.2f,0.0f);
        gl.glColor3f(1,0,0);
        glu.gluSphere(q, 0.03, 24, 24);
        gl.glRotatef(-90, 1, 0, 0);
        gl.glRotatef(-45, 0, 1, 0);
        gl.glColor3f(0.8f,0.8f,0.8f);
        glu.gluCylinder(q, 0.01, 0.01, 0.3, 24, 1);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, -0.25f,0.0f);
        gl.glColor3f(0,1,0);
        glu.gluSphere(q, 0.1, 24, 24);
            gl.glPushMatrix();
            gl.glRotatef(90, 1, 0, 0);
            gl.glRotatef(60, 0, 1, 0);
            gl.glColor3f(0.8f,0.8f,0.8f);
            glu.gluCylinder(q, 0.01, 0.01, 0.5, 24, 1);
            gl.glPopMatrix();
            gl.glPushMatrix();
            gl.glTranslatef(0.03f,0,0);
            gl.glRotatef(-90, 1, 0, 0);
            glu.gluCylinder(q, 0.01, 0.01, 0.5, 24, 1);
            gl.glPopMatrix();
        gl.glTranslatef(-0.2f,-0.2f,0.0f);
        gl.glColor3f(1,0,0);
        glu.gluSphere(q, 0.03, 24, 24);
        gl.glRotatef(-90, 1, 0, 0);
        gl.glRotatef(45, 0, 1, 0);
        gl.glColor3f(0.8f,0.8f,0.8f);
        glu.gluCylinder(q, 0.01, 0.01, 0.3, 24, 1);
        gl.glPopMatrix();


        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

