import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import javax.swing.event.*;
 
public class tutorial {
    int angle = 0;
 
    //Sirve para  crear el JPanel e insertarle contenido
    private JPanel getContent() {
        label.setFont(new Font("Monospaced", Font.PLAIN, 24));
        label.setBorder(BorderFactory.createEtchedBorder());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(label, new GridBagConstraints());
        return panel;
    }
 
    
    
    
    
    
    
    
    //Lo importante para 
     JLabel label = new JLabel("hello world") {
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
            AffineTransform aT = g2.getTransform();
            Shape oldshape = g2.getClip();
            double x = getWidth()/2.0;
            double y = getHeight()/2.0;
            aT.rotate(Math.toRadians(angle), x, y);
            g2.transform(aT);
            g2.setTransform(aT);
            g2.setClip(oldshape);
            super.paintComponent(g);
        }
    };
 
    
    
    
    
    
    
    
    
    private JSlider getSlider() {
        final JSlider slider = new JSlider(-180, 180, angle);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                angle = slider.getValue();
                label.getParent().repaint();
            }
        });
        return slider;
    }
 
    
    
    
    
    
    
    
    //MAIN
    
    public static void main(String[] args) {
    	
    	
    	//se instancia la clase tutorial para acceder a sus metodos
    	tutorial rotLabel = new tutorial();
    	
    	//se instancia la clase para poder hacer un JFrame
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        f.add(rotLabel.getContent());
        f.add(rotLabel.getSlider(), "Last");

        
        //atributos de ventana
        f.setSize(400,400);
        f.setLocation(100,100);
        f.setVisible(true);
    }
}
