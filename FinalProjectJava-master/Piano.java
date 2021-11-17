/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.*;
import java.awt.MouseInfo;
import java.awt.*;
import java.awt.event.*;
import static piano.displayFramework.runFrame;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Polygon;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.*;
import java.util.LinkedList;
import java.util.Random;


//import static displayFramework.SwingConsole.runFrame;
/**
 *
 * @author ja
 */
class PianoFrame extends JFrame{
    static DrawingAppPanel dp=new DrawingAppPanel();
    public PianoFrame(){
        //DrawingAppPanel dp= new DrawingAppPanel();
        JPanel draw= dp.drawingJPanel;
        draw.setPreferredSize(new Dimension(200,100));//set size of drawing panel
        draw.setBorder(BorderFactory.createLineBorder(Color.black));//create a border for it
        add(draw,BorderLayout.LINE_END);//put the drawing panel on the right
        PianoPanel p=new PianoPanel();
        add(p.environmentJPanel);//add panel that contains piano
        ClearButtonPanel clearbutton=new ClearButtonPanel();
        add(clearbutton,BorderLayout.PAGE_END);
    }
}
class DrawingAppPanel extends JPanel {
    // Point is a class that represents a geometric point occupying a location on
    // a component.
    // We must qualify our use of list because both the java.util and the java.awt
    // packages have a list class.
    static java.util.List<Point> paintedPoints = new LinkedList();
    static java.util.List<Point> tempPoints = new LinkedList();
    static Point startPoint =new Point(0,0);
    public JPanel drawingJPanel;
    static int x1;
    static int x2;
    static int y1;
    static int y2;
    Timer paintTimer=new Timer(100,event->{
        //get stuff from tempPoints
        if(tempPoints.size()<2){}
        else{
            x1=tempPoints.get(0).x;
            x2=tempPoints.get(1).x;
            y1=tempPoints.get(0).y;
            int y2=tempPoints.get(1).y;
            paintedPoints.add(tempPoints.remove(0));
            drawingJPanel.repaint();
            System.out.println("paint");
        }
    
         
    });
    
    
    
