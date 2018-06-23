import React from "react";
import renderer from "react-test-renderer";

import Home from "../pages/home/index";

it("renders without crashing", () => {
  const rendered = renderer.create(<Home />).toJSON();
  expect(rendered).toBeTruthy();
});
