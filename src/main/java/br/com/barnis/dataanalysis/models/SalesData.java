package br.com.barnis.dataanalysis.models;

import java.util.List;
import java.util.Objects;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public class SalesData implements AbstractModel {

    private String saleId;

    private List<SaleItem> listSaleItems;

    private SalesMan salesMan;

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public List<SaleItem> getListSaleItems() {
        return listSaleItems;
    }

    public void setListSaleItems(List<SaleItem> listSaleItems) {
        this.listSaleItems = listSaleItems;
    }

    public SalesMan getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(SalesMan salesMan) {
        this.salesMan = salesMan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesData)) return false;
        SalesData salesData = (SalesData) o;
        return Objects.equals(getSaleId(), salesData.getSaleId()) &&
                Objects.equals(getListSaleItems(), salesData.getListSaleItems()) &&
                Objects.equals(getSalesMan(), salesData.getSalesMan());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSaleId(), getListSaleItems(), getSalesMan());
    }
}
