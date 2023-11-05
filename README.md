Hello, this project is a Minesweeper in Java using the library Swing for the graphic interface.


To compile the project you can use the Makefile and run the command make

To execute, use one of the following command :
   - java main/Main
     	  => 10 * 10 grid with 10 mine
	  
   - java main/Main x y z
     	  => x the height of the grid you want
     	  => y the width of the grid you want
     	  => z the number of mine you want
	  => x * y grid  with z mine
	  
   - java main/Main x y
     	  => x the height of the grid you want
     	  => y the width of the grid you want
	  => x * y grid with (x * y) / 2 mine