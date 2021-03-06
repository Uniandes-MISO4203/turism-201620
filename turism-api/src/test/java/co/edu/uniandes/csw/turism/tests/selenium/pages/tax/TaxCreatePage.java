/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.turism.tests.selenium.pages.tax;


import co.edu.uniandes.csw.turism.dtos.minimum.TaxDTO;
import static org.jboss.arquillian.graphene.Graphene.guardAjax;
import static org.jboss.arquillian.graphene.Graphene.waitGui;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.jboss.arquillian.graphene.Graphene.waitGui;

/**
 *
 * @author lm.ariza10
 */
public class TaxCreatePage {
    @FindBy(id = "name")
    private WebElement nameInput;
    @FindBy(id = "description")
    private WebElement descriptionInput;
    @FindBy(id = "value")
    private WebElement valueInput;

    @FindBy(id = "save-tax")
    private WebElement saveBtn;

    @FindBy(id = "cancel-tax")
    private WebElement cancelBtn;

    public void saveTrip(TaxDTO tax) {
         waitGui().until().element(nameInput).is().visible();
         nameInput.clear();
         nameInput.sendKeys(tax.getName());
         waitGui().until().element(descriptionInput).is().visible();
         descriptionInput.clear();
         descriptionInput.sendKeys(tax.getDescription());
         waitGui().until().element(valueInput).is().visible();
         valueInput.clear();
         valueInput.sendKeys(tax.getValue().toString());
        guardAjax(saveBtn).click();
    }
}
