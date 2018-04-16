package Graphical_User_Interface;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Choice extends JFrame implements ItemListener{
	String account;
	String password;
	
	JComboBox<String> JC_box = new JComboBox<String>();
	
	Font font = new Font("楷体_GB2312",Font.BOLD+Font.ITALIC,20);
	
	String path = "C:/Users/yangcheng/workspace/DatabaseExperiment/src"
			+ "/Graphical_User_Interface/Choice.png";
	
	JPanel jpl = new JPanel();
	
	public Choice(String ac, String pd){
		account = ac;
		password = pd;
		
		this.setTitle("学籍管理系统");
		this.setSize(250,200);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		
		ImageIcon bg = new ImageIcon(path);                        //背景图片
		JLabel label = new JLabel(bg);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel imgP = (JPanel)this.getContentPane();
		imgP.setOpaque(false);
		
		JC_box.addItem("功能选择");
		JC_box.addItem("学生档案管理");
		JC_box.addItem("学生学籍管理");
		JC_box.addItem("学生成绩管理");
		JC_box.addItem("统计、查询");
		JC_box.setSelectedItem("选择功能");   							//默认选项
		JC_box.setFont(font);
		
		JC_box.addItemListener(this);
		
		jpl.add(JC_box);
		jpl.setOpaque(false);
		
        this.add(jpl);
        
        this.setVisible(true);
		this.setResizable(true);
	}
	
	public void itemStateChanged(ItemEvent e){                          //下拉框Item
		if(e.getStateChange() == ItemEvent.SELECTED){
			if(JC_box.getSelectedItem()=="学生档案管理"){                   //学生档案管理
				new Record_Manage(account,password);
				JC_box.setSelectedIndex(0);
			}
			
			if(JC_box.getSelectedItem()=="学生学籍管理"){				//学生学籍管理
				new School_Manage(account,password);
				JC_box.setSelectedIndex(0);
			}
			
			if(JC_box.getSelectedItem()=="学生成绩管理"){				//学生成绩管理
				new Score_Manage(account,password);
				JC_box.setSelectedIndex(0);
			}
			
			if(JC_box.getSelectedItem()=="统计、查询"){					//统计、查询
				new Statistics_Manage(account,password);
				JC_box.setSelectedIndex(0);
			}
		}
	}
}
