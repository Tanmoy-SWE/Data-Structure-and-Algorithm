using System;
using System.Collections.Generic;

//Template Class Declaration
public class Weather < T > {  
    // Instance Variables with getter setter
    public string month {  
        get;  
        set;  
    }  
    public T temperature {  
        get;  
        set;  
    }  
    public T date {  
        get;  
        set;  
    }  
    //Constructor of the weather class
    public Weather(string s, T d, T t) {  
        month = s;  
        temperature = t;  
        date = d;  
        GetData();  
    }  
    //A public method to show output
    public void GetData() {  
        Console.WriteLine(month+" "+date+", "+temperature+" degrees");
    }  
}  
class Program {  
    static void Main(string[] args) {
        Console.WriteLine("Atlanta Weather Report : ");
         // Creating object
        new Weather < int > ("May", 1, 78);  
        new Weather < int > ("May", 2, 81);  
        new Weather < long > ("May", 3, 79);  
        new Weather < long > ("May", 4, 78);  
        new Weather < int > ("May", 5, 78);
        /*
        The object initialized and shown output as I declared
        the GetData method inside the constructor of the
        Weather class
        */
        Console.ReadKey();  
    }  
} 
