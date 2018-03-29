package view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class HomeView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//private final MenuView sessionBean;
	private String loadHome = "";
	
	
	/*@Inject
	public HomeView(MenuView sessionBean) {
		this.sessionBean = sessionBean;
	}

	@PostConstruct
	private void init(){
		this.sessionBean.setSelectedItem(MenuButtons.INICIO);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("menubar");
	}*/

	public String getLoadIndex() {
		return loadHome;
	}

	public void setLoadIndex(String loadIndex) {
		this.loadHome = loadIndex;
	}
	
}
