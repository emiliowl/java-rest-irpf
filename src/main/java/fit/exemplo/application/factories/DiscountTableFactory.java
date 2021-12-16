package fit.exemplo.application.factories;

import fit.exemplo.application.abstracts.DiscountTable;
import fit.exemplo.application.impl.DiscountTable2021;
import fit.exemplo.application.impl.DiscountTable2022;

public abstract class DiscountTableFactory {
    public static DiscountTable build(int year) {
        if (year == 2021)
            return new DiscountTable2021();
        if (year == 2022)
            return new DiscountTable2022();

        return null;
    }
}
