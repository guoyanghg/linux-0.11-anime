import java.awt.Graphics;

import javax.swing.ImageIcon;

public class FrameObj {
	double x;
	double y;  //зјБъ
	double w;
	double h;  //зјБъ
	Boolean flag=false;
	ImageIcon myself= new ImageIcon("E://guo//baozou.jpg");
	public FrameObj(int px,int py) {
		// TODO Auto-generated constructor stub
		
		x=px;
		y=py;
		w=100;
		h=100;
		System.out.println("New Obj Created!");
	}
	public void draw(Graphics g){
		if(flag){
			g.drawImage(myself.getImage(), (int)x, (int)y, (int)w, (int)h, null);
		}
	}
	public void setIcon(ImageIcon icon){
		myself=icon;
		w=icon.getImage().getWidth(null)/2;
		h=icon.getImage().getHeight(null)/2;
	}
	public void setPosition(double px,double py){
		x=px;
		y=py;
	}
	public void setWH(double pw,double ph){
		w=pw;
		h=ph;
	}
	public void Ivoke(){
		flag = true;
	}
	public void Kill(){
		flag = false;
	}
}
