package com.minesweeper.bean;
import javax.swing.JLabel;

public class MineLabel extends JLabel
{

	private static final long serialVersionUID = -7271927020145498558L;

	private boolean isMine;

	private boolean isExpanded;

	private boolean isFlag;

	@SuppressWarnings("unused")
	private boolean isMineAndNotflag;

	private int mineCount;

	private int rowIndex;

	private int colIndex;
	
	@SuppressWarnings("unused")
	private int expend=0;

	public MineLabel(int rowIndex, int colIndex)
	{
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}

	public boolean isMine()
	{
		return isMine;
	}

	public void setMine(boolean isMine)
	{
		this.isMine = isMine;
	}

	public boolean isExpanded()
	{
		return isExpanded;
	}

	public void setExpanded(boolean isExpanded)
	{
		this.isExpanded = isExpanded;
	}

	public boolean isFlag()
	{
		return isFlag;
	}

	public void setFlag(boolean isFlag)
	{
		this.isFlag = isFlag;
	}

	public int getMineCount()
	{
		return mineCount;
	}

	public void setMineCount(int mineCount)
	{
		this.mineCount = mineCount;
	}

	public int getRowIndex()
	{
		return rowIndex;
	}

	public void setRowIndex(int rowIndex)
	{
		this.rowIndex = rowIndex;
	}

	public int getColIndex()
	{
		return colIndex;
	}

	public void setColIndex(int colIndex)
	{
		this.colIndex = colIndex;
		
		
	}

	private int rightClickCount;

	public int getRightClickCount()
	{
		return rightClickCount;
	}

	public void setRightClickCount(int rightClickCount)
	{
		this.rightClickCount = rightClickCount;
	}

}



