package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static int MANY_WEEDS = 2000; // Количество растений в пруду
    static double WEED_SIZE = 15; // Начальный размер растения
    static double WEED_RATE = 2.5; // Скорость роста растения
    static int INIT_FISH = 300; // Начальный размер популяции рыб
    static double FISH_SIZE = 50; // Размер рыб
    static double FRACTION = 0.5; // Рыба каждую неделю должна съедать объем равный FRACTION * FISH_SIZE
    static int AVERAGE_NIBBLES = 30; //Среднее количество растений, частично съедаемых рыбами в течение недели равно
    //произведению AVERAGE_NIBBLES на размер популяции рыб
    static double BIRTH_RATE = 0.05; // Общее количество новых рыб равно произведению размера популяции на константу BIRTH_RATE


    public static void main(String[] args) {
        ArrayList<Plant> weeds = new ArrayList(MANY_WEEDS);
        ArrayList<Herbivore> fish = new ArrayList(INIT_FISH);

        Scanner in = new Scanner(System.in);
        int manyWeeks;   // Количество недель для моделирования
        int i;

        System.out.println("How many weeks shall I simulate? ");
        manyWeeks = in.nextInt();

        //Создание популяции травоядных рыб
        for (i = 0; i < INIT_FISH; i++)
            fish.add(new Herbivore(0, FISH_SIZE, FISH_SIZE * FRACTION));

        //Создание популяции растений
        for (i = 0; i < MANY_WEEDS; i++)
            weeds.add(new Plant(WEED_RATE, WEED_SIZE));

        //Моделирование жизни в пруду
        for (i = 0; i < manyWeeks; i++) {
            pondWeek(fish, weeds);
            System.out.println((i + 1) + "\t" + fish.size() + "\t" + totalMass(weeds));
        }
    }

    /**
     * Постусловие: В среднем каждая рыба съедает AVERAGE_NIBBLES растений.
     * Затем активируется  simulateWeek() для каждой рыбы и каждого растения.
     * Все умершие рыбы удаляются из популяции, затем в популяцию добавляется
     * BIRTH_RATE * fish.size( ) новых рыб.
     **/
    static void pondWeek(ArrayList<Herbivore> fish, ArrayList<Plant> weeds) {
        int f = 0, p = 0;
        int manyIterations = AVERAGE_NIBBLES * fish.size();
        for (int i = 0; i < manyIterations; ++i) {
            //Случайный выбор рыбы и растения для питания
            f = (int) (Math.random() * fish.size());
            p = (int) (Math.random() * weeds.size());

            fish.get(f).nibble(weeds.get(p));
        }
        //Моделирование одной недели для растений
        Iterator<Plant> iterPlants = weeds.iterator();

        while (iterPlants.hasNext())
            iterPlants.next().simulateWeek();

        //Моделирование одной недели для рыб с удалением из популяции умерших рыб
        Iterator<Herbivore> iterFish = fish.iterator();
        Herbivore Onefish;
        while (iterFish.hasNext()) {

            Onefish = iterFish.next();
            Onefish.simulateWeek();

            if (!Onefish.isAlive())
                iterFish.remove();
        }


        //Добавление в популяцию новых рыб
        int newFishPopulation = (int) (BIRTH_RATE * fish.size());
        for (int i = 0; i < newFishPopulation; i++) {
            fish.add(new Herbivore(0, FISH_SIZE, FISH_SIZE * FRACTION));
        }

    }

    /**
     * Постусловие: Возвращает массу всех растений в списке weeds.
     **/
    static double totalMass(ArrayList<Plant> weeds) {
        double mass = 0;
        Iterator<Plant> iter = weeds.iterator();
        while (iter.hasNext())
            mass += iter.next().getSize();
        return mass;
    }
}
