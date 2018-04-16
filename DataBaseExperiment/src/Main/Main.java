package Main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Graphical_User_Interface.Choice;
import Graphical_User_Interface.Register;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener,FocusListener{
	
	String account;
	String password;
    String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Databaseproject";// 数据源
    Connection con;							// 连接数据库对象
    Statement stmt;							// 创建SQL命令对象
    
	boolean flag = false;					//标识是否登录
	
	Font font0 = new Font("楷体_GB2312",Font.BOLD+Font.ITALIC,40);
	Font font = new Font("楷体_GB2312",Font.BOLD+Font.ITALIC,25);
	Font font1 = new Font("楷体_GB2312",Font.BOLD+Font.ITALIC,20);
	
	String str = "输入账号";
	
	String path = "C:/Users/yangcheng/workspace/DatabaseExperiment/src"
			+ "/Graphical_User_Interface/背景.png";
	String path1 = "C:/Users/yangcheng/workspace/DatabaseExperiment/src"
			+ "/Graphical_User_Interface/登录.png";
	String path2 = "C:/Users/yangcheng/workspace/DatabaseExperiment/src"
			+ "/Graphical_User_Interface/注销.png";
	String path3 = "C:/Users/yangcheng/workspace/DatabaseExperiment/src"
			+ "/Graphical_User_Interface/注册.png";
	String path4 = "C:/Users/yangcheng/workspace/DatabaseExperiment/src"
			+ "/Graphical_User_Interface/功能选择.png";
	String path5 = "C:/Users/yangcheng/workspace/DatabaseExperiment/src"
			+ "/Graphical_User_Interface/切换用户.png";
	
	JButton JB_log_in = new JButton("");
	JButton JB_log_out = new JButton("");
	JButton JB_change = new JButton("");
	JButton JB_register = new JButton("");
	JButton JB_choice = new JButton("");
	
	JTextField login_act = new JTextField("输入账号");
	JPasswordField login_pwd;
	
	JPanel jp = new JPanel();

	//*******************************************************************************
	public Main(){
		this.setTitle("学籍管理系统");
		this.setSize(500,500);
		this.setLayout(new GridLayout(3,4,10,10));
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon bg = new ImageIcon(path);                        //背景图片
		JLabel label = new JLabel(bg);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel imgP = (JPanel)this.getContentPane();
		imgP.setOpaque(false);
		
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
	      
	    try {
	        Class.forName(JDriver);
	        JOptionPane.showMessageDialog(null,"数据库驱动成功");
	    } catch (ClassNotFoundException e) {
	    	JOptionPane.showMessageDialog(null,"加载数据库引擎失败");
	        System.exit(0);
	    }
		
		this.add(createN());
		this.add(createC());
		this.add(createS());
		
        this.setVisible(true);
		this.setResizable(false);
	}
	
//*******************************************************************************
	public JPanel createN(){
		JPanel jpl = new JPanel();
		jpl.setLayout(new FlowLayout(FlowLayout.CENTER,33,20));
		
		String tit = "   学籍管理系统";
		JLabel lb0 = new JLabel(tit);               			 //标题
		lb0.setFont(font0);
		jpl.add(lb0);
		
		String by = "   By:Dkangel";
		JLabel lb3 = new JLabel(by);             				 //by
		lb3.setFont(font);
		jpl.add(lb3);
		
		jpl.setOpaque(false);
		return jpl;
	}

//*******************************************************************************
	public JPanel createC(){
		jp.setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
		
		JLabel lb1 = new JLabel("账号：");                          //账号框
		lb1.setFont(font);
		login_act = new JTextField(str,15);
		login_act.setFont(font1);
		login_act.addFocusListener(this);
		jp.add(lb1);
		jp.add(login_act);
		
		JLabel lb2 = new JLabel("密码：");                          //密码框
		lb2.setFont(font);
		login_pwd = new JPasswordField(15);
		login_pwd.setFont(font1);
		jp.add(lb2);
		jp.add(login_pwd);
		
		jp.setOpaque(false);
		return jp;
	}
	
//*******************************************************************************	
	public JPanel createS(){
		JPanel jpl = new JPanel();
		jpl.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		
		ImageIcon image_login = new ImageIcon(path1);             //登录按钮
		JB_log_in.setIcon(image_login);
		JB_log_in.setBorderPainted(false);
		JB_log_in.setActionCommand("login");
		JB_log_in.addActionListener(this);
		JB_log_in.setPreferredSize(new Dimension(40,40));
		jpl.add(JB_log_in);
		
		ImageIcon image_choice = new ImageIcon(path4);            //功能选择按钮
		JB_choice.setIcon(image_choice);
		JB_choice.setBorderPainted(false);
		JB_choice.setActionCommand("logchoice");
		JB_choice.addActionListener(this);
		JB_choice.setPreferredSize(new Dimension(40,40));
		jpl.add(JB_choice);
		
		ImageIcon image_change = new ImageIcon(path5);            //切换用户按钮
		JB_change.setIcon(image_change);
		JB_change.setBorderPainted(false);
		JB_change.setActionCommand("logchange");
		JB_change.addActionListener(this);
		JB_change.setPreferredSize(new Dimension(40,40));  
		jpl.add(JB_change);
		
		JButton jbt = new JButton();							 //换行
		jbt.setPreferredSize(new Dimension(500,10));  
		jbt.setBorderPainted(false);
		jbt.setContentAreaFilled(false);
		jpl.add(jbt);
		
		ImageIcon image_register = new ImageIcon(path3);           //注册按钮
		JB_register.setIcon(image_register);
		JB_register.setBorderPainted(false);
		JB_register.setActionCommand("register");
		JB_register.addActionListener(this);
		JB_register.setPreferredSize(new Dimension(40,40));  
		jpl.add(JB_register);
		
		ImageIcon image_logout = new ImageIcon(path2);             //注销按钮
		JB_log_out.setIcon(image_logout);
		JB_log_out.setBorderPainted(false);
		JB_log_out.setActionCommand("logout");
		JB_log_out.addActionListener(this);
		JB_log_out.setPreferredSize(new Dimension(45,45));  
		jpl.add(JB_log_out);
		
		jpl.setOpaque(false);
		return jpl;
	}
	
//*******************************************************************************	
	public void focusGained(FocusEvent arg0){                      //动态实现输入账号
		String content = login_act.getText();
		if(content.equals("输入账号")){
			login_act.setText("");
		}else{
			login_act.setText(content);
		}
	}
	
	public void focusLost(FocusEvent arg0){
		String content = login_act.getText();
		if(!content.equals("输入账号") && content.equals("")){
			login_act.setText(str);
		}else{
			login_act.setText(content);
		}
	}
	
//*******************************************************************************	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("login") && !flag){					  //登录操作
			account = login_act.getText();
			char[] pwd = login_pwd.getPassword();			
			password = new String(pwd);
			
			if(!account.equals("输入账号") && !account.equals("")){
				try {
					con = DriverManager.getConnection(connectDB, account, password);
					
					if(con != null){
						JOptionPane.showMessageDialog(null,"登录成功");
						flag = true;
						jp.removeAll();
						jp.repaint();
						stmt = con.createStatement();
						
						ResultSet rs = stmt.executeQuery("select * from My_Adminstrator");
						
						while (rs.next()) {
							if(rs.getString("Account").equals(account)){
								jp = Display(rs.getString("NAME"));
								break;
				            }
						}
						this.add(jp);
						this.validate();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"数据库连接失败");
				}
			}else{
				JOptionPane.showMessageDialog(null,"账号或密码不能为空!!!");
			}
		}
		
		if(e.getActionCommand().equals("logchoice")){                  //选择功能操作         
			if(flag){
				new Choice(account,password);
			}else{
				JOptionPane.showMessageDialog(null,"还未登录");
			}
		}
		
		if(e.getActionCommand().equals("logchange")){           	 	//切换用户操作     
			if(flag){
				try{
					stmt.close();
					con.close();
					flag = false;
					JOptionPane.showMessageDialog(null,"切换用户成功");
					
					jp.removeAll();
					jp.repaint();
					jp = createC();
					this.add(jp);
					this.validate();
				}catch(Exception ex){
				}
			}else{
				JOptionPane.showMessageDialog(null,"还未登录");
			}
		}
		
		if(e.getActionCommand().equals("register")){  				  //注册
			if(flag){
				new Register(account,password);
			}else{
				JOptionPane.showMessageDialog(null,"还未登录");
			}
		}
		
		if(e.getActionCommand().equals("logout")){  	            	//退出
			try {
				if(flag){
					stmt.close();
					con.close();
				}
				dispose();
				System.exit(0);
			} catch (SQLException e1) {
			}
		}
	}
	
	public JPanel Display(String str){
		jp.setLayout(new GridLayout(2,1,1,5));
		
		String tit = "           W e l c o m e";
		JLabel lb0 = new JLabel(tit);               	 
		lb0.setFont(font0);
		jp.add(lb0);
		
		JLabel lb3 = new JLabel("                       name：" + str);             		 
		lb3.setFont(font);
		jp.add(lb3);
		
		jp.setOpaque(false);
		return jp;
	}
	
	public static void main(String[] args){
		new Main();
	}
}
