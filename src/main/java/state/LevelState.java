package state;

public interface LevelState {
    void train(GameHero hero);
    void fight(GameHero hero);
    void meditate(GameHero hero);
}
