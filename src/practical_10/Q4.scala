object Q4 {
  class Account(var balance: Double) {

    def deposit(amount: Double): Unit = {
      require(amount > 0, "Deposit amount must be positive")
      balance += amount
    }

    def withdraw(amount: Double): Unit = {
      require(amount > 0, "Withdrawal amount must be positive")
      if (amount <= balance) balance -= amount
      else println("Insufficient balance for withdrawal.")
    }

    def transfer(amount: Double, toAccount: Account): Unit = {
      require(amount > 0, "Transfer amount must be positive")
      if (amount <= balance) {
        this.withdraw(amount)
        toAccount.deposit(amount)
      } else {
        println("Insufficient balance for transfer.")
      }
    }

    def applyInterest(): Unit = {
      if (balance > 0) balance += balance * 0.05
      else balance += balance * 0.10
    }

    override def toString: String = s"Account balance: $$${balance}"
  }

  class Bank(val accounts: List[Account]) {

    def accountsWithNegativeBalance: List[Account] = {
      accounts.filter(account => account.balance < 0)
    }

    def totalBalance: Double = {
      accounts.map(_.balance).sum
    }

    def applyInterestToAllAccounts(): Unit = {
      accounts.foreach(_.applyInterest())
    }
  }

  // Main method
  def main(args: Array[String]): Unit = {
    // Create some accounts
    val account1 = new Account(500.0)
    val account2 = new Account(-200.0)
    val account3 = new Account(300.0)
    val account4 = new Account(-100.0)

    val bank = new Bank(List(account1, account2, account3, account4))

    println("Accounts with negative balances:")
    val negativeAccounts = bank.accountsWithNegativeBalance
    negativeAccounts.foreach(account => println(account))

    println(s"\nTotal balance in the bank: $$${bank.totalBalance}")

    bank.applyInterestToAllAccounts()

    println("\nFinal balances after applying interest:")
    bank.accounts.foreach(account => println(account))

    println(s"\nTotal balance in the bank after interest: $$${bank.totalBalance}")
  }
}
