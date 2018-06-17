package br.com.barnis.dataanalysis.domain;

import br.com.barnis.dataanalysis.models.AbstractModel;
import br.com.barnis.dataanalysis.models.Customer;
import br.com.barnis.dataanalysis.models.SalesData;
import br.com.barnis.dataanalysis.models.SalesMan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public interface LayoutProcessor <E extends AbstractModel> {

    public List<SalesMan> processedSalesMan = new ArrayList<>();
    public List<Customer> processedCustomer = new ArrayList<>();
    public List<SalesData> processedSalesData = new ArrayList<>();

    String getLayoutCode();

    String layoutName();

    void process(String[] data);

    public List<E> obtainModel();



}
