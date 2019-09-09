//Muhammad Ahmad


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class P_2 {
	
	// method that returns a postfix queue
	public static Queue<String> infixtopostfix(Scanner line) {
				Stack<String> stack = new Stack<String>();
				Queue<String> queue = new Queue<String>();
				while (line.hasNext()){
					String temp = line.next();
					//System.out.print(temp + " ");
					if (isOperator(temp)){
						// if bracket
						if (temp.equals(")")){
							while (!stack.getTop().equals("(")){
								//String xx = stack.pop();
								queue.enqueue(stack.pop());
							}
							stack.pop();
						}
						// if ( or stack empty
						else if (temp.equals("(") || stack.isEmpty()){
							stack.push(temp);
						}
						// all other operators
						else{
							try{
							while (op_order(temp, stack) == true){	// not equal to false
								if (op_order(temp, stack) == true){
									queue.enqueue(stack.pop());
								}
							}
							}catch(Exception e){}
							stack.push(temp);
						}
						
					}
					else if (temp.equals(" ")){}
					else{
						queue.enqueue(temp);
					}
					
				}
				while (!stack.isEmpty()){
					queue.enqueue(stack.pop());
				}
				//System.out.println();				
				return queue;
			
	}
	
	// method to check precedence of operators
	public static boolean op_order(String temp, Stack<String> s_temp){
		if (s_temp.getTop().equals("(")){
			return false;
		}
		else if (s_temp.getTop().equals("!") || s_temp.getTop().equals("^")){
			return true;
		}
		else if ((temp.equals("*") || temp.equals("/") || temp.equals("%")) && (s_temp.getTop().equals("^") || s_temp.getTop().equals("*") || s_temp.getTop().equals("/") || s_temp.getTop().equals("%"))){
			return true;
		}
		else if ((temp.equals("-") || temp.equals("+")) && (!s_temp.getTop().equals("<") || !s_temp.getTop().equals(">") || !s_temp.getTop().equals("=") || !s_temp.getTop().equals("!") || !s_temp.getTop().equals("&") || !s_temp.getTop().equals("|"))){
			return true;
		}
		else if ((temp.equals("<") || temp.equals(">") || temp.equals("=")) && (!s_temp.getTop().equals("|") || !s_temp.getTop().equals("!") || !s_temp.getTop().equals("&"))){
			return true;
		}
		else if ((temp.equals("!")) && (!s_temp.getTop().equals("|") || !s_temp.getTop().equals("&"))){
			return true;
		}
		else if ((temp.equals("&") || temp.equals("|"))){
			return true;
		}
		else{
			return false;
		}
	}
	
	// checks if operator or not
	public static boolean isOperator(String temp){
		if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/") || temp.equals("|")
			|| temp.equals("(") || temp.equals(")") || temp.equals("<") || temp.equals(">") || temp.equals("=") 
			|| temp.equals("|") || temp.equals("!") || temp.equals("&") || temp.equals("^") || temp.equals("%")){
			return true;
			
		}
		else{
			return false;
		}
	}
	
	// method that evaluates the postfix expression
	public static String eval(Queue<String> queue){
		Stack<String> stack = new Stack<String>();
		String t_ans;
		while (!queue.Empty()){
			String token = queue.dequeue();
			if(!isOperator(token)){
				stack.push(token);
			}
			else{
				t_ans = calc(stack, token);
				stack.push(t_ans);
			}
			
		}
		String ans = stack.pop();
		return ans;
	}

	
	// method to calculate each operator
	public static String calc(Stack<String> stack, String token){
		String t_ans = "0";
		if (token.equals("+")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			t_ans = String.valueOf(y+x);
		}
		else if (token.equals("-")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			t_ans = String.valueOf(y-x);
		}
		else if (token.equals("*")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			t_ans = String.valueOf(y*x);
		}
		else if (token.equals("/")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			t_ans = String.valueOf(y/x);
		}
		else if (token.equals("^")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			t_ans = String.valueOf(Math.pow(y, x));
		}
		else if (token.equals("%")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			t_ans = String.valueOf(y % x);
		}
		else if (token.equals(">")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			if (y > x){
				t_ans = String.valueOf(1.0);
			}
			else{
				t_ans = String.valueOf(0.0);
			}
		}
		else if (token.equals("<")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			if (y < x){
				t_ans = String.valueOf(1.0);
			}
			
			else{
				t_ans = String.valueOf(0.0);
			}
		}
		else if (token.equals("=")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			if (y.equals(x)){
				t_ans = String.valueOf(1.0);
			}
			else{
				t_ans = String.valueOf(0.0);
			}
		}
		else if (token.equals("|")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			if (y.equals(0.0) && x.equals(0.0)){
				t_ans = String.valueOf(0.0);
			}
			else{
				t_ans = String.valueOf(1.0);
			}
		}
		else if (token.equals("&")){
			Double x = Double.valueOf(stack.pop());
			Double y = Double.valueOf(stack.pop());
			if (y.equals(1.0) && x.equals(1.0)){
				t_ans = String.valueOf(1.0);
			}
			else{
				t_ans = String.valueOf(0.0);
			}
		}
		else if (token.equals("!")){
			Double x = Double.valueOf(stack.pop());
			if (x.equals(1.0)){
				t_ans = String.valueOf(0.0);
			}
			else{
				t_ans = String.valueOf(1.0);
			}
		}
		return t_ans;
	}
	
	// main method calls in the file, passes the line to the infixtopostfix method which returns a queue, passes the queue to the eval method which returns a value and it saves the value in the output file
	public static<E> void main(String[] args) {
		try{
			PrintWriter writer = new PrintWriter("src/postfix_eval_short.txt");
			File infix = new File("src/infix_expr_short.txt");
			Scanner file = new Scanner(infix);
			Scanner line;
			while(file.hasNextLine()){
				line = new Scanner(file.nextLine());
				Queue<String> queue = infixtopostfix(line);
				
				writer.println(eval(queue));
			}
			
			
			file.close(); writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("GOT IT");
		System.out.println("CHECK THE postfix_eval_short document for answers");
	}

}
