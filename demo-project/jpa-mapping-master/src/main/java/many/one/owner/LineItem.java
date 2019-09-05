package many.one.owner;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "line_item")
public class LineItem {

    @EmbeddedId
    private LineItemKey lineItemKey;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private CustomerOrder customerOrder;

    private int quantity;

    @Column(name = "item_price")
    private BigDecimal itemPrice;

    @Column(name = "sub_total")
    private BigDecimal subTotal;

    public LineItemKey getLineItemKey() {
        return lineItemKey;
    }

    public void setLineItemKey(LineItemKey lineItemKey) {
        this.lineItemKey = lineItemKey;
    }

    public CustomerOrder getOrder() {
        return customerOrder;
    }

    public void setOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "lineItemKey=" + lineItemKey +
                ", quantity=" + quantity +
                ", itemPrice=" + itemPrice +
                ", subTotal=" + subTotal +
                ", order=" + customerOrder +
                '}';
    }
}
