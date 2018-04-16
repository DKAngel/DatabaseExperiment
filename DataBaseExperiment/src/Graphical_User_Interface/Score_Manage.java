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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Score_Manage extends JFrame implements ActionListener{
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
	
	String path = "C:/Users/yangcheng/workspace/DatabaseExperiment/src"
			+ "/Graphical_User_Interface/背景.png";
	Font font = new Font("楷体_GB2312",Font.BOLD+Font.ITALIC,20);
	
	JPanel jpl = new JPanel(null);
	
	JButton JB_back = new JButton("返回");
	JButton JB_add = new JButton("录入");
	JButton JB_change = new JButton("修改");
	JButton JB_search = new JButton("查询");
	JButton JB_display = new JButton("输出");
	
	JTextField jtid;
	JTextField jtchinese;
	JTextField jtmath;
	JTextField jtenglish;
	
	JTextField jthighmath;
	JTextField jtphysics;
	JTextField jthighenglish;
	
	JTextField jtalgorithm;
	JTextField jtdatastructure;
	JTextField jtdatabase;
	
	int snum; String strnum;
	float chinese; 
	float math;	
	float english;	
	float highmath;	
	float physical;	
	float highenglish;
	float salgorithm;	
	float datastructure;	
	float sdatabase;	
	
	JScrollPane jsinfor;
	JTextArea jtinfor;
	
	boolean flag_add = false;
	boolean flag_change = false;
	boolean flag_search = false;
	boolean flag_display = false;
	
	public Score_Manage(String ac, String pw){
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
		
		ImageIcon bg = new ImageIcon(path);                            //背景图片
		JLabel label = new JLabel(bg);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel imgP = (JPanel)this.getContentPane();
		imgP.setOpaque(false);
		
		JLabel lb0 = new JLabel("学生成绩管理");                           //标题
		lb0.setFont(font0);
		this.add(lb0);
		
		JButton jbt = new JButton();							 		//换行
		jbt.setPreferredSize(new Dimension(400,1));  
		jbt.setBorderPainted(false);
		jbt.setContentAreaFilled(false);
		this.add(jbt);
		
		JB_add.setBorderPainted(false);									//录入
		JB_add.setFont(fontjb);
		JB_add.setActionCommand("jbadd");
		JB_add.addActionListener(this);
		this.add(JB_add);
		
		JB_change.setBorderPainted(false);								//修改
		JB_change.setActionCommand("jbchange");
		JB_change.addActionListener(this);
		JB_change.setFont(fontjb);
		this.add(JB_change);
		
		JB_search.setBorderPainted(false);								//查询
		JB_search.setActionCommand("jbsearch");
		JB_search.addActionListener(this);
		JB_search.setFont(fontjb);
		this.add(JB_search);
		
		JB_display.setBorderPainted(false);								//输出
		JB_display.setActionCommand("jbdisplay");
		JB_display.addActionListener(this);
		JB_display.setFont(fontjb);
		this.add(JB_display);
		
		JB_back.setBorderPainted(false);								//返回
		JB_back.setActionCommand("jbback");
		JB_back.addActionListener(this);
		JB_back.setFont(fontjb);
		this.add(JB_back);
		
		JButton jbt1 = new JButton();							 		//换行
		jbt1.setPreferredSize(new Dimension(400,0));  
		jbt1.setBorderPainted(false);
		jbt1.setContentAreaFilled(false);
		this.add(jbt1);
		
		this.setVisible(true);
		this.setResizable(false);
	}

//***********************************************************************
	public JPanel createAdd(){											//录入界面
		
		jpl.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		jpl.setPreferredSize(new Dimension(516, 530));
		
		//学号***************************************
		JLabel lbid = new JLabel("学生学号：");   
		lbid.setFont(fontjt);
		jpl.add(lbid);
		
		jtid = new JTextField(5);
		jtid.setFont(fontjt);
		jpl.add(jtid);
		
		//换行
		JButton jbt8 = new JButton();							 		
		jbt8.setPreferredSize(new Dimension(400,0));  
		jbt8.setBorderPainted(false);
		jbt8.setContentAreaFilled(false);
		jpl.add(jbt8);
		
		//入学成绩***************************************
		JLabel lbenterscore = new JLabel("入学成绩：              ");
		lbenterscore.setFont(fontjt);
		jpl.add(lbenterscore);
		
		//上学期成绩***************************************
		JLabel lblastscore = new JLabel("      上学期成绩：");   
		lblastscore.setFont(fontjt);
		jpl.add(lblastscore);
		
		//换行
		JButton jbt = new JButton();							 		
		jbt.setPreferredSize(new Dimension(400,0));  
		jbt.setBorderPainted(false);
		jbt.setContentAreaFilled(false);
		jpl.add(jbt);
		
		//语文
		JLabel lbchinesescore = new JLabel("语文成绩：");
		lbchinesescore.setFont(fontjt);
		jpl.add(lbchinesescore);
		
		jtchinese = new JTextField(5);
		jtchinese.setFont(fontjt);
		jpl.add(jtchinese);
		
		//高数
		JLabel lbhighmath = new JLabel("高数成绩：");
		lbhighmath.setFont(fontjt);
		jpl.add(lbhighmath);
		
		jthighmath = new JTextField(5);
		jthighmath.setFont(fontjt);
		jpl.add(jthighmath);
		
		//换行
		JButton jbt1 = new JButton();							 		
		jbt1.setPreferredSize(new Dimension(400,0));  
		jbt1.setBorderPainted(false);
		jbt1.setContentAreaFilled(false);
		jpl.add(jbt1);
		
		//数学
		JLabel lbmathscore = new JLabel("数学成绩：");
		lbmathscore.setFont(fontjt);
		jpl.add(lbmathscore);
		
		jtmath = new JTextField(5);
		jtmath.setFont(fontjt);
		jpl.add(jtmath);
		
		//大物
		JLabel lbphysics = new JLabel("大物成绩：");
		lbphysics.setFont(fontjt);
		jpl.add(lbphysics);
		
		jtphysics = new JTextField(5);
		jtphysics.setFont(fontjt);
		jpl.add(jtphysics);
		
		//换行
		JButton jbt2 = new JButton();							 		
		jbt2.setPreferredSize(new Dimension(400,0));  
		jbt2.setBorderPainted(false);
		jbt2.setContentAreaFilled(false);
		jpl.add(jbt2);
		
		//英语
		JLabel lbenglishscore = new JLabel("英语成绩：");
		lbenglishscore.setFont(fontjt);
		jpl.add(lbenglishscore);
		
		jtenglish = new JTextField(5);
		jtenglish.setFont(fontjt);
		jpl.add(jtenglish);
		
		//英语
		JLabel lbhighenligh = new JLabel("英语成绩：");
		lbhighenligh.setFont(fontjt);
		jpl.add(lbhighenligh);
		
		jthighenglish = new JTextField(5);
		jthighenglish.setFont(fontjt);
		jpl.add(jthighenglish);
		
		//换行
		JButton jbt3 = new JButton();							 		
		jbt3.setPreferredSize(new Dimension(400,0));  
		jbt3.setBorderPainted(false);
		jbt3.setContentAreaFilled(false);
		jpl.add(jbt3);
		
		//上学期成绩***************************************
		JLabel lbnextscore = new JLabel("下学期成绩：");   
		lbnextscore.setFont(fontjt);
		jpl.add(lbnextscore);
		
		//换行
		JButton jbt4 = new JButton();							 		
		jbt4.setPreferredSize(new Dimension(400,0));  
		jbt4.setBorderPainted(false);
		jbt4.setContentAreaFilled(false);
		jpl.add(jbt4);
		
		//算法
		JLabel lbalgorithm = new JLabel("算法成绩：");
		lbalgorithm.setFont(fontjt);
		jpl.add(lbalgorithm);
		
		jtalgorithm = new JTextField(5);
		jtalgorithm.setFont(fontjt);
		jpl.add(jtalgorithm);
		
		//换行
		JButton jbt5 = new JButton();							 		
		jbt5.setPreferredSize(new Dimension(400,0));  
		jbt5.setBorderPainted(false);
		jbt5.setContentAreaFilled(false);
		jpl.add(jbt5);
		
		//数据结构
		JLabel lbdatastructure = new JLabel("数据结构：");
		lbdatastructure.setFont(fontjt);
		jpl.add(lbdatastructure);
		
		jtdatastructure = new JTextField(5);
		jtdatastructure.setFont(fontjt);
		jpl.add(jtdatastructure);
		
		
		JButton jbt7 = new JButton();							 		
		jbt7.setPreferredSize(new Dimension(45,1));  
		jbt7.setBorderPainted(false);
		jbt7.setContentAreaFilled(false);
		jpl.add(jbt7);
		
		//确定按钮
		if(flag_add || flag_change){
			JButton JB_sure = new JButton("确定");
			JB_sure.setBorderPainted(false);								
			JB_sure.setActionCommand("jbsure");
			JB_sure.addActionListener(this);
			JB_sure.setFont(fontjb);
			jpl.add(JB_sure);
		}
				
		//换行
		JButton jbt6 = new JButton();							 		
		jbt6.setPreferredSize(new Dimension(400,0));  
		jbt6.setBorderPainted(false);
		jbt6.setContentAreaFilled(false);
		jpl.add(jbt6);
		
		//数据库
		JLabel lbdatabase = new JLabel("数据库论：");
		lbdatabase.setFont(fontjt);
		jpl.add(lbdatabase);
		
		jtdatabase = new JTextField(5);
		jtdatabase.setFont(fontjt);
		jpl.add(jtdatabase);
		
		return jpl;
	}
	
	public JPanel createChange(){										//修改界面
		jpl = createAdd();
		
		jtid.setText(strnum);
		jtchinese.setText(chinese+"");
		jtmath.setText(math+"");
		jtenglish.setText(english+"");
		jthighmath.setText(highmath+"");
		jtphysics.setText(physical+"");
		jthighenglish.setText(highenglish+"");
		jtalgorithm.setText(salgorithm+"");
		jtdatastructure.setText(datastructure+"");
		jtdatabase.setText(sdatabase+"");
		
		return jpl;
	}
	
	public JPanel createSearch(){										//查询界面
		jpl = createAdd();
		jtid.setText(strnum);
		jtchinese.setText(chinese+"");
		jtmath.setText(math+"");
		jtenglish.setText(english+"");
		jthighmath.setText(highmath+"");
		jtphysics.setText(physical+"");
		jthighenglish.setText(highenglish+"");
		jtalgorithm.setText(salgorithm+"");
		jtdatastructure.setText(datastructure+"");
		jtdatabase.setText(sdatabase+"");
		
		return jpl;
	}
	
	public JPanel createDisplay(){										//输出界面
		jpl.setLayout(new FlowLayout(FlowLayout.CENTER,30,5));
		jpl.setPreferredSize(new Dimension(516, 530));
		
		JLabel lbinfor = new JLabel("学生成绩表全部信息：");
		lbinfor.setFont(fontarea);
		jpl.add(lbinfor);
		
		JButton jbt = new JButton();							 		//换行
		jbt.setPreferredSize(new Dimension(400,0));  
		jbt.setBorderPainted(false);
		jbt.setContentAreaFilled(false);
		jpl.add(jbt);
		
		jtinfor = new JTextArea(15,40);
		jtinfor.setFont(fontjb);
		jtinfor.setText("学生成绩信息如下：\n");
		jtinfor.setCaretPosition(0);
		
		jsinfor = new JScrollPane(jtinfor);
		jpl.add(jsinfor);
		
		return jpl;
	}
//***********************************************************************	
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("jbadd")){						//录入操作
			flag_add = true;
			flag_change = false;
			flag_search = false;
			flag_display = false;
			
			jpl.removeAll();
			jpl.repaint();
			
			jpl = createAdd();
			
			jpl.setOpaque(false);
			this.add(jpl);
			this.validate();
		}
		
		if(e.getActionCommand().equals("jbchange")){					//修改操作
			flag_add = false;
			flag_change = true;
			flag_search = false;
			flag_display = false;
			
			strnum = JOptionPane.showInputDialog("输入要更新的学号：");
			boolean flag = false;
			if(strnum.equals("")){
				JOptionPane.showMessageDialog(null,"学号不能为空！！！");
			}else{
				snum = Integer.valueOf(strnum).intValue();
				try {
					ResultSet result_snum_score = statement.executeQuery("select snum from Score_Manage");
					while (result_snum_score.next()) {
						int num = Integer.valueOf(result_snum_score.getString("snum")).intValue();
						if(num == snum){
							flag = true;
							break;
			            }
					}
					if(flag){
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
						}
						jpl.removeAll();
						jpl.repaint();
						
						jpl = createChange();
						
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
					JOptionPane.showMessageDialog(null,"操作失败！！！");
				}
			}
		}
		
		if(e.getActionCommand().equals("jbsearch")){					//查找操作
			flag_add = false;
			flag_change = false;
			flag_search = true;
			flag_display = false;
			
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
						}
						jpl.removeAll();
						jpl.repaint();
						jpl = createSearch();
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
		
		if(e.getActionCommand().equals("jbdisplay")){					//输出操作
			flag_add = false;
			flag_change = false;
			flag_search = false;
			flag_display = true;
			
			boolean flag = false;
			try {
				ResultSet result_infor_exist = statement.executeQuery("select * from Score_Manage order by snum");
				while (result_infor_exist.next()) {
					flag = true;
					break;
				}
				
				if(flag){
					jpl.removeAll();
					jpl.repaint();
					jpl = createDisplay();
					ResultSet result_infor = statement.executeQuery("select * from Score_Manage order by snum");
					while(result_infor.next()){
						strnum = result_infor.getString("snum");
						
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
						jtinfor.append("入学成绩："+"\n");
						jtinfor.append("语文："+chinese+"\n");
						jtinfor.append("数学："+math+"\n");
						jtinfor.append("英语："+english+"\n");
						jtinfor.append("上学期成绩："+"\n");
						jtinfor.append("高数："+highmath+"\n");
						jtinfor.append("大物："+physical+"\n");
						jtinfor.append("大学英语："+highenglish+"\n");
						jtinfor.append("下学期成绩："+"\n");
						jtinfor.append("算法："+salgorithm+"\n");
						jtinfor.append("数据结构："+datastructure+"\n");
						jtinfor.append("数据库论："+sdatabase+'\n'+"*****"
										+ "****************"+'\n');
					}
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
		
		if(e.getActionCommand().equals("jbback")){						//返回操作
			try {
				statement.close();
				conR.close();
				dispose();
			} catch (SQLException e1) {
			}
			dispose();
		}
		
		if(e.getActionCommand().equals("jbsure")){						//确定操作
			boolean exist_R = false;
			boolean exist_Score = true;
			
			if(jtid.getText().equals("")){
				JOptionPane.showMessageDialog(null,"学号不能为空！！！");
			}else{
				try{
					snum = Integer.valueOf(jtid.getText()).intValue();
					chinese = Float.parseFloat(jtchinese.getText());
					math = Float.parseFloat(jtmath.getText());
					english = Float.parseFloat(jtenglish.getText());
					highmath = Float.parseFloat(jthighmath.getText());
					physical = Float.parseFloat(jtphysics.getText());
					highenglish = Float.parseFloat(jthighenglish.getText());
					salgorithm = Float.parseFloat(jtalgorithm.getText());
					datastructure = Float.parseFloat(jtdatastructure.getText());
					sdatabase = Float.parseFloat(jtdatabase.getText());
					
					String insert = "insert into Score_Manage values('"+snum+"','"+chinese+"','"+math+"','"
							+english+"','"+highmath+"','"+physical+"','"+highenglish+"','"+salgorithm+"','"
							+datastructure+"','"+sdatabase+"')";
					
					if(flag_add){
						ResultSet result_snum_R = statement.executeQuery("select snum from Record_Manage");
						while (result_snum_R.next()){
							int num_R = Integer.valueOf(result_snum_R.getString("snum")).intValue();
							if(snum == num_R){
								exist_R = true;
								break;
				            }
						}
						if(exist_R){
							ResultSet result_snum_Score = statement.executeQuery("select snum from Score_Manage");
							while (result_snum_Score.next()) {
								int num_Score = Integer.valueOf(result_snum_Score.getString("snum")).intValue();
								if(snum == num_Score){
									exist_Score = false;
									break;
					            }
							}
							if(exist_Score){
								statement.executeUpdate(insert);
								JOptionPane.showMessageDialog(null,"录入成功！！！");
							}else{
								JOptionPane.showMessageDialog(null,"已存在成绩信息，不需要重新录入");
							}
						}else{
							JOptionPane.showMessageDialog(null,"学生档案中不存在该学生，无法录入学籍信息");
						}
					}
					
					if(flag_change){
						String delete = "delete from Score_Manage where snum = '"+snum+"'";
						statement.executeUpdate(delete);
						statement.executeUpdate(insert);
						JOptionPane.showMessageDialog(null,"修改成功！！！");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"数据库操作失败！！！");
				}
			}
		}
	}
//	public static void main(String[] args){
//		new Score_Manage("YC","123");
//	}
}
