package br.com.barnis.dataanalysis.domain;

import br.com.barnis.dataanalysis.models.AbstractModel;

import java.util.List;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public interface LayoutProcessor <E extends AbstractModel> {


    String getLayoutCode();

    String layoutName();

    void process(String[] data);

    public List<E> obtainModel();



}
