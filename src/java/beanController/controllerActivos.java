package beanController;

import beanEJB.ActivosFacadeLocal;
import beanModelo.Activos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ironside
 */
@Named(value = "controllerActivos")
@RequestScoped

public class controllerActivos implements  Serializable{
    
    private Activos _activos = new Activos();
    private List<Activos> _listaActivos;
    private String message;

    @EJB //enfocada para el FDL
    private ActivosFacadeLocal _activosfacedelocal;

    //Inicia la activos  
    @PostConstruct
    public void iniit() {
        _activos = new Activos();

    }

    public Activos getActivos() {
        return _activos;
    }

    public void setActivos(Activos _activos) {
        this._activos = _activos;
    }

    public List<Activos> getListaActivos() {
        _listaActivos = _activosfacedelocal.findAll();
        return _listaActivos;
    }

    public void setListaActivos(List<Activos> _listaActivos) {
        this._listaActivos = _listaActivos;
    }

    public void registrarActivos() {
        
        try {
            this._activosfacedelocal.create(_activos);
            this.message = "Registro Guardado";
            _activos= new Activos();

        } catch (Exception e) {
            e.printStackTrace();
            this.message="Error" +e.getMessage();
        }
        FacesMessage message= new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

  
    
}
