package edu.sda;

public class Bar {
    String name;
    double fett;
    double protein;
    double fiber;
    String reviewer;

    public Bar(String name, double fett, double protein, double fiber, String reviewer) {
        this.name = name;
        this.fett = fett;
        this.protein = protein;
        this.fiber = fiber;
        this.reviewer = reviewer;
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

    public String getReviewer() {
        return reviewer;
    }
}
