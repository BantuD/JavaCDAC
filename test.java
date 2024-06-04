using System;

class Employee
{
    public int Id { get; set; }
    public string Name { get; set; }
    public int Age { get; set; }
    public double Sal { get; set; }
    public double Comm { get; set; }
    public DateTime Bdate { get; set; }

    public Employee(int id, string name, int age, double sal, double comm, DateTime bdate)
    {
        Id = id;
        Name = name;
        Age = age;
        Sal = sal;
        Comm = comm;
        Bdate = bdate;
    }

    public virtual double Income()
    {
        return Sal + Comm;
    }
}

class Manager : Employee
{
    public int NoOfSubordinates { get; set; }

    public Manager(int id, string name, int age, double sal, double comm, DateTime bdate, int noOfSubordinates)
        : base(id, name, age, sal, comm, bdate)
    {
        NoOfSubordinates = noOfSubordinates;
    }

    public override double Income()
    {
        double income = base.Income();
        if (NoOfSubordinates > 10)
            income += income * 0.1; // 10% extra income
        return income;
    }
}

class Secretary : Employee
{
    public string CommGrade { get; set; }

    public Secretary(int id, string name, int age, double sal, double comm, DateTime bdate, string commGrade)
        : base(id, name, age, sal, comm, bdate)
    {
        CommGrade = commGrade;
    }

    public override double Income()
    {
        double income = base.Income();
        if (CommGrade == "A")
            income += income * 0.1; // 10% extra income
        else
            income += income * 0.05; // 5% extra income
        return income;
    }
}

class Program
{
    static void Main(string[] args)
    {
        Employee[] employees = new Employee[]
        {
            new Employee(1, "John", 30, 5000, 500, new DateTime(1990, 5, 15)),
            new Manager(2, "Jane", 35, 6000, 800, new DateTime(1985, 7, 20), 15),
            new Secretary(3, "Bob", 28, 4500, 600, new DateTime(1992, 3, 10), "A"),
            new Secretary(4, "Alice", 32, 5200, 700, new DateTime(1988, 9, 5), "B")
        };

        foreach (Employee emp in employees)
        {
            Console.WriteLine($"Employee {emp.Name} has an income of {emp.Income()}");
        }
    }
}
