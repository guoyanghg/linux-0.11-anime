import java.awt.Graphics;

import javax.swing.ImageIcon;

public class SystemHead {
	int x;
	int y;  //зјБъ
	int w;
	int h;  //зјБъ
	Boolean flag=false;
	ImageIcon myself= new ImageIcon("E://guo//baozou.jpg");;
	public SystemHead(int px,int py) {
		// TODO Auto-generated constructor stub
		
		x=px;
		y=py;
		w=100;
		h=100;
		System.out.println("System is created!");
	}
	public void draw(Graphics g){
		if(flag){
		g.drawImage(myself.getImage(), x, y, w, h, null);
		}
	}

	public void InitIDT(){
		
	}
	public void InitGDT(){
		
	}
	public void Pageing(){
		
		
	}
     public void Rettomain(){
		
		
	}
     public void Ivoke(){
 		flag = true;
 	}
     public void Kill(){
 		flag = false;
 	}
     public void setIcon(ImageIcon icon){
 		myself=icon;
 		w=icon.getImage().getWidth(null)/2;
 		h=icon.getImage().getHeight(null)/2;
 	}
}
