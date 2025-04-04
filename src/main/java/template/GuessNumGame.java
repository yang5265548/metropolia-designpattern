package template;

import java.util.*;

public class GuessNumGame extends Game{
    private int numOfPlayers;
    private int targetNumber;
    private boolean gameEnded=false;
    private int winner=-1;
    private Map<Integer, List<Integer>> guesses;
    private Random random;

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.random=new Random();
        this.numOfPlayers=numberOfPlayers;
        this.targetNumber=random.nextInt(100)+1; // target number between 1 and 100
        this.guesses=new HashMap<>();
        for (int i=0; i<numOfPlayers; i++){
            guesses.put(i,new ArrayList<>());
        }
        System.out.println("Game initialized with " + numberOfPlayers + " players. Target number is " + targetNumber);

    }

    @Override
    public boolean endOfGame() {
        return gameEnded;
    }

    @Override
    public void playSingleTurn(int player) {
        int guess=random.nextInt(100)+1; // random guess between 1 and 100
        guesses.get(player).add(guess);
        System.out.println("Player " + player + " guessed: " + guess);

        if (guess==targetNumber){
            winner=player;
            gameEnded=true;
        }

    }

    @Override
    public void displayWinner() {
        System.out.println("Game Over! Player " + winner + " wins!");
        System.out.println("Guesses:");
        for (int player:guesses.keySet()) {
            System.out.println("Player " + player + ": " + guesses.get(player));

        }
    }
}
