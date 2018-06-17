package br.com.barnis.dataanalysis.models;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public class SalesMan implements AbstractModel {

    private String Cpf;

    private String name;

    private BigDecimal salary;

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesMan)) return false;
        SalesMan salesMan = (SalesMan) o;
        return Objects.equals(getCpf(), salesMan.getCpf()) &&
                Objects.equals(getName(), salesMan.getName()) &&
                Objects.equals(getSalary(), salesMan.getSalary());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCpf(), getName(), getSalary());
    }


}
