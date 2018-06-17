package br.com.barnis.dataanalysis.domain;

import br.com.barnis.dataanalysis.models.SalesMan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public class LayoutProcessorSalesman implements LayoutProcessor<SalesMan> {

    private final String layoutCode = "001";
    private final String layoutName = "SalesmanData";

    private static List<SalesMan> salesManList = new ArrayList<>();


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
        SalesMan salesMan = new SalesMan();
        salesMan.setCpf(data[1]);
        salesMan.setName(data[2]);
        Float salary = Float.valueOf(data[3]);
        salesMan.setSalary(BigDecimal.valueOf(salary));
        salesManList.add(salesMan);
    }

    @Override
    public List<SalesMan> obtainModel() {
        return salesManList;
    }

}
