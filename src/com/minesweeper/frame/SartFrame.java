package com.minesweeper.frame;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import com.minesweeper.menu.MineMenu;
import com.minesweeper.panel.MineField;
import com.minesweeper.panel.MineState;
import com.minesweeper.timer.Timers;
import com.minesweeper.tools.Tools;

public class SartFrame extends JFrame
{
	private static final long serialVersionUID = -1585043387266273492L;
	private MineState mineState;
	private MineField mineField;
	private MineMenu mineMenu;
	private Timer timer;
	private Timers timers;
	private boolean isStart;
	JLabel jLabel_start = new JLabel();
	public SartFrame() {
		Font font = new Font("Dialog", Font.PLAIN, 12);
		@SuppressWarnings("rawtypes")
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements())
		{
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource)
			{
				UIManager.put(key, font);
			}
		}
		this.setTitle("É¨À× Design By Guo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setIconImage(Tools.iicon);
		this.setResizable(false);
		mineState = new MineState(this);
		this.add(mineState, BorderLayout.NORTH);

		mineField = new MineField(this);
		this.add(mineField, BorderLayout.CENTER);

		jLabel_start.setIcon(Tools.start);
		this.add(jLabel_start, BorderLayout.CENTER);

		mineMenu = new MineMenu(this);
		this.setJMenuBar(mineMenu);

		Tools.time = 0;
		timers = new Timers(mineState);
		timer = new Timer(1000, timers);
	
		pack();
		this.setVisible(true);
	}

	public void restart()
	{

		this.remove(mineState);
		this.remove(mineField);
		this.remove(jLabel_start);

		mineState = new MineState(this);
		this.add(mineState, BorderLayout.NORTH);

		mineField = new MineField(this);
		this.add(mineField, BorderLayout.CENTER);

		Tools.time = 0;
		Timers timers = new Timers(mineState);
		timer = new Timer(1000, timers);

		pack();
		validate();
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public MineState getMineState()
	{
		return mineState;
	}

	public MineField getMineField()
	{
		return mineField;
	}

	public MineMenu getMineMenu()
	{
		return mineMenu;
	}

	public Timer getTimer()
	{
		return timer;
	}

	public Timers getTimers()
	{
		return timers;
	}

	public boolean isStart()
	{
		return isStart;
	}

	public void setStart(boolean isStart)
	{
		this.isStart = isStart;
	}
	public static void main(String[] args)
	{
		new SartFrame();
		
	}
}