package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller{
    private PriceList priceList;

    Stock stock;
    double profit;

    public IceCreamCar(PriceList priceList) {
        this.priceList = priceList;
        stock = new Stock(3,3,10,4);

    }

    
    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        profit += priceList.getRocketprice() * flavors.length * 0.25;
        return prepareCone(flavors);
    }

    private Cone prepareCone(Cone.Flavor[] flavors){

        if (stock.getCones() > 0 && stock.getBalls() > 0 && flavors.length <= stock.getBalls()) {
            stock.setCones(stock.getCones()-1);
            stock.setBalls(stock.getBalls() - flavors.length);
            return new Cone(flavors);
        } else System.out.println("no more");

        return null;

    }
    
    @Override
    public IceRocket orderIceRocket() {
        profit += priceList.getRocketprice() * 0.20;
        return prepareIceRocket();
    }

    private IceRocket prepareIceRocket(){

        if (stock.getIceRockets() > 0) {
            stock.setIceRockets(stock.getIceRockets()-1);
            return new IceRocket();
        } else System.out.println("no more");

        return null;

    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        profit += priceList.getMagnumPrice(type) * 0.01;
        return prepareMagnum(type);
    }

    private Magnum prepareMagnum(Magnum.MagnumType type){
        if (stock.getMagni() > 0) {
            stock.setMagni(stock.getMagni()-1);
            return new Magnum(type);
        } else System.out.println("no more");

        return null;
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
