package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.PriceList;

public class IceCreamAppV2 {
    public static void main(String[] args) {

        PriceList priceList = new PriceList(1,1,1);
        IceCreamCar iceCreamCar = new IceCreamCar(priceList);

        Eatable[] eatables = {
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS),
                iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES),
                iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.LEMON, Cone.Flavor.MOKKA}),
                iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.LEMON}),
                iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.PISTACHE}),
                iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.STRATCIATELLE})};

        for (Eatable eatable : eatables) {
            eatable.eat();
        }

        System.out.println(iceCreamCar.getProfit());










    }
}
