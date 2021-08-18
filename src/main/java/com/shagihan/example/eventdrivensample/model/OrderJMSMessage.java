package com.shagihan.example.eventdrivensample.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@messageId", scope = OrderJMSMessage.class)
public class OrderJMSMessage {
    private int messageId;
    private int orderId;
    private int userId;
    private String eta;

    public OrderJMSMessage(int orderId, int userId, String eta) {
        this.orderId = orderId;
        this.userId = userId;
        this.eta = eta;
    }
}
