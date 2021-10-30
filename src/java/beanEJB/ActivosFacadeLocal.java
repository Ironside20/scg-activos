/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEJB;

import beanModelo.Activos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ironside
 */
@Local
public interface ActivosFacadeLocal {

    void create(Activos activos);

    void edit(Activos activos);

    void remove(Activos activos);

    Activos find(Object id);

    List<Activos> findAll();

    List<Activos> findRange(int[] range);

    int count();
    
}
