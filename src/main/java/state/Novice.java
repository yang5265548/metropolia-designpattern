package state;

import java.util.Random;

public class Novice implements LevelState{
    @Override
    public void train(GameHero hero) {
        System.out.println(hero.getName()+" is training as a novice.");
        hero.setExperience(hero.getExperience() + new Random().nextInt(5)+1);

    }

    @Override
    public void fight(GameHero hero) {
        System.out.println(hero.getName()+" cannot fight as a novice.");
    }

    @Override
    public void meditate(GameHero hero) {
        System.out.println(hero.getName()+" cannot meditate as a novice.");
    }
}
