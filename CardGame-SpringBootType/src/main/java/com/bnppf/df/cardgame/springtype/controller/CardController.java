package com.bnppf.df.cardgame.springtype.controller;

import com.bnppf.df.cardgame.springtype.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    private List<Card> cardList = new ArrayList<>();
    @GetMapping("/oneCard")
    public ResponseEntity<Card> printCard() {
        return ResponseEntity.ok(new Field(CardType.FIELD, 0, FieldColor.blue, 25) {
        });
    }

    @GetMapping("/cardAll")
    public ResponseEntity<List<Card>> printAll() {
        return ResponseEntity.ok(cardList);
    }

    @PostMapping("/createCardCreature")
    public ResponseEntity<Card> createCard(@RequestBody Creature card){
        System.out.println("Creation de carte : " + card.getName());
        // TODO insertion en bdd
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

        Card card1 = new Field(CardType.FIELD, 0,FieldColor.white, 7);
        Card card2 = new Creature(CardType.CREATURE,0,"Godzilla", 52,20);
        Card card3 = new Curse(CardType.CURSE, 0, "Innalator", "make things becomes gaz");

        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);

        return cardList;

    }

}
