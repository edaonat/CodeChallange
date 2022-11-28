package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BoardPage {
    public BoardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Plentific Test']")
    public WebElement plentificTest;
    @FindBy(xpath="//*[@title='Automation Board']")
    public WebElement automationBoard;
    @FindBy(xpath = "//*[text()='Automation Board']")
    public WebElement automationBoardText;
    @FindBy(xpath = "//textarea[@aria-label='Plentific']")
    public WebElement plentificListText;
    @FindBy(xpath = "//a[@class='list-card js-member-droppable ui-droppable']")
    public List<WebElement> cards;
    @FindBy(xpath = "//*[@class='badge-icon icon-sm icon-comment']")
    public WebElement commentIcon;
    @FindBy(xpath = "//*[@class='current-comment js-friendly-links js-open-card']")
    public List<WebElement> currentComment;
    @FindBy(xpath = "//*[@class='comment-box-input js-new-comment-input']")
    public WebElement writeComment;
    @FindBy(xpath = "//*[@class='nch-button nch-button--primary confirm mod-no-top-bottom-margin js-add-comment']")
    public WebElement saveComment;
    @FindBy(linkText = "just now")
    public WebElement newComment;
    @FindBy(xpath = "(//*[@class='list-card-details js-card-details'])[2]")
    public WebElement thirdCard;
    @FindBy(xpath = "(//*[text()='Done'])[3]")
    public WebElement doneList;
    @FindBy(xpath = "(//*[@class='card-composer-container js-card-composer-container'])[4]")
    public WebElement doneCard;
    @FindBy(xpath = "//*[@class='icon-md icon-close dialog-close-button js-close-window']")
    public WebElement close;
    @FindBy(xpath = "(//a[text()='Edit'])[2]")
    public WebElement editButton;
    @FindBy(xpath = "(//*[@class='comment-box-input js-text'])[4]")
    public WebElement editTextArea;
    @FindBy(xpath = "(//input[@class='nch-button nch-button--primary confirm mod-no-top-bottom-margin js-save-edit'])[4]")
    public WebElement disableSaveButton;
    @FindBy(xpath = "(//*[@class='js-is-empty-warning'])[1]")
    public WebElement emptyError;
    @FindBy(xpath = "(//a[@class='js-discard-comment-edits icon-lg icon-close dark-hover cancel'])[4]")
    public WebElement cancel;
    @FindBy(xpath = "(//*[@class='js-confirm-delete-action'])[1]")
    public WebElement deleteButton;
    @FindBy(xpath = "//input[@class='js-confirm full nch-button nch-button--danger']")
    public WebElement deleteConfirm;







}

