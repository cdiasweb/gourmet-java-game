package com.gourmet.game;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.gourmet.model.Meal;
import com.gourmet.model.MealSubtype;
import com.gourmet.model.MealType;

public class HandleGame {
		
	public HandleGame() {
		this.addFirstMeals();
	}

	private ArrayList<Meal> meals = new ArrayList<Meal>();
	private ArrayList<MealType> mealTypes = new ArrayList<MealType>();
	
	// better to see in code
	private final int YES = JOptionPane.YES_OPTION;
	private final int NO = JOptionPane.NO_OPTION;
	
	public void startGame() {
		JOptionPane.showMessageDialog(null, "Pense em um prato que gosta.", "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
		this.tryMealType(mealTypes.get(0));
	}
	
	private void tryMealType(MealType type) {
		int answer = this.showConfirmMealCorrect(type.getDescription(), "Confirm");
		// right type
		if( answer == YES ) {
			tryMealByType(type);
		} else if( answer == NO ) {
			// try second meal type
			Meal meal = meals.get(1);
			tryMealByType(meal.getType());
		}
		
	}
	
	private void tryMealByType(MealType type) {
		Meal foundMeal = this.findMealByType(type);	
		if(foundMeal != null && foundMeal.getType() != null) {
			int answer = this.showConfirmMealCorrect(foundMeal.getName(), "Confirm");
			if(answer == YES) {
				this.showMessageAndRestartGame();
			} else if(!type.getSubtypes().isEmpty()) {
				// the type has subtypes, test them.
				this.tryMealBySubtype(type, foundMeal);
			} else {
				// give up
				this.getUserMeal(foundMeal, type);
			}
		}
		
	}
	
	private void tryMealBySubtype(MealType type, Meal previousMeal) {
		boolean giveUp = false;
		for(MealSubtype ms: type.getSubtypes()) {
			int answer = showConfirmMealCorrect(ms.getDescription(), "Confirm");
			if( answer == YES) {
				giveUp = false;
				Meal meal = this.findMealBySubtype(ms);
				if(meal != null) {
					int choice = this.showConfirmMealCorrect(meal.getName(), "Confirm");
					if(choice == YES) {
						this.showMessageAndRestartGame();
					}
				}
			} else {
				giveUp = true;
			}
		}
		
		if(giveUp) {
			this.getUserMeal(previousMeal, type);
		}
	}
		
	private void getUserMeal(Meal lastMeal, MealType type) {
		String meal = JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", JOptionPane.QUESTION_MESSAGE);
		String subtype = JOptionPane.showInputDialog(null, meal + " é ________ mas "  + lastMeal + " não.", "Complete", JOptionPane.QUESTION_MESSAGE);
		
		MealSubtype newSubtype = new MealSubtype(subtype);
		type.addSubtype(newSubtype);
		
		Meal addMeal = new Meal(meal, type, newSubtype);
		
		meals.add(addMeal);
		
		// restart the game
		this.startGame();
	}
	
	private Meal findMealByType(MealType type) {
		return meals.stream()
				.filter(meal -> type.equals(meal.getType()))
				.findAny()
				.orElse(null);
	}
	
	private Meal findMealBySubtype(MealSubtype subtype)  {
		return meals.stream()
				.filter(meal -> subtype.equals(meal.getSubtype()))
				.findAny()
				.orElse(null);
	}
	
	private void addFirstMeals() {		
		MealType pasta = new MealType("massa");
		mealTypes.add(pasta);
		
		MealType cake = new MealType("bolo");
		mealTypes.add(cake);
		
		Meal lasagna = new Meal("Lasanha", pasta);
		meals.add(lasagna);
		
		Meal chocolateCake = new Meal("Bolo de chocolate", cake);
		meals.add(chocolateCake);
	}
	
	private void showMessageAndRestartGame() {
		JOptionPane.showMessageDialog(null, "Acertei de novo!");
		this.startGame();
	}

	private int showConfirmMealCorrect(String mealInfo, String title) {
		String message = "O prato que você pensou é " + mealInfo + " ?";
		return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	}

}
