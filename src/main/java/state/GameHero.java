package state;

public class GameHero {
    private final String name;
    private LevelState level;
    private int health;
    private int experience;

    public GameHero(String name ) {
        this.name = name;
        this.level = new Novice();
        this.health = 10;
        this.experience = 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setState(LevelState level) {
        this.level = level;
    }
    public void train(){
        level.train(this);
    }
    public void fight(){
        level.fight(this);
    }
    public void meditate(){
        level.meditate(this);
    }

}
