package br.com.barnis.dataanalysis.domain;

import br.com.barnis.dataanalysis.models.Customer;

import java.util.List;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public class LayoutProcessorCustomer implements LayoutProcessor<Customer> {

    private final String layoutCode = "002";
    private final String layoutName = "CustomerData";

    private static List<Customer> CUSTOMER_LIST;

    @Override
    public String getLayoutCode() {
        return layoutCode;
    }

    @Override
    public String layoutName() {
        return layoutName;
    }

    @Override
    public void process(String[] data) {

    }

    @Override
    public List<Customer> obtainModel() {
        return null;
    }


}
