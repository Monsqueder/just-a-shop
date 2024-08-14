package com.mlachowski;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final MessagePublisher messagePublisher;
    private final Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    public PurchaseService(PurchaseRepository purchaseRepository, MessagePublisher messagePublisher) {
        this.purchaseRepository = purchaseRepository;
        this.messagePublisher = messagePublisher;
    }

    public void createPurchase(PurchaseRequestDto purchaseRequestDto) {
        logger.info("Processing: " + purchaseRequestDto);
        Purchase purchase = purchaseRepository.save(new Purchase(null, purchaseRequestDto.userId(), purchaseRequestDto.productIds(), PurchaseStatus.CREATED));
        logger.info("Created purchase with id: " + purchase.getId());
        PurchaseMessage purchaseMessage = new PurchaseMessage(purchase.getId(), purchase.getUserId(), purchase.getProductIds());
        messagePublisher.sendMessage(purchaseMessage);
    }

}
