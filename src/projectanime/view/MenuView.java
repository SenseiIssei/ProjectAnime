package projectanime.view;

import projectanime.Menu;
import projectanime.menu.AdditonalOptions;
import projectanime.menu.MenuEntry;
import projectanime.util.InputCheck;

import java.util.ArrayList;
import java.util.List;

public class MenuView extends Menu {

    private List<Menu> entries;
    private String menuTitle;

    public MenuView(String name) {
        super(name);
        menuTitle = name;
        entries = new ArrayList<>();
    }

    public String getMenuTitle() {
        if (menuTitle == null) {
            menuTitle = "";
        }
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public List<Menu> getEntries() {
        return entries;
    }

    public void setEntries(List<Menu> entry) {
        this.entries = entry;
    }

    public void addEntryToList(Menu menuEntry) {
        entries.add(menuEntry);

    }

    public void run() {
        boolean loop = true;
        while (loop) {
            StringBuilder allEntries = new StringBuilder();
            int index = 0;
            for (Menu entry: entries) {
                allEntries.append("\t").append(++index).append(". -> ").append(entry.getName()).append("\n");
            }
            String footer = "\n" + charloop("-", 95);
            String header = charloop("-", 95) + "\n"
                    + "|" + charloop(" ", 93) + "|\n"
                    + "|" + prepareTitleline(93) + "|\n"
                    + "|" + charloop(" ", 93) + "|\n"
                    + charloop("-", 95) + "\n";
            String menu = header + "\n" + allEntries + footer;
            System.out.println(menu);
            int input = InputCheck.readInt();
            if (entries != null && !entries.isEmpty()) {
                if (input > 0 && input <= entries.size()) {
                    Menu selectedEntry = entries.get(input - 1);
                    if (selectedEntry instanceof MenuEntry) {
                        MenuEntry entry = (MenuEntry) selectedEntry;
                        if (entry.getAdditonalOptions() == AdditonalOptions.BACK) {
                            loop = false;
                        } else if (entry.getAdditonalOptions() == AdditonalOptions.EXIT) {
                            System.exit(104);
                        } else {
                            entry.run();
                        }
                    } else {
                        selectedEntry.run();
                    }
                }
            }
        }
    }

    public String charloop(String symbol, int amount) {
        String subString = "";
        for (int i = 0;i < amount;i++) {
            subString += symbol;
        }
        return subString;
    }

    public String prepareTitleline(int amount) {
        int lengthwithouttitle = amount - menuTitle.length();
        int lengwithouttitledividedby2 = lengthwithouttitle / 2;
        return charloop(" ", lengwithouttitledividedby2) + menuTitle + charloop(" ", lengwithouttitledividedby2);
    }

}