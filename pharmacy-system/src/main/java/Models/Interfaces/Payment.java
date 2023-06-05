package Models.Interfaces;

import Models.Cash;
import Models.CreditCard;

public interface Payment {
    void Pay(CreditCard card) throws Exception;
    void Pay(Cash cash);
}
