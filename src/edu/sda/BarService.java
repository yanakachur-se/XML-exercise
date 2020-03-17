package edu.sda;

import java.util.Comparator;
import java.util.List;

public class BarService {

    List<Bar> bars;

    public void initBars() {
        Parser parser = new Parser();
        bars = parser.fetchBars();
    }

    void fetchNames() {
        bars.stream().map(Bar::getName).forEach(System.out::println);
    }

    void sortByHighProtein() {
        bars.stream()
                .sorted(Comparator.comparingDouble(Bar::getProtein))
                .map(Bar::getName)
                .forEach(System.out::println);
    }

    void sortByHighFett() {
        bars.stream()
                .sorted(Comparator.comparingDouble(Bar::getFett))
                .map(Bar::getName)
                .forEach(System.out::println);
    }

    void filterByLowFiberSort(double userFiber) {
        bars.stream()
                .filter(bar -> bar.getFiber() < userFiber)
                .sorted(Comparator.comparingDouble(Bar::getFiber))
                .map(Bar::getName)
                .forEach(System.out::println);
    }

    void filterByProteinAndReviews(double userProtein, int userReviewNumber){
        bars.stream()
                .filter(bar -> bar.getProtein() > userProtein)
                .filter(bar -> bar.getReviewNumber() == userReviewNumber)
                .map(Bar::getName)
                .forEach(System.out::println);
    }
}
