package com.sistema.beans;

import com.sistema.dao.loginDao;
import com.sistema.token.JwtTokenUtil;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author SYNC
 *
 */
@ManagedBean(name = "loginBean")
@ViewScoped
public class loginBean {

    private String login;
    private String password;
    private static  String token;

    public String autenticar() throws Exception {
        JwtTokenUtil token = new JwtTokenUtil();
        FacesMessage mensagem;
        int statusCod = 0;
        loginBean adduser = new loginBean();
        loginDao authenticate = new loginDao();
        adduser.setLogin(login);
        adduser.setPassword(password);
        //Gerar token
        setToken(token.generateToken(login));
        System.out.println("Token: " +adduser.getToken());
        if (token.validateToken(getToken(), login)) {
            System.out.println("Token ok: " );
            statusCod = authenticate.validate(adduser);
            switch (statusCod) {
                case 0:
                    mensagem = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Banco de dados desconectado!", null);
                    FacesContext.getCurrentInstance().addMessage(null, mensagem);
                    return null;
                case 200:

                    FacesContext.getCurrentInstance().getExternalContext().redirect("Dashboard.xhtml");
                    return null;

                case 250:
                    mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campos vazio!", null);
                    FacesContext.getCurrentInstance().addMessage(null, mensagem);
                    return null;

                case 400:
                    mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha incorretar!", null);
                    FacesContext.getCurrentInstance().addMessage(null, mensagem);
                    return null;
                default:
                    return null;
            }
        } else {
            System.out.println("Falhou");
        }
        return null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String aToken) {
        token = aToken;
    }



}
