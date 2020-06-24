# Spring MVC

docs: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html

## What is Spring MVC?

Spring MVC is a module for Spring which supports MVC development pattern and web applications for 
Spring projects.  As part of the MVC pattern, Spring MVC introduces 3 new stereo annotations:
@Controller, @Service, @Repository to identity specific layers of our application. Additionally
Spring MVC implements a lot of preprocessing logic for routing requests to handler controllers and
automatic registration of these controllers to Spring. It's important to note that Spring MVC also
manages the resolution of files to serve through views.  We will primarily focus on RESTful applications
(web APIs) rather than server side rendering, so we won't use these, but they are an important part
of how Spring MVC works.

Spring Architecture Knowledge:

1. Provide step-by-step processing explanation.
	eg. First requests are received by the dispatcher servlet. Second the dispatcher servlet attempts
		to map the request to a controller using the HandlerMapper.  Then this information is returned 
		to the dispatcher servlet, which passes it along to the handler adapter, which provides 
		preprocessing steps before passing the request along to our own controller.  This is the first 
		point where our own code is invoked.  We can then do our internal processing (pass to service, 
		repository, database, etc). Spring MVC will then expect us to return a View name or a ModelAndView
		. The View name is then passed back to the dispatcher servlet which will pass it to the view resolver
		which will attempt to find a matching view (effectively a matching .jsp to render).  If Model
		data is present, the .jsp will be rendered with the data provided by the model. In our own code
		we will build RESTful APIs, so instead of our controllers returning view names they will return
		JSON data, and the view steps will be skipped.
		
2. Be able to draw out the structure.