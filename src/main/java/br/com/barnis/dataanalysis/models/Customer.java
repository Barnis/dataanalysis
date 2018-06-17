package br.com.barnis.dataanalysis.models;

import java.util.Objects;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public class Customer implements AbstractModel{

    private String Cnpj;

    private String name;

    private String businessArea;

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String cnpj) {
        Cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getCnpj(), customer.getCnpj()) &&
                Objects.equals(getName(), customer.getName()) &&
                Objects.equals(getBusinessArea(), customer.getBusinessArea());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCnpj(), getName(), getBusinessArea());
    }
}
