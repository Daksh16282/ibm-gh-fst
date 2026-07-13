import {test, expect} from "@playwright/test"

test("Clicking a Link", async({page}) => {

    await page.goto("https://training-support.net");
    await expect(page).toHaveTitle("Training Support");
    await page.getByText("About Us").click();
    console.log(page.title);

});