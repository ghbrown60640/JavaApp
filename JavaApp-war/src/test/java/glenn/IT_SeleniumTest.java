/*
 * Copyright 2014 glenn.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package glenn;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author glenn
 */
public class IT_SeleniumTest {

    @Test
    public void seleniumTest() {
        StringBuffer verificationErrors = new StringBuffer();
        String baseUrl = "http://localhost:8090";

        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl + "/JavaApp-war/");
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Glenn Brown");
        driver.findElement(By.name("Submit")).click();
// Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}
