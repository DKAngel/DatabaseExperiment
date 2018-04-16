package Graphical_User_Interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Statistics_Manage extends JFrame implements ActionListener{
	String account;
	String password;
	String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Databaseproject"; //数据源
	String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	//SQL数据库引擎
	Connection conR;
    Statement statement;
	
	Font font0 = new Font("楷体_GB2312",Font.BOLD+Font.ITALIC,40);
	Font fontjb = new Font("楷体_GB2312",Font.BOLD,15);
	Font fontjt = new Font("楷体_GB2312",Font.BOLD,20);
	Font fontarea = new Font("楷体_GB2312",Font.BOLD,25);
	Font font = new Font("楷体_GB2312",Font.BOLD+Font.ITALIC,20);
	
	String path = "C:/Users/yangcheng/workspace/DatabaseExperiment/src"
			+ "/Graphical_User_Interface/背景.png";
	
	JPanel jpl = new JPanel(null);
	
	JButton JB_average_course = new JButton("各学科成绩、平均分");
	JButton JB_average_student = new JButton("某学生各科成绩、平均分");
	JButton JB_grade_score = new JButton("按年级显示学生成绩");
	JButton JB_class_score = new JButton("按班级显示学生成绩");
	JButton JB_back = new JButton("返回");
	
	JScrollPane jsinfor;
	JTextArea jtinfor;
	
	String strnum;	int snum;
	String strgradenum; int gradenum;
	String strclassnum; int classnum;
	float chinese;
	float math;
	float english;
	float highmath;
	float physical;
	float highenglish;
	float salgorithm;
	float datastructure;
	float sdatabase;
	float sum;
	float average;
	int n = 0;
	
	public Statistics_Manage(String ac, String pw){
		account = ac;
		password = pw;
		try {
	        Class.forName(JDriver);
	        conR = DriverManager.getConnection(connectDB, account, password);
	        statement = conR.createStatement();
	    } catch (ClassNotFoundException | SQLException e) {
	    	dispose();
	    }
		
		this.setTitle("学籍管理系统");	
		this.setSize(516 , 530);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		this.setLocationRelativeTo(null);
		
		ImageIcon bg = new ImageIcon(path);                            		//背景图片
		JLabel label = new JLabel(bg);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel imgP = (JPanel)this.getContentPane();
		imgP.setOpaque(false);
		
		JLabel lb0 = new JLabel("学生统计、查询管理");                          	 //标题
		lb0.setFont(font0);
		this.add(lb0);
		
		JButton jbt = new JButton();							 			//换行
		jbt.setPreferredSize(new Dimension(400,1));  
		jbt.setBorderPainted(false);
		jbt.setContentAreaFilled(false);
		this.add(jbt);
		
		JB_average_course.setBorderPainted(false);							//各学科平均分
		JB_average_course.setFont(fontjb);
		JB_average_course.setActionCommand("jbaverage_course");
		JB_average_course.addActionListener(this);
		this.add(JB_average_course);
		
		JB_average_student.setBorderPainted(false);							//查询某学生平均分
		JB_average_student.setActionCommand("jbaverage_student");
		JB_average_student.addActionListener(this);
		JB_average_student.setFont(fontjb);
		this.add(JB_average_student);
		
		JB_grade_score.setBorderPainted(false);								//按年级显示成绩
		JB_grade_score.setActionCommand("jbgrade_score");
		JB_grade_score.addActionListener(this);
		JB_grade_score.setFont(fontjb);
		this.add(JB_grade_score);
		
		JB_class_score.setBorderPainted(false);								//按班级显示成绩
		JB_class_score.setActionCommand("jbclass_score");
		JB_class_score.addActionListener(this);
		JB_class_score.setFont(fontjb);
		this.add(JB_class_score);
		
		JB_back.setBorderPainted(false);									//返回
		JB_back.setActionCommand("jbback");
		JB_back.addActionListener(this);
		JB_back.setFont(fontjb);
		this.add(JB_back);
		
		JButton jbt1 = new JButton();							 			//换行
		jbt1.setPreferredSize(new Dimension(400,0));  
		jbt1.setBorderPainted(false);
		jbt1.setContentAreaFilled(false);
		this.add(jbt1);
		
		this.setVisible(true);
		this.setResizable(false);
	}

//***********************************************************************
	public JPanel createGUI(){												//创建界面
		jpl.setLayout(new FlowLayout(FlowLayout.CENTER,30,5));
		jpl.setPreferredSize(new Dimension(516, 530));
		
		jtinfor = new JTextArea(13,40);
		jtinfor.setFont(fontjb);
		
		jsinfor = new JScrollPane(jtinfor);
		jpl.add(jsinfor);
		
		return jpl;
	}
//***********************************************************************	
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("jbaverage_course")){				//各科成绩、平均分操作
			boolean flag = false;
			try {
				ResultSet result_infor_chinese = statement.executeQuery("select * from Score_Manage order by snum");
				if(result_infor_chinese != null){
					flag = true;
				}
				if(flag){
					jpl.removeAll();
					jpl.repaint();
					jpl = createGUI();
					jtinfor.setText("各科成绩、平均分如下：\n");
					
					jtinfor.append("语文成绩：\n");
					sum = 0;
					while(result_infor_chinese.next()){
						strnum = result_infor_chinese.getString("snum");
						chinese = result_infor_chinese.getFloat("chinese");
						n++;
						sum += chinese;
						jtinfor.append("学号："+strnum+"    ");
						jtinfor.append("成绩："+chinese+"\n");
					}
					average = sum / n;
					jtinfor.append("语文的平均成绩是："+average+'\n'+"**************************"+'\n');
					
					jtinfor.append("数学成绩：\n");
					sum = 0; n = 0;
					ResultSet result_infor_math = statement.executeQuery("select * from Score_Manage order by snum");
					while(result_infor_math.next()){
						strnum = result_infor_math.getString("snum");
						math = result_infor_math.getFloat("math");
						n++;
						sum += math;
						jtinfor.append("学号："+strnum+"    ");
						jtinfor.append("成绩："+math+"\n");
					}
					average = sum / n;
					jtinfor.append("数学的平均成绩是："+average+'\n'+"**************************"+'\n');
					
					jtinfor.append("英语成绩：\n");
					sum = 0; n = 0;
					ResultSet result_infor_english = statement.executeQuery("select * from Score_Manage order by snum");
					while(result_infor_english.next()){
						strnum = result_infor_english.getString("snum");
						english = result_infor_english.getFloat("english");
						n++;
						sum += english;
						jtinfor.append("学号："+strnum+"    ");
						jtinfor.append("成绩："+english+"\n");
					}
					average = sum / n;
					jtinfor.append("英语的平均成绩是："+average+'\n'+"**************************"+'\n');
					
					jtinfor.append("高数成绩：\n");
					sum = 0; n = 0;
					ResultSet result_infor_highmath = statement.executeQuery("select * from Score_Manage order by snum");
					while(result_infor_highmath.next()){
						strnum = result_infor_highmath.getString("snum");
						highmath = result_infor_highmath.getFloat("highmath");
						n++;
						sum += highmath;
						jtinfor.append("学号："+strnum+"    ");
						jtinfor.append("成绩："+highmath+"\n");
					}
					average = sum / n;
					jtinfor.append("高数的平均成绩是："+average+'\n'+"**************************"+'\n');
					
					jtinfor.append("大物成绩：\n");
					sum = 0; n = 0;
					ResultSet result_infor_physical = statement.executeQuery("select * from Score_Manage order by snum");
					while(result_infor_physical.next()){
						strnum = result_infor_physical.getString("snum");
						physical = result_infor_physical.getFloat("physical");
						n++;
						sum += physical;
						jtinfor.append("学号："+strnum+"    ");
						jtinfor.append("成绩："+physical+"\n");
					}
					average = sum / n;
					jtinfor.append("大物的平均成绩是："+average+'\n'+"**************************"+'\n');
					
					jtinfor.append("大学英语成绩：\n");
					sum = 0; n = 0;
					ResultSet result_infor_highenglish = statement.executeQuery("select * from Score_Manage order by snum");
					while(result_infor_highenglish.next()){
						strnum = result_infor_highenglish.getString("snum");
						highenglish = result_infor_highenglish.getFloat("highenglish");
						n++;
						sum += highenglish;
						jtinfor.append("学号："+strnum+"    ");
						jtinfor.append("成绩："+highenglish+"\n");
					}
					average = sum / n;
					jtinfor.append("大学英语的平均成绩是："+average+'\n'+"**************************"+'\n');
					
					jtinfor.append("算法成绩：\n");
					sum = 0; n = 0;
					ResultSet result_infor_salgorithm = statement.executeQuery("select * from Score_Manage order by snum");
					while(result_infor_salgorithm.next()){
						strnum = result_infor_salgorithm.getString("snum");
						salgorithm = result_infor_salgorithm.getFloat("salgorithm");
						n++;
						sum += salgorithm;
						jtinfor.append("学号："+strnum+"    ");
						jtinfor.append("成绩："+salgorithm+"\n");
					}
					average = sum / n;
					jtinfor.append("算法的平均成绩是："+average+'\n'+"**************************"+'\n');
					
					jtinfor.append("数据结构成绩：\n");
					sum = 0; n = 0;
					ResultSet result_infor_datastructure = statement.executeQuery("select * from Score_Manage order by snum");
					while(result_infor_datastructure.next()){
						strnum = result_infor_datastructure.getString("snum");
						datastructure = result_infor_datastructure.getFloat("datastructure");
						n++;
						sum += datastructure;
						jtinfor.append("学号："+strnum+"    ");
						jtinfor.append("成绩："+datastructure+"\n");
					}
					average = sum / n;
					jtinfor.append("数据结构的平均成绩是："+average+'\n'+"**************************"+'\n');
					
					jtinfor.append("数据库论成绩：\n");
					sum = 0; n = 0;
					ResultSet result_infor_sdatabase = statement.executeQuery("select * from Score_Manage order by snum");
					while(result_infor_sdatabase.next()){
						strnum = result_infor_sdatabase.getString("snum");
						sdatabase = result_infor_sdatabase.getFloat("sdatabase");
						n++;
						sum += sdatabase;
						jtinfor.append("学号："+strnum+"    ");
						jtinfor.append("成绩："+sdatabase+"\n");
					}
					average = sum / n;
					jtinfor.append("数据库论的平均成绩是："+average+'\n'+"**************************");
					
					jtinfor.setCaretPosition(0);
					jpl.setOpaque(false);
					this.add(jpl);
					this.validate();
				}else{
					JOptionPane.showMessageDialog(null,"学生成绩表中没有信息！！！");
					jpl.removeAll();
					jpl.repaint();
					jpl.setOpaque(false);
					this.add(jpl);
					this.validate();
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null,"数据库操作失败！！！");
			}
		}
		
		if(e.getActionCommand().equals("jbaverage_student")){				//某学生各科成绩、平均分
			jpl.removeAll();
			jpl.repaint();
			jpl = createGUI();
			jtinfor.setText("该学生各科成绩、平均分如下：\n");
			
			boolean flag = false;
			strnum = JOptionPane.showInputDialog("输入要查询的学号：");
			if(strnum.equals("")){
				JOptionPane.showMessageDialog(null,"学号不能为空！！！");
			}else{
				snum = Integer.valueOf(strnum).intValue();
				try {
					ResultSet result_snum = statement.executeQuery("select * from Score_Manage");
					while (result_snum.next()) {
						int num = Integer.valueOf(result_snum.getString("snum")).intValue();
						if(num == snum){
							flag = true;
							break;
			            }
					}
					if(flag){
						sum = 0;
						ResultSet result_infor = statement.executeQuery("select * "
													+"from Score_Manage where snum = '"+snum+"'");
						while(result_infor.next()){
							chinese = result_infor.getFloat("chinese");
							math = result_infor.getFloat("math");
							english = result_infor.getFloat("english");
							
							highmath = result_infor.getFloat("highmath");
							physical = result_infor.getFloat("physical");
							highenglish = result_infor.getFloat("highenglish");
							
							salgorithm = result_infor.getFloat("salgorithm");
							datastructure = result_infor.getFloat("datastructure");
							sdatabase = result_infor.getFloat("sdatabase");
							jtinfor.append("学号："+strnum+"\n");
//							jtinfor.append("入学成绩："+"\n");
							jtinfor.append("语文："+chinese+"\n");
							jtinfor.append("数学："+math+"\n");
							jtinfor.append("英语："+english+"\n");
//							jtinfor.append("上学期成绩："+"\n");
							jtinfor.append("高数："+highmath+"\n");
							jtinfor.append("大物："+physical+"\n");
							jtinfor.append("大学英语："+highenglish+"\n");
//							jtinfor.append("下学期成绩："+"\n");
							jtinfor.append("算法："+salgorithm+"\n");
							jtinfor.append("数据结构："+datastructure+"\n");
							jtinfor.append("数据库论："+sdatabase+'\n'+"*****"
											+ "****************"+'\n');
						}
						sum = chinese+math+english+highmath+physical+highenglish+salgorithm+datastructure+sdatabase; 
						average = sum / 9;
						jtinfor.append("该学生的平均成绩是："+average+'\n'+"**************************");
						
						jtinfor.setCaretPosition(0);
						jpl.setOpaque(false);
						this.add(jpl);
						this.validate();
					}else{
						JOptionPane.showMessageDialog(null,"学生成绩信息不存在，请创建");
						jpl.removeAll();
						jpl.repaint();
						jpl.setOpaque(false);
						this.add(jpl);
						this.validate();
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"数据库操作失败！！！");
				}
			}
		}
		
		if(e.getActionCommand().equals("jbgrade_score")){					//按年级显示学生成绩操作
			jpl.removeAll();
			jpl.repaint();
			jpl = createGUI();
			jtinfor.setText("该年级学生成绩如下：\n");
			
			boolean flag = false;
			strgradenum = JOptionPane.showInputDialog("输入要查询的年级：");
			if(strgradenum.equals("")){
				JOptionPane.showMessageDialog(null,"年级号不能为空！！！");
			}else{
				gradenum = Integer.valueOf(strgradenum).intValue();
				try {
					ResultSet result_grade = statement.executeQuery("select sgrade from Record_Manage");
					
					while (result_grade.next()) {
						int num = Integer.valueOf(result_grade.getString("sgrade")).intValue();
						if(num == gradenum){
							flag = true;
							break;
			            }
					}
					
					if(flag){
						ResultSet result_grade_snum = statement.executeQuery("select snum from Record_Manage where sgrade = '"+gradenum+"'");
						ArrayList<Integer> grade_id = new ArrayList<>();
						while(result_grade_snum.next()){
							String strid = result_grade_snum.getString("snum");
							int x = Integer.valueOf(strid).intValue();
							grade_id.add(x);
						}
						for(int element: grade_id){
							ResultSet result = statement.executeQuery("select * from Score_Manage where snum = '"+element+"'");
							while(result.next()){
								chinese = result.getFloat("chinese");
								math = result.getFloat("math");
								english = result.getFloat("english");
								highmath = result.getFloat("highmath");
								physical = result.getFloat("physical");
								highenglish = result.getFloat("highenglish");
								salgorithm = result.getFloat("salgorithm");
								datastructure = result.getFloat("datastructure");
								sdatabase = result.getFloat("sdatabase");
								
								jtinfor.append("学号："+element+"\n");
//								jtinfor.append("入学成绩："+"\n");
								jtinfor.append("语文："+chinese+"\n");
								jtinfor.append("数学："+math+"\n");
								jtinfor.append("英语："+english+"\n");
//								jtinfor.append("上学期成绩："+"\n");
								jtinfor.append("高数："+highmath+"\n");
								jtinfor.append("大物："+physical+"\n");
								jtinfor.append("大学英语："+highenglish+"\n");
//								jtinfor.append("下学期成绩："+"\n");
								jtinfor.append("算法："+salgorithm+"\n");
								jtinfor.append("数据结构："+datastructure+"\n");
								jtinfor.append("数据库论："+sdatabase+'\n'+"*****"
												+ "****************"+'\n');
							}
						}
						jtinfor.setCaretPosition(0);
						jpl.setOpaque(false);
						this.add(jpl);
						this.validate();
					}else{
						JOptionPane.showMessageDialog(null,"学生档案中不存在该年级学生，请创建");
						jpl.removeAll();
						jpl.repaint();
						jpl.setOpaque(false);
						this.add(jpl);
						this.validate();
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"数据库操作失败！！！");
				}
			}
		}

		if(e.getActionCommand().equals("jbclass_score")){					//按班级显示学生成绩操作
			jpl.removeAll();
			jpl.repaint();
			jpl = createGUI();
			jtinfor.setText("该班级学生成绩如下：\n");
			
			boolean flag = false;
			strclassnum = JOptionPane.showInputDialog("输入要查询的班级：");
			if(strclassnum.equals("")){
				JOptionPane.showMessageDialog(null,"班级号不能为空！！！");
			}else{
				classnum = Integer.valueOf(strclassnum).intValue();
				try {
					
					ResultSet result_class = statement.executeQuery("select sclass from Record_Manage");
					
					while (result_class.next()) {
						int num = Integer.valueOf(result_class.getString("sclass")).intValue();
						if(num == classnum){
							flag = true;
							break;
			            }
					}
					
					if(flag){
						ResultSet result_class_snum = statement.executeQuery("select snum from Record_Manage where sclass= '"+classnum+"'");
						ArrayList<Integer> class_id = new ArrayList<>();
						while(result_class_snum.next()){
							String strid = result_class_snum.getString("snum");
							int x = Integer.valueOf(strid).intValue();
							class_id.add(x);
						}
						for(int element: class_id){
							ResultSet result = statement.executeQuery("select * from Score_Manage where snum = '"+element+"'");
							while(result.next()){
								chinese = result.getFloat("chinese");
								math = result.getFloat("math");
								english = result.getFloat("english");
								highmath = result.getFloat("highmath");
								physical = result.getFloat("physical");
								highenglish = result.getFloat("highenglish");
								salgorithm = result.getFloat("salgorithm");
								datastructure = result.getFloat("datastructure");
								sdatabase = result.getFloat("sdatabase");
								
								jtinfor.append("学号："+element+"\n");
//								jtinfor.append("入学成绩："+"\n");
								jtinfor.append("语文："+chinese+"\n");
								jtinfor.append("数学："+math+"\n");
								jtinfor.append("英语："+english+"\n");
//								jtinfor.append("上学期成绩："+"\n");
								jtinfor.append("高数："+highmath+"\n");
								jtinfor.append("大物："+physical+"\n");
								jtinfor.append("大学英语："+highenglish+"\n");
//								jtinfor.append("下学期成绩："+"\n");
								jtinfor.append("算法："+salgorithm+"\n");
								jtinfor.append("数据结构："+datastructure+"\n");
								jtinfor.append("数据库论："+sdatabase+'\n'+"*****"
												+ "****************"+'\n');
							}
						}
						jtinfor.setCaretPosition(0);
						jpl.setOpaque(false);
						this.add(jpl);
						this.validate();
					}else{
						JOptionPane.showMessageDialog(null,"学生档案中不存在该班级的学生，请创建");
						jpl.removeAll();
						jpl.repaint();
						jpl.setOpaque(false);
						this.add(jpl);
						this.validate();
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"数据库操作失败！！！");
				}
			}
		}
		
		if(e.getActionCommand().equals("jbback")){							//返回操作
			try {
				statement.close();
				conR.close();
				dispose();
			} catch (SQLException e1) {
			}
			dispose();
		}
	}
//	public static void main(String[] args){
//		new Statistics_Manage("YC","123");
//	}
}
