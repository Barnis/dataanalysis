package br.com.barnis.dataanalysis.models;

import java.util.Objects;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public class SaleItem {

    private String id;

    private Integer quantity;

    private Float price;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;

    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleItem)) return false;
        SaleItem saleItem = (SaleItem) o;
        return Objects.equals(getId(), saleItem.getId()) &&
                Objects.equals(getQuantity(), saleItem.getQuantity()) &&
                Objects.equals(getPrice(), saleItem.getPrice());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getQuantity(), getPrice());
    }


}