    public DrawingAppPanel() {
        drawingJPanel = new JPanel() {
            // https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
            @Override
            public void paintComponent(Graphics g) {
                
                Random rand=new Random();
                setBackground(Color.WHITE);
                super.paintComponent(g);
                g.setColor(Color.MAGENTA);
                g.drawLine(x1, y1, x2, y2);
                
            }
        };
  
    }
}
class PianoPanel extends JPanel {
    public JPanel environmentJPanel;
    //public JSlider VolumeSlide=new JSlider(0,10,1);
    //public JButton recordButton=new JButton("record");
    // in the constructor we are drawing all the keys, 
    public PianoPanel() {
        environmentJPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                setBackground(Color.WHITE);
                super.paint(g);
                Polygon C = new Polygon();
                C.addPoint(200, 200);
                C.addPoint(200,400);
                C.addPoint(250,400);
                C.addPoint(250,280);
                C.addPoint(230,280); 
                C.addPoint(230,200);
                g.drawPolygon(C);
                Polygon Cs=new Polygon();
                Cs.addPoint(230,200);Cs.addPoint(270,200);
                Cs.addPoint(270,280);Cs.addPoint(230, 280);
                g.drawPolygon(Cs);
                g.fillPolygon(Cs);
                Polygon D= new Polygon();
                D.addPoint(270, 200);
                D.addPoint(270, 280);D.addPoint(250, 280);
                D.addPoint(250, 400);D.addPoint(300, 400);
                D.addPoint(300, 280);D.addPoint(280, 280);D.addPoint(280, 200);
                g.drawPolygon(D);
                Polygon Ds=new Polygon();
                Ds.addPoint(280,200);Ds.addPoint(280, 280);
                Ds.addPoint(320,280);Ds.addPoint(320,200);
                g.drawPolygon(Ds);
                g.fillPolygon(Ds);
                Polygon E=new Polygon();
                E.addPoint(320,200); E.addPoint(320,280);
                E.addPoint(300,280); E.addPoint(300, 400);
                E.addPoint(350,400); E.addPoint(350,200);
                g.drawPolygon(E);
                int[] fx={350,380,380,400,400,350};
                int[] fy={200,200,280,280,400,400};
                Polygon F= new Polygon();
                F.addPoint(350,200);F.addPoint(380,200);
                F.addPoint(380,280);F.addPoint(400,280);
                F.addPoint(400,400);F.addPoint(350,400);
                g.drawPolygon(F);
                
                Polygon Fs=new Polygon(); 
                Fs.addPoint(380,200);Fs.addPoint(420,200);
                Fs.addPoint(420,280); Fs.addPoint(380,280);
                g.drawPolygon(Fs);
                g.fillPolygon(Fs);
                
                Polygon G=new Polygon();
                G.addPoint(420,200); G.addPoint(430,200);
                G.addPoint(430,280); G.addPoint(450,280);
                G.addPoint(450,400); G.addPoint(400,400);
                G.addPoint(400,280); G.addPoint(420,280);
                g.drawPolygon(G);
                    
                Polygon Gs=new Polygon();
                Gs.addPoint(430,200); Gs.addPoint(470,200);
                Gs.addPoint(470,280); Gs.addPoint(430,280);
                g.drawPolygon(Gs);
                g.fillPolygon(Gs);
                
                Polygon A= new Polygon();
                A.addPoint(470,200); A.addPoint(480,200);
                A.addPoint(480,280); A.addPoint(500,280);
                A.addPoint(500,400); A.addPoint(450,400);
                A.addPoint(450, 280); A.addPoint(470,280);
                g.drawPolygon(A);
                
                Polygon Bb= new Polygon();
                Bb.addPoint(480,200); Bb.addPoint(520,200);
                Bb.addPoint(520,280); Bb.addPoint(480,280);
                g.drawPolygon(Bb);
                g.fillPolygon(Bb);
                
                Polygon B= new Polygon();
                B.addPoint(520,200); B.addPoint(550,200);
                B.addPoint(550,400); B.addPoint(500,400);
                B.addPoint(500,280); B.addPoint(520, 280);
                g.drawPolygon(B);
          
              
            InputMap inputMap = environmentJPanel.getInputMap();
            ActionMap actionMap = environmentJPanel.getActionMap();
            
            //all key bindings for keyboard
            Action CKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/c3Piano.mid");
                }
            };
            Action CsKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/cs3Piano.mid");
                }
            };
            Action DKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/d3Piano.mid");
                }
            };
            Action DsKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/ds3Piano.mid");
                }
            };
            Action EKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/e3Piano.mid");
                }
            };
            Action FKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/f3Piano.mid");
                }
            };
            Action FsKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/fs3Piano.mid");
                }
            };
            Action GKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/g3Piano.mid");
                }
            };
            Action GsKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/gs3Piano.mid");
                }
            };
            Action AKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/a3Piano.mid");
                }
            };
            Action BbKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/as3Piano.mid");
                }
            };
            Action BKey = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                play("resources/b3Piano.mid");
                }
            };

            actionMap.put("cnat", CKey);
            actionMap.put("csharp", CsKey);
            actionMap.put("dnat", DKey);
            actionMap.put("dsharp", DsKey);
            actionMap.put("enat", EKey);
            actionMap.put("fnat", FKey);
            actionMap.put("fsharp", FsKey);
            actionMap.put("gnat", GKey);
            actionMap.put("gsharp", GsKey);
            actionMap.put("anat", AKey);
            actionMap.put("bflat", BbKey);
            actionMap.put("bnat", BKey);
            inputMap.put(KeyStroke.getKeyStroke('a'),"cnat");
            inputMap.put(KeyStroke.getKeyStroke('w'), "csharp");
            inputMap.put(KeyStroke.getKeyStroke('d'), "dnat");
            inputMap.put(KeyStroke.getKeyStroke('r'), "dsharp");
            inputMap.put(KeyStroke.getKeyStroke('f'), "enat");
            inputMap.put(KeyStroke.getKeyStroke('g'), "fnat");
            inputMap.put(KeyStroke.getKeyStroke('t'), "fsharp");
            inputMap.put(KeyStroke.getKeyStroke('h'), "gnat");
            inputMap.put(KeyStroke.getKeyStroke('u'), "gsharp");
            inputMap.put(KeyStroke.getKeyStroke('j'), "anat");
            inputMap.put(KeyStroke.getKeyStroke('i'), "bflat");
            inputMap.put(KeyStroke.getKeyStroke('k'), "bnat");
            
            
            environmentJPanel.addMouseListener(new MouseListener(){
                boolean ispressed;
          @Override
          public void mousePressed(MouseEvent e) {
            Random ran=new Random();
            if(C.contains(e.getX(),e.getY())) { 
                play("resources/c3Piano.mid");
                //get random initial point
                Point startTemp=DrawingAppPanel.startPoint;
                DrawingAppPanel.tempPoints.add(startTemp);
                for (int i=0;i<100;i++){
                    //take the last point from startTemp
                    Point lastPoint=DrawingAppPanel.tempPoints.get(DrawingAppPanel.tempPoints.size()-1);
                    //find a point close to that last point
                    Point close=new Point(lastPoint.x+ran.nextInt(20),lastPoint.y+ran.nextInt(20));
                    //add it to our temp points
                    DrawingAppPanel.tempPoints.add(close);
                    
                    //now we need to draw point 0-1 1-2 2-3 ect. using a timer
                    PianoFrame.dp.paintTimer.start();
                    
                    
                    }
                
                
                }
            
            if(Cs.contains(e.getX(),e.getY())){ play("resources/cs3Piano.mid");}
            if(D.contains(e.getX(),e.getY())){ play("resources/d3Piano.mid");}
            if(Ds.contains(e.getX(),e.getY())){ play("resources/ds3Piano.mid"); }
            if(E.contains(e.getX(),e.getY())){ play("resources/e3Piano.mid");}
            if(F.contains(e.getX(),e.getY())){play("resources/f3Piano.mid"); }
            if(Fs.contains(e.getX(),e.getY())){play("resources/fs3Piano.mid");}
            if(G.contains(e.getX(),e.getY())){play("resources/g3Piano.mid");}
            if(Gs.contains(e.getX(),e.getY())){play("resources/gs3Piano.mid");}
            if(A.contains(e.getX(),e.getY())){play("resources/a3Piano.mid");}
            if(Bb.contains(e.getX(),e.getY())){play("resources/as3Piano.mid");}
            if(B.contains(e.getX(),e.getY())){play("resources/b3Piano.mid");}
          }

          @Override
          public void mouseClicked(MouseEvent e) {}
          @Override
          public void mouseReleased(MouseEvent e) {
              PianoFrame.dp.paintTimer.stop();

          }
          @Override
          public void mouseEntered(MouseEvent e) {
          }
          @Override
          public void mouseExited(MouseEvent e) {
          }

          });
          }
          };//end constructor
        //add(environmentJPanel);
        //environmentJPanel.add(recordButton);
        //made slider, still need to add logic to change volume
        //VolumeSlide.addChangeListener(new SliderListener());
                
        //environmentJPanel.add(VolumeSlide);
        
        
    }
    public Point getInitPoint(){
        Random rand=new Random();
        int xPoint=rand.nextInt(150);
        int yPoint=rand.nextInt(800);
        Point paintPoint= new Point(xPoint,yPoint);
        return paintPoint;
    }
    public int getSlideNum(){
        //return VolumeSlide.getValue();
        return 0;

    }
