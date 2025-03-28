package state;

import java.util.Random;

public class Expert implements LevelState{
    @Override
    public void train(GameHero hero) {
        System.out.println(hero.getName()+" is training as an expert.");
        hero.setExperience(hero.getExperience() + new Random().nextInt(10)+5);
    }

    @Override
    public void fight(GameHero hero) {
        System.out.println(hero.getName()+" is fighting as an expert.");
        hero.setHealth(hero.getHealth() - new Random().nextInt(30)+5);
        hero.setExperience(hero.getExperience() + new Random().nextInt(10)+5);
    }

    @Override
    public void meditate(GameHero hero) {
        System.out.println(hero.getName()+" is meditating as an expert.");
        hero.setHealth(hero.getHealth() + new Random().nextInt(10)+5);
    }
}
