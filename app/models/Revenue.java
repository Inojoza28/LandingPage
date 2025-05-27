package models;

import io.ebean.Finder;
import io.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Revenue extends Model {
    @Id
    private Long id;
    private String month;
    private Double amount;

    public static final Finder<Long, Revenue> find = new Finder<>(Revenue.class);

    public static List<Revenue> findAll() {
        return find.all();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
