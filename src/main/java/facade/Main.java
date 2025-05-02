package facade;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Facade Pattern Example");
        ApiFacade apiFacade = new ApiFacade();
        System.out.println("Get the Churck");
        String chuckURL="https://api.chucknorris.io/jokes/random";
        String chuckValue="value";
        String value=apiFacade.getAttributeValueFromJson(chuckURL, chuckValue);
        System.out.println("Chuck Norris Joke: " + value);

        System.out.println("Get the exchange rates");
        String exchangeURL="https://api.fxratesapi.com/latest";
        String exchangeRates="rates";
        String rates=apiFacade.getAttributeValueFromJson(exchangeURL, exchangeRates);
        System.out.println("Exchange Rates: " + rates);
    }
}
