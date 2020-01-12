public abstract class Card {
    private CardType cardType;
    private Integer cost;


    public Card() {
    }

    public Card(CardType cardType, Integer cost) {
        this.cardType = cardType;
        this.cost = cost;

    }

    public CardType getCardType(){
        return cardType;
    }

    public Integer getCost(){
        return cost;
    }


    public void setCardType(CardType cardType){
        this.cardType = cardType;
    }

    public void setCost(Integer cost){
        this.cost = cost;
    }


    public void displayCardType(){
        System.out.println("Type de carte : " + cardType);
    }

    public void displayCostArgs(){
        System.out.println("Cout de la carte : " + this.cost);
    }

    @Override
    public String toString() {
        return cardType.toString() + " " + cost.toString();
    }
}
