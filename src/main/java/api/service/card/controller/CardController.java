package api.service.card.controller;

import api.service.card.entity.Card;
import api.service.card.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @Operation(summary = "Create a new card", description = "Creates a new bank card")
    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        Card createdCard = cardService.createCard(card);
        return ResponseEntity.ok(createdCard);
    }

    @Operation(summary = "Get all cards", description = "Retrieves a list of all cards")
    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }

    @Operation(summary = "Update card information", description = "Updates the information of an existing card")
    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody Card cardDetails) {
        Card updatedCard = cardService.updateCard(id, cardDetails);
        if (updatedCard != null) {
            return ResponseEntity.ok(updatedCard);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete a card", description = "Deletes a card by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}
