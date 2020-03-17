package edu.sda;

public class Bar {
    String name;
    double fett;
    double protein;
    double fiber;
    int reviewNumber;

    public Bar(String name, double fett, double protein, double fiber, int reviewNumber) {
        this.name = name;
        this.fett = fett;
        this.protein = protein;
        this.fiber = fiber;
        this.reviewNumber = reviewNumber;
    }

    public String getName() {
        return name;
    }

    public double getFett() {
        return fett;
    }

    public double getProtein() {
        return protein;
    }

    public double getFiber() {
        return fiber;
    }

    public int getReviewNumber() {
        return reviewNumber;
    }
}