//need to change logic of this so i understand it. 
// class SliderListener implements ChangeListener {
//  public void stateChanged(ChangeEvent changeEvent) {
//    Object source = changeEvent.getSource();
//    if (source instanceof BoundedRangeModel) {
//      BoundedRangeModel aModel = (BoundedRangeModel) source;
//      if (!aModel.getValueIsAdjusting()) {
//        System.out.println("Changed: " + aModel.getValue());
//      }
//    } else if (source instanceof JSlider) {
//      JSlider theJSlider = (JSlider) source;
//      if (!theJSlider.getValueIsAdjusting()) {
//        System.out.println("Slider changed: " + theJSlider.getValue());
//      }
//    } else {
//      System.out.println("Something changed: " + source);
//    }
//  }
//}
//    
    public void play(String s){
           //https://www.java-tips.org/java-se-tips-100019/43-javax-sound-midi/1960-how-to-load-and-play-midi-audio.html
           // I used code here to play midi file.
        try {
           Sequence sequence = MidiSystem.getSequence(new File(s).getAbsoluteFile());
           Sequencer sequencer = MidiSystem.getSequencer();
           Synthesizer synth=MidiSystem.getSynthesizer();
           sequencer.open();
           sequencer.setSequence(sequence);
           //Synthesizer synthesizer = (Synthesizer) sequencer;
           sequencer.start();
           //http://www.java2s.com/Code/Java/Development-Class/SettingtheVolumeofPlayingMidiAudio.htm
           //documentation used to change volume
           //but it doesn't work, so I'm gonna try some other stuff before I come back to this. 
        } catch (Exception all){System.out.println(all);}

       }  
    }

//recordButton.addMouseListener(new MouseListener(){
//                public void mousePressed(MouseEvent e){}
//                public void mouseClicked(MouseEvent e){
//                    //start recording
//                    
//                    try{
//                        Sequencer mySequencer=MidiSystem.getSequencer();
//                        Sequence mySeq;
//                        Receiver r= mySequencer.getReceiver();
//                        Transmitter trans=mySequencer.getTransmitter();
//                        trans.setReceiver(r);
//                        
//                     
//                        mySeq = new Sequence(Sequence.PPQ, 10);
//                        Track recTrack=mySeq.createTrack();
//                        
//                    } catch (Exception ex) {}
//                    
//                
//                
//                }
//                public void mouseReleased(MouseEvent e){}
//                public void mouseEntered(MouseEvent e) {}
//                public void mouseExited(MouseEvent e) {}
//            });
class ClearButtonPanel extends JPanel{
    public ClearButtonPanel(){
    JButton clear=new JButton("clear");
    add(clear);
    clear.addMouseListener(new MouseListener(){
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseClicked(MouseEvent e) {
        DrawingAppPanel.paintedPoints.clear();
        PianoFrame.dp.drawingJPanel.repaint();
        }
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}

        });
  
    }
};
public class Piano {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        runFrame(new PianoFrame(), 900, 900);
}
}
    

//to paint
//generate 100points
//we wont' use them all

//for each point in that list
//we will draw a line between 1st two points
//using a timer....???
