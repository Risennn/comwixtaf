# comwixtaf
Home task

Test automation framework based on Serenity Cucumber Archetype: https://mvnrepository.com/artifact/net.serenity-bdd/serenity-cucumber-archetype

Test scenario (cucumber feature file) can be found in project resources: \comwixtaf\src\test\resources\features\cart\CartManipulations.feature
Might need to install cucumber plugin for Idea: https://plugins.jetbrains.com/plugin/7212-cucumber-for-java

To run test: 
1. Set system environment property with a path to chromedriver e.g.: webdriver.chrome.driver=C:\chromedriver
2. Run test with \comwixtaf\src\test\java\comwittaf\CartManipulationsTest.java 

To check report:
1. run command in terminal: mvnw serenity:aggregate
2. find and open index.html in browser: \comwixtaf\target\site\serenity\index.html
