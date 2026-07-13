import {test, expect} from "@playwright/test"

test("Target Practice", async({page})=>{

    await page.goto("https://training-support.net/webelements/target-practice");
    const pageTitle = await page.title();
    console.log(`Title of page is : ${pageTitle}`);
    const cyanButtonText =await  page.getByText("Cyan").textContent();
    console.log(cyanButtonText);
    const heading5Classes = await page.getByRole("heading").filter({hasText : "Heading #6"}).getAttribute('class');
    console.log(heading5Classes);

    const heading5 = page.getByRole("heading").filter({hasText : "Heading #5"});
    console.log(
        await heading5.evaluate((heading) => 
            window.getComputedStyle(heading).getPropertyValue("color")
        )
    );

    const pinkButtonDimension = await page.getByRole("button").filter({hasText : "Pink"}).boundingBox();
    console.log(
        pinkButtonDimension
    );

    await page.close();
});