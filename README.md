##WEBAPI-NODEJS##

This project show an implementation of different task-runner / build tool / module bundler in a NodeJS web application. For each tools we choose to
use different plugins / modules, providing a complete scenario to evaluate each tools and show their PRO and CONS.
Moreover this project has been achieved using Lerna, a tool for managing projects with multiple packages.

Differences between the used toolkits along with all their plugins will be shown below.

**GULP**  

	PRO:  
		- More control over the flow  
		- Greater clarity  
		- Faster Performance due to the usage of STREAM  
		- Large ecosystem with thousends of plugins 
		- Requires less amount of code  
		- Allows creating task dependencies  
		- Streaming build system makes it easier to apply code transformations
  

	CONS:
		- Streams are hard to understand
		- Errors that occur inside a Gulp wrapper arean't always handled very well
		- Gulp plugins often get out of date and dont support new features from the underlying library
		- Debugging a Gulp plugin can be frustrating
		- You need to know some limitations that are not very intuitive
  
	PLUGINS:  
		- Beautifier, reformat and re-indent bookmarklets, ugly JS  
		- Benchmark, robust benchmark library to get statistically significant results  
		- Concat, concatenate multiple file  
		- Uglify, minifying .js files  
  
  **GRUNT**  
  
	PRO:  
		- Huge ecosystem of plugins to perform various tasks  
		- Faster performance  
		- Easy to finds stuff with his declarative configuration style and nested json  
		- Its possbile to use shell commands inside Grunt  
		
  
	CONS: 
		- The need to track creation/movement of files make it very hard 
		- The lack of backward compatibility is painfull
		- Can become complicated as the configuration grows
		- Tend to outdating
		- Lack of flexibility with uncommon tasks
		
	PLUGINS:
		- Cordova, a plugin test runner for Jasmine
		- JShint, to ensure that the code adheres to best practice
		- Uglify, create a file that contains the result of minifying the JS files
		- Watch, provide tools that make managing the watching of file and directory trees easier

**WEBPACK**

	PRO:	
		- Good control over assets processing
		- Elimination of dead assets
		- Multiple options and features right out of the box
		- Webpack-dev-server supports hot and live reloading

	CONS:
		- Difficult to configure
		- Can not load files discovered during runtime
