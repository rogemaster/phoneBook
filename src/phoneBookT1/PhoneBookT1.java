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
	
	static int MODE;

	public PhoneBookT1() throws Exception {
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
		
		fileReader();
		
		
		mainFrame.setVisible(true);
		
	}
	
	public void fileReader() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(phoneBookMap.Properties.filepapath));
		maplist = new HashMap<String, Employee>();
		
		while(true) {
			String text = br.readLine();
			
			if(text == null) break;
			
			Employee emp = new Employee(text.split(","));
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
				System.out.println(key);
				
				if(key == 10 && inputField.getText().equals("1")) {
					allList();
					inputField.setText("");
				} else if(key == 10 && inputField.getText().equals("2")) {
					MODE = 2;
					viewText.setText(Properties.menu_EX2);
					inputField.setText("");
				} else if(MODE == 2 && key == 10) {
					if(nameChk(inputField.getText(), key) == 1) {
						String name = maplist.values().toString();
						System.out.println(name);
					}
					
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
	public int nameChk(String name, int key) {
		
		int rst = 0;
		
		if(maplist.containsKey(name)) {
			System.out.println("있음");
			viewText.setText(Properties.menu_EX2_1);
			inputField.setText("");
			rst = 1;
		}
		
		return rst;
	}

	// 저장
	public void saveList(String name, int num) {
		if(MODE != 2) {
			viewText.setText(Properties.Error);
		}else if(MODE == 2) {
		//	nameChk(name);
		}
	}
	
	
	
	
	
}
