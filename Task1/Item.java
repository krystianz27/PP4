class Item {
    String name;
    double netAmount;
    double vatRate;

    public Item(String name, double netAmount, double vatRate) {
        this.name = name;
        this.netAmount = netAmount;
        this.vatRate = vatRate;
    }

    double calculateGrossAmount() {
        return netAmount * (1 + vatRate / 100);
    }
}