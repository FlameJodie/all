package com.company;


/**
 * Моделирование поведения травоядной рыбы
**/
public class Herbivore extends Animal {
	/**
	 * Вызывает конструктор родителя.
	 *
	 * @param    initRate
	 * @param    initSize
	 * @param    initNeed
	**/
	public Herbivore(double initRate, double initSize, double initNeed) {
		super(initRate, initSize, initNeed);
	}
	
	/**
	 * Моделирование питания рыбы растением meal. 
	 * Параметры питания задаются в модели. Сначала по параметрам модели вычисляется количество пищи, 
	 * которое может быть съедено одной рыбой, затем это количество обрабатывается текущей как съеденное и 
	 * растению сообщается, что им питались и откусили некоторое количество.
	 *
	 * @param    meal
	**/
	public void nibble(Plant meal) {
		double canEat = this.stillNeed();
		double pl = meal.getSize()/2;
		double a = 0.1*this.getNeed();

		double amount = Math.min(Math.min(pl,a),canEat);

		eat(amount);
		meal.alterSize(-amount);






	}
}
