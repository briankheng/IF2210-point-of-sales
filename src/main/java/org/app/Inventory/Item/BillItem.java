package org.app.Inventory.Item;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(fluent = true)
@Root
public class BillItem extends ItemDescription implements Serializable {
    @Element
    @NotNull private int quantity;
    @Element
    @NotNull private String orderType;
    @Element(required = false)
    @Builder.Default
    @NotNull private String notes = "";

    public BillItem(Item item){
        super(item);
        this.quantity = 1;
        this.orderType = "Dine In";
        this.notes = "";
    }

    public BillItem(BillItem item){
        super(item);
        this.quantity = item.quantity();
        this.orderType = new String(item.orderType());
        this.notes = new String(item.notes());
    }
}
