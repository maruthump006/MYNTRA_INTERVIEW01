$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Myntra.feature");
formatter.feature({
  "name": "Myntra Web Application Automation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add T-Shirt to Bag",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I open the Myntra web application",
  "keyword": "Given "
});
formatter.match({
  "location": "myntraOrder.i_open_the_Myntra_web_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I type and search for the \"T-Shirt\" product",
  "keyword": "And "
});
formatter.match({
  "location": "myntraOrder.i_type_and_search_for_the_product(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select the first product",
  "keyword": "And "
});
formatter.match({
  "location": "myntraOrder.i_select_the_first_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select the \"M\" size",
  "keyword": "And "
});
formatter.match({
  "location": "myntraOrder.i_select_the_size(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the \"Add To Bag\" button",
  "keyword": "And "
});
formatter.match({
  "location": "myntraOrder.i_click_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the current tab",
  "keyword": "Then "
});
formatter.match({
  "location": "myntraOrder.i_close_the_current_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the bag icon",
  "keyword": "And "
});
formatter.match({
  "location": "myntraOrder.i_click_the_bag_icon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I take a screenshot of the selected bag",
  "keyword": "And "
});
formatter.match({
  "location": "myntraOrder.i_take_a_screenshot_of_the_selected_bag()"
});
formatter.result({
  "status": "passed"
});
});