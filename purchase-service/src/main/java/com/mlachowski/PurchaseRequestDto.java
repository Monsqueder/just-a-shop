package com.mlachowski;

import java.util.List;

public record PurchaseRequestDto(
        Long userId,
        List<Long> productIds
) {}
