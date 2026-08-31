package absEncInOOP;

public class BankAccount {



private String AccontNumber;
private String holderName;
private double balance;
private char gender;//gender ke liye
private String AccountType;
public void setAccountType(String s)
{
    this.AccountType=s;
}
public String GetAccountType()
{
     return this.AccountType;   
}

 public String getName()
 {
    return this.holderName;
 }
 public void setName(String s)
 {
    this.holderName=s;
 }

public void addBalance(double d)
{
    this.balance=this.balance + d;
}

public void setBalance(double d){
    this.balance=d;
}

public double getBalance()
{
    return this.balance;
}

public void setAccountNumber(String s)
{
   this.AccontNumber=s;  
}

public String getAccountNo()
{
    return this.AccontNumber;
}

public void withdraw(double amnt)
{
    this.balance=(this.balance-amnt);
}

public boolean isMale()
{
    if(this.gender=='M')return true;
    return false;
}
public void setGender(char c)
{
    this.gender=c;
}
public char getGender()
{
   return this.gender;
}

}
