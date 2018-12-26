import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main{
    public static MyFrame f= new MyFrame();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
      
      JFrame j= new JFrame();
      
      
      f.setVisible(true);
    
      j.setSize(800, 600);
      int windowWidth = j.getWidth(); //获得窗口宽
      int windowHeight = j.getHeight(); //获得窗口高
      Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
      Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
      int screenWidth = screenSize.width; //获取屏幕的宽
      int screenHeight = screenSize.height; //获取屏幕的高
      j.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
      
      j.setVisible(true);
      
      j.add(f);
      
      
      f.setSize(500,500);
      
      j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      
      
	}
	

}
