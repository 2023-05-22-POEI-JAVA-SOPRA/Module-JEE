package fr.m2i.crud.service;

import java.util.ArrayList;

import fr.m2i.crud.model.Score;
import fr.m2i.crud.model.User;

public class UserService {

	private static ArrayList<User> listUsers = new ArrayList<>();
	
	
	public User getById(int id) {
		try {
			return listUsers.get(id);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public ArrayList<User> getAll(){
		return listUsers;
	}
	
	public boolean create(User u) {
		if (u == null) {
			return false;
		}
		
		listUsers.add(u);
		return true;
	}
	
	public boolean create(String name, String login, String password, String email, int age, int win, int lose, int tie) {		
		User u = new User(name, login, password, email, age, win, lose, tie);
		return create(u);
	}
	
	public boolean update(int id, User u) {
		try {
			listUsers.set(id, u);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public boolean update(int id, String name, String login, String password, String email, int age, int win, int lose, int tie) {
		User u = new User(name, login, password, email, age, win, lose, tie);
		return update(id, u);
	}
	
	
	public boolean delete(int id) {
		try {
			listUsers.remove(id);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public void updateScore(int id, Score score) {
		User u = this.getById(id);
		
		u.setWin( score.getWin() );
		u.setLose( score.getLose() );
		u.setTie( score.getTie() );
	}
	
	
	public String play(int id, String action) {
		
		int intAction =  (int) (Math.random() * 3) ;
		String[] actions= {"pierre", "feuille", "ciseaux"};
		String actionComputer = actions[intAction];
		
		
		System.out.println(actionComputer);
		
		listUsers.add( new User("Computer", "nopassword", "", "", 1, 0, 0, 0) );
		String result = this.play(id, action, listUsers.size()-1 ,actionComputer);
		listUsers.remove( listUsers.size() -1 );
		
		return result;
	}
	
	public String play(int id1, String action1, int id2,String action2) {
		User u1 = this.getById(id1);
		User u2 = this.getById(id2);
		
		int intAction1 = actionToInt(action1);
		int intAction2 = actionToInt(action2);
		
		if (intAction1 == -1 || intAction2 == -1) {
			throw new IllegalArgumentException("Unexpected value: " + intAction1 + " : " + intAction2);
		}
		
		
		int winner = (intAction1 - intAction2 + 3) % 3;
		
		switch (winner) {
		case 0: 
			u1.setTie( u1.getTie() + 1 );
			u2.setTie( u2.getTie() + 1 );
			return "tie";
		case 1: 
			u1.setWin( u1.getWin() + 1 );
			u2.setLose( u2.getLose() + 1 );

			return "player 1 win";
		case 2: 
			u2.setWin( u2.getWin() + 1 );
			u1.setLose( u1.getLose() + 1 );
			return "player 2 win";
		default:
			throw new IllegalArgumentException("Unexpected value: " + winner);
		}
	}
	
	private int actionToInt(String action) {
		return action.equalsIgnoreCase("Pierre") ? 0 : action.equalsIgnoreCase("Feuille") ? 1 : action.equalsIgnoreCase("Ciseaux") ? 2 : -1;
	}
	
}
