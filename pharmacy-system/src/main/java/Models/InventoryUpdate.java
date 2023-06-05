package Models;

import Models.Enums.ReasonOfRemoval;

public class InventoryUpdate {
    public String ID;
    public int quantity;
    public ReasonOfRemoval reasonOfRemoval;

    public InventoryUpdate(String id, int quantity, ReasonOfRemoval reasonOfRemoval) {
        this.ID = id;
        this.quantity = quantity;
        this.reasonOfRemoval = reasonOfRemoval;

        // TODO: removing item from stock logic
    }

}
