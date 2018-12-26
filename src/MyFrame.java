
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyFrame extends JPanel implements Runnable {
	Reader r;
	ArrayList<FrameObj> objlist=new ArrayList<FrameObj>(20);
	Thread process;
	StringChangeModel[] list= new StringChangeModel[50]; 
	boolean juqingwenzi=false;
	int juqingbiaohao=0;
	ImageIcon dialog= new ImageIcon("�Ի���.jpg");
	boolean loadingfont=true;
	public MyFrame() {
		// TODO Auto-generated constructor stub
		
		r=new Reader();
		list[29]= new StringChangeModel("��  ��",50,422);
		list[12]= new StringChangeModel("��ǰ����ɽ��");				
		list[13]= new StringChangeModel("ɽ��������");
		list[14]= new StringChangeModel("������̨С���ԡ�");
		list[15]= new StringChangeModel("С����Ҫ�𴲡�");
		list[16]= new StringChangeModel("�����һ���ܸ��ӵĹ����أ�");
		list[0]= new StringChangeModel("���ȣ�BIOS�ӵ�������");
		list[1]= new StringChangeModel("�������Ӳ��֮��BIOS������0�����̵�0�ŵ�1������Bootsect���ص��ڴ档");
		list[2]= new StringChangeModel("�ٽ����жϷ�����򽫳���ָ��ת��Bootsect�Ŀ�ʼλ�á�");
		list[3]= new StringChangeModel("Bootsect��ʼִ��!�����Լ��ƶ���90000Hλ�á�");
		list[4]= new StringChangeModel("�ƶ���ϣ��˿�Ϊ�� "+r.list[0]+"ʱ��Ƭ"+",ָ����ת����ִ��Bootsect����");
		list[41]= new StringChangeModel("׼������SETUP���롣");
		list[5]= new StringChangeModel("SETUP������ϣ�׼������systemģ����룬�˿��ǣ�"+r.list[1]+"ʱ��Ƭ");
		list[6]= new StringChangeModel("Bootsectִ����ϣ�ָ��ǡ��ִ�е�SETUP�Ŀ�ʼλ�ã��˿��ǣ�"+r.list[2]+"ʱ��Ƭ");
		list[7]= new StringChangeModel("���жϣ�׼���ƶ�system����,�˿��ǣ�"+r.list[3]+"ʱ��Ƭ");
		list[42]= new StringChangeModel("ԭ����BIOS�жϴ��벿�ֽ��ᱻ��û.");
		list[21]= new StringChangeModel("������ʱ��GDT��IDT��");
		list[18]= new StringChangeModel("��A20ת��Ϊ����ģʽ�� ");
		list[19]= new StringChangeModel("ģʽת����ϣ��ڴ����Ѱַ��Χ��Ϊ4G��");
		list[8]= new StringChangeModel("������ת��HEADλ�ã��˿��ǣ�"+r.list[4]+"ʱ��Ƭ");
		list[9]= new StringChangeModel("׼����ʼ��GDT�� �˿��ǣ�"+r.list[5]+"ʱ��Ƭ");
		list[20]= new StringChangeModel("���ݺ��ݣ�");
		list[10]= new StringChangeModel("׼����ʼ��IDT���˿��ǣ�"+r.list[6]+"ʱ��Ƭ");
		list[22]= new StringChangeModel("��ʼ����ҳ���ƣ��˿��ǣ�"+r.list[7]+"ʱ��Ƭ");
		list[11]= new StringChangeModel("������ϣ�ret��main.c ��ʼ���׶ν�����");
		list[17]= new StringChangeModel("'�㶨��,��ȥ���·�����!',С���Ը��˵�˵��������");
		
		process=new Thread(this);
		process.start();
	  
	   
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
	
	    super.paintComponent(g);
	    
	    this.setBackground(Color.white);
	    
	
	   
	    Font f=g.getFont();
	    Font z1=new Font(f.getName(),f.getStyle(),20);
	    g.setFont(z1);
	    
		for(int i=0;i<objlist.size();i++){
			objlist.get(i).draw(g);
		}
	
		
		 
	    if(juqingwenzi){
	      g.drawImage(dialog.getImage(),0,400,800,dialog.getImage().getHeight(this),this);
		  g.setColor(Color.white);
		  list[29].draw(g);
		  list[juqingbiaohao].draw(g);
		  g.setColor(Color.BLACK);
		  
	    }
		
	   
		
		repaint();
		
		
	}
	
	public void ChufaJuqing(int biaohao){
		juqingwenzi=true;
		juqingbiaohao=biaohao;
	}
	
	public void CloseJuqing(){
		juqingwenzi=false;
		
	}
	
	public void TimeDelay(int time){
		
	    	
	    	
	    	try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	     
		
	}
	public void KillAll(){
		for(int i=0;i<objlist.size();i++){
			objlist.get(i).Kill();
		}
	}
	
	public void BIOSstart(){
		 FrameObj tobe = new FrameObj(150, 20);
		 tobe.setIcon(new ImageIcon("tobe.png"));
		 tobe.setWH(tobe.myself.getImage().getWidth(null), tobe.myself.getImage().getHeight(null));
		 this.objlist.add(tobe);
		
		 FrameObj title = new FrameObj(150, 20);
		 title.setIcon(new ImageIcon("title.png"));
		 title.setWH(title.myself.getImage().getWidth(null), title.myself.getImage().getHeight(null));
		 title.Ivoke();
		 this.objlist.add(title);
		 
				 
		TimeDelay(5000);
		
		System.out.println("��ǰ����ɽ!");
		FrameObj obj1= new FrameObj(160,100);
		obj1.setIcon(new ImageIcon("mount.png"));
		obj1.setWH(440, 330);
	    obj1.Ivoke();//�����������
		this.objlist.add(obj1);
		title.Kill();
		ChufaJuqing(12);
		
		TimeDelay(3000);//��ͣ����
		
		System.out.println("ɽ��������");
		
		FrameObj obj2= new FrameObj(240,140);
		obj2.setIcon(new ImageIcon("miao.jpg"));
		obj2.setWH(300, 300);
		obj2.Ivoke();
		obj1.Kill();
		this.objlist.add(obj2);
		ChufaJuqing(13);
		
		TimeDelay(2000);
		
		FrameObj obj3= new FrameObj(280,170);
		ZZZ zzz=new ZZZ(510,180);
		obj3.setIcon(new ImageIcon("smallTV.png"));
		obj3.setWH(200, 200);
		obj3.Ivoke();
		zzz.Ivoke();
		obj1.Kill();
		obj2.Kill();
		this.objlist.add(obj3);
		this.objlist.add(zzz);
		
		ChufaJuqing(14);
		
		TimeDelay(2000);
		
        ChufaJuqing(15);
		
		TimeDelay(2000);
		
        ChufaJuqing(16);
		
		TimeDelay(2000); 
		
		
		obj1.setIcon(new ImageIcon("lightning.jpg"));
		obj1.setPosition(330, 180);
		obj1.setWH(obj1.w, obj1.h*3/2);
		obj1.Ivoke();
		obj3.Kill();
		zzz.Kill();
		
		ChufaJuqing(0);
			
		TimeDelay(2000);   
		
		obj2.setIcon(new ImageIcon("check.jpg"));
		obj1.Kill();
		obj2.setWH(380, 280);
		obj2.Ivoke();
	 
		ChufaJuqing(1);
		
		TimeDelay(2000);
		
		FrameObj bootsect= new FrameObj(235, 70);
		FrameObj graybootsect= new FrameObj(235, 70);
		FrameObj setup= new FrameObj(286,30);
		FrameObj system= new FrameObj(67, 110);
		FrameObj graysystem= new FrameObj(67, 110);
		FrameObj bar4= new FrameObj(350, 70);
		FrameObj intserver= new FrameObj(195, 70);
		FrameObj intdata= new FrameObj(240, 70);
		FrameObj frame= new FrameObj(190, 70);
		FrameObj extframe= new FrameObj(470, 70);
		FrameObj arrow= new FrameObj(485, 165);
		FrameObj white= new FrameObj(575, 70);
		FrameObj bubble= new FrameObj(145, 70);
		FrameObj bubbleBIO= new FrameObj(400, 70);
		FrameObj bubbleint= new FrameObj(90, 70);
		FrameObj bubbleintdata= new FrameObj(165, 70);
		
		bootsect.setIcon(new ImageIcon("�ڴ����1.png"));
		graybootsect.setIcon(new ImageIcon("�ڴ����1.png"));
		setup.setIcon(new ImageIcon("�ڴ����1.png"));
		system.setIcon(new ImageIcon("�ڴ����1.png"));
		graysystem.setIcon(new ImageIcon("�ڴ����1.png"));
		bar4.setIcon(new ImageIcon("�ڴ����1.png"));
		intserver.setIcon(new ImageIcon("�ڴ����1.png"));
		intdata.setIcon(new ImageIcon("�ڴ����1.png"));
		frame.setIcon(new ImageIcon("�ڴ���.png"));
		extframe.setIcon(new ImageIcon("�ڴ�����.png"));
		arrow.setIcon(new ImageIcon("arrow.png"));
		white.setIcon(new ImageIcon("white.png"));
		bubble.setIcon(new ImageIcon("bubble.png"));
		bubbleBIO.setIcon(new ImageIcon("bubbleROM.png"));
		bubbleint.setIcon(new ImageIcon("bubbleint.png"));
		bubbleintdata.setIcon(new ImageIcon("bubbleintdata.png"));
		obj2.Kill();
		bootsect.setWH(40, 300);
		graybootsect.setWH(40, 300);
		intserver.setWH(10, 300);
		intdata.setWH(60, 300);
		setup.setWH(350, 300);
		system.setWH(600, 300);
		graysystem.setWH(600, 300);
		bar4.setWH(450, 300);
		frame.setWH(400, 300);
		extframe.setWH(20, 300);
		white.setWH(40, 300);
		arrow.setWH(20, 30);
		bar4.Ivoke();
		frame.Ivoke();
		arrow.Ivoke();
		intserver.Ivoke();
		intdata.Ivoke();
		bubbleBIO.Ivoke();
		bubbleint.Ivoke();
		bubbleintdata.Ivoke();
		objlist.add(extframe);
		objlist.add(frame);
		objlist.add(graybootsect);
		objlist.add(bootsect);
		objlist.add(setup);
		objlist.add(graysystem);
		objlist.add(system);
		objlist.add(bar4);
		objlist.add(intserver);
		objlist.add(intdata);
		objlist.add(white);
		objlist.add(arrow);
		objlist.add(bubble);
		objlist.add(bubbleBIO);
		objlist.add(bubbleintdata);
		objlist.add(bubbleint);
		
	    TimeDelay(5000);
	    
		bubbleBIO.Kill();
		bubbleint.Kill();
		bubbleintdata.Kill();
	
		
		
		for(int i=0;i<200;i++){
			arrow.setPosition(arrow.x+0.3, arrow.y);
		    TimeDelay(10);
		}
		
	
		bootsect.Ivoke();
		graybootsect.Ivoke();
		
        bubble.Ivoke();
		
	    TimeDelay(5000);
	    
	    bubble.Kill();
		//���ﰲ�� 
		//ͼƬ�л�Ϊ�ڴ��� ���г�ʼ��bios����
		//���bootsect��ʼλ�ã����������Ķ�̬���̣�һ���г���ָ��Ĺ���
		
		TimeDelay(5000);
		
		
	    arrow.setPosition(arrow.x-305, arrow.y);
		
		ChufaJuqing(2);//��ת��ͷ
		
		TimeDelay(5000);
		
		ChufaJuqing(3);
		
        for(int i=0;i<300;i++){
			
        	bootsect.setPosition(bootsect.x+0.5, bootsect.y);
			arrow.setPosition(arrow.x+0.005, arrow.y);
			TimeDelay(10);
			
		}
		
		//Bootsect�����ƶ� 
        TimeDelay(500);
        
        ChufaJuqing(4);
        TimeDelay(5000);
        ChufaJuqing(41);
        
        arrow.setPosition(arrow.x+150, arrow.y);
		
        TimeDelay(5000);
        
        ChufaJuqing(20);
        
        setup.Ivoke();//����SETUP
        for(int i=0;i<400;i++){
			
        	setup.setPosition(setup.x, setup.y+0.1);
			
			TimeDelay(5);
			
		}
        //Loading setup..
	
		ChufaJuqing(5);
		
		TimeDelay(5000);
		
		ChufaJuqing(20);
		
		system.Ivoke();//����SYSTEM
		graysystem.Ivoke();
	        for(int i=0;i<400;i++){
				
	        system.setPosition(system.x, system.y-0.1);
	        graysystem.setPosition(system.x, system.y-0.1);
	        arrow.setPosition(arrow.x+0.005, arrow.y);	
			TimeDelay(5);
				
			}
	    system.setPosition(system.x, 70);
	    graysystem.setPosition(system.x, 70);
		
		//Loading system..
		
		ChufaJuqing(6); //ת��setup��ʼλ��
		
		TimeDelay(5000);
		
		
		
	/*	//�������ָ���ƶ� ���м�ͣ
		     for(int i=0;i<200;i++){
				
		        arrow.setPosition(arrow.x+0.1, arrow.y);	
				TimeDelay(10);
					
			}
		     
		*/
		
        ChufaJuqing(7);
        TimeDelay(5000);
        ChufaJuqing(42);
        
        TimeDelay(5000);
        
        ChufaJuqing(20);
        
        for(int i=0;i<72;i++){
			
        	system.setPosition(system.x-1, system.y);
        	arrow.setPosition(arrow.x+0.33, arrow.y);
			
			TimeDelay(10);
			
		} //���жϲ��ƶ�
		
        //��system�ƶ�����ʼλ��
        
        ChufaJuqing(21);
        
        TimeDelay(5000);
        
        ChufaJuqing(20);
        
        for(int i=0;i<200;i++){
			
	        arrow.setPosition(arrow.x+0.1, arrow.y);	
			TimeDelay(10);
				
		}
        
      
        
        ChufaJuqing(18);
  
	
        TimeDelay(2000);
        
        //����¾��飬�ڴ�ѳְ��Χ���
        ChufaJuqing(19);
        
        white.Ivoke();
        
        TimeDelay(500);
        
        extframe.Ivoke();
        for(int i=0;i<100;i++){
        	
        	extframe.setWH(extframe.w+10, extframe.h);
        	TimeDelay(10);
        }
        
        TimeDelay(5000);
        
		ChufaJuqing(8);
		
		//ָ����ת����ͷ
		arrow.setPosition(arrow.x-246, arrow.y);
		
		TimeDelay(5000);
		
		ChufaJuqing(20);
		
		for(int i=0;i<100;i++){
			
	        arrow.setPosition(arrow.x+0.05, arrow.y);	
			TimeDelay(10);
				
		}
		
		ChufaJuqing(9);	
		
		TimeDelay(5000);
		
		ChufaJuqing(20);
		
		for(int i=0;i<100;i++){
			
	        arrow.setPosition(arrow.x+0.05, arrow.y);	
			TimeDelay(10);
				
		}
		
		ChufaJuqing(10);

		TimeDelay(5000);
		
		ChufaJuqing(20);
		
        for(int i=0;i<100;i++){
			
	        arrow.setPosition(arrow.x+0.05, arrow.y);	
			TimeDelay(10);
				
		}
        
        ChufaJuqing(22);

		TimeDelay(5000);
		
		ChufaJuqing(20);
		
        for(int i=0;i<100;i++){
			
	        arrow.setPosition(arrow.x+0.1, arrow.y);	
			TimeDelay(10);
				
		}
		
		ChufaJuqing(11);
		
		TimeDelay(5000);
		
		KillAll();
		
		obj1.setIcon(new ImageIcon("thoughts.png"));
		
		obj1.setPosition(470, 40);
		
		obj1.Ivoke();
		
		obj3.Ivoke();
		
		ChufaJuqing(17);
		
		TimeDelay(5000);
		
		KillAll();
		
		juqingwenzi=false;
		
		tobe.Ivoke();
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		this.BIOSstart();//BIOS�����޷��궨ʱ������ֱ�ӿ�ʼ
		
		
		
	}
	
	
	

}
