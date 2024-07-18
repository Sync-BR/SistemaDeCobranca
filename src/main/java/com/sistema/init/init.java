package com.sistema.init;

import com.sistema.beans.clientesBean;
import com.sistema.beans.loginBean;
import com.sistema.token.JwtTokenUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sync
 * @Configurações iniciais
 */
@ManagedBean(name = "Init")
@RequestScoped
public class init {
    
    public String checkToken() throws Exception {
        JwtTokenUtil token = new JwtTokenUtil();
        if (loginBean.getToken() != null) {
            System.out.println("Token: " +loginBean.getToken());
            String user = token.extractUsername(loginBean.getToken());
            System.out.println(user);
            return null;
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            return null;
        }
     
    }

}
