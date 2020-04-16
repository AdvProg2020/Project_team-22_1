package controller.menu.userArea.AccessMenu;

import controller.menu.Menu;
import model.Discount;
import model.product.Product;
import model.product.ProductStatus;
import model.product.StockStatus;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class ManagerMenu extends Menu {
    public ManagerMenu (Menu parentMenu) {
        super("Manager Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getCreateDiscountMenu());
        submenus.put(2, getEditDiscountMenu());
        submenus.put(3, getCreateCategoryMenu());
        submenus.put(3, getEditProductInfoMenu());
        this.setSubmenus(submenus);
    }

    private Menu getEditProductInfoMenu() {
        return new Menu("Edit product menu", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                ProductStatus productStatus = null;
                int price = 0;
                StockStatus stockStatus = null;
                String description = null;
                core.editProductInfo(productStatus, price, stockStatus, description);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getCreateCategoryMenu() {
        return new Menu("Create category", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                String name = null;
                ArrayList<Product> productsList = null;
                core.createCategory(name, productsList);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getEditDiscountMenu() {
        return new Menu("Edit discount", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                Discount discount = null;
                Time endTime = null;
                double discountPercent = 0;
                int maxDiscountAmount = 0;
                core.editDiscount(discount, endTime, discountPercent, maxDiscountAmount);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getCreateDiscountMenu() {
        return new Menu("Create discount", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
            }

            @Override
            public void execute() {
                double discountPercent = 0;
                int maxDiscountAmount = 0;
                core.createDiscount(null, null, discountPercent, maxDiscountAmount);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
}
