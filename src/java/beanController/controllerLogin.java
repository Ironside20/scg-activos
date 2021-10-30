package beanController;

import beanEJB.UsuarioFacadeLocal;
import beanModelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.Query;

/**
 *
 * @author Ironside
 */
@Named(value = "controllerLogin")
@ViewScoped

public class controllerLogin implements Serializable {

    private Usuario usuario;
    private List<Usuario> _listaUsuario;

    @EJB
    private UsuarioFacadeLocal usuarioEJB;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        return _listaUsuario;
    }

    public void setListaUsuario(List<Usuario> _listaUsuario) {
        this._listaUsuario = _listaUsuario;
    }
    
   
    private void obtenerDatosUsuario() {
        this._listaUsuario = this.usuarioEJB.findAll();
    }

    public String validar() {

        String outcome = null;
        boolean resp = false;

        try {
                        obtenerDatosUsuario();
            for (Usuario user: _listaUsuario){
                if(user.getUser().equals(usuario.getUser()) && user.getClave().equals(usuario.getClave()) )
                    resp= true;
            
            }
            if(resp){
                outcome="front-end/inicio";
            
            }else{
                        String msg="Credenciales Incorrectas";
                        String compenentID=null;
                        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                        FacesContext facesContext=FacesContext.getCurrentInstance();
                        facesContext.addMessage(compenentID, facesMessage);
            }
        } catch (Exception e) {
            throw e;
        }
        return outcome;
        }

    }


