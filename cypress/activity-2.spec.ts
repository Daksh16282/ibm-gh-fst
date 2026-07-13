import {test, expect} from "@playwright/test"

test("Sending Input", async({page})=>{

    await page.goto("https://training-support.net/webelements/simple-form");
    console.log(`Title of page is : ${page.title}`);
    await page.getByPlaceholder("Full name").fill('Random Person');
    await page.getByPlaceholder("Email Address").fill('random@random.com');
    await page.getByTestId("event-date").fill('2026-08-12');
    await page.locator("//textarea[@id='additional-details']").fill('Random');
    await page.getByText("Submit").click();
    let receivedMessage =  page.getByText("Your event has been scheduled!").textContent;
    console.log(`Message on confirmation is : ${receivedMessage}`);
    await page.close();
});