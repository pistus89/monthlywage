package main;
import scala.io.Source
import java.text.SimpleDateFormat
import org.scala_tools.time._ //external time library that simplifies date management, included with maven


object Main{
	def main(args: Array[String]) {
	  val sourcePath = "/home/krister/Downloads/Solinor/HourList201403.csv";
	  val break = ","; 
	  val CSVlist = CSVReader(sourcePath,break);
	  
	  for (line <- CSVlist) {
	    for (element <- line) {
	    	println(element);
	    }
	    println("|");
	  }
	  
	}
	
	def CSVReader(path:String, break:String): List[List[Any]] = {
	  println("reading file " + path);
	  val list = Source.fromFile(path).getLines().toList map {
	    _.split("""\""" + break).toList;
	    //splits the lines from CSV-file to a list containing separated columns as own lists
	  }
	  return list;
	}
	
	def ArrangeByID(list:List[List[Any]], id:Integer): List[List[Any]] = {
	  val newList = List();
	  for (singleList <- list) {
	    if (singleList.lift(1) == id) newList ++ singleList;
	  }
	  return newList;
	}
	
	def CalculateHours(start:String, end:String, date:String): Integer = {
	  
	  val hours:Int = ((endDate.getTime() - startDate.getTime())/(1000*60*60)).toInt;
	  
	  return hours;
	}
	
	def CalculateWorkHours(list:List[List[Any]]): List[Map[String,Integer]] = {
	  //returns a List containing maps, where the working hours of a person are stored as separated
	  //by type. the index of a map element is the same as workers ID
	  for (line <- list) {
			val start = line(3).toString;
			val end = line(4).toString;
			val date = line(2).toString;
			val format = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm");
			val startDate = format.parseDateTime(date +" "+ start);
			val endDate = format.parseDateTime(date + " " + end);
			val morningDate = format.parseDateTime(date + " 06:15");
			val eveningDate:DateTime = {
			  
			}
			if ()
	  }
	}
}