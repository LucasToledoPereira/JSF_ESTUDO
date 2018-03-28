package view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import enums.MenuButtons;

@Named
@SessionScoped
public class MenuView implements Serializable {

	private static final long serialVersionUID = 1L;
	private MenuButtons selectedItem = MenuButtons.INICIO;
	
	public void selectMenu(MenuButtons item){
		this.selectedItem = item;
	}

	public MenuButtons getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(MenuButtons selectedItem) {
		this.selectedItem = selectedItem;
	}

}
