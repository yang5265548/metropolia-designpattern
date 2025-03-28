package state;

public class Master implements LevelState{
    @Override
    public void train(GameHero hero) {
        System.out.println(hero.getName()+" is training as a master.");
    }

    @Override
    public void fight(GameHero hero) {
        System.out.println(hero.getName()+" is fighting as a master.");
    }

    @Override
    public void meditate(GameHero hero) {
        System.out.println(hero.getName()+" is meditating as a master.");
    }
}
