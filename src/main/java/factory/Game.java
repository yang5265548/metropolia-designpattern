package factory;

public class Game {
    public Map createMap(String type, int rows, int cols) {
        if (type.equals("city")) {
            return new CityMap(rows, cols);
        } else if (type.equals("wilderness")) {
            return new WildernessMap(rows, cols);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        Map cityMap = game.createMap("city", 5, 5);
        cityMap.display();
    }
}
