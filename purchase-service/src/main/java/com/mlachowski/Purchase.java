package com.mlachowski;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "purchases")
@AllArgsConstructor
@Getter
@Setter
public class Purchase {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private Long userId;
        private List<Long> productIds;
        private PurchaseStatus purchaseStatus;
}
