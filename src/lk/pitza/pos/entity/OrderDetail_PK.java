package lk.pitza.pos.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable

public class OrderDetail_PK implements Serializable {
    private String orderId;
    private String itemCode;

    public OrderDetail_PK() {
    }

    public OrderDetail_PK(String orderId, String itemCode) {
        this.setOrderId(orderId);
        this.setItemCode(itemCode);
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
