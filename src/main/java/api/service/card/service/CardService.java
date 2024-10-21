package api.service.card.service;

import api.service.card.entity.Card;
import api.service.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    public Card updateCard(Long id, Card cardDetails) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if (cardOptional.isPresent()) {
            Card existingCard = cardOptional.get();
            existingCard.setCardNumber(cardDetails.getCardNumber());
            existingCard.setCardType(cardDetails.getCardType());
            existingCard.setExpiryDate(cardDetails.getExpiryDate());
            existingCard.setHolderName(cardDetails.getHolderName());
            existingCard.setCvv(cardDetails.getCvv());
            existingCard.setAccountId(cardDetails.getAccountId());
            return cardRepository.save(existingCard);
        }
        return null;
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
