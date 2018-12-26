import java.awt.Font;
import java.awt.Graphics;

public class ZZZ extends FrameObj{
    int zcount=0;
	public ZZZ(int px, int py) {
		super(px, py);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Font f=g.getFont();
		
		if(flag){
			    Font z1=new Font(f.getName(),f.getStyle(),30);
			    g.setFont(z1);
				g.drawString("z", (int)x, (int)y);
			
				Font z2=new Font(f.getName(),f.getStyle(),50);
				g.setFont(z2);
				g.drawString("z", (int)x+50, (int)y-50);
				
				Font z3=new Font(f.getName(),f.getStyle(),70);
				g.setFont(z3);
				g.drawString("z", (int)x+100, (int)y-100);
		}
		g.setFont(f);
				
	
	}
	public void TimeDelay(int time){
		
    	
    	
    	try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
     
	
  }

}
