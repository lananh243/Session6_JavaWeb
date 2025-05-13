package com.data.session06_javaweb.ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCart {
    private int productCartId;
    private int userId;
    private int productId;
    private int quantity;
}
