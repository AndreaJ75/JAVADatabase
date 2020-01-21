package com.bnppf.df.cardgame.springtype.controller;

import com.bnppf.df.cardgame.springtype.model.*;
import com.bnppf.df.cardgame.springtype.repository.Cardrepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/card")
public class CardController {

    private Cardrepository cardrepository;

    public CardController(Cardrepository cardrepository) {
        this.cardrepository = cardrepository;
    }

    private List<Card> cardList = new ArrayList<>();
    @GetMapping("/oneCard")
    public ResponseEntity<Card> printCard() {
        Random xVal = new Random();
        System.out.println("Lecture de carte : " + xVal);
        return ResponseEntity.ok(cardrepository.findById((int) xVal.nextInt(15)).get());


    }

    @GetMapping("/cardAll")
    public ResponseEntity<List<Card>> printAll() {
        return ResponseEntity.ok(cardList);
    }

    @PostMapping("/createCardCreature")
    public ResponseEntity<Card> createCard(@RequestBody Creature card){
        System.out.println("Creation de carte : " + card.getName());
        return ResponseEntity.ok(card);
    }

    @PostMapping("/createCardField")
    public ResponseEntity<Card> createCard(@RequestBody Field card){
        System.out.println("Creation de carte : " + card.getColor());
        return ResponseEntity.ok(card);
    }

    @PostMapping("/createCardCurse")
    public ResponseEntity<Card> createCard(@RequestBody Curse card){
        System.out.println("Creation de carte : " + card.getName());
        return ResponseEntity.ok(card);
    }


    public List<Card> getListCard(){

        Card card1 = new Field(CardType.FIELD, 0,FieldColor.WHITE, 7);
        Card card2 = new Creature(CardType.CREATURE,0,"Godzilla", 52,20);
        Card card3 = new Curse(CardType.CURSE, 0, "Innalator", "make things becomes gaz");

        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);

        return cardList;

    }

}
