package com.test.automation.pageaction;

import com.test.automation.testbase.ObjectRepoWE;
import org.openqa.selenium.WebElement;

/**
 * @author Narendra Marbate
 *
 * - Validate product added to the Cart are present in the Cart and are correct
 */
public class CartPageActions {
  public boolean verifyItemsInCart(String cartItem) {
    boolean iteamAvailableinCart = false;
    for (WebElement ele : ObjectRepoWE.elementName) {
      if (cartItem.equals(ele.getText())) {
        iteamAvailableinCart = true;
        break;
      }
    }
    return iteamAvailableinCart;
  }
}
