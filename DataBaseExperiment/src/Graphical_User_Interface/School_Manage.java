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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class School_Manage extends JFrame implements ActionListener{
	String account;
	String password;
	String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Databaseproject"; //数据源
	String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	//SQL数据库引擎
	Connection conR;
    Statement statement;
	
	Font font0 = new Font("楷体_GB2312",Font.BOLD+Font.ITALIC,40);
	Font fontjb = new Font("楷体_GB2312",Font.BOLD,15);
	Font fontarea = new Font("楷体_GB2312",Font.BOLD,25);
	Font fontjt = new Font("楷体_GB2312",Font.BOLD,20);
	
	String path = "C:/Users/yangcheng/workspace/DatabaseExperiment/src"
			+ "/Graphical_User_Interface/背景.png";
	Font font = new Font("楷体_GB2312",Font.BOLD+Font.ITALIC,20);
	
	JPanel jpl = new JPanel(null);
	
	JButton JB_add = new JButton("录入");
	JButton JB_change = new JButton("修改");
	JButton JB_search = new JButton("查询");
	JButton JB_display = new JButton("输出");
	JButton JB_back = new JButton("返回");
	
	JRadioButton jrbmilifalse;
	JRadioButton jrbmilitrue;
	JTextField jtid;													//学号
	JTextField jtawardtext;												//奖学金
	JTextField jtloantext;												//贷款
	JRadioButton jrbregtrue;
	JRadioButton jrbregfalse;
	JTextField jtunusualtext;											//异动情况
	JTextField jtmilitarytext;											//军训情况
	JTextField jtgraduationtext;										//是否毕业
	JRadioButton jrbgradfalse;
	JRadioButton jrbgradtrue;

	JScrollPane jsinfor;
	JTextArea jtinfor;
	
	int snum; String strnum;
	String saward;
	String sloan;
	String sregister;													
	String sunusual;													
	String smilitary;													
	String sgraduation;	
	
	boolean flag_add = false;
	boolean flag_change = false;
	boolean flag_search = false;
	boolean flag_display = false;
	
	public School_Manage(String ac, String pw){
		this.setTitle("学籍管理系统");	
		this.setSize(516 , 530);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		this.setLocationRelativeTo(null);
		
		account = ac;
		password = pw;
		try {
	        Class.forName(JDriver);
	        conR = DriverManager.getConnection(connectDB, account, password);
	        statement = conR.createStatement();
	    } catch (ClassNotFoundException | SQLException e) {
	    	dispose();
	    }
		
		ImageIcon bg = new ImageIcon(path);                            //背景图片
		JLabel label = new JLabel(bg);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel imgP = (JPanel)this.getContentPane();
		imgP.setOpaque(false);
		
		JLabel lb0 = new JLabel("学生学籍管理");                           //标题
		lb0.setFont(font0);
		this.add(lb0);
		
		JButton jbt = new JButton();							 		//换行
		jbt.setPreferredSize(new Dimension(400,1));  
		jbt.setBorderPainted(false);
		jbt.setContentAreaFilled(false);
		this.add(jbt);
		
		JB_add.setBorderPainted(false);									//录入
		JB_add.setActionCommand("jbadd");
		JB_add.addActionListener(this);
		JB_add.setFont(fontjb);
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
		jpl.setLayout(new FlowLayout(FlowLayout.CENTER,30,5));
		jpl.setPreferredSize(new Dimension(516, 530));
		
		//学号****************************************
		JLabel lbid = new JLabel("学号：");   							//学号
		lbid.setFont(fontjt);
		jtid = new JTextField(5);
		jtid.setFont(fontjb);
		jpl.add(lbid);
		jpl.add(jtid);
		
		//换行
		JButton jbt6 = new JButton();		
		jbt6.setPreferredSize(new Dimension(400,0));  
		jbt6.setBorderPainted(false);
		jbt6.setContentAreaFilled(false);
		jpl.add(jbt6);
		//奖学金***************************************
		JLabel lbaward = new JLabel("奖学金：");   
		lbaward.setFont(fontjt);
		jpl.add(lbaward);
		
		ButtonGroup bgaward = new ButtonGroup();
		
		JRadioButton jrbawardfalse = new JRadioButton("无",false);
		jrbawardfalse.setFont(fontjt);
		jrbawardfalse.setContentAreaFilled(false);
		jrbawardfalse.setActionCommand("awardfalse");
		jrbawardfalse.addActionListener(this);
		jpl.add(jrbawardfalse);
		
		JRadioButton jrbawardtrue = new JRadioButton("有",false);
		jrbawardtrue.setFont(fontjt);
		jrbawardtrue.setContentAreaFilled(false);
		jrbawardtrue.setActionCommand("awardtrue");
		jrbawardtrue.addActionListener(this);
		jpl.add(jrbawardtrue);
		
		jtawardtext = new JTextField(5);
		jtawardtext.setFont(fontjb);
		jpl.add(jtawardtext);
		
		bgaward.add(jrbawardtrue);
		bgaward.add(jrbawardfalse);
		
		//换行
		JButton jbt = new JButton();		
		jbt.setPreferredSize(new Dimension(400,0));  
		jbt.setBorderPainted(false);
		jbt.setContentAreaFilled(false);
		jpl.add(jbt);
		
		//贷款***************************************
		JLabel lbloan = new JLabel("贷款：");   
		lbloan.setFont(fontjt);
		jpl.add(lbloan);
		
		ButtonGroup bgloan = new ButtonGroup();
		
		JRadioButton jrbloanfalse = new JRadioButton("无",false);
		jrbloanfalse.setFont(fontjt);
		jrbloanfalse.setContentAreaFilled(false);
		jrbloanfalse.setActionCommand("loanfalse");
		jrbloanfalse.addActionListener(this);
		jpl.add(jrbloanfalse);
		
		JRadioButton jrbloantrue = new JRadioButton("有",false);
		jrbloantrue.setFont(fontjt);
		jrbloantrue.setContentAreaFilled(false);
		jrbloantrue.setActionCommand("loantrue");
		jrbloantrue.addActionListener(this);
		jpl.add(jrbloantrue);
		
		jtloantext = new JTextField(5);
		jtloantext.setFont(fontjb);
		jpl.add(jtloantext);
		
		bgloan.add(jrbloantrue);
		bgloan.add(jrbloanfalse);
		
		//换行
		JButton jbt5 = new JButton();		
		jbt5.setPreferredSize(new Dimension(400,0));  
		jbt5.setBorderPainted(false);
		jbt5.setContentAreaFilled(false);
		jpl.add(jbt5);
		
		//注册情况***************************************
		JLabel lbregister = new JLabel("注册情况：");   
		lbregister.setFont(fontjt);
		jpl.add(lbregister);
		
		ButtonGroup bgregister = new ButtonGroup();
		
		jrbregtrue = new JRadioButton("是",false);
		jrbregtrue.setFont(fontjt);
		jrbregtrue.setContentAreaFilled(false);
		jrbregtrue.setActionCommand("registertrue");
		jrbregtrue.addActionListener(this);
		jpl.add(jrbregtrue);
		
		jrbregfalse = new JRadioButton("否",false);
		jrbregfalse.setFont(fontjt);
		jrbregfalse.setContentAreaFilled(false);
		jrbregfalse.setActionCommand("registerfalse");
		jrbregfalse.addActionListener(this);
		jpl.add(jrbregfalse);
		
		bgregister.add(jrbregtrue);
		bgregister.add(jrbregfalse);
		
		//换行
		JButton jbt1 = new JButton();							 		
		jbt1.setPreferredSize(new Dimension(400,0));  
		jbt1.setBorderPainted(false);
		jbt1.setContentAreaFilled(false);
		jpl.add(jbt1);
		
		//异动情况***************************************
		JLabel lbunusual = new JLabel("异动情况：");
		lbunusual.setFont(fontjt);
		jpl.add(lbunusual);
		
		ButtonGroup bgunusual = new ButtonGroup();
		
		JRadioButton jrbunfalse = new JRadioButton("无",false);
		jrbunfalse.setFont(fontjt);
		jrbunfalse.setContentAreaFilled(false);
		jrbunfalse.setActionCommand("unusualfalse");
		jrbunfalse.addActionListener(this);
		jpl.add(jrbunfalse);
		
		JRadioButton jrbuntrue = new JRadioButton("有",false);
		jrbuntrue.setFont(fontjt);
		jrbuntrue.setContentAreaFilled(false);
		jrbuntrue.setActionCommand("unusualtrue");
		jrbuntrue.addActionListener(this);
		jpl.add(jrbuntrue);
		
		jtunusualtext = new JTextField(5);
		jtunusualtext.setFont(fontjb);
		jpl.add(jtunusualtext);
		
		bgunusual.add(jrbuntrue);
		bgunusual.add(jrbunfalse);
		
		//换行
		JButton jbt2 = new JButton();							 		
		jbt2.setPreferredSize(new Dimension(400,0));  
		jbt2.setBorderPainted(false);
		jbt2.setContentAreaFilled(false);
		jpl.add(jbt2);
		
		//军训情况***************************************
		JLabel lbmilitary = new JLabel("军训情况：");
		lbmilitary.setFont(fontjt);
		jpl.add(lbmilitary);
		
		ButtonGroup bgmilitary = new ButtonGroup();
		
		jrbmilifalse = new JRadioButton("无",false);
		jrbmilifalse.setFont(fontjt);
		jrbmilifalse.setContentAreaFilled(false);
		jrbmilifalse.setActionCommand("militaryfalse");
		jrbmilifalse.addActionListener(this);
		jpl.add(jrbmilifalse);
		
		jrbmilitrue = new JRadioButton("有",false);
		jrbmilitrue.setFont(fontjt);
		jrbmilitrue.setContentAreaFilled(false);
		jrbmilitrue.setActionCommand("militarytrue");
		jrbmilitrue.addActionListener(this);
		jpl.add(jrbmilitrue);
		
		jtmilitarytext = new JTextField(5);
		jtmilitarytext.setFont(fontjb);
		jpl.add(jtmilitarytext);
		
		bgmilitary.add(jrbmilifalse);
		bgmilitary.add(jrbmilitrue);
		
		//换行
		JButton jbt3 = new JButton();							 		
		jbt3.setPreferredSize(new Dimension(400,0));  
		jbt3.setBorderPainted(false);
		jbt3.setContentAreaFilled(false);
		jpl.add(jbt3);
		
		//毕业情况***************************************
		JLabel lbgraduation = new JLabel("毕业情况：");   
		lbgraduation.setFont(fontjt);
		jpl.add(lbgraduation);
		
		ButtonGroup bggraduation = new ButtonGroup();
		
		jrbgradfalse = new JRadioButton("否",false);
		jrbgradfalse.setFont(fontjt);
		jrbgradfalse.setContentAreaFilled(false);
		jrbgradfalse.setActionCommand("graduationfalse");
		jrbgradfalse.addActionListener(this);
		jpl.add(jrbgradfalse);
		
		jrbgradtrue = new JRadioButton("是",false);
		jrbgradtrue.setFont(fontjt);
		jrbgradtrue.setContentAreaFilled(false);
		jrbgradtrue.setActionCommand("graduationtrue");
		jrbgradtrue.addActionListener(this);
		jpl.add(jrbgradtrue);
		
		bggraduation.add(jrbgradfalse);
		bggraduation.add(jrbgradtrue);
		
		//换行
		JButton jbt4 = new JButton();							 		
		jbt4.setPreferredSize(new Dimension(400,0));  
		jbt4.setBorderPainted(false);
		jbt4.setContentAreaFilled(false);
		jpl.add(jbt4);
		
		if(flag_add || flag_change){
			JButton JB_sure = new JButton("确定");
			JB_sure.setBorderPainted(false);								//确定
			JB_sure.setActionCommand("jbSsure");
			JB_sure.addActionListener(this);
			JB_sure.setFont(fontjb);
			jpl.add(JB_sure);
		}
		
		return jpl;
	}
	
	public JPanel createChange(){										//修改界面
		jpl = createAdd();
		jtid.setText(strnum);
		jtawardtext.setText(saward);
		jtloantext.setText(sloan);
		if(sregister.equals("是")){
			jrbregtrue.setSelected(true);
		}else{
			jrbregfalse.setSelected(true);
		}
		jtunusualtext.setText(sunusual);
		jtmilitarytext.setText(smilitary);
		if(sgraduation.equals("是")){
			jrbgradtrue.setSelected(true);
		}else{
			jrbgradfalse.setSelected(true);
		}
		
		return jpl;
	}
	
	public JPanel createSearch(){										//查询界面
		jpl = createAdd();
		jtid.setText(strnum);
		jtawardtext.setText(saward);
		jtloantext.setText(sloan);
		if(sregister.equals("是")){
			jrbregtrue.setSelected(true);
		}else{
			jrbregfalse.setSelected(true);
		}
		jtunusualtext.setText(sunusual);
		jtmilitarytext.setText(smilitary);
		if(sgraduation.equals("是")){
			jrbgradtrue.setSelected(true);
		}else{
			jrbgradfalse.setSelected(true);
		}
		
		return jpl;
	}
	
	public JPanel createDisplay(){										//输出界面
		jpl.setLayout(new FlowLayout(FlowLayout.CENTER,30,5));
		jpl.setPreferredSize(new Dimension(516, 530));
		
		JLabel lbinfor = new JLabel("学生学籍表全部信息：");
		lbinfor.setFont(fontarea);
		jpl.add(lbinfor);
		
		JButton jbt = new JButton();							 		//换行
		jbt.setPreferredSize(new Dimension(400,0));  
		jbt.setBorderPainted(false);
		jbt.setContentAreaFilled(false);
		jpl.add(jbt);
		
		jtinfor = new JTextArea(15,40);
		jtinfor.setFont(fontjb);
		jtinfor.setText("学生学籍信息如下：\n");
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
					ResultSet result_snum = statement.executeQuery("select snum from School_Manage");
					while (result_snum.next()) {
						int num = Integer.valueOf(result_snum.getString("snum")).intValue();
						if(num == snum){
							flag = true;
							break;
			            }
					}
					if(flag){
						ResultSet result_snum_infor = statement.executeQuery("select * "
													+"from School_Manage where snum = '"+snum+"'");
						while(result_snum_infor.next()){
							saward = result_snum_infor.getString("saward");
							sloan = result_snum_infor.getString("sloan");
							sregister = result_snum_infor.getString("sregister");
							sunusual = result_snum_infor.getString("sunusual");
							smilitary = result_snum_infor.getString("smilitary");
							sgraduation = result_snum_infor.getString("sgraduation");
						}
						jpl.removeAll();
						jpl.repaint();
						
						jpl = createChange();
						
						jpl.setOpaque(false);
						this.add(jpl);
						this.validate();
					}else{
						JOptionPane.showMessageDialog(null,"学生档案信息不存在，请创建");
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
					ResultSet result_snum = statement.executeQuery("select * from School_Manage");
					while (result_snum.next()) {
						int num = Integer.valueOf(result_snum.getString("snum")).intValue();
						if(num == snum){
							flag = true;
							break;
			            }
					}
					if(flag){
						ResultSet result_snum_infor = statement.executeQuery("select * "
													+"from School_Manage where snum = '"+snum+"'");
						while(result_snum_infor.next()){
							saward = result_snum_infor.getString("saward");
							sloan = result_snum_infor.getString("sloan");
							sregister = result_snum_infor.getString("sregister");
							sunusual = result_snum_infor.getString("sunusual");
							smilitary = result_snum_infor.getString("smilitary");
							sgraduation = result_snum_infor.getString("sgraduation");
						}
						jpl.removeAll();
						jpl.repaint();
						jpl = createSearch();
						jpl.setOpaque(false);
						this.add(jpl);
						this.validate();
					}else{
						JOptionPane.showMessageDialog(null,"学生学籍信息不存在，请创建");
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
				ResultSet result_infor_exist = statement.executeQuery("select * from School_Manage order by snum");
				while (result_infor_exist.next()) {
					flag = true;
					break;
				}
				
				if(flag){
					jpl.removeAll();
					jpl.repaint();
					jpl = createDisplay();
					ResultSet result_infor = statement.executeQuery("select * from School_Manage order by snum");
					while(result_infor.next()){
						strnum = result_infor.getString("snum");
						saward = result_infor.getString("saward");
						sloan = result_infor.getString("sloan");
						sregister = result_infor.getString("sregister");
						sunusual = result_infor.getString("sunusual");
						smilitary = result_infor.getString("smilitary");
						sgraduation = result_infor.getString("sgraduation");
						
						jtinfor.append("学号："+strnum+"\n");
						jtinfor.append("奖学金："+saward+"\n");
						jtinfor.append("贷款："+sloan+"\n");
						jtinfor.append("注册情况："+sregister+"\n");
						jtinfor.append("异动情况："+sunusual+"\n");
						jtinfor.append("军训情况："+smilitary+"\n");
						jtinfor.append("是否毕业："+sgraduation+'\n'+"*****"
										+ "****************"+'\n');
					}
					jpl.setOpaque(false);
					this.add(jpl);
					this.validate();
				}else{
					JOptionPane.showMessageDialog(null,"学生档案表中没有信息！！！");
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
		
		if(e.getActionCommand().equals("awardfalse")){					//奖学金
			jtawardtext.setText("无");
		}
		if(e.getActionCommand().equals("awardtrue")){					
			jtawardtext.setText("具体内容：");
		}
		
		if(e.getActionCommand().equals("loanfalse")){					//贷款
			jtloantext.setText("无");
		}
		if(e.getActionCommand().equals("loantrue")){					
			jtloantext.setText("具体内容：");
		}
		
		if(e.getActionCommand().equals("registerfalse")){				//注册情况
			sregister = "否";
		}
		if(e.getActionCommand().equals("registertrue")){	
			sregister = "是";
		}
		
		if(e.getActionCommand().equals("unusualfalse")){				//异动情况
			jtunusualtext.setText("无");
		}
		if(e.getActionCommand().equals("unusualtrue")){
			jtunusualtext.setText("具体情况：");
		}
		
		if(e.getActionCommand().equals("militaryfalse")){				//军训情况
			jtmilitarytext.setText("无");
		}
		if(e.getActionCommand().equals("militarytrue")){	
			jtmilitarytext.setText("成绩：");
		}
		
		if(e.getActionCommand().equals("graduationfalse")){				//是否毕业
			sgraduation = "否";
		}
		if(e.getActionCommand().equals("graduationtrue")){	
			sgraduation = "是";
		}
		
		if(e.getActionCommand().equals("jbSsure")){								//确定操作
			boolean exit_R = false;
			boolean exit_S = true;
			
			if(jtid.getText().equals("")){
				JOptionPane.showMessageDialog(null,"学号不能为空！！！");
			}else{
				try{
					snum = Integer.valueOf(jtid.getText()).intValue();
					saward = jtawardtext.getText();
					sloan = jtloantext.getText();
					sunusual = jtunusualtext.getText();
					smilitary = jtmilitarytext.getText();
//					if(saward.equals("")||sloan.equals("")||sunusual.equals("")||smilitary.equals("")){
					String insert = "insert into School_Manage values('"+snum+"','"+saward+"','"+sloan+"','"
							+sregister+"','"+sunusual+"','"+smilitary+"','"+sgraduation+"')";
					if(flag_add){
						ResultSet result_snum_R = statement.executeQuery("select snum from Record_Manage");
						while (result_snum_R.next()){
							int num_R = Integer.valueOf(result_snum_R.getString("snum")).intValue();
							if(snum == num_R){
								exit_R = true;
								break;
				            }
						}
						if(exit_R){
							ResultSet result_snum_S = statement.executeQuery("select snum from School_Manage");
							while (result_snum_S.next()) {
								int num_S = Integer.valueOf(result_snum_S.getString("snum")).intValue();
								if(snum == num_S){
									exit_S = false;
									break;
					            }
							}
							if(exit_S){
								statement.executeUpdate(insert);
								JOptionPane.showMessageDialog(null,"录入成功！！！");
							}else{
								JOptionPane.showMessageDialog(null,"学生学籍信息存在，无法重新录入！！！");
							}
						}else{
							JOptionPane.showMessageDialog(null,"学生档案中不存在该学生，无法录入学籍信息！！！");
						}
					}
					if(flag_change){
						String delete = "delete from School_Manage where snum = '"+snum+"'";
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
//		new School_Manage("YC","123");
//	}
}
