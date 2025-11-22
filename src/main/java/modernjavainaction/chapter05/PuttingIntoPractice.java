package modernjavainaction.chapter05;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

public class PuttingIntoPractice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> transactionsFor2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .toList();
        System.out.println(transactionsFor2011);

        List<String> listOfUniqueCities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();
        System.out.println(listOfUniqueCities);

        List<Trader> tradersFromCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .toList();
        System.out.println(tradersFromCambridge);

        String namesOfTraders = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());

        System.out.println(namesOfTraders);

        boolean traderFromMilan = transactions.stream()
                .anyMatch(trader -> trader.getTrader().getCity().equals("Milan"));
        System.out.println(traderFromMilan);

        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        Optional<Integer> maximumAmountAmongAllTransactions = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(maximumAmountAmongAllTransactions);

        Optional<Transaction> transactionWithMinimumAmount = transactions.stream()
                .min((comparing(Transaction::getValue)));
        System.out.println(transactionWithMinimumAmount);
    }
}
