import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Setup {
	int x;
	int y;  //зјБъ
	int w;
	int h;  //зјБъ
	Boolean flag=false;
	ImageIcon myself= new ImageIcon("E://guo//baozou.jpg");
	public Setup(int px,int py) {
		// TODO Auto-generated constructor stub
		x=px;
		y=py;
		w=100;
		h=100;
		System.out.println("Setup is created!");
	}
	public void draw(Graphics g){
		
		if(flag){
			g.drawImage(myself.getImage(), x, y, w, h, null);
		}
	}
	public void ChangePositionOfSystem(Graphics g){
		
	}
	public void CheckHardware(){
		
	}
	public void CloseInt(){
		
	}
	public void OpenA20(){
		
		
	}
     public void ModeChangeOk(){
		
		
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
