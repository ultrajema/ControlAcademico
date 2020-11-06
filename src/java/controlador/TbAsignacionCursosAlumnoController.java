package controlador;

import modelo.TbAsignacionCursosAlumno;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("tbAsignacionCursosAlumnoController")
@SessionScoped
public class TbAsignacionCursosAlumnoController implements Serializable {

    @EJB
    private controlador.TbAsignacionCursosAlumnoFacade ejbFacade;
    private List<TbAsignacionCursosAlumno> items = null;
    private TbAsignacionCursosAlumno selected;

    public TbAsignacionCursosAlumnoController() {
    }

    public TbAsignacionCursosAlumno getSelected() {
        return selected;
    }

    public void setSelected(TbAsignacionCursosAlumno selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TbAsignacionCursosAlumnoFacade getFacade() {
        return ejbFacade;
    }

    public TbAsignacionCursosAlumno prepareCreate() {
        selected = new TbAsignacionCursosAlumno();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TbAsignacionCursosAlumnoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TbAsignacionCursosAlumnoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TbAsignacionCursosAlumnoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TbAsignacionCursosAlumno> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public TbAsignacionCursosAlumno getTbAsignacionCursosAlumno(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TbAsignacionCursosAlumno> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TbAsignacionCursosAlumno> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TbAsignacionCursosAlumno.class)
    public static class TbAsignacionCursosAlumnoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TbAsignacionCursosAlumnoController controller = (TbAsignacionCursosAlumnoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tbAsignacionCursosAlumnoController");
            return controller.getTbAsignacionCursosAlumno(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TbAsignacionCursosAlumno) {
                TbAsignacionCursosAlumno o = (TbAsignacionCursosAlumno) object;
                return getStringKey(o.getIdAsignacionCurso());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TbAsignacionCursosAlumno.class.getName()});
                return null;
            }
        }

    }

}
