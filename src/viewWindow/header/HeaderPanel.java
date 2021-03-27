package viewWindow.header;

import controller.WPresenter;

import javax.swing.*;

public class HeaderPanel extends JPanel {

    private HeadMenu menu;
    private MenuToolBar toolBar;

    public HeaderPanel(WPresenter wPresenter) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.menu = new HeadMenu(wPresenter);
        //this.add(menu);
        this.toolBar = new MenuToolBar(wPresenter);
        this.add(toolBar);
    }

    public void changeLanguage(){
        toolBar.changeLanguage();
    }
}
