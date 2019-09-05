package Bag;

import java.util.ArrayList;
import java.util.List;

public class BagTask {
    class Item {
        public Item(String name, Double weight, Double price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String name;
        public Double weight;
        public Double price;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    private List<Item> itemList = new ArrayList<>();
    private double maxW;
    private double bestPrise;

    public BagTask(double maxW) {
        this.maxW = maxW;
    }

    //метод для вычисления общего веса набора предметов
    private double CalcWeight(List<Item> itemList) {
        return 0;
    }

    //метод для вычисления общей стоимости набора предметов
    private double CalcPrice(List<Item> itemList) {
        return 0;
    }

    //метод роверяющий явдяется ли данный набор решением задачи
    private void CheckSet(List<Item> items) {

    }

    //статический при тесте
    private double findBestRes(int i, double weight) {
        if (i < 0) {
            return 0;
        }
        if (itemList.get(i).getWeight() > weight) {
            return findBestRes(i - 1, weight);
        } else {
            return Math.max(findBestRes(i - 1, weight), findBestRes(i - 1, weight - itemList.get(i).getWeight())
                    + itemList.get(i).getPrice());
        }
    }
}
