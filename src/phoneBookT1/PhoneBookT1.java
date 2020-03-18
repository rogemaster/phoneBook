package phoneBookT1;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import phoneBookMap.Employee;

public class PhoneBookT1 {

	JFrame mainFrame;
	JPanel mainPanel;
	JTextArea menuText;
	JTextArea viewText;
	JTextField inputField;
	JLabel label;
	
	Map<String, Employee> maplist;
	Employee emp;
	
	static int MODE;
	
	public PhoneBookT1() throws Exception {
		view();
		MODE = 0;
		fileReader();
	}
	
	public void view() throws Exception {
		// TODO Auto-generated constructor stub
		
		mainFrame = new JFrame();
		mainFrame.setTitle("phonebook");
		mainFrame.setSize(600, 400);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(3);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);

		menuText = new JTextArea();
		menuText.setBorder(new TitledBorder("menu"));
		menuText.setLocation(0, 0);
		menuText.setSize(295, 300);
		menuText.setText(Properties.menu_EX1);
		
		viewText = new JTextArea();
		viewText.setBorder(new TitledBorder("explain"));
		viewText.setLocation(300, 0);
		viewText.setSize(295, 300);
		
		inputField = new JTextField();
		inputField.setBorder(new TitledBorder("inputbox"));
		inputField.setLocation(0, 300);
		inputField.setSize(600, 80);
		inputField.addKeyListener(ketEvent());
		
		mainPanel.add(menuText);
		mainPanel.add(viewText);
		mainPanel.add(inputField);
		
		mainFrame.setContentPane(mainPanel);
		mainFrame.setVisible(true);
		
	}
	
	public void fileReader() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(phoneBookMap.Properties.filepapath));
		maplist = new HashMap<String, Employee>();
		
		while(true) {
			String text = br.readLine();
			
			if(text == null) break;
			
			emp = new Employee(text.split(","));
			maplist.put(emp.name, emp);
		}
		
		Iterator<String> list = maplist.keySet().iterator();
		
	}
	
	//키 이벤트
	public KeyListener ketEvent() {
		
		KeyListener listener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				int key = e.getKeyCode();
				String name = "";
				System.out.println(key);
				
				if(key == 10 && inputField.getText().equals("1")) {
					allList();
					inputField.setText("");
				} else if(key == 10 && inputField.getText().equals("2")) {
					// 2번 메뉴 메시지 실행
					MODE = 2;
					viewText.setText(Properties.menu_EX2);
					inputField.setText("");
				} else if(MODE == 2 && key == 10) {
					name = inputField.getText();
					System.out.println(name);
					inputField.setText("");
					nameChk(name);
				
				}else if(MODE == 21 && "y".equals(inputField.getText()) && key == 10) {
					menu2NameSave(name);
					inputField.setText("");
				}else if(MODE == 2 && "n".equals(inputField.getText()) && key == 10) {
					viewText.setText(Properties.menu_EX2_n);
					MODE = 0;
				
				}else if(MODE == 22 && key == 10) {
					meun2AgeSave(inputField.getText());
					inputField.setText("");
				}else if(MODE == 23 && key == 10) {
					menu2DepSave(inputField.getText());
					inputField.setText("");
				}else if(MODE == 24 && key == 10) {
					menu2PhoneSave(inputField.getText());
					inputField.setText("");
				}
			}
		};
		
		return listener;
		
	}
	
	// 전체 리스트 출력
	public void allList() {
		for(String list : maplist.keySet()) {
			viewText.append(maplist.get(list).toString() + "\n");
		}
	}
	
	//필터 - 입력한 이름 검사 메소드
	public void nameChk(String name) {
		
		if(maplist.containsKey(name)) {
			System.out.println("있음");
			viewText.setText(Properties.menu_EX2_1);
			MODE = 21;
			
			
		}else {
			viewText.setText(Properties.menu_EX2_2);
			MODE = 22;
			
		}
	}
	
	public void menu2NameSave(String name) {
			System.out.println("여기 찍히나?1");
			// y 값일 경우
		int num = 0;
		emp.setName(name + "(" + Integer.toString(num+1) + ")");
		viewText.setText(Properties.menu_EX2_2);
			
		MODE = 22;
			
	}
	
	public void meun2AgeSave(String age) {
		emp.setAge(age);
		viewText.setText(Properties.menu_EX2_3);
		
		MODE = 23;
	}
	
	public void menu2DepSave(String dep) {
		emp.setDepartment(dep);
		viewText.setText(Properties.menu_EX2_4);
		
		MODE = 24;
	}
	
	public void menu2PhoneSave(String Phone) {
		emp.setPhonenumber(Phone);
		viewText.setText(Properties.menu_EX2_5);
		
		MODE = 0;
	}
	
	
	
}
