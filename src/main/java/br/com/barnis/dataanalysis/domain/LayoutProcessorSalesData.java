package br.com.barnis.dataanalysis.domain;

import br.com.barnis.dataanalysis.models.SalesData;

import java.util.List;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public class LayoutProcessorSalesData implements LayoutProcessor<SalesData> {

    private final String layoutCode = "003";

    private final String layoutName = "SalesData";

    private static List<SalesData> SALES_DATA_LIST;

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
    public List<SalesData> obtainModel() {
        return null;
    }


}
