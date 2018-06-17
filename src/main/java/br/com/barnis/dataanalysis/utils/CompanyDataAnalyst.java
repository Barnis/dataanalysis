package br.com.barnis.dataanalysis.utils;

import br.com.barnis.dataanalysis.domain.EnumLayoutType;
import br.com.barnis.dataanalysis.models.Customer;
import br.com.barnis.dataanalysis.models.SaleItem;
import br.com.barnis.dataanalysis.models.SalesData;
import br.com.barnis.dataanalysis.models.SalesMan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
@Component
public class CompanyDataAnalyst {

    public void generateAnalysisReport(Map<String, List> fileTotals) {
        fileTotals.forEach((k, v) -> {
            if (EnumLayoutType.CUSTOMER.getLayoutCode().equals(k)) {
                processCustomerData(v);
            }else if (EnumLayoutType.SALESMAN.getLayoutCode().equals(k)) {
                processCustomerData(v);
            }else if(EnumLayoutType.SALES_DATA.getLayoutCode().equals(k)){
                processSalesData(v);
            }
        });
    }

    private void processCustomerData(List<Customer> customerList) {
        int totalOfCustomers = customerList.size();
        System.out.println("Total of customers: " + totalOfCustomers);
    }

    private void processSalesManData(List<SalesMan> salesManList) {
        int totalSalesMan = salesManList.size();
        System.out.println("Total of customers: " + totalSalesMan);
    }

    private void processSalesData(List<SalesData> salesData) {

    }

}

