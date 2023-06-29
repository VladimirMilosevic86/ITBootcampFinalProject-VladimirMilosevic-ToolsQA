package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BasePage {

    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "searchBox")
    WebElement serachBox;

    @FindBy (className = "rt-resizable-header-content")
    List<WebElement> columnName;

    @FindBy (className = "rt-td")
    List<WebElement> rows;

    //@FindBy (id = "delete-record-2")
    //WebElement deleteButtonFor2ndRecord;

    public void insertFirstNameInSearchBox(String firstName) {
        serachBox.clear();
        serachBox.sendKeys(firstName);
    }

    public String searchFirstNameInColumn(String searchedFirstName) {
        String realFirstName = "";
        for (int i = 0; i < columnName.size(); i++) {
            if (columnName.get(i).getText().equals("First Name")) {
                for (int j = 0; j < rows.size(); j++) {
                    if (rows.get(j).getText().equals(searchedFirstName)) {
                        realFirstName = searchedFirstName;
                    }
                }
            }
        }
        return realFirstName;
    }

    public void deleteEmployeeFromWebTable(String firstName, String lastName, String age, String email, String salary, String department, int row) {
        String locator = "delete-record-" + row;
        WebElement deleteButton;
        for (int i = 0; i < columnName.size(); i++) {
            if (columnName.get(i).getText().equals("First Name")) {
                for (int j = 0; j < rows.size(); j++) {
                    if (rows.get(j).getText().equals(firstName)) {
                        for (int k = 0; k < columnName.size(); k++) {
                            if (columnName.get(k).getText().equals("Last Name")) {
                                for (int l = 0; l < rows.size(); l++) {
                                    if (rows.get(l).getText().equals(lastName)) {
                                        for (int m = 0; m < columnName.size(); m++) {
                                            if (columnName.get(m).getText().equals("Age")) {
                                                for (int n = 0; n < rows.size(); n++) {
                                                    if(rows.get(n).getText().equals(age)) {
                                                        for (int o = 0; o < columnName.size(); o++) {
                                                            if (columnName.get(o).getText().equals("Email")) {
                                                                for (int p = 0; p < rows.size(); p++) {
                                                                    if (rows.get(p).getText().equals(email)) {
                                                                        for (int q = 0; q < columnName.size(); q++) {
                                                                            if (columnName.get(q).getText().equals("Salary")) {
                                                                                for (int r = 0; r < rows.size(); r++) {
                                                                                    if (rows.get(r).getText().equals(salary)) {
                                                                                        for (int s = 0; s < columnName.size(); s++) {
                                                                                            if(columnName.get(s).getText().equals("Department")) {
                                                                                                for (int t = 0; t < rows.size(); t++) {
                                                                                                    if (rows.get(t).getText().equals(department)) {
                                                                                                        deleteButton = driver.findElement(By.id(locator));
                                                                                                        deleteButton.click();
                                                                                                    }

                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public boolean isEmployeeInTheWebTable(String firstName, String lastName, String age, String email, String salary, String department) {
        for (int i = 0; i < columnName.size(); i++) {
            if (columnName.get(i).getText().equals("First Name")) {
                for (int j = 0; j < rows.size(); j++) {
                    if (rows.get(j).getText().equals(firstName)) {
                        for (int k = 0; k < columnName.size(); k++) {
                            if (columnName.get(k).getText().equals("Last Name")) {
                                for (int l = 0; l < rows.size(); l++) {
                                    if (rows.get(l).getText().equals(lastName)) {
                                        for (int m = 0; m < columnName.size(); m++) {
                                            if (columnName.get(m).getText().equals("Age")) {
                                                for (int n = 0; n < rows.size(); n++) {
                                                    if(rows.get(n).getText().equals(age)) {
                                                        for (int o = 0; o < columnName.size(); o++) {
                                                            if (columnName.get(o).getText().equals("Email")) {
                                                                for (int p = 0; p < rows.size(); p++) {
                                                                    if (rows.get(p).getText().equals(email)) {
                                                                        for (int q = 0; q < columnName.size(); q++) {
                                                                            if (columnName.get(q).getText().equals("Salary")) {
                                                                                for (int r = 0; r < rows.size(); r++) {
                                                                                    if (rows.get(r).getText().equals(salary)) {
                                                                                        for (int s = 0; s < columnName.size(); s++) {
                                                                                            if(columnName.get(s).getText().equals("Department")) {
                                                                                                for (int t = 0; t < rows.size(); t++) {
                                                                                                    if (rows.get(t).getText().equals(department)) {
                                                                                                        return true;
                                                                                                    }

                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }

                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return false;
    }

}
