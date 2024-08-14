package com.mlachowski;

import java.util.List;

public record PurchaseMessage(Long id,
                              Long userId,
                              List<Long> productIds) {}
