package fr.m2i.crud.model;

public class Score {
	int win;
	int lose;
	int tie;
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getTie() {
		return tie;
	}
	public void setTie(int tie) {
		this.tie = tie;
	}
	public Score(int win, int lose, int tie) {
		super();
		this.win = win;
		this.lose = lose;
		this.tie = tie;
	}
	
	
	
}
