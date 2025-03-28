package state;

import java.util.Random;

public class Intermediate implements LevelState{
    @Override
    public void train(GameHero hero) {
        System.out.println(hero.getName()+" is training as an intermediate.");
        hero.setExperience(hero.getExperience() + new Random().nextInt(10)+5);
    }

    @Override
    public void fight(GameHero hero) {
        System.out.println(hero.getName()+" cannot fight as an intermediate.");
    }

    @Override
    public void meditate(GameHero hero) {
        System.out.println(hero.getName()+" is meditating as an intermediate.");
        hero.setHealth(hero.getHealth() + new Random().nextInt(5)+1);
    }
}
