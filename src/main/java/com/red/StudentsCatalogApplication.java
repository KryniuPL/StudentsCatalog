package com.red;

import com.red.commands.Command;
import com.red.model.MenuItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.red.utils.ConsoleUiUtils.*;

public class StudentsCatalogApplication {

    private static List<MenuItem> buildMenuItemLists(List<String> items) {
        return items.stream()
                .map(item -> {
                    var index = items.indexOf(item) + 1;
                    return new MenuItem(index, item);
                })
                .collect(Collectors.toList());
    }

    private static final Command[] commands = Command.values();

    private static final List<MenuItem> menuItemList = buildMenuItemLists(
            Arrays.stream(commands)
                    .map(Command::getMessage)
                    .collect(Collectors.toList())
    );

    public static void main(String[] args) {
        showGreetingMessage();

        while (true) {
            showMenuItems(menuItemList);
            showQueryMessage();
            int scannedInput = getUserInput(menuItemList);
            if (menuItemList.stream().map(MenuItem::getIndex).collect(Collectors.toList()).contains(scannedInput)) {
                commands[--scannedInput].getCommandProvider().execute();
            } else {
                showOutOfRangeMessage();
            }
        }
    }
}
