import java.io.*;
class Account
{
protected int accnumber;
protected double balance;
Account()
{
accnumber=0;
balance=0;
}
Account(int accnumber,double balance)
{
super();
this.accnumber=accnumber;
this.balance=balance;
}
}
class SBAccount extends Account
{
SBAccount(int accnumber,double balance)
{
super(accnumber,balance);
}
void deposit(double amount)
{
if (amount>0)
{
System.out.println("balance before deposit your amount:"+balance);
balance+=amount;
System.out.println(" New balance before deposit your amount:"+balance);
}
else 
System.out.println("Insufficient amount");
}
void withdraw(double amount)
{
if (balance-amount>1000 && amount >0)
{
System.out.println("Balance before withdraw your amount:"+balance);
balance-=amount;
System.out.println("balance before withdraw your amount:"+balance);
}
else
System.out.println("Insufficient balance Error");
}
void calc_interest()
{
double interest=balance +balance *4/(12*100);
System.out.println("calc_interest =" + interest);
}
}
class FDAccount extends Account
{
int period;
FDAccount(int accnumber,int period,double balance)
{
super(accnumber,balance);
this.period=period;
}
double calc_interest()
{
return balance+balance*8.25*period/100;
}
void close()
{
System.out.println("calc_interest= "+ calc_interest());
}
}
class Customer
{
int cust_id;
String name;
String address;
SBAccount sb;
FDAccount fd;
static int sbaccno=12300;
static int fdaccno=12456;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
Customer(int cust_id,String name,String address)
{
this.cust_id=cust_id;
this.name=name;
this.address=address;
}
void createAccount(int type)throws IOException
{
if (type==1)
{
System.out.println("Enter the inital amount of Sbaccount ");
Double amount=Double.valueOf(br.readLine());
sb=new SBAccount(sbaccno++,amount);
System.out.println("your SBAccount is created");
}
else if (type==2)
{
System.out.println("Enter the inital amount of FDAccount ");
Double amount=Double.valueOf(br.readLine());
System.out.println("Enter the Period:");
Integer period=Integer.valueOf(br.readLine());
fd=new FDAccount(fdaccno++,period,amount);
System.out.println("your FDAccount is created");
}
else
{
System.out.println("Invalid createAccount type");
}
}
void transaction(int type)throws IOException
{
if(type==1)
{
System.out.println("Enter the deposit amount:");
Double amount=Double.valueOf(br.readLine());
sb.deposit(amount);
}
else if(type==2)
{
System.out.println("Enter the withdraw amount:");
Double amount=Double.valueOf(br.readLine());
sb.withdraw(amount);
}
else if(type==3)
{
sb.calc_interest();
}
else if(type==4)
{
fd.close();
}
else
System.out.println("Invalid transaction type:");
}
}
class Bankdemo
{
public static void main(String arg[])throws IOException
{
Customer c[]=new Customer[5];
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String name;
String address;
int cid,i=0;
int ch1,ch2,ch3;
do
{
System.out.println("SBAccount ---> 1");
System.out.println("FDAccount ---> 2");
System.out.println("Exit ---> 3");
System.out.println("Enter your choice:");
ch1=Integer.valueOf(br.readLine());
switch(ch1)
{
case 1:
System.out.println("New SBAccount ---> 1");
System.out.println("SBaccount deposit ---> 2");
System.out.println("SBAccount withdraw ---> 3");
System.out.println("calc_interest--->4");
System.out.println("Exit ---> 5");
System.out.println("Enter your choice:");
ch2=Integer.valueOf(br.readLine());
switch(ch2)
{
case 1:
System.out.println("Enter name & address:");
name=br.readLine();
address=br.readLine();
c[i]=new Customer(i,name,address);
c[i].createAccount(1);
System.out.println("your customer id :"+i);
i++;
break;
case 2:
System.out.println("Enter your customer id:");
cid=Integer.valueOf(br.readLine());
c[cid].transaction(1);
break;
case 3:
System.out.println("Enter your customer id:");
cid=Integer.valueOf(br.readLine());
c[cid].transaction(2);
break;
case 4:
System.out.println("Enter your customer id:");
cid=Integer.valueOf(br.readLine());
c[cid].transaction(2);
case 5:
break;
default:
System.out.println("Invalid SBAccount menu:");
}
break;
case 2:
System.out.println("new FDAccount ---> 1");
System.out.println("close ---> 2");
System.out.println("Exit ---> 3");
System.out.println("Enter your choice:");
ch3=Integer.valueOf(br.readLine());
switch(ch3)
{
case 1:
System.out.println("Enter name & address");
name=br.readLine();
address=br.readLine();
c[i]=new Customer(i,name,address);
c[i].createAccount(2);
System.out.println("This is your customer id:" + i);
i++;
break;
case 2:
System.out.println("Enter the customer id:");
cid=Integer.valueOf(br.readLine());
c[cid].transaction(3);
break;
case 3:
break;
default:
System.out.println("Invalid FDAccount menu");
}
break;
case 3:
break;
default:
System.out.println("Invalid Main Menu");
}
}while(ch1!=3);
}
}













