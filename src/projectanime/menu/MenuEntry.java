package projectanime.menu;

import projectanime.Menu;

public class MenuEntry extends Menu {

    public MenuEntry(String name) {
        super(name);
    }

    private AdditonalOptions additonalOptions;

    public AdditonalOptions getAdditonalOptions() {
        return additonalOptions;
    }

    public void setAdditonalOptions(AdditonalOptions additonalOptions) {
        this.additonalOptions = additonalOptions;
    }

    public void run() {
    }
}
