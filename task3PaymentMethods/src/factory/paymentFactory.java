package factory;

import payment.PayPal;
import payment.creditCard;
import payment.crypto;
import payment.paymentMethod;

public class paymentFactory {
    public static paymentMethod createPaymentMethod(String type){
        switch(type.toLowerCase()){
            case "credit_card":
                return new creditCard();
            case "paypal":
                return new PayPal();
            case "crypto":
                return new crypto();
            default:
                throw new IllegalArgumentException("Неизвестный тип оплаты для данного сервиса: " + type);
        }
    }
}
