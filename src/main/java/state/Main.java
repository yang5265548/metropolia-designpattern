package state;

public class Main {

    public static void main(String[] args) {
        GameHero mario= new GameHero("Mario");
        System.out.println("Hero name: " + mario.getName());
        mario.fight();
        mario.meditate();
        while (mario.getExperience()<=70){
            mario.train();
            System.out.println("Experience: " + mario.getExperience());
            System.out.println("   ");
        }
        System.out.println("Level up!");
        mario.setState(new Intermediate());
        System.out.println("Now " + mario.getName() + " is an intermediate.");
        mario.fight();
        while (mario.getExperience()<=150){
            mario.train();
            mario.meditate();
            System.out.println(mario.getName()+"'s Experience: " + mario.getExperience()+" Health: " + mario.getHealth());
            System.out.println("   ");
        }

        System.out.println("Level up!");
        mario.setState(new Expert());
        System.out.println("Now " + mario.getName() + " is an expert.");
        while ( mario.getHealth()>0 && mario.getExperience()<=300){
            mario.fight();
            mario.train();
            mario.meditate();
            System.out.println(mario.getName()+"'s Experience: " + mario.getExperience()+" Health: " + mario.getHealth());
            System.out.println("   ");
        }
        if (mario.getHealth()<=0) {
            System.out.println(mario.getName() + " is dead.");
        }else {
            System.out.println("Level up!");
            mario.setState(new Master());
            System.out.println("Now " + mario.getName() + " is a master.The game is over.");
        }


    }
}
