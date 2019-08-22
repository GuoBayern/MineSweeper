package com.minesweeper.panel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import com.minesweeper.bean.MineLabel;
import com.minesweeper.frame.SartFrame;
import com.minesweeper.listener.MouseListener;
import com.minesweeper.tools.Tools;

@SuppressWarnings("serial")
public class MineField extends JPanel
{
	SartFrame sartFrame;
	MouseListener mouseListener;
	private MineLabel mineLabel[][];
	public  MineField(SartFrame sartFrame)
	{
		this.sartFrame=sartFrame;
		this.setLayout(new BorderLayout());
		mineLabel=new MineLabel[Tools.totalx][Tools.totaly];

		JPanel jPanel2=new JPanel();
		jPanel2.setLayout(new GridLayout(Tools.totalx,Tools.totaly));
		mouseListener=new MouseListener(sartFrame);
		
		for(int i=0;i<Tools.totalx;i++)
		{
			for(int j=0;j<Tools.totaly;j++)
			{
				mineLabel[i][j]=new MineLabel(i,j);
				mineLabel[i][j].setIcon(Tools.iiblank);
				mineLabel[i][j].addMouseListener(mouseListener);
				jPanel2.add(mineLabel[i][j]);
			}
		}
		this.add(jPanel2);		
	}

	public void buildMine(int rowx, int coly)
	{
		for (int i = 0; i < Tools.totalMine; i++)
		{
			int x = (int) (Math.random() * Tools.totalx);
			int y = (int) (Math.random() * Tools.totaly);
			if(x==rowx && y==coly)
			{
				i--;
			}
			else if(mineLabel[x][y].isMine())
			{
				i--;
			}
			else
			{
				mineLabel[x][y].setMine(true);
			}
		}
		for (int i = 0; i < Tools.totalx; i++)
		{
			for (int j = 0; j < Tools.totaly; j++)
			{
				int count = 0;
				if (!mineLabel[i][j].isMine())
				{
					for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1,Tools.totalx - 1); x++)
					{
						for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1,Tools.totaly - 1); y++)
						{
							if (mineLabel[x][y].isMine())
							{
								count++;
							}
						}
					}
					mineLabel[i][j].setMineCount(count);	
				}
			}
		}
	}

	public MineLabel[][] getMineLabel()
	{
		return mineLabel;
	}

	public void setMineLabel(MineLabel[][] mineLabel)
	{
		this.mineLabel = mineLabel;
	}

	public MouseListener getMouseListener()
	{
		return mouseListener;
	}
}