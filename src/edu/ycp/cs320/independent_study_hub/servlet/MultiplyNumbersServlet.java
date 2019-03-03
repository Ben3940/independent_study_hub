package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.independent_study_hub.controller.NumbersController;
import edu.ycp.cs320.independent_study_hub.model.Numbers;

public class MultiplyNumbersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("MultiplyNumbers Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("MultiplyNumbers Servlet: doPost");
		
		// create GuessingGame model - model does not persist between requests
		// must recreate it each time a Post comes in 
		Numbers model = new Numbers();
				
		// create GuessingGame controller - controller does not persist between requests
		// must recreate it each time a Post comes in
		NumbersController controller = new NumbersController();
				
		// assign model reference to controller so that controller can access modelWithout doing this, we would
		//store values in the model's field but when we call the controller's methods (i.e. add and multiply) it 
		//would not be accessing our model's fields
		controller.setModel(model);
		
		// holds the error message text, if there is any
		String errorMessage = null;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			//Sets first and second values of model.  Since data is not persist, it will need to be re-initialized every time
			model.setFirst(getDoubleFromParameter(req.getParameter("first")));
			model.setSecond(getDoubleFromParameter(req.getParameter("second")));
						
			// check for errors in the form data before using is in a calculation
			if (model.getFirst() == null || model.getSecond() == null) {
				errorMessage = "Please specify two numbers";
			}
			// otherwise, data is good, do the calculation
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			else {				
				//Pulls values from model (rather than HTTP request)
				controller.multiply(model.getFirst(), model.getSecond());
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
		req.setAttribute("numbers.first", model.getFirst());
		req.setAttribute("numbers.second", model.getSecond());
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", model.getResult());
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
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
