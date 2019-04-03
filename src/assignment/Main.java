package assignment;
import java.io.*;
import java.util.*;


class Student{
	   private int token;
	   private String name;
	   private double cgpa;
	   public Student(int id, String name, double cgpa) {
	      super();
	      this.token = id;
	      this.name = name;
	      this.cgpa = cgpa;
	   }
	
	   public String getName() {
	      return name;
	   }
	   public int compare(Student s)
	   {
	       if(this.cgpa > s.cgpa){  
	           return 1;
	       }else if (this.cgpa < s.cgpa){
	            return -1; 
	       }
	       if(this.name.compareTo(s.name) > 0){
	           return -1;
	       }else if(this.name.compareTo(s.name) < 0){
	           return 1;
	       }else{
	            if(this.token < s.token){ 
	               return -1;
	            }
	       }
	       return 1;
	   }
	       
	   
	}




public class Main 
{
	 public static ArrayList<Student> PriorityQueue = new ArrayList<>();
	 public static void insert(Student s)
	    {
	        int Pos = 0;
	        for(int i = 0;i < PriorityQueue.size() ;i++){
	            if(PriorityQueue.get(Pos).compare(s)>0){
	                Pos = i+1;
	            }else{
	                break;
	            }
	        }
	        PriorityQueue.add(Pos,s);
	    }
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	      int Events = Integer.parseInt(input.nextLine());
	      while(Events>0){
	        String[] event_type = input.nextLine().split(" ");
	        if(event_type.length == 1){
	            if(!PriorityQueue.isEmpty()){
	            	PriorityQueue.remove(0);
	            }
	        }else{
	            Student s = new Student(Integer.parseInt(event_type[3]),event_type[1],Double.parseDouble(event_type[2]));
	            insert(s);
	        }      
	         Events--;
	      }
	        if(PriorityQueue.size() > 0){
	            for(int i = 0;i <PriorityQueue.size();i++){
	                System.out.println(PriorityQueue.get(i).getName());
	            }
	        }else{
	            System.out.println("EMPTY");
	        }
	            
	    }
		
	}

