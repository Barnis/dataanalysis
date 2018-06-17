package br.com.barnis.dataanalysis.domain;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public enum EnumLayoutType {

    SALESMAN("001") {
        @Override
        public LayoutProcessor returnLayoutProcessor(){
            return new LayoutProcessorSalesman();
        }
    },

    CUSTOMER("002") {
        @Override
        public LayoutProcessor returnLayoutProcessor(){
            return new LayoutProcessorCustomer();
        }
    },

    SALES_DATA("003") {
        @Override
        public LayoutProcessor returnLayoutProcessor(){
            return new LayoutProcessorSalesData();
        }
    };

    private final String layoutId;

    EnumLayoutType(String layoutId){
        this.layoutId = layoutId;
    }

    public static EnumLayoutType layoutByCodeId(String layoutId){
        for(EnumLayoutType enumLayoutType : EnumLayoutType.values()){
            if(enumLayoutType.layoutId.equals(layoutId)){
                return enumLayoutType;
            }
        }
        throw new IllegalArgumentException("Layout Code not found");
    }

    public String getLayoutCode(){
        return this.layoutId;
    }

    public abstract LayoutProcessor returnLayoutProcessor();
}
