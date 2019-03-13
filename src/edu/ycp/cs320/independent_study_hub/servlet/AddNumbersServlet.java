package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.NumbersController;
import edu.ycp.cs320.independent_study_hub.model.Numbers;

public class AddNumbersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("AddNumbers Servlet: doGet");	
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("AddNumbers Servlet: doPost");
		
		// create GuessingGame model - model does not persist between requests
		// must recreate it each time a Post comes in 
		Numbers model = new Numbers();
		
		// create GuessingGame controller - controller does not persist between requests
		// must recreate it each time a Post comes in
		NumbersController controller = new NumbersController();
		
		// assign model reference to controller so that controller can access model.  Without doing this, we would
		//store values in the model's field but when we call the controller's methods (i.e. add and multiply) it 
		//would not be accessing our model's fields
		controller.setModel(model);

		// holds the error message text, if there is any
		String errorMessage = null;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			//When the doPost is issued, the servlets will get the parameter labeled as first, second, third
			//and set the model's first, second, third fields, respectively
			model.setFirst(getDoubleFromParameter(req.getParameter("first")));
			model.setSecond(getDoubleFromParameter(req.getParameter("second")));
			model.setThird(getDoubleFromParameter(req.getParameter("third")));

			// check for errors in the form data before using is in a calculation
			if (model.getFirst() == null || model.getSecond() == null || model.getThird() == null) {
				errorMessage = "Please specify three numbers";
			}
			// otherwise, data is good, do the calculation
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			else {
				controller.add(model.getFirst(), model.getSecond(), model.getThird());
			}
		} catch (NumberFormatException e) {
			errorMessage = "Invalid double";
		}
		
		// set "numbers" attribute to the model reference
		// the JSP will reference the model elements through "numbers"
		req.setAttribute("numbers", model);
		
		// Add parameters as request attributes
		// this creates attributes named "first" and "second for the response, and grabs the
		// values that were originally assigned to the request attributes, also named "first" and "second"
		// they don't have to be named the same, but in this case, since we are passing them back
		// and forth, it's a good idea
		req.setAttribute("numbers.first", model.getFirst()); //Issue
		req.setAttribute("numbers.second", model.getSecond());
		req.setAttribute("numbers.third", model.getThird());
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", model.getResult());
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
	}

	// gets double from the request with attribute named s
	private Double getDoubleFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Double.parseDouble(s);
		}
	}
}
