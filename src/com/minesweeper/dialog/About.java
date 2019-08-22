package com.minesweeper.dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.minesweeper.frame.SartFrame;
import com.minesweeper.tools.Tools;

@SuppressWarnings("serial")
public class About extends JDialog
{
	@SuppressWarnings("unused")
	private JLabel labx,laby,labmine;
	private JTextField jTextField1,jTextField2,jTextField3;
	private JButton butyes,butno;
	SartFrame sartFrame;
	public About(SartFrame sartFrame)
	{
		this.sartFrame = sartFrame;
		this.setTitle("");
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setSize(new Dimension(200,200));
		this.init();
		this.setVisible(true);
	}

	private void init()
	{
		JPanel jPanel = new JPanel();
		 labx = new JLabel("");
		 jTextField1=new JTextField(12);
		 jTextField2=new JTextField(12);
		 jTextField3=new JTextField(12);
		 
		 JLabel jLabelTotalx=new JLabel("行数:");
		 JLabel jLabelTotaly=new JLabel("列数:");
		 JLabel jLabelTotalMine=new JLabel("雷数:");

		jPanel.add(jLabelTotalx);
		jPanel.add(jTextField1);
		
		jPanel.add(jLabelTotaly);
		jPanel.add(jTextField2);
		
		jPanel.add(jLabelTotalMine);
		jPanel.add(jTextField3);

		
		butyes = new JButton("确定");
		butno = new JButton("取消");
		jPanel.add(butyes);
		jPanel.add(butno);
		
		butyes.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
			
				try
				{
					Tools.totalx=Integer.parseInt(jTextField1.getText());
					Tools.totaly=Integer.parseInt(jTextField2.getText());
					Tools.totalMine=Integer.parseInt(jTextField3.getText());
					if(Tools.totalx>9&&Tools.totalx<30)
					{
						if(Tools.totaly>9&&Tools.totaly<30)
						{
							if(Tools.totalMine>=10&&Tools.totalMine<Tools.totalx*Tools.totaly*4/5)
							{
								sartFrame.restart();
								About.this.dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "埋雷错误!\n地雷数量应少于总格子数!", "错误", JOptionPane.NO_OPTION);	
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "输入的列数有误", "错误", JOptionPane.NO_OPTION);		
						}				
					}
					else
					{
						JOptionPane.showMessageDialog(null, "输入的行数有误", "错误", JOptionPane.NO_OPTION);	
					}		
				}
				catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null, "必须是数字", "错误", JOptionPane.NO_OPTION);
					return;
				}
				
			}
		});

		butno.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				About.this.dispose();
			}
		});
		this.add(jPanel);
	}
}
