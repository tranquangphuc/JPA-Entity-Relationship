package one.many.inverse;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal discount;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_modified")
    private Date lastModified;

    private int status;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<LineItem> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", discount=" + discount +
                ", createdDate=" + createdDate +
                ", lastModified=" + lastModified +
                ", status=" + status +
                ", items=" + items.size() +
                '}';
    }
}
