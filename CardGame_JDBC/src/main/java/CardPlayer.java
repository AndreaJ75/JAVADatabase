import java.util.List;

public class CardPlayer {

    private List<Card> cardCollect;
    private Integer maxCardNbr;

    public CardPlayer(List<Card> cardCollect, Integer maxCardNbr) {
        this.cardCollect = cardCollect;
        this.maxCardNbr = maxCardNbr;
    }

    public List<Card> getCardCollect() {
        return cardCollect;
    }

    public Integer getMaxCardNbr() {
        return maxCardNbr;
    }

    public void setCardCollect(List cardCollect) {
        this.cardCollect = cardCollect;
    }

    public void setMaxCardNbr(Integer maxCardNbr) {
        this.maxCardNbr = maxCardNbr;
    }


    public void drawCard(Card cardPioch) {

        System.out.println(" ************* Card Draw  *******************");
        cardCollect.add(cardPioch);

        System.out.println("Number of drawn card : " + cardCollect.size() );

        cardPioch.displayCardType();
        cardPioch.displayCostArgs();
    }

    public void displayPlayerGame(){
        System.out.println(" ****** Display user Play  ******** ");
        for (int i = 0; i < cardCollect.size(); i++) {
            cardCollect.get(i).displayCardType();
            cardCollect.get(i).displayCostArgs();
        }
        System.out.println("Maximum Card Number : " + maxCardNbr);


    }


    public void playCard(Card playedCard){

        System.out.println("******* BEFORE PLAYING ********");
        System.out.println("Remaining Cards in Player Game : " +  cardCollect.size());
        playedCard.displayCardType();
        playedCard.displayCostArgs();

        cardCollect.remove(playedCard);

        // ci-dessous comme cr'est la référence de l'objet qui est passé et non l'objet en lui même
        // dans le paramètre de la méthode, la commande ci-dessous ne joue que sur l'objet playedCard (et pas
        // sur l'image de l'objet passé par le main : firstCard.
        //playedCard = null;

        System.out.println("******** AFTER PLAYING ***********");
        System.out.println("Remaining Cards in Player Game : " + cardCollect.size());

        displayPlayerGame();


    }

}
