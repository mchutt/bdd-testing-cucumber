package com.solvd.carina.saucedemo.utils;

import com.solvd.carina.saucedemo.gui.components.ProductCard;
import com.solvd.carina.saucedemo.gui.enums.SortType;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public interface ISortingHelper {

    default boolean isProductListSorted(List<ProductCard> list, SortType type) {
        switch (type) {
            case NAME_A_TO_Z:
                return isSortedInAscendingOrder(extractProductNames(list));
            case NAME_Z_TO_A:
                return isSortedInDescendingOrder(extractProductNames(list));
            case PRICE_LOW_TO_HIGH:
                return isSortedInAscendingOrder(extractProductPrices(list));
            case PRICE_HIGH_TO_LOW:
                return isSortedInDescendingOrder(extractProductPrices(list));
            default:
                throw new NotImplementedException("sorting type not implemented: " + type);
        }
    }

    // helper methods
    private List<Double> extractProductPrices(List<ProductCard> list) {
        return list.stream().map(ProductCard::getPrice).collect(Collectors.toList());
    }

    private List<String> extractProductNames(List<ProductCard> list) {
        return list.stream().map(ProductCard::getProductName).collect(Collectors.toList());
    }

    private <T extends Comparable<T>> boolean isSortedInAscendingOrder(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private <T extends Comparable<T>> boolean isSortedInDescendingOrder(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }
}
