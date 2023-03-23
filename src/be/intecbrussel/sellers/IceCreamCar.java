package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.Optional;

public class IceCreamCar implements IceCreamSeller {
    private PriceList priceList;

    Stock stock;
    double profit;

    public IceCreamCar(PriceList priceList) {
        this.priceList = priceList;
        stock = new Stock(1, 3, 10, 4);
    }


    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        return prepareCone(flavors);
    }

    private Cone prepareCone(Cone.Flavor[] flavors) {

        if (stock.getCones() <= 0 || stock.getBalls() <= 0 || flavors.length > stock.getBalls()) {
            System.out.prinln("No more Cones")
            return null;
        } else {
            profit += priceList.getRocketprice() * flavors.length * 0.25;
            stock.setCones(stock.getCones() - 1);
            stock.setBalls(stock.getBalls() - flavors.length);
            return new Cone(flavors);
        }

    }

    @Override
    public IceRocket orderIceRocket() {
        return prepareIceRocket();
    }

    private IceRocket prepareIceRocket() {
        if (stock.getIceRockets() <= 0){
            System.out.prinln("No more icerockets")
            return null;
        } else {
            profit += priceList.getRocketprice() * 0.20;
            stock.setIceRockets(stock.getIceRockets() - 1);
            return new IceRocket();
        }
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        return prepareMagnum(type);
    }

    private Magnum prepareMagnum(Magnum.MagnumType type) {
        if (stock.getMagni() > 0) {
            System.out.prinln("No more magni")
            return null;
        } else {
            profit += priceList.getMagnumPrice(type) * 0.01;
            stock.setMagni(stock.getMagni() - 1);
            return new Magnum(type);
        }
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
