# Currency converter

## Your Task
You’ve got a basic spring-boot application. You can open the web interface using:
http://localhost:8080/

Please create a currency converter website which will have input fields for amount and from/to
currency selection you want to exchange. Website should looks like following (it does not have to be beautiful but functional):

![mockup](./task-mockup.png)

Use exchange rates API from https://exchangeratesapi.io/ to get all the required conversion rates.

### Important considerations:
- The project was created with a certain version of Java and Spring, but feel free to upgrade it to the latest versions.
- Use the symbols and latest rates API from https://exchangeratesapi.io/ (don't use the convert endpoint, we expect you to implement conversion based on latest rates yourself)
- Calls to exchange-rates API should be proxied through the application
- Design your own currency conversion API
- Consider caching of exchange-rates API calls
