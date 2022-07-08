package com.company;


/**
* Класс, моделирующий поведение живого организма
**/
public class Organism {
        /**
        * Скорость роста организма
        **/
	private double rate;
	/**
        * Масса организма
        **/
        private double size;
	/**
	 * Конструктор класса
	 *
	 * @param    initRate
	 * @param    initSize
	**/
	public Organism(double initRate, double initSize) {
		this.rate = initRate;
		this.size = initSize;
	}
	
	/**
	 * Установка новой скорости роста
	 *
	 * @param    newRate
	**/
	public void setRate(double newRate) {
		this.rate = newRate;
	
	}
	
	/**
	 * Изменение размера организма на значение amount (увеличение/уменьшение)
	 *
	 * @param    amount
	**/
	public void alterSize(double amount) {
		this.size += amount;
	}
	
	/**
	 * Функция возвращает истину, если организм живой (размер организма больше 0)
	**/
	public boolean isAlive() {
		if(this.size>0)
			return true;
		return false;
	}
	
	/**
	 * Возврат текущего размера организма
	**/
	public double getSize() {
		return size;
	}
	
	/**
	 * Возврат текущей скорости роста организма
	**/
	public double getRate() {
		return rate;
	
	}
	
	/**
	 * Реализация смерти организма. Размер и скорость роста устанавливаются равными 0
	**/
	public void death() {
		this.size=0;
		this.rate=0;
	
	}
	
	/**
	 * Описание факта проживания организмом одной недели. Размер организма изменяется на значение скорости роста
	**/
	public void simulateWeek() {
		this.size+=this.rate;
	
	}
}
