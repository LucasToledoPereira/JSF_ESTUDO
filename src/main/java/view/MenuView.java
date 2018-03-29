package view;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import enums.MenuButtons;
import model.Theme;
import services.ThemeService;

@Named
@SessionScoped
public class MenuView implements Serializable {

	private static final long serialVersionUID = 1L;
	private MenuButtons selectedItem = MenuButtons.INICIO;
	private Locale locale;
	private List<Theme> themes;
	private String theme;
	
    @Inject
    private ThemeService service;
	
	@PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
        themes = service.getThemes();
        theme = themes.get(0).getName();
    }
	
	public void selectMenu(MenuButtons item){
		this.selectedItem = item;
	}

	public MenuButtons getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(MenuButtons selectedItem) {
		this.selectedItem = selectedItem;
	}
	
	public String changeLocaleUS(){
		this.setLocale(new Locale("en_US"));
		this.selectedItem = MenuButtons.INICIO;
		return "index";
	}
	
	public String changeLocaleBR(){
		this.setLocale(new Locale("pt_BR"));
		this.selectedItem = MenuButtons.INICIO;
		return "index";
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
	}

    public List<Theme> getThemes() {
        return themes;
    }
 
    public void setService(ThemeService service) {
        this.service = service;
    }

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public void changeTheme(){
		try {
			this.selectedItem = MenuButtons.INICIO;
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
