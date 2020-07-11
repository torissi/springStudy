package com.example.restaurant.interfaces;

import com.example.restaurant.application.MenuItemService;
import com.example.restaurant.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/restaurant/{restaurantId}/menuitems")
    public List<MenuItem> list(@PathVariable Long restaurantId) {
        List<MenuItem> menuItems = menuItemService.getMenuItems(restaurantId);

        return menuItems;
    }

    @PatchMapping("/restaurant/{restaurantId}/menuitems")
    public String bulkUpdate(@RequestBody List<MenuItem> menuItems,
                            @PathVariable("restaurantId") Long restaurantId) {
        menuItemService.bulkUpdate(restaurantId, menuItems);

        return "";
    }
}
